package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//@Disabled
@Autonomous(name = "EncoderWheelTest", group = "test")
public class EncoderWheelTest extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor Carasol;
    Servo leftClaw;
    Servo rightClaw;
    DcMotor Claw;
    private final ElapsedTime runtime = new ElapsedTime();

    static final double Counts_PER_MOTOR_REV = 537.6;
    static final double DRIVE_GEAR_REDUCTION = 1.0;
    static final double WHEEL_DIAMETER_INCHES = 3.78;
    static final double COUNTS_PER_INCH = (Counts_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);

    static final double DRIVE_SPEED = 0.3;
    static final double TURN_SPEED = 0.2;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        Claw = hardwareMap.dcMotor.get("Claw");
        Carasol = hardwareMap.dcMotor.get("Carasol");

        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Path0", "Starting at %7d :%7d" ,frontRight.getCurrentPosition(), frontLeft.getCurrentPosition(),backRight.getCurrentPosition(), backLeft.getCurrentPosition());
        telemetry.update();

        waitForStart();

        encoderDrive(DRIVE_SPEED,800,800,50.0);
        sleep(3000);


        //leftClaw.setPosition(1.0);
        //rightClaw.setPosition(0.0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeouts) {
       // int newLeftFrontTarget;
        int newRightFrontTarget;
        //int newLeftBackTarget;
        //int newRightBackTarget;

        if (opModeIsActive()) {

           // newLeftFrontTarget =(frontLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH))*-1;
            newRightFrontTarget = frontRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
           // newLeftBackTarget = (backLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH))*-1;
            //newRightBackTarget = backRight.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
           // frontLeft.setTargetPosition(newLeftFrontTarget);
            frontRight.setTargetPosition(newRightFrontTarget);
            //backLeft.setTargetPosition(newLeftBackTarget);
            //backRight.setTargetPosition(newRightBackTarget);

           // frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
           // backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            //frontLeft.setPower(-speed);
            frontRight.setPower(speed);
           // backLeft.setPower(-speed);
           // backRight.setPower(speed);

            while (opModeIsActive() && (runtime.seconds() < timeouts) && (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy())) {

                //telemetry.addData("Pat1", "Running to %7d :%7d", newLeftFrontTarget, newRightFrontTarget);
                //telemetry.addData("Path2", "Running to %7d :%7d", frontLeft.getCurrentPosition(), frontRight.getCurrentPosition());
               // telemetry.addData("fL pos", frontLeft.getCurrentPosition());
                telemetry.addData("fR pos", frontRight.getCurrentPosition());
                //telemetry.addData("bL pos", backLeft.getCurrentPosition());
               // telemetry.addData("fR pos", backRight.getCurrentPosition());

                //telemetry.addData("fL goal", newLeftFrontTarget);
                telemetry.addData("fR goal", newRightFrontTarget);
               // telemetry.addData("bL goal", newLeftBackTarget);
                //telemetry.addData("bR goal", newRightBackTarget);
                telemetry.update();
            }
           // frontLeft.setPower(0);
            frontRight.setPower(0);
           // backLeft.setPower(0);
          //  backRight.setPower(0);

            //frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           // backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
           // backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
