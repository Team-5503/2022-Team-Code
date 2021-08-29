package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainPID;

public class LimelightDrive extends CommandBase {

  private final Drivetrain drivetrain;
  private final DrivetrainPID drivetrainPID;


  public LimelightDrive(Drivetrain dt, DrivetrainPID d_PID) {

    drivetrain = dt;
    drivetrainPID = d_PID;

    addRequirements(drivetrain);
    addRequirements(drivetrainPID);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.limelightDrive(RobotContainer.operatorJoystick, 0.5, drivetrainPID.pidOutput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
