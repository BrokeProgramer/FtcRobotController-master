package org.firstinspires.ftc.teamcode.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Tutorial")
public class Tutorial extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.speak("How did I get here");
        sleep(5000);
    }
}