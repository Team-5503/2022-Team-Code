package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final PWMTalonFX ballShooter;
  public Shooter() {
    ballShooter = new PWMTalonFX(Constants.PWM.BALL_SHOOTER);
    ballShooter.setSafetyEnabled(false);


    }

  @Override
  public void periodic() {}

  public void runBallShooter (double speed) {
    ballShooter.set(speed);
  }

  public void runShooterWithLimelight (double speed) {
    ballShooter.set(speed);
  }

  public void stopBallShooter () {
    ballShooter.stopMotor();
  }
}
