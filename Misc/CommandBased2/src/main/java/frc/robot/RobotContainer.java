// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;


import frc.robot.commands.DisengageServo;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.EngageServo;
import frc.robot.commands.RunIntake_BallsIn;
import frc.robot.commands.RunIntake_BallsOut;
import frc.robot.commands.RunShooter;
import frc.robot.commands.Targeting_Disable;
import frc.robot.commands.Targeting_Enable;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterServo;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoystick;
  private final DriveForwardTimed driveForwardTimed;
  public static Joystick driverJoystick;

  private final Shooter shooter;
  private final RunShooter runShooter;

  private final ShooterServo shooterServo;
  private final DisengageServo disengageServo;
  private final EngageServo engageServo;

  private final Intake intake;
  private final RunIntake_BallsIn runIntake_BallsIn;
  private final RunIntake_BallsOut runIntake_BallsOut;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Initialize Drivetrain
      driveTrain = new DriveTrain();
      driveWithJoystick = new DriveWithJoysticks(driveTrain);
      driveWithJoystick.addRequirements(driveTrain);
      driveTrain.setDefaultCommand(driveWithJoystick);

      driveForwardTimed = new DriveForwardTimed(driveTrain);
      driveForwardTimed.addRequirements(driveTrain);

      driverJoystick = new Joystick(Constants.JOYSTICK_NUMBER);

    
    // Initialize Shooter
      shooter = new Shooter();
      runShooter = new RunShooter(shooter);
      runShooter.addRequirements(shooter);

    
    // Initialize Shooter Servo

    shooterServo = new ShooterServo();
    disengageServo = new DisengageServo(shooterServo);
    engageServo = new EngageServo(shooterServo);
    disengageServo.addRequirements(shooterServo);
    engageServo.addRequirements(shooterServo);
    shooterServo.setDefaultCommand(engageServo);



    // Initialize Intake
      intake = new Intake();
      runIntake_BallsIn = new RunIntake_BallsIn(intake);
      runIntake_BallsOut = new RunIntake_BallsOut(intake);
      runIntake_BallsIn.addRequirements(intake);
      runIntake_BallsOut.addRequirements(intake);
      
    {
      
    };{
      
    };
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    JoystickButton shootButton = new JoystickButton(driverJoystick, Constants.RT);
    shootButton.whileHeld(new RunShooter(shooter));


    JoystickButton IntakeInButton = new JoystickButton(driverJoystick, Constants.Y);
    IntakeInButton.whileHeld(new RunIntake_BallsIn(intake));


    JoystickButton IntakeOutButton = new JoystickButton(driverJoystick, Constants.A);
    IntakeOutButton.whileHeld(new RunIntake_BallsOut(intake));


    JoystickButton DisengageServoButton = new JoystickButton(driverJoystick, Constants.LT);
    DisengageServoButton.whileHeld(new DisengageServo(shooterServo));
    

    JoystickButton EngageServoButton = new JoystickButton(driverJoystick, Constants.LT);
    EngageServoButton.whenReleased(new EngageServo(shooterServo));


    JoystickButton VisionToggleButton = new JoystickButton(driverJoystick, Constants.X);
    VisionToggleButton.toggleWhenPressed(new Targeting_Enable());
    VisionToggleButton.toggleWhenPressed(new Targeting_Disable());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // driveForwardTimed will run in Autonomous
    return driveForwardTimed;
  }
}
