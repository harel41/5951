
package frc.robot.commands;

import frc.robot.subsystems.mamota;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class mamotaOutput extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private mamota mamota;

  public mamotaOutput(mamota subsystem) {
    mamota = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    mamota.input(-1);
  }

}

