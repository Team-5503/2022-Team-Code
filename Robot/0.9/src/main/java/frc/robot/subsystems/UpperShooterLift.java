package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class UpperShooterLift extends SubsystemBase {
  PWMSparkMax upperShooterLift;


  public UpperShooterLift() {
    upperShooterLift = new PWMSparkMax(Constants.PWM.UPPER_SHOOTER_LIFT);
    upperShooterLift.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {}


  public void liftUp () {
    upperShooterLift.set(0.25);
  }

  public void stop () {
    upperShooterLift.stopMotor();
  }
}
