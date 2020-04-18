
package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.drive;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class driveCommend extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private drive drive;

  public driveCommend(drive subsystem) {
    drive = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    drive.right(RobotContainer.righJoystick.getY());
    drive.left(RobotContainer.leftJoystick.getY());
  }
}
