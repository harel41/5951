

package frc.robot.commands;

import frc.robot.subsystems.Mamota;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MamotaInput extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private Mamota mamota;

    public MamotaInput() {
        mamota = Mamota.getinstance();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        mamota.input(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      mamota.input(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
