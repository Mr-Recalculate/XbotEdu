package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.rotation.MockHeadingSensor;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TurnLeft90DegreesCommand extends BaseCommand {
	
	DriveSubsystem drive;
	MockHeadingSensor gyro;

	double x;
	double y;
	
	@Inject
	public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		x = drive.gyro.getYaw() + 90;
		if (x > 180) {
			x -= 360;
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		y = (1/90) * (x - drive.gyro.getYaw());
		double a = -1 * y;
		double b = 1 * y;
			drive.tankDrive(a, b);
 	}



}
