package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.teamcode.Autonomous.D4C;

@TeleOp(name = "TelopRunV2")
public class TeleopRunAutonomized extends LinearOpMode {
    D4C D4CLT = new D4C();

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
    boolean aState, aCurr, aPrev;

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
        waitForStart();

        while (opModeIsActive()) {

            aPrev = aCurr;
            aCurr = gamepad1.a;

            if (aCurr && !aPrev)
                aState = !aState;

            if (!aState) {

                // Driving forwards
                if (Math.abs(-gamepad1.left_stick_y) > .1) {
                    frontLeft.setPower(-gamepad1.left_stick_y * .8);
                    backLeft.setPower(-gamepad1.left_stick_y * .8);
                } else {
                    frontLeft.setPower(0);
                    backLeft.setPower(0);
                }
                if (Math.abs(-gamepad1.right_stick_y) > .1) {
                    frontRight.setPower(-gamepad1.right_stick_y * .8);
                    backRight.setPower(-gamepad1.right_stick_y * .8);

                } else {
                    frontRight.setPower(0);
                    backRight.setPower(0);
                }
                if (gamepad1.dpad_right) {
                    frontLeft.setPower(.8);
                    backLeft.setPower(-.8);
                    frontRight.setPower(-.8);
                    backRight.setPower(.8);
                }
                if (gamepad1.dpad_left) {
                    frontLeft.setPower(-.8);
                    backLeft.setPower(.8);
                    frontRight.setPower(.8);
                    backRight.setPower(-.8);
                }
                if (gamepad1.dpad_down) {
                    frontLeft.setPower(-.4);
                    backLeft.setPower(-.4);
                    frontRight.setPower(-.4);
                    backRight.setPower(-.4);
                }
                if (gamepad1.dpad_up) {
                    frontLeft.setPower(.4);
                    backLeft.setPower(.4);
                    frontRight.setPower(.4);
                    backRight.setPower(.4);
                }
            } else {

                // Driving backwards
                if (Math.abs(-gamepad1.left_stick_y) > .1) {
                    frontRight.setPower(-gamepad1.left_stick_y * -.8);
                    backRight.setPower(-gamepad1.left_stick_y * -.8);
                } else {
                    frontRight.setPower(0);
                    backRight.setPower(0);
                }
                if (Math.abs(-gamepad1.right_stick_y) > .1) {
                    frontLeft.setPower(-gamepad1.right_stick_y * -.8);
                    backLeft.setPower(-gamepad1.right_stick_y * -.8);
                } else {
                    frontLeft.setPower(0);
                    backLeft.setPower(0);
                }
                if (gamepad1.dpad_right) {
                    frontLeft.setPower(-.8);
                    backLeft.setPower(.8);
                    frontRight.setPower(.8);
                    backRight.setPower(-.8);
                }
                if (gamepad1.dpad_left) {
                    frontLeft.setPower(.8);
                    backLeft.setPower(-.8);
                    frontRight.setPower(-.8);
                    backRight.setPower(0.8);
                }

            }
                if (gamepad2.dpad_right) {
                    D4CLT.hold();
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.hold();
                }
                if (gamepad2.dpad_down) {
                    D4CLT.hold();
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.hold();
                }
                if (gamepad2.dpad_left) {
                    D4CLT.hold();
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.hold();
                }
                if (gamepad2.dpad_up) {
                    D4CLT.hold();
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.hold();
                }
                if (gamepad2.x) {
                    D4CLT.hold();
                }
                if (gamepad2.y) {

                    D4CLT.hold();
                }

                if (gamepad2.a) {
                    if (gamepad2.b) {
                        leftClaw.setPosition(1.0);
                        rightClaw.setPosition(0);
                    } else {
                        leftClaw.setPosition(.15);
                        rightClaw.setPosition(.85);
                    }
                } else {
                    leftClaw.setPosition(-1.0);
                    rightClaw.setPosition(1.0);
                }
            }
        }
    }
