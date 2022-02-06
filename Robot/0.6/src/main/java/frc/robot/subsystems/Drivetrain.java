package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
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
  public void periodic() {
    drive.stopMotor();
  }

  public void ArcadeDrive () {
    drive.arcadeDrive(RobotContainer.controller.getRawAxis(1) * Constants.MaxSubsystemValues.DRIVETRAIN_Y, 
    RobotContainer.controller.getRawAxis(0) * Constants.MaxSubsystemValues.DRIVETRAIN_X);
  }

  public void AutoArcadeDrive (double YSpd, double XSpd) {
    drive.arcadeDrive(YSpd, XSpd);
  }

  public void stop () {
    drive.stopMotor();
  }
}