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

    public final class PWM {
        
        public static final int LEFT_DRIVE = 0;
        public static final int RIGHT_DRIVE = 1;
        public static final int TOP_SHOOTER = 2;
        public static final int BOTTOM = 3;
        public static final int INTAKE = 4;
        public static final int SERVO = 9;
    }


    public final class SubsystemSpeeds { // Maximum allowed speed for each Subsystem

        public static final double ARCADE_X_DRIVE = 0.65;
        public static final double ARCADE_Y_DRIVE = 0.7;

        public static final double INTAKE = 0.5;

        public static final double TOP_SHOOTER = 0.65;
        public static final double BOTTOM_SHOOTER = 0.65;

        public static final double SERVO_ENGAGED_ANGLE = 90;
        public static final double SERVO_DISENGAGED_ANGLE = 0;
    }


    public final class USB {
        public static final int OPERATOR_1_USB = 0;
        // public static final int OPERATOR_2_USB = 1; // Not in use
    }
}
