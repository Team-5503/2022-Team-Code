package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterServo extends SubsystemBase {
  Servo shooterServo;
  public ShooterServo() {
    shooterServo = new Servo(6);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runServo(double angle) {
    shooterServo.setAngle(angle);
  }
}
