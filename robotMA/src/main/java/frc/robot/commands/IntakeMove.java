
package frc.robot.commands;


import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeMove extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake intake;

  
  public IntakeMove() {
    intake = Intake.getinstance();

    addRequirements(intake);
  }

// Called when the command is initially scheduled.
   @Override
   public void initialize() {
   }

  @Override
  public void execute() {
    intake.moveIntake(1);
  }
      // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.moveIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
