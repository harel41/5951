package frc.robot.commands;
import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbCommend extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private Climb climb;

  public ClimbCommend() {
    climb = Climb.getinstance();
    addRequirements(climb);
  }
  
  @Override
  public void initialize() {
    if (climb.sPiston.get() == Value.kForward){
      climb.pistonRev();
  }
  else{
      climb.pistonFor();
   }
  }
  @Override
  public void execute() {}
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

