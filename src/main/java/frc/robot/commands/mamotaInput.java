

package frc.robot.commands;

import frc.robot.subsystems.mamota;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class mamotaInput extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private mamota mamota;

  public mamotaInput(mamota subsystem) {
    mamota = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    mamota.input(1);
  }
}
