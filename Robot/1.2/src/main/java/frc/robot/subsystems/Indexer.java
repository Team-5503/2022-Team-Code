package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  private final PWMSparkMax lowerShooterLift;
  

  public Indexer() {
    lowerShooterLift = new PWMSparkMax(2);
    lowerShooterLift.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {}

  public void liftUp (double speed) {
    lowerShooterLift.set(speed);
  }

  public void liftDown (double speed) {
    lowerShooterLift.set(speed);
  }

  public void stop () {
    lowerShooterLift.stopMotor();
  }
}
