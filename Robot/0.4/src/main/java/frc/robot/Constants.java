// ======================= //
// CREATED AND PROGRAMMED  //
// BY IAN FETTES           //
// ======================= //

package frc.robot;


public final class Constants {

    public final class PWM {
        public static final int DRIVETRAIN_L = 0;
        public static final int DRIVETRAIN_R = 1;
    }

    public final class USB {
        public static final int OPERATOR_0 = 0;
    }

    public final class MaxSubsystemValues { // Max allowed speed for each motor / subsystem
        public static final double DRIVETRAIN_X = 0.7;
        public static final double DRIVETRAIN_Y = 0.75;
        public static final double DRIVETRAIN_SPR_X = 0.9;  // When Oscar-Mike mode is active
        public static final double DRIVETRAIN_SPR_Y = 0.95; // When Oscar-Mike mode is active
    }
}
