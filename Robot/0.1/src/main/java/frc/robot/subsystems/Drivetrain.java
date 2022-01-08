package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  VictorSP leftDrive;
  VictorSP rightDrive;
  DifferentialDrive drive;
  public Drivetrain() {
    leftDrive = new VictorSP(Constants.PWM.DRIVETRAIN_L);
    rightDrive = new VictorSP(Constants.PWM.DRIVETRAIN_R);

    drive = new DifferentialDrive(leftDrive, rightDrive);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void teleopArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(RobotContainer.controller.getRawAxis(1) * YSpd, RobotContainer.controller.getRawAxis(0) * XSpd);
  }

  public void stop () {
    drive.stopMotor();
  }
}
