package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakePiston extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake intake;

  public IntakePiston() {
    intake = Intake.getinstance();
    addRequirements(intake);

  }
@Override
    public void initialize() {
        intake.pistonFire(!intake.getPiston());
  }
}


