
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


/**
 * An example command that uses an example subsystem.
 */
public class IntakePID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake intake;
  private double setPoint;
  private double waitTime;
  private double lastTimeOnTarget;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public IntakePID(double setPoint, double waitTime) {
    intake = Intake.getinstance();
    this.setPoint = setPoint;
    this.waitTime = waitTime;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.moveIntake(intake.encoderPID(setPoint));      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.moveIntake(0);

  }
  @Override
  public boolean isFinished() {
    if(!intake.PIDatSetpoint()){
      lastTimeOnTarget = Timer.getFPGATimestamp();
    }
    return intake.PIDatSetpoint() && Timer.getFPGATimestamp() - lastTimeOnTarget > waitTime;
  }
}
