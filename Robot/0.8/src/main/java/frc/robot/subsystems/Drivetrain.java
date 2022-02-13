package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  public VictorSP leftDrive;
  public VictorSP rightDrive;
  DifferentialDrive drive;

  public Drivetrain() {
    leftDrive = new VictorSP(0);
    rightDrive = new VictorSP(1);
    drive = new DifferentialDrive(leftDrive, rightDrive);
  }

  @Override
  public void periodic() {}

  public void ArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(RobotContainer.controller.getRawAxis(0) * YSpd, 
    RobotContainer.controller.getRawAxis(1) * XSpd);
  }

  public void AutoArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(YSpd, XSpd);
  }

  public void stop () {
    drive.stopMotor();
  }
}