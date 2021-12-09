package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class SwitchingBaseTemplate extends OpMode {

    boolean aState, aCurr, aPrev;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        aPrev = aCurr;
        aCurr = gamepad1.a;

        if (aCurr && !aPrev)
            aState = !aState;

        if (!aState) {
            //put program here for driving
        }
        else {
            //put driving program here again but change the values
        }
    }
}
