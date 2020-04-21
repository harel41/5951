

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Mamota;

public class MamotaMove extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Mamota mamota;

  
  public MamotaMove() {
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
    mamota.move(RobotContainer.Operator_Joystick.getRawAxis(1));
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
