// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  private final Dashboard dashboard;
  PIDController pid;
  /** Creates a new Limelight. */
  public Limelight() {

    dashboard = new Dashboard();
    pid = new PIDController(-0.35, 0, 0.01);
    pid.setSetpoint(0);
    pid.enableContinuousInput(-0.7, 0.7);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enableVision () {
    dashboard.publishData("camMode", 0);
    dashboard.publishData("ledMode", 3);
    pid.calculate(dashboard.getDouble("tx", 0));
  }

  public void disableVision () {
    dashboard.publishData("camMode", 1);
    dashboard.publishData("ledMode", 1);
  }
}
