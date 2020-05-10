/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int DriveMotorAPort = 1;
    public static int DriveMotorBPort = 2;
    public static int DriveMotorCPort = 3;
    public static int DriveMotorDPort = 4;

    public static int MamotaMovePort = 5;
    public static int MamotaInputPort = 6;
    
    public static int IntakeMoveAPort = 7;
    public static int IntakeMoveBPort = 8;
    public static int IntakeMotorPort = 9;

    public static int ElevatorMotorPort = 10;


    public static int MamotaEncoderAPort = 0;
    public static int MamotaEncoderBPort = 1;

    public static int IntakeEncoderAPort = 2;
    public static int IntakeEncoderBPort = 3;

    public static int ElevatorEncoderAPort = 4;
    public static int ElevatorEncoderBPort = 5;

    public static int DoubleSolenoidFoward = 0;
    public static int DoubleSolenoidReverse = 1;

}
