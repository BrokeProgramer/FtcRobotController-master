package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TelopRun")
public class TeleopRun extends OpMode {
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
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        Claw = hardwareMap.dcMotor.get("Claw");
        Carasol = hardwareMap.dcMotor.get("Carasol");
    }

    @Override
    public void loop() {

        aPrev = aCurr;
        aCurr = gamepad1.a;

        if (aCurr && !aPrev)
            aState = !aState;

        if (!aState) {

            // Driving forwards
            if (Math.abs(-gamepad1.left_stick_y) > .1) {
                frontLeft.setPower(-gamepad1.left_stick_y * -.7);
                backLeft.setPower(-gamepad1.left_stick_y * -.7);
            } else {
                frontLeft.setPower(0);
                backLeft.setPower(0);
            }
            if (Math.abs(-gamepad1.right_stick_y) > .1) {
                frontRight.setPower(-gamepad1.right_stick_y * .7);
                backRight.setPower(-gamepad1.right_stick_y * .7);
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
                frontLeft.setPower(-gamepad1.right_stick_y * .7);
                backLeft.setPower(-gamepad1.right_stick_y * .7);
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
                backRight.setPower(.8);
            }
        }

        if (gamepad2.a) {
            leftClaw.setPosition(1.0);
            rightClaw.setPosition(-1.0);
        } else {
            leftClaw.setPosition(-1.0);
            rightClaw.setPosition(1.0);
        }
        if (Math.abs(gamepad2.left_stick_y) > .1) {
            Claw.setPower(-gamepad2.left_stick_y * .5);
        } else {
            Claw.setPower(0.0);
        }
        if (gamepad2.right_bumper) {
            Carasol.setPower(0.8);
        } else {
            Carasol.setPower(0.0);
        }
        if (gamepad2.left_bumper) {
            Carasol.setPower(-0.7);
        } else {
            Carasol.setPower(0.0);
        }
    }
}