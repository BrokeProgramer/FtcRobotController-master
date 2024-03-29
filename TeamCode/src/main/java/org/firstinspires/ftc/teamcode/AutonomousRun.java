package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;

@Autonomous(name = "AutonomousRun", group = "test")
public class AutonomousRun extends LinearOpMode {
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

    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 2150.8;
    static final double DRIVE_GEAR_REDUCTION = 2.0;
    static final double WHEEL_DIAMETER_INCHES = 3.77953;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;


    Integer cpr = 28;
    Integer gearratio = (((1 + (46 / 17))) * (1 + (46 / 11)));
    Double diameter = 4.0;
    Double cpi = (cpr * gearratio) / (Math.PI * diameter);
    Double bias = 0.8;
    //
    Double conversion = cpi * bias;
    Boolean exit = false;
    private Object AutoTransitioner;

    @Override
    public void runOpMode() throws InterruptedException {
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

        frontLeft.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);

        waitForStart();
        encoderDrive(.6, -40, 40, .5);

        AutoTransitioner(this, "TeleopRun");
    }

    private void AutoTransitioner(AutonomousRun autonomousRun, String teleopRun) {
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        if (opModeIsActive()) {

            newFrontLeftTarget = frontLeft.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newBackLeftTarget = backLeft.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newFrontRightTarget = frontRight.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            newBackRightTarget = backRight.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

            frontLeft.setTargetPosition(newFrontLeftTarget);
            backLeft.setTargetPosition(newBackLeftTarget);
            frontRight.setTargetPosition(newFrontRightTarget);
            backRight.setTargetPosition(newBackRightTarget);

            frontLeft.setMode(RUN_TO_POSITION);
            backLeft.setMode(RUN_TO_POSITION);
            frontRight.setMode(RUN_TO_POSITION);
            backRight.setMode(RUN_TO_POSITION);

            runtime.reset();

            frontLeft.setPower(Math.abs(speed));
            backLeft.setPower(Math.abs(speed));
            frontRight.setPower(Math.abs(speed));
            backRight.setPower(Math.abs(speed));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    frontLeft.isBusy() || frontRight.isBusy() &&
                    backLeft.isBusy() || backRight.isBusy()) {

                telemetry.addData("Path1", "Running to %7d :%7d", newFrontLeftTarget, newFrontRightTarget,
                        newBackLeftTarget, newBackRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        frontLeft.getCurrentPosition(),
                        backLeft.getCurrentPosition(),
                        frontRight.getCurrentPosition(),
                        backRight.getCurrentPosition());
                telemetry.update();
            }
            frontLeft.setMode(RUN_USING_ENCODER);
            backLeft.setMode(RUN_USING_ENCODER);
            frontRight.setMode(RUN_USING_ENCODER);
            backRight.setMode(RUN_USING_ENCODER);

        }
    }
}