
package frc.robot.commands;

import frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakePull extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private intake intake;

  public intakePull(intake subsystem) {
    intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    intake.intakeCollect(1);
    
  }
}
