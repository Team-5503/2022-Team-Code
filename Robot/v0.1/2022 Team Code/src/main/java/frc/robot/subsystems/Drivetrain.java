package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  VictorSP leftDrive;
  VictorSP rightDrive;
  DifferentialDrive drive;

  public Drivetrain() {

    leftDrive = new VictorSP(0);
    rightDrive = new VictorSP(1);
    drive = new DifferentialDrive(leftDrive, rightDrive);
  }

  public void teleopDrive (GenericHID controller, double Y_Speed, double X_Speed) {
    drive.arcadeDrive(controller.getRawAxis(1) * Y_Speed, controller.getRawAxis(0) * X_Speed);
  }

  // public void limelightDrive_TrackX (GenericHID controller, double Y_Speed, double X_PID) {
    // drive.arcadeDrive(controller.getRawAxis(1) * Y_Speed, controller.getRawAxis(0) * X_PID);
  //}

  public void autoDrive (double L_Speed, double R_Speed) {}
  

  public void stop() {
    drive.stopMotor();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}