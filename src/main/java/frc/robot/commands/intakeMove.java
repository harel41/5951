
package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakeMove extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private intake intake;

  public intakeMove(intake subsystem) {
    intake = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    intake.moveIntake(RobotContainer.intakeJoystick.getY());
    
  }
}
