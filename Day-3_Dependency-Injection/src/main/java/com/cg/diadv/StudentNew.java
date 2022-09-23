package com.cg.diadv;

public class StudentNew 
{
	MathCheat math;
	
	public void cheating()
	{
		math.mathCheat();
	}

	//DI using Setters
	public void setMath(MathCheat math) {
		this.math = math;
	}

}
