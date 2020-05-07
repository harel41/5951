
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamota;


/**
 * An example command that uses an example subsystem.
 */
public class MamotaPID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public Mamota mamota;
  private double PIDsetpoint;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public MamotaPID() {
    mamota = Mamota.getinstance();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mamota);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      PIDsetpoint = mamota.getDistance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mamota.move(mamota.encoderPID(PIDsetpoint));      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}