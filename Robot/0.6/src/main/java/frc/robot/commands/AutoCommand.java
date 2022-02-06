package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Dashboard;
import frc.robot.subsystems.Drivetrain;

public class AutoCommand extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private final Dashboard dashboard;
  private boolean finish = false;

  public AutoCommand(Drivetrain dt, Dashboard db) {
    drivetrain = dt;
    dashboard = db;
    addRequirements(drivetrain);
    addRequirements(dashboard);
    timer = new Timer();
  }


  @Override
  public void initialize() {
    timer.reset();

    if (dashboard.autoChooser.getSelected().contains("None")) {
      drivetrain.stop();
    } else if (dashboard.autoChooser.getSelected().contains("Straight Back Red")) {
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, -0.5);
      }
      finish = true;
    } else if (dashboard.autoChooser.getSelected().contains("Straight Back Blue")) {
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
