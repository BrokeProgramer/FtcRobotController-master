package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "RedLefthublv3", group = "Colored Zone")
public class RedLefthublv3 extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor Carasol;
    Servo leftClaw;
    Servo rightClaw;
    DcMotor Claw;
    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        Carasol = hardwareMap.dcMotor.get("Carasol");
        Claw = hardwareMap.dcMotor.get("Claw");
        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");
        hold();
        waitForStart();
        //move "forward"(camera side)
        backwards();
        sleep(1000);
        //turn toward hub
        turnRight();
        sleep(800);
        //move towards hub
        backwards();
        sleep(900);
        //arm down to rest on lip
        //let arm fall
        //let go
        //put arm up in air
        //turn torwards hole
        //drive to hole
        //turn into proper position
        //drive in


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
        frontLeft.setPower(-.2);
        frontRight.setPower(.2);
        backLeft.setPower(-.2);
        backRight.setPower(.2);
    }
    public void Straithleft() {
        frontLeft.setPower(.2);
        frontRight.setPower(-.2);
        backLeft.setPower(.2);
        backRight.setPower(-.2);
    }
}