package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "BlueDuckE", group = "EncoderUpgrade")
public class BlueDuckE extends LinearOpMode {
    D4C D4CLT = new D4C();
    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        D4CLT.hold();
        waitForStart();
        // Go backwards
        D4CLT.hold();
        D4CLT.encoderDrive(0.4, 12, 12, 1000);
        D4CLT.StrafeLeft();
        sleep(200);
        D4CLT.encoderDrive(0.4, 3, 3, 1000);
        D4CLT.stayConnected();
        sleep(3000);
        D4CLT.encoderDrive(0.4, -7, -7, 1000);
        D4CLT.encoderLeftDrive(0.4, 25, 1000);
        D4CLT.encoderDrive(0.4, 20, 20, 1000);
        D4CLT.letGo();
        sleep(200);
        //D4CLT.encoderDrive();
    }
}