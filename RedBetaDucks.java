package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import android.database.sqlite.SQLiteException;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "RedBetaDucks", group = "game")
public class RedBetaDucks extends LinearOpMode {

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
        sleep(1200);
        turnLeft();
        sleep(50);
        stopexceptCarasol();
        sleep(5000);
        turnLeft();
        sleep(490);
        forward();
        sleep(240);
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
        frontLeft.setPower(-.1);
        frontRight.setPower(.1);
        backLeft.setPower(-.1);
        backRight.setPower(.1);
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
        frontLeft.setPower(.3);
        backLeft.setPower(-.3);
        frontRight.setPower(.3);
        backRight.setPower(-.3);
    }
    public void Straithleft() {
        frontLeft.setPower(-.3);
        backLeft.setPower(.3);
        frontRight.setPower(-.3);
        backRight.setPower(0.3);
    }
}

