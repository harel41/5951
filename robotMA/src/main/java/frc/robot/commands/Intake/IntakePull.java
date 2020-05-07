
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakePull extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake intake;

  public IntakePull(){
    intake = Intake.getinstance();
    addRequirements(intake);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    }

  @Override
  public void execute() {
    intake.intakeCollect(1);
  }
  

   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
    intake.intakeCollect(0);

   }

   
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
   
  
