package frc.robot.commands;

import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ClimbCommend extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  Climb climb;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public ClimbCommend() {
    climb = Climb.getinstance();
    addRequirements(climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (climb.sPiston.get() == Value.kForward){
      climb.pistonFor();
  }
  else{
      climb.pistonRev();
   }
  }
}