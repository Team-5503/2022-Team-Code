package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  CANSparkMax topShooter;
  CANSparkMax bottomShooter;

  CANPIDController topPid;
  CANPIDController bottomPid;

  public Shooter() {
    topShooter = new CANSparkMax(1, MotorType.kBrushless);
    bottomShooter = new CANSparkMax(4, MotorType.kBrushless);

    topPid = topShooter.getPIDController();
    topPid.setP(-0.35);
    topPid.setI(0);
    topPid.setD(0.01);

    bottomPid = bottomShooter.getPIDController();
    bottomPid.setP(-0.35);
    bottomPid.setI(0);
    bottomPid.setD(0.01);
    bottomPid.setOutputRange(-1, 1);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double topSpeed, double bottomSpeed) {
    topShooter.set(topSpeed * -1);
    bottomShooter.set(bottomSpeed);
  }

  public void stopShooter() {
    topShooter.stopMotor();
    bottomShooter.stopMotor();
  }
}
