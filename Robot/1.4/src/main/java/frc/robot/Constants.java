// ======================= //
// CREATED AND PROGRAMMED  //
// BY IAN FETTES           //
// ======================= //

package frc.robot;


public final class Constants {

    public final class PWM { //PWM values for each device
        public static final int DRIVETRAIN_L = 0;
        public static final int DRIVETRAIN_R = 1;
        public static final int LOWER_SHOOTER_LIFT = 2;
    }

    public final class CAN { // CAN IDs for each device
        public static final int SHOOTER = 2;
        public static final int CLIMBER_L = 3;
        public static final int CLIMBER_R = 4;
        public static final int INTAKE = 5;
        public static final int AGITATOR = 6;
    }

    public final class USB { // USB devices
        public static final int OPERATOR_0 = 0;
    }

    public final class MaxSubsystemValues { // Max allowed speed for each motor / subsystem
        public static final double DRIVETRAIN_X = 0.7;
        public static final double DRIVETRAIN_Y = 0.75;
        public static final double INTAKE = 0.25;
        public static final double LOWER_SHOOTER_LIFT = 0.4;
        public static final double UPPER_SHOOTER_LIFT = -0.5;
    }

    // public final static double[][] SHOOTER_DATA = { {5.50, 11788}, {10.60, 10938}, {16.26, 11190}, {17.67, 10000}, {3.3, 12621}, {-0.056, 13551} };
}
