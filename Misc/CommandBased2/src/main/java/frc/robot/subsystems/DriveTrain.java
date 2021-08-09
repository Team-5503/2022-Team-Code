// Programmed by Ian Fettes
// Lead Programmer, FRC #5503

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  VictorSP leftDrive;
  VictorSP rightDrive;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive Drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftDrive = new VictorSP(Constants.LEFT_DRIVE_PWM);
    rightDrive = new VictorSP(Constants.RIGHT_DRIVE_PWM);

    leftMotors = new SpeedControllerGroup(leftDrive);
    rightMotors = new SpeedControllerGroup(rightDrive);

    Drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(GenericHID controller, double speed) {
    Drive.arcadeDrive(controller.getRawAxis(Constants.CONTROLLER_LS_Y_AXIS) * speed, controller.getRawAxis(Constants.CONTROLLER_LS_X_AXIS) * speed);
  }

  public void AUTO_driveForward(double speed) {
    Drive.tankDrive(speed, speed);
  }

  public void AUTO_stop() {
    Drive.stopMotor();
  }

public void stop() {
}

}
