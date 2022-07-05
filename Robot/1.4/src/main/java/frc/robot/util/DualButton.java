// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Add your docs here. 
 * 
 * @param joystick, Your Joystick
 * @param button1, First button to be linked
 * @param button2, Second button to be linked
 * 
 * get()
 * @return TRUE if both buttons are pressed.
*/
public class DualButton extends Trigger {
    Joystick joystick;
    int button1;
    int button2;

    public DualButton (Joystick joystick, int button1, int button2) {
        this.joystick = joystick;
        this.button1 = button1;
        this.button2 = button2;
    }

    public boolean get () {
        return joystick.getRawButton(button1) && joystick.getRawButton(button2);
    }
}
