package frc.robot.commands;

import frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakePiston extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private intake intake;

  public intakePiston(intake subsystem) {
    intake = subsystem;
    addRequirements(subsystem);
  }
  @Override
    public void initialize() {
        intake.pistonFire(!intake.getPiston());
  }
}

