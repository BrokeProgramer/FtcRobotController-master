package org.firstinspires.ftc.teamcode.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "motorTest")
public class motorTest extends LinearOpMode {

    DcMotor motor;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("frontRight");

        waitForStart();

        while (opModeIsActive()) {
            motor.setPower(.2);
        }
    }
}
