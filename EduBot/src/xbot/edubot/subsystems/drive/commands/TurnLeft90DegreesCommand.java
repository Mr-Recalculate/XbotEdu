package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.rotation.MockHeadingSensor;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TurnLeft90DegreesCommand extends BaseCommand {
	
	DriveSubsystem drive;
	MockHeadingSensor gyro;

	double goal;
	double error;
	boolean isFinished;
	
	@Inject
	public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		goal = drive.gyro.getYaw() + 90;
		if (goal > 180) {
			goal -= 360;
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		double oldError = error;
		error = goal - drive.gyro.getYaw();
		double a = .5 * error - 2* (oldError - error);
		drive.tankDrive(-a, a);
		oldError = error;
		if (drive.gyro.getYaw() > goal - .25 && drive.gyro.getYaw() < goal + .25) {
			isFinished = true;
		}
		else {
			isFinished = false;
		}

	}
	
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		if(isFinished) {
			return true;
			}
			else {
				return false;
			}
	}
}
