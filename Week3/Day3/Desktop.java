package org.system;

public class Desktop extends Computer{
	
	public float desktopSize(float size)
	{
		return size;
	}

	public static void main(String[] args) {
		Desktop desk = new Desktop();
		String model = desk.computerModel("HP I7 BGPR");
		float size = desk.desktopSize(29.5f);
		
		System.out.println("Desktop Model is "+model + " and size is "+size);
	}
}
