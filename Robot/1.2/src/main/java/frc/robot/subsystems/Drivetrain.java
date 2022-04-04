package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  private final VictorSP leftDrive;
  private final VictorSP rightDrive;
  DifferentialDrive drive;

  public Drivetrain() {
    leftDrive = new VictorSP(0);
    leftDrive.setSafetyEnabled(false);
    rightDrive = new VictorSP(1);
    rightDrive.setSafetyEnabled(false);

    drive = new DifferentialDrive(leftDrive, rightDrive);
    drive.setSafetyEnabled(false);

    }

  @Override
  public void periodic() {}

  public void ArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(RobotContainer.m_controller.getRawAxis(0) * XSpd, 
    RobotContainer.m_controller.getRawAxis(1) * YSpd);
  }
  
  public void LimelightDrive_X (double XSpd, double YSpd) {
    drive.setMaxOutput(0.7);
    drive.arcadeDrive(XSpd, RobotContainer.m_controller.getRawAxis(1) * YSpd);
  }
  
  public void AutoArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(XSpd, YSpd);
  }

  
  public void stop () {
    drive.stopMotor();
  }

}