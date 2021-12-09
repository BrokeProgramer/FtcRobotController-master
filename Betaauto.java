package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name = "Betaauto")
public class Betaauto extends LinearOpMode {

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
        backwards();
        sleep(550);
        stopexceptCarasol();
        sleep(1500);
        turnLeft();
        sleep(600);
        forward();
        sleep(1000);
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
}
