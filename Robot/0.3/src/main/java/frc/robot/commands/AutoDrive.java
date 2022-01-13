// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private boolean finish = false;
  /** Creates a new AutoDrive. */
  public AutoDrive(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.autoInit();
    timer.reset();
    timer.start();
    while (timer.get() < 3) {
      drivetrain.AutoArcadeDrive(0, -0.5);
    }
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
