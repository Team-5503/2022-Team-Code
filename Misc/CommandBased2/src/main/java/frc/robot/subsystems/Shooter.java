// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  Spark topShooter;
  Spark bottomShooter;
  /** Creates a new Shooter. */
  public Shooter() {
    topShooter = new Spark(Constants.TOP_SHOOTER_PWM);
    bottomShooter = new Spark(Constants.BOTTOM_SHOOTER_PWM);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double speed) {
    topShooter.set(speed * -1); // Inverted
    bottomShooter.set(speed);
  }
  
  public void stopShooter() {
    topShooter.set(0);
    bottomShooter.set(0);
  }
}
