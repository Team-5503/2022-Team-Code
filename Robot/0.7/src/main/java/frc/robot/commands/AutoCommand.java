package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class AutoCommand extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private boolean finish = false;

  public AutoCommand(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
    timer = new Timer();
  }


  @Override
  public void initialize() {
        timer.reset();
    if (RobotContainer.autoChooser.getSelected().contains("None")) {
      drivetrain.stop();
    } else if (RobotContainer.autoChooser.getSelected().contains("StraightBackRed")) {
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, -0.5);
      }
      finish = true;
    } else if (RobotContainer.autoChooser.getSelected().contains("StraightBackBlue")) {
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, -0.5);
      }
      finish = true;
  }

}


  @Override
  public void execute() {}


  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  
  @Override
  public boolean isFinished() {
    drivetrain.stop();
    return finish;
  }
}
