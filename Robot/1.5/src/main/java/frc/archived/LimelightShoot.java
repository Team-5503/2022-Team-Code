// package frc.robot.commands.archived;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Limelight;
// import frc.robot.subsystems.Shooter;

// public class LimelightShoot extends CommandBase {
//   private final Shooter shooter;
//   private final Limelight limelight;
//   public LimelightShoot(Shooter s, Limelight ll) {
//     shooter = s;
//     limelight = ll;
//     addRequirements(shooter, limelight);
//     }

//   @Override
//   public void initialize() {}

//   @Override
//   public void execute() {
//     limelight.trackTargetX();
//     limelight.limelightOn();
//   }

//   @Override
//   public void end(boolean interrupted) {}

//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
