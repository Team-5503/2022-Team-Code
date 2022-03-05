package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LowerShooterLift extends SubsystemBase {
  private final PWMSparkMax lowerShooterLift;
  

  public LowerShooterLift() {
    lowerShooterLift = new PWMSparkMax(Constants.PWM.LOWER_SHOOTER_LIFT);
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
