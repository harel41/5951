
package frc.robot.commands;

import frc.robot.subsystems.climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class climbCommend extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private climb climb;

    public climbCommend(climb subsystem) {
    climb = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    climb.extend();
    climb.extract();
  }
}
