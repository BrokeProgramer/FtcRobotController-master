package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "ShortBlueE", group = "EncoderUpgrade")
public class ShortBlueE extends LinearOpMode {
    D4C D4CLT = new D4C();
    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        D4CLT.hold();
        waitForStart();

        // Go backwards
        D4CLT.hold();
        D4CLT.Fall();
        D4CLT.encoderDrive(0.4, -23, -23, 1000);
        D4CLT.encoderLeftDrive(0.4, -28, 1000);
        D4CLT.encoderDrive(0.4, -9, -9, 1000);
        D4CLT.encoderLeftDrive(0.4, -12.6, 1000);



        //D4CLT.encoderDrive();
    }
}
