package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "ShortBetaBlue", group = "game")
public class ShortBetaBlue extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo leftClaw;
    Servo rightClaw;
    DcMotor Claw;
    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        Claw = hardwareMap.dcMotor.get("Claw");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        hold();
        waitForStart();

        forward();
        sleep(900);
        turnRight();
        sleep(900);
        forward();
        sleep(250);
        stop();

        stopMotors();

    }
    public void Foldout(){
        Claw.setPower(.8);
    }
    public void Foldin(){
        Claw.setPower(-.8);
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
        frontLeft.setPower(0);
        frontRight.setPower(-.5);
        backLeft.setPower(0);
        backRight.setPower(-.5);
    }
    public void turnLeft() {
        frontLeft.setPower(0);
        frontRight.setPower(-.5);
        backLeft.setPower(0);
        backRight.setPower(-.5);
    }
    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
