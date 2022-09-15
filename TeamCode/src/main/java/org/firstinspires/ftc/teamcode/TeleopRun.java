package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.teamcode.Autonomous.D4C;

@TeleOp(name = "TeleopRun")
public class TeleopRun extends OpMode {

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
    public void init() {
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
                frontLeft.setPower(-.8);
                backLeft.setPower(.8);
                frontRight.setPower(-.8);
                backRight.setPower(.8);
            }
            if (gamepad1.dpad_left) {
                frontLeft.setPower(.8);
                backLeft.setPower(-.8);
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
                frontLeft.setPower(.8);
                backLeft.setPower(-.8);
                frontRight.setPower(.8);
                backRight.setPower(-.8);
            }
            if (gamepad1.dpad_left) {
                frontLeft.setPower(-.8);
                backLeft.setPower(.8);
                frontRight.setPower(-.8);
                backRight.setPower(0.8);
            }
        }
        if (gamepad2.a) {
            if (gamepad2.b) {
                leftClaw.setPosition(.4);
                rightClaw.setPosition(.6);
            } else {
                leftClaw.setPosition(.15);
                rightClaw.setPosition(.85);
            }
        } else {
            leftClaw.setPosition(-1.0);
            rightClaw.setPosition(1.0);
        }
        if (gamepad2.right_bumper) {
            ArmMotor1.setPower(.8);
            ArmMotor2.setPower(-.8);
        }
        else {
            ArmMotor1.setPower(0);
            ArmMotor2.setPower(0);
        }
        if (gamepad2.left_bumper) {
            ArmMotor1.setPower(-.6);
            ArmMotor2.setPower(.6);
        }
        else {
            ArmMotor1.setPower(0);
            ArmMotor2.setPower(0);
        }
        if (Math.abs(gamepad2.right_trigger) > .1) {
            Lift.setPower(gamepad2.right_trigger * .5);
        }
        if (Math.abs(gamepad2.left_trigger) > .1) {
            Lift.setPower(gamepad2.left_trigger * -.5);
        }
        if (gamepad2.dpad_right) {
            Hopper.setPower(.3);
        }
        else if (gamepad2.dpad_left){
            Hopper.setPower(-.3);
        }
        else {
            Hopper.setPower(0);
        }
    }
}