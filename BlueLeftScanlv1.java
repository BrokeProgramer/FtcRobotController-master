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
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.teamcode.vision.BarcodeRed;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous (name = "BlueLeftScanlv1", group = "Barcode")
public class BlueLeftScanlv1 extends LinearOpMode {

    // Define motors and servos

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo leftClaw;
    Servo rightClaw;
    DcMotor Carasol;
    DcMotor Claw;

    OpenCvCamera webcam;

    BarcodeRed pipeline = new BarcodeRed(telemetry);

    @Override
    public void runOpMode() {
        //initialize robot hardware

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        Carasol = hardwareMap.dcMotor.get("Carasol");
        Claw = hardwareMap.dcMotor.get("Claw");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");


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
        hold();
        waitForStart();

        //Manages Telemetry and stopping the stream
        while (opModeIsActive()) {

            sleep(2000);
            telemetry.addData("Analysis", pipeline.getAnalysis());
            telemetry.update();

            switch (pipeline.getAnalysis()) {
                case LEFT:
                    //
                    break;
                case CENTER:
                    //
                    break;
                case RIGHT:
                    //move "forward"(camera side)
                    backwards();
                    hold();
                    sleep(1000);

                    //gap
                    hold();
                    stopMotors();
                    sleep(200);

                    //turn toward hub
                    turnLeft();
                    hold();
                    sleep(420);

                    //gap
                    hold();
                    stopMotors();
                    sleep(200);

                    //move towards hub
                    backwards();
                    hold();
                    sleep(60);

                    //gap
                    hold();
                    stopMotors();
                    sleep(200);

                    //arm down to rest on lip
                    Foldout();
                    hold();
                    sleep(500);

                    //gap
                    hold();
                    stopMotors();
                    sleep(200);

                    //let arm fall
                    hold();
                    stopMotors();
                    sleep(2000);

                    //let go
                    letGo();
                    stopMotors();
                    sleep(100);

                    //put arm back
                    Foldin();
                    letGo();
                    sleep(500);

                    //gap
                    letGo();
                    stopMotors();
                    sleep(200);

                    //turn torwards hole
                    turnRight();
                    letGo();
                    sleep(40);

                    //gap
                    letGo();
                    stopMotors();
                    sleep(200);

                    //drive to hole
                    forward();
                    letGo();
                    sleep(800);

                    //gap
                    letGo();
                    stopMotors();
                    sleep(200);

                    //turn into proper position
                    turnLeft();
                    letGo();
                    sleep(350);

                    //gap
                    letGo();
                    stopMotors();
                    sleep(300);

                    //drive in
                    forward();
                    letGo();
                    sleep(700);

                    stop();
                    stopMotors();

                    break;
            }

            //reminder to use the KNO3 auto transitioner once this code is working
            webcam.stopStreaming();
            webcam.closeCameraDevice();
            break;
        }
    }
    public void StayUp(){
        Claw.setPower(-.1);
    }
    public void Foldout(){
        Claw.setPower(-.7);
    }
    public void Foldin(){
        Claw.setPower(.7);
    }
    public void hold(){
        leftClaw.setPosition(-.95);
        rightClaw.setPosition(.95);
    }
    public void letGo(){
        leftClaw.setPosition(1.0);
        rightClaw.setPosition(-1.0);
    }
    public void forward() {
        frontLeft.setPower(.5);
        frontRight.setPower(-.5);
        backLeft.setPower(.5);
        backRight.setPower(-.5);
    }

    public void backwards() {
        frontLeft.setPower(-.3);
        frontRight.setPower(.3);
        backLeft.setPower(-.3);
        backRight.setPower(.3);
    }

    public void turnRight() {
        frontLeft.setPower(0);
        frontRight.setPower(-.5);
        backLeft.setPower(0);
        backRight.setPower(-.5);
    }

    public void turnLeft() {
        frontLeft.setPower(.5);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(.5);
    }

    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        Carasol.setPower(0);
        Claw.setPower(0);
    }

    public void stopexceptCarasol() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        Carasol.setPower(-.5);
    }

    public void CarasolRightSide() {
        frontLeft.setPower(-.03);
        frontRight.setPower(.03);
        backLeft.setPower(-.03);
        backRight.setPower(.03);
        Carasol.setPower(.5);
    }
    public void Straithright() {
        frontLeft.setPower(.3);
        backLeft.setPower(-.3);
        frontRight.setPower(.3);
        backRight.setPower(-.3);
    }
    public void Straithleft() {
        frontLeft.setPower(-.3);
        backLeft.setPower(.3);
        frontRight.setPower(-.3);
        backRight.setPower(0.3);
    }
}
