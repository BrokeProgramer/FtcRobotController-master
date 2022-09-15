/*
 * Copyright (c) 2019 OpenFTC Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.teamcode.vision.BarcodeRed;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous (name = "RedLeftScanE", group = "EncoderUpgradeBarcode")
public class RedLeftScanE extends LinearOpMode {
    D4C D4CLT = new D4C();
    // Define motors and servos

    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor backRight;
    Servo leftClaw;
    Servo rightClaw;
    DcMotor ArmMotor1;
    DcMotor ArmMotor2;
    DcMotor Lift;
    CRServo Hopper;
    OpenCvCamera webcam;

    BarcodeRed pipeline = new BarcodeRed(telemetry);

    @Override
    public void runOpMode() {
        D4CLT.init(hardwareMap, telemetry);
        D4CLT.hold();
        //initialize robot hardware

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        ArmMotor1 = hardwareMap.dcMotor.get("ArmMotor1");
        ArmMotor2 = hardwareMap.dcMotor.get("ArmMotor2");
        Lift = hardwareMap.dcMotor.get("Lift");
        Hopper = hardwareMap.crservo.get("Hopper");


        //FOR THE WEBCAM
        /*
         * Instantiate an OpenCvCamera object for the camera we'll be using.
         * Webcam stream goes to RC phone
         */
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        //webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);

        //webcam.setPipeline(pipeline);
//waitForStart();
        /*
         * Open the connection to the camera device. New in v1.4.0 is the ability
         * to open the camera asynchronously which allows faster init time, and
         * better behavior when pressing stop during init (i.e. less of a chance
         * of tripping the stuck watchdog)
         */
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                /*
                 * Tell the webcam to start streaming images to us! Note that you must make sure
                 * the resolution you specify is supported by the camera. If it is not, an exception
                 * will be thrown.
                 *
                 * Keep in mind that the SDK's UVC driver (what OpenCvWebcam uses under the hood) only
                 * supports streaming from the webcam in the uncompressed YUV image format. This means
                 * that the maximum resolution you can stream at and still get up to 30FPS is 480p (640x480).
                 * Streaming at e.g. 720p will limit you to up to 10FPS and so on and so forth.
                 *
                 * Also, we specify the rotation that the webcam is used in. This is so that the image
                 * from the camera sensor can be rotated such that it is always displayed with the image upright.
                 * For a front facing camera, rotation is defined assuming the user is looking at the screen.
                 * For a rear facing camera or a webcam, rotation is defined assuming the camera is facing
                 * away from the user.
                 */
                //320px x 340px
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);

                /*
                 * Specify the image processing pipeline we wish to invoke upon receipt
                 * of a frame from the camera. Note that switching pipelines on-the-fly
                 * (while a streaming session is in flight) *IS* supported.
                 */

                webcam.setPipeline(pipeline);
            }

            @Override
            public void onError(int errorCode) {
                telemetry.addData("errorCode", errorCode);
            }
        });
        // Tell telemetry to update faster than the default 250ms period :)
        telemetry.setMsTransmissionInterval(20);

        telemetry.addLine("Waiting for start");
        telemetry.update();

        //Wait for the user to press start on the Driver Station
        D4CLT.hold();
        waitForStart();

        //Manages Telemetry and stopping the stream
        while (opModeIsActive()) {

            sleep(2000);
            telemetry.addData("Analysis", pipeline.getAnalysis());
            telemetry.update();

            switch (pipeline.getAnalysis()) {
                case LEFT:
                    D4CLT.hold();
                    //go forward
                    D4CLT.encoderDrive(0.5, 12, 12, 1000);
                    sleep(100);
                    //turn
                    D4CLT.encoderRightDrive(0.5,14,1000);
                    //go forward slightly
                    D4CLT.encoderDrive(0.5, -6.5, -6.5, 1000);
                    //extend arm out
                    sleep(1600);
                    stopMotors();
                    sleep(1000);

                    //D4CLT.setArm(-1800);
                    //open claw and go in

                    D4CLT.encoderDrive(0.3, 4, 4, 1000);
                    D4CLT.letGo();
                    sleep(180);
                    //close and go back out
                    D4CLT.hold();

                    D4CLT.encoderDrive(.3,-4,-4,1000);
                    //back up a bit
                    D4CLT.encoderDrive(.5,6.5,6.5,1000);
                    //turn back
                    D4CLT.encoderRightDrive(0.5,-14,1000);
                    //travel back a bit
                    D4CLT.encoderDrive(0.5, -6, -6, 1000);
                    //turn into gap
                    D4CLT.encoderRightDrive(0.5,-35,1000);
                    D4CLT.StrafeLeft();
                    sleep(1000);
                    //park
                    D4CLT.encoderDrive(0.5, -50, -50, 1000);
                    break;
                case CENTER:
                    D4CLT.hold();
                    //go forward
                    D4CLT.encoderDrive(0.5, 12, 12, 1000);
                    sleep(100);
                    //turn
                    D4CLT.encoderRightDrive(0.5,14,1000);
                    //go forward slightly
                    D4CLT.encoderDrive(0.5, -6.5, -6.5, 1000);
                    //extend arm out
                    sleep(1600);
                    stopMotors();
                    sleep(1000);

                    //D4CLT.setArm(-1800);
                    //open claw and go in

                    D4CLT.encoderDrive(0.3, 5, 55, 1000);
                    D4CLT.letGo();
                    sleep(300);
                    //close and go back out
                    D4CLT.hold();

                    D4CLT.encoderDrive(.3,-5,-5,1000);
                    //back up a bit
                    D4CLT.encoderDrive(.5,6,6,1000);
                    //turn back
                    D4CLT.encoderRightDrive(0.5,-14,1000);
                    //travel back a bit
                    D4CLT.encoderDrive(0.5, -6.5, -6.5, 1000);
                    //turn into gap
                    D4CLT.encoderRightDrive(0.5,-35,1000);
                    D4CLT.StrafeLeft();
                    sleep(1000);
                    //park
                    D4CLT.encoderDrive(0.5, -50, -50, 1000);
                    break;
                case RIGHT:
                    D4CLT.hold();
                    //go forward
                    D4CLT.encoderDrive(0.5, 12, 12, 1000);
                    sleep(100);
                    sleep(100);
                    //turn
                    D4CLT.encoderRightDrive(0.5,14,1000);
                    //go forward slightly
                    D4CLT.encoderDrive(0.5, 3, 3, 1000);
                    //extend arm out
                    //open claw and fold in
                    D4CLT.letGo();
                    //back up a bit
                    D4CLT.encoderDrive(0.5, -3, -3, 1000);
                    //turn back
                    D4CLT.encoderRightDrive(0.5,-14,1000);
                    //travel back a bit
                    D4CLT.encoderDrive(0.5, -6, -6, 1000);
                    //turn into gap
                    D4CLT.encoderRightDrive(0.5,-32,1000);
                    D4CLT.StrafeLeft();
                    sleep(1000);
                    //park
                    D4CLT.encoderDrive(0.5, -50, -50, 1000);
                    break;
            }

            //reminder to use the KNO3 auto transitioner once this code is working
            webcam.stopStreaming();
            webcam.closeCameraDevice();
            break;
        }
    }
    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

}

//D4CLT.encoderDrive(0.5, -23, -23, 1000);
// D4CLT.encoderLeftDrive(0.5, -28, 1000);
// D4CLT.encoderRightDrive(0.5, -28, 1000);