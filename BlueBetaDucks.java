package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "BlueBetaDucks", group = "game")
public class BlueBetaDucks extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor Carasol;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        Carasol = hardwareMap.dcMotor.get("Carasol");
        waitForStart();
        Straithright();
        sleep(150);
        backwards();
        sleep(1500);
        CarasolRightSide();
        sleep(5000);
        turnRight();
        sleep(1000);
        forward();
        sleep(500);
        turnLeft();
        sleep(500);
        backwards();
        sleep(400);
        stop();
        stopMotors();

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
        Carasol.setPower(.8);
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

