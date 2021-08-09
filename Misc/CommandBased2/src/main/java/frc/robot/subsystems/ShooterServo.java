// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterServo extends SubsystemBase {
  Servo ShooterServo;
  /** Creates a new ShooterServo. */
  public ShooterServo() {
    ShooterServo = new Servo(Constants.SERVO_PWM);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void disengageServo(double degrees) {
    ShooterServo.setAngle(degrees);
  }

  public void engageServo(double degrees) {
    ShooterServo.setAngle(degrees);
  }

public void setAngle(double disengagedServoAngle) {
}
}
