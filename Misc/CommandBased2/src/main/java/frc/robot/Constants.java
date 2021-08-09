// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final double DRIVETRAINSPEED = 0.7;
    public static final double SHOOTER_SPEED = 0.5;
    public static final double INTAKE_IN_SPEED = -0.65;
    public static final double INTAKE_OUT_SPEED = 0.65;
    public static final double DISENGAGED_SERVO_ANGLE = 90;
    public static final double ENGAGED_SERVO_ANGLE = 0;


    // USB
        public static final int JOYSTICK_NUMBER = 0;


    // PWM Constants
        public static final int LEFT_DRIVE_PWM = 0;
        public static final int RIGHT_DRIVE_PWM = 1;

        public static final int INTAKE_PWM = 2;

    // Only if Electrical chooses to use PWM over CAN
        public static final int TOP_SHOOTER_PWM = 3;
        public static final int BOTTOM_SHOOTER_PWM = 4;

        public static final int SERVO_PWM = 9;


    // CAN Constants
        public static final int TOP_SHOOTER_CAN_ID = 1;
        public static final int BOTTOM_SHOOTER_CAN_ID = 4;

        public static final int LEFT_ARM_CAN_ID = 2;
        public static final int RIGHT_ARM_CAN_ID = 3;


    // Controller Constants

            // Axes
                public static final int CONTROLLER_LS_X_AXIS = 0;
                public static final int CONTROLLER_LS_Y_AXIS = 1;
                public static final int CONTROLLER_RS_X_AXIS = 2;
                public static final int CONTROLLER_RS_Y_AXIS = 3;

            // Buttons
                public static final int X = 1;
                public static final int A = 2;
                public static final int B = 3;
                public static final int Y = 4;
                public static final int LB = 5;
                public static final int RB = 6;
                public static final int LT = 7;
                public static final int RT = 8;
                public static final int SELECT = 9;
                public static final int START = 10;
                public static final int LS_PRESS = 11;
                public static final int RS_PRESS = 12;

    
    // Autonomous Constants
        public static final double DRIVE_FORWARD_TIME = 3.0;
        public static final double AUTO_SPEED = 0.65;


    // Limelight Constants
        public static final int LIMELIGHT_VISION_PROCESSOR = 0;
        public static final int LIMELIGHT_OPERATOR_CAMERA = 1;

        public static final int LIMELIGHT_LED_ON = 3;
        public static final int LIMELIGHT_LED_OFF = 1;
}
