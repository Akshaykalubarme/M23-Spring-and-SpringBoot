package com.cg.springioc;

public class Airtel implements Sim{
	
	Airtel()
	{
		System.out.println("Airtel Constructor called");
	}

	public void calling() {
		System.out.println("Calling using Airtel sim");
		
	}

	public void data() {
		System.out.println("Data using Airtel sim");
		
	}

}
