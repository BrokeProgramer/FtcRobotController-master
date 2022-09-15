package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "StagingERed", group = "EncoderUpgrade")
public class StagingERed extends LinearOpMode {
    D4C D4CLT = new D4C();
    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        D4CLT.hold();
        waitForStart();

        // Go backwards
        D4CLT.hold();
        D4CLT.encoderDrive(0.4, 24, 24, 1000);



        //D4CLT.encoderDrive();
    }
}