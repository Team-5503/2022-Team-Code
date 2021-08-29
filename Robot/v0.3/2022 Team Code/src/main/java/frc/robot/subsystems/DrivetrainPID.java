// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainPID extends SubsystemBase {

  private final PIDController pidController;
  public double pidOutput;

  public DrivetrainPID() {
    pidController = new PIDController(-0.35, 0, 0.001);
    pidController.setSetpoint(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void calculatePID () {
    pidOutput = pidController.calculate(3.575);
  }
}
