package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import edu.wpi.first.wpilibj.MockDistanceSensor;
import xbot.common.command.BaseCommand;
import xbot.common.controls.actuators.XSpeedController;
import xbot.edubot.operator_interface.OperatorInterface;
import xbot.edubot.rotation.MockHeadingSensor;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {

	DriveSubsystem drive;
	OperatorInterface operate;

	
	@Inject
	public ArcadeDriveWithJoysticksCommand(DriveSubsystem driveSubsystem, OperatorInterface oi) {
		// TODO Auto-generated constructor stub
		drive = driveSubsystem;
		operate = oi;
		
		
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		double X = operate.leftJoystick.getVector().x;
		double Y = operate.leftJoystick.getVector().y;
		double L = Y+X;
		double R = Y-X;
		drive.tankDrive(L,R);
	}

}
