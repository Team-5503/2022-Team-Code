// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeAgitator extends SubsystemBase {
  private final VictorSP intakeAgitator;
  /** Creates a new IntakeAgitator. */
  public IntakeAgitator() {
    intakeAgitator = new VictorSP(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void agitatorForward () {
    intakeAgitator.set(-1);
  }

  public void agitatorReverse () {
    intakeAgitator.set(1);
  }

  public void stop() {
    intakeAgitator.stopMotor();
  }
}
