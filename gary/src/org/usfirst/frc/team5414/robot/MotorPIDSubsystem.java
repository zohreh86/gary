package org.usfirst.frc.team5414.robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class MotorPIDSubsystem extends PIDSubsystem {
	SpeedController motorFront;
	SpeedController motorRear;
	Encoder encoder;
	
	
	public MotorPIDSubsystem(SpeedController front, SpeedController rear,
			Encoder enc, String name ) 
	{
		super(name, 0.5, 0.0, 0.0);
		motorFront = front;
		motorRear = rear;
		encoder = enc;
		
	}
	
	public void initDefaultCommand(){
		
	}
	
	protected double returnPIDInput(){
		return encoder.getRate();
	}
	
	protected void usePIDOutput(double output) {
		motorFront.pidWrite(output);
		motorRear.pidWrite(output);
	}

}