package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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
    DcMotor Claw;
    DcMotor Carasol;
    boolean aState, aCurr, aPrev;

    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        Claw = hardwareMap.dcMotor.get("Claw");
        Carasol = hardwareMap.dcMotor.get("Carasol");
        waitForStart();

        while (opModeIsActive()) {

            aPrev = aCurr;
            aCurr = gamepad1.a;

            if (aCurr && !aPrev)
                aState = !aState;

            if (!aState) {

                // Driving forwards
                if (Math.abs(-gamepad1.left_stick_y) > .1) {
                    frontLeft.setPower(-gamepad1.left_stick_y * .7);
                    D4CLT.backLeft.setPower(-gamepad1.left_stick_y * .7);
                } else {
                    frontLeft.setPower(0);
                    backLeft.setPower(0);
                }
                if (Math.abs(-gamepad1.right_stick_y) > .1) {
                    frontRight.setPower(-gamepad1.right_stick_y * .7);
                    backRight.setPower(-gamepad1.right_stick_y * .7);
                }
                if (gamepad1.dpad_up) {
                    frontRight.setPower(-gamepad1.right_stick_y * .4);
                    backRight.setPower(-gamepad1.right_stick_y * .4);
                }
                if (gamepad1.dpad_down) {
                    frontRight.setPower(-gamepad1.right_stick_y * -.4);
                    backRight.setPower(-gamepad1.right_stick_y * -.4);
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
            } else {

                // Driving backwards
                if (Math.abs(-gamepad1.left_stick_y) > .1) {
                    frontRight.setPower(-gamepad1.left_stick_y * -.7);
                    backRight.setPower(-gamepad1.left_stick_y * -.7);
                } else {
                    frontRight.setPower(0);
                    backRight.setPower(0);
                }
                if (Math.abs(-gamepad1.right_stick_y) > .1) {
                    frontLeft.setPower(-gamepad1.right_stick_y * -.7);
                    backLeft.setPower(-gamepad1.right_stick_y * -.7);
                }
                if (gamepad1.dpad_up) {
                    frontRight.setPower(-gamepad1.right_stick_y * -.4);
                    backRight.setPower(-gamepad1.right_stick_y * -.4);
                }
                if (gamepad1.dpad_down) {
                    frontRight.setPower(-gamepad1.right_stick_y * .4);
                    backRight.setPower(-gamepad1.right_stick_y * .4);
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
                    D4CLT.setArm(-1600);
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.hold();
                    D4CLT.setArm(1400);
                }
                if (gamepad2.dpad_down) {
                    D4CLT.hold();
                    D4CLT.StayUp();
                    D4CLT.setArm(-1950);
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.Fall();
                    D4CLT.hold();
                    D4CLT.setArm(1650);
                }
                if (gamepad2.dpad_left) {
                    D4CLT.hold();
                    D4CLT.StayUp();
                    D4CLT.setArm(-1850);
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.Fall();
                    D4CLT.hold();
                    D4CLT.setArm(1650);
                }
                if (gamepad2.dpad_up) {
                    D4CLT.hold();
                    D4CLT.StayUp();
                    D4CLT.setArm(-1800);
                    D4CLT.letGoAll();
                    // D4CLT.leftClaw.setPosition(1.0);
                    // D4CLT.rightClaw.setPosition(-1.0);
                    sleep(200);
                    D4CLT.Fall();
                    D4CLT.hold();
                    D4CLT.setArm(1650);
                }
                if (gamepad2.x) {
                    D4CLT.hold();
                    D4CLT.setArm(-200);
                }
                if (gamepad2.y) {

                    D4CLT.hold();
                    D4CLT.setArm(-1850);
                }

                if (gamepad2.a) {
                    if (gamepad2.b) {
                        leftClaw.setPosition(1.0);
                        rightClaw.setPosition(0);
                    } else {
                        leftClaw.setPosition(.2);
                        rightClaw.setPosition(.8);
                    }
                } else {
                    leftClaw.setPosition(-1.0);
                    rightClaw.setPosition(1.0);
                }
                if (Math.abs(gamepad2.left_stick_y) > .1) {
                    Claw.setPower(-gamepad2.left_stick_y * .5);
                } else {
                    Claw.setPower(0.0);
                }
                if (gamepad1.right_bumper) {
                    Carasol.setPower(0.8);
                } else {
                    Carasol.setPower(0.0);
                }
                if (gamepad1.left_bumper) {
                    Carasol.setPower(-0.7);
                } else {
                    Carasol.setPower(0.0);
                }
            if (Math.abs(gamepad2.left_trigger) > .1) {
                Claw.setPower(-.1);
            }
            if (Math.abs(gamepad2.right_trigger) > .1) {
                Claw.setPower(.1);
            }
            }
        }
    }
