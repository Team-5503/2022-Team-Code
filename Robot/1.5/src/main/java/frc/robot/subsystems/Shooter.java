package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class Shooter extends SubsystemBase {
  private final TalonFX ballShooter;
  double velocity;
  public Shooter() {
   
    ballShooter = new TalonFX(Constants.CAN.SHOOTER);
    ballShooter.configSelectedFeedbackSensor(FeedbackDevice.Tachometer);
    }

  @Override
  public void periodic() {}

  public void runBallShooter (double speed) {
    ballShooter.set(ControlMode.PercentOutput, speed, DemandType.Neutral, 0);
    velocity = ballShooter.getSelectedSensorVelocity();
    SmartDashboard.putNumber("Shooter Velocity", velocity);
  }

  public void stopBallShooter () {
    ballShooter.set(ControlMode.PercentOutput, 0, DemandType.Neutral, 0);
  }
}
