// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  private final Drivetrain drivetrain;

  /** Creates a new c_TeleopDrive. */
  public TeleopDrive(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.ArcadeDrive(Constants.MaxSubsystemValues.DRIVETRAIN_X, Constants.MaxSubsystemValues.DRIVETRAIN_Y); // X = 0.7, Y = 0.75
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
