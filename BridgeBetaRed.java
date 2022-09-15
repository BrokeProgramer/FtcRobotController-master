package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "BridgeBetaRed", group = "Beta")
public class BridgeBetaRed extends LinearOpMode {

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
        hold();
        waitForStart();

        forward();
        sleep(800);
        turnLeft();
        sleep(1000);
        forward();
        sleep(600);
        stop();

        stopMotors();

    }
    public void hold(){
        leftClaw.setPosition(-1.0);
        rightClaw.setPosition(1.0);
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
        frontLeft.setPower(-.5);
        frontRight.setPower(.5);
        backLeft.setPower(-.5);
        backRight.setPower(.5);
    }
    public void turnRight() {
        frontLeft.setPower(.5);
        frontRight.setPower(0);
        backLeft.setPower(.5);
        backRight.setPower(0);
    }
    public void turnLeft() {
        frontLeft.setPower(.5);
        frontRight.setPower(0);
        backLeft.setPower(.5);
        backRight.setPower(0);
    }
    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
