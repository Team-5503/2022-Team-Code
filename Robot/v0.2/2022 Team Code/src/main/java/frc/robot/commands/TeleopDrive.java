package frc.robot.commands;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
public class TeleopDrive extends CommandBase {

  private final Drivetrain drivetrain;

  public TeleopDrive(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
    }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute () {
      drivetrain.teleopDrive(RobotContainer.operatorJoystick, Constants.SubsystemSpeeds.ARCADE_Y_DRIVE, Constants.SubsystemSpeeds.ARCADE_X_DRIVE);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
