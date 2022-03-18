// ======================= //
// CREATED AND PROGRAMMED  //
// BY IAN FETTES           //
// ======================= //

package frc.robot;


public final class Constants {

    public final class PWM { //PWM values for each device
        public static final int DRIVETRAIN_L = 0;
        public static final int DRIVETRAIN_R = 1;
        public static final int INTAKE = 3;
        public static final int LOWER_SHOOTER_LIFT = 4;
        public static final int UPPER_SHOOTER_LIFT = 5;
        public static final int BALL_SHOOTER = 6;

    }

    public final class PCM { // PCM IDs for each device
        public static final int SOLENOID_1 = 5;
        public static final int SOLENOID_2 = 7;
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


    public static final double[][] ShooterConstants = {
  // {<TY>, <RPM>}
        {0, 0},
        {0, 0},
        {0, 0},
        {0, 0},
        {0, 0},
    };
}
