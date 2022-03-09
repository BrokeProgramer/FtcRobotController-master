package org.firstinspires.ftc.teamcode.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "D4CTest", group = "EncoderUpgrade")
public class D4Ctest extends LinearOpMode {
    D4C D4CLT = new D4C();
    @Override
    public void runOpMode() throws InterruptedException {
        D4CLT.init(hardwareMap, telemetry);
        waitForStart();

        D4CLT.hold();
        // Turn right
        D4CLT.encoderLeftDrive(0.4, -26, 1000);

        D4CLT.letGo();

        // Raise arm
        D4CLT.setArm(-200);

        //D4CLT.encoderDrive();
    }
}
