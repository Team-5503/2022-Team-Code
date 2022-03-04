package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private final PWMTalonFX leftClimber;
  private final PWMTalonFX rightClimber;
  public Climber() {
    leftClimber = new PWMTalonFX(7);
    leftClimber.setSafetyEnabled(false);
    rightClimber = new PWMTalonFX(8);
    rightClimber.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {}

  public void climberUp () {
    leftClimber.set(0.1);
    rightClimber.set(0.1);
  }

  public void climberDown () {
    leftClimber.set(-0.1);
    rightClimber.set(-0.1);
  }

  public void stopClimber () {
    leftClimber.stopMotor();
    rightClimber.stopMotor();
  }
}
