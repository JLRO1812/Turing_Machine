package model;

public class Machine {
	
	private HeadBand c0;
	private HeadBand c1;
	private HeadBand c2;
	
	public Machine () {
		c0 = null;
		c1 = middlePosition();
		c2 = finalPosition();
	}
	
	public HeadBand getC0() {
		return c0;
	}
	
	public void setC0() {
		this.c0 = c0;
	}
	
	public int mediumPart() {
		int size = 0;
		int medium = 0;
		
		HeadBand current = c0;
		
		while(current != null) {
			size++;
			current = current.getNextHead();
		}medium = size/2;
		return medium;
	}
	
	public HeadBand middlePosition() {
		int medium = mediumPart();
		int count = 0;
		
		HeadBand middlePosition = getC0();
		
		if(medium == 0) {
			middlePosition = getC0();
		}else {
			while(count<medium) {
				middlePosition = middlePosition.getNextHead();
				count++;
			}
		}return middlePosition;
	}
	
	public HeadBand finalPosition() {
		HeadBand current = c0;
		
		if(current != null) {
			while(current.getNextHead() != null) {
				current = current.getNextHead();
			}
		}return current;
	}

	public String readChar(char head) {
		
		return null;
	}

	public void addFirstChar(char letter) {
		
		
	}

	public void addMiddleChar(char letter) {
		
		
	}

	public void addEndChar(char letter) {
		
		
	}

	public void removeChar(char head) {
		
		
	}

}
