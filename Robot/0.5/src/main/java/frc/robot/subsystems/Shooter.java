// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final PWMSparkMax shooterLift;

  /** Creates a new Shooter. */
  public Shooter() {
    shooterLift = new PWMSparkMax(2);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter () {
    shooterLift.set(0.25);
  }

  public void stopShooter () {
    shooterLift.stopMotor();
  }
}
