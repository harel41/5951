
package frc.robot.commands;

import frc.robot.subsystems.Mamota;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MamotaOutput extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Mamota mamota;

  public MamotaOutput(){
    mamota = Mamota.getinstance();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mamota);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   }

  @Override
  public void execute() {
    mamota.input(-1);
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


