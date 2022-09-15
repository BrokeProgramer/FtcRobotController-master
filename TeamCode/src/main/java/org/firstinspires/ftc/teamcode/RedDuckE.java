package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "RedDuckE", group = "EncoderUpgrade")
public class RedDuckE extends LinearOpMode {
    D4C D4CLT = new D4C();
    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        D4CLT.hold();
        waitForStart();
        // Go backwards
        D4CLT.hold();
        D4CLT.encoderDrive(0.4, 14, 14, 1000);
        D4CLT.StrafeRight();
        sleep(100);
        D4CLT.encoderDrive(0.4, -2, 2, 1000);
        D4CLT.stayConnected();
        sleep(3000);
        D4CLT.encoderDrive(0.4, -7, -7, 1000);
        D4CLT.encoderRightDrive(0.4, 25, 1000);
        D4CLT.encoderDrive(0.4, 21, 21, 1000);
        D4CLT.letGo();
        D4CLT.StrafeLeft();
        sleep(200);
        //D4CLT.encoderDrive();
    }
}