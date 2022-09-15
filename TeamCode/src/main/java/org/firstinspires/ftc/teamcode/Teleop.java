package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.teamcode.Autonomous.D4C;

@TeleOp(name = "Teleop")
public class Teleop extends OpMode {

    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor backRight;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
    }

    @Override
    public void loop() {


        // Driving forwards
        if (Math.abs(-gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y * -.6);
            backLeft.setPower(-gamepad1.left_stick_y * .6);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (Math.abs(-gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y * -.6);
            backRight.setPower(-gamepad1.right_stick_y * .6);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }
    }
}