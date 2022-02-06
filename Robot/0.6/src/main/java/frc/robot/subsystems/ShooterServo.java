package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterServo extends SubsystemBase {
  private final Servo servo;

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
