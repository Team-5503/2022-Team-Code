// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  private final Dashboard dashboard;
  /** Creates a new Limelight. */
  public Limelight() {
    dashboard = new Dashboard();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enableVision () {
    dashboard.publishData("camMode", 0);
    dashboard.publishData("ledMode", 3);
  }

  public void disableVision () {
    dashboard.publishData("camMode", 1);
    dashboard.publishData("ledMode", 1);
  }
}
