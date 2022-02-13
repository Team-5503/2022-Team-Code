package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
  private final Drivetrain drivetrain;

  public DriveCommand(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    drivetrain.ArcadeDrive(0.7, 0.75);
  }


  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
