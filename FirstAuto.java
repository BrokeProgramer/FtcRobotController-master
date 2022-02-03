package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "FirstAuto test")
public class FirstAuto extends LinearOpMode {
    // characteristics
    // define your hardware
    DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        waitForStart();

        // instructions
        forward();
        sleep(1500);

        backwards();
        sleep(1500);

        turnLeft();
        sleep(1500);

        turnRight();
        sleep(1500);

        forward();
        sleep(750);

        stopMotors();
    }
    // behaviors
    // forward
    public void forward() {
        frontLeft.setPower(.5);
        frontRight.setPower(-.5);
        backLeft.setPower(.5);
        backRight.setPower(-.5);
    }

    // backwards
    public void backwards() {
        frontLeft.setPower(-.5);
        frontRight.setPower(.5);
        backLeft.setPower(-.5);
        backRight.setPower(.5);
    }

    // turn right
    public void turnRight() {
        frontLeft.setPower(.5);
        frontRight.setPower(0);
        backLeft.setPower(.5);
        backRight.setPower(0);
    }

    // turn left
    public void turnLeft() {
        frontLeft.setPower(0);
        frontRight.setPower(-.5);
        backLeft.setPower(0);
        backRight.setPower(-.5);
    }

    // stop
    public void stopMotors() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}