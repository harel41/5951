

package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.mamota;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class mamotaMove extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private mamota mamota;

  public mamotaMove(mamota subsystem) {
    mamota = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    mamota.move(RobotContainer.xbox.getRawAxis(1));
  }
}
