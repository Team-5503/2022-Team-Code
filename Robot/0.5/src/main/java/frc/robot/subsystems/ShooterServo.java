// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterServo extends SubsystemBase {
  private final Servo servo;
  /** Creates a new ShooterServo. */
  public ShooterServo() {
    servo = new Servo(3);
  }

  @Override
  public void periodic() {}

  public void engageServo () {
    servo.setAngle(0);
  }

  public void disengageServo () {
    servo.setAngle(90);
  }
}
