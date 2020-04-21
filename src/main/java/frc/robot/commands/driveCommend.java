
package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommend extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Drive drive;

  public DriveCommend() {
    drive = Drive.getinstance();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drive.right(RobotContainer.Right_Joystick.getY());
    drive.left(RobotContainer.Left_Joystick.getY());
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
