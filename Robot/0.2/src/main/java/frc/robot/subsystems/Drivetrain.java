package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  public Timer timer;
  public VictorSP leftDrive;
  VictorSP rightDrive;
  DifferentialDrive drive;
  public SendableChooser<String> autoChooser;
  public Drivetrain() {
    leftDrive = new VictorSP(Constants.PWM.DRIVETRAIN_L);
    rightDrive = new VictorSP(Constants.PWM.DRIVETRAIN_R);
    drive = new DifferentialDrive(leftDrive, rightDrive);
    autoChooser = new SendableChooser<String>();
    timer = new Timer();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void teleopArcadeDrive (double XSpd, double YSpd) {
    drive.arcadeDrive(RobotContainer.controller.getRawAxis(1) * YSpd, RobotContainer.controller.getRawAxis(0) * XSpd);
  }


  public void teleopArcadeSprint (double XSpd, double YSpd) {
    // Makes robot drive 20 percent faster on both X and Y axes
    drive.arcadeDrive(RobotContainer.controller.getRawAxis(1) * YSpd, RobotContainer.controller.getRawAxis(0) * XSpd);
  }


  public void autoInit () {
    autoChooser.addOption("StraightBackRed", "Straight Back (Red)");
    autoChooser.addOption("StraightBackBlue" ,"Straight Back (Blue)");
    SmartDashboard.putData("autoChooser", autoChooser);
    timer.reset();
  }

  public void runAuto (double XSpd, double YSpd) {
    if(autoChooser.getSelected() == "Straight Back Red") {
      timer.start();
      while (timer.get() < 3) {
        drive.arcadeDrive(YSpd, XSpd);
      }
    }
  }

  public void stop () {
    drive.stopMotor();
  }
}
