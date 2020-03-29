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
	
	public void setC0(HeadBand c0) {
		this.c0 = c0;
	}

	public int mediumPart() {
		int size = 0;
		int medium = 0;
		
		HeadBand current = c0;
		
		while(current != null) {
			size++;
			current = current.getNextHeadB();
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
				middlePosition = middlePosition.getNextHeadB();
				count++;
			}
		}return middlePosition;
	}
	
	public HeadBand finalPosition() {
		HeadBand current = c0;
		
		if(current != null) {
			while(current.getNextHeadB() != null) {
				current = current.getNextHeadB();
			}
		}return current;
	}

	public String readChar(char head) {
		
		
		
		return null;
	}

	public void addFirstChar(char letter) {
		
		HeadBand first = new HeadBand(letter);
		
		if(c0==null) {
			c0 = first;
		}else {
			first.setNextHeadB(c0);
			c0 = first;
		}
	}

	public void addMiddleChar(char letter) {
		
		HeadBand middle = new HeadBand(letter);
		
		if(c1==null) {
			c1 = middle;
		}else {
			middle = middlePosition();
			middle.addAfter(c1);
		}
	}

	public void addEndChar(char letter) {
		
		HeadBand end = new HeadBand(letter);
		
		if(c2==null) {
			c2 = end;
		}else {
			end = finalPosition();
			end.addAfter(c2);
		}
	}

	public void removeChar(char head) {
		
		if(head == c0.getSymbol()) {
			c0 = c0.getNextHeadB();
		}else if(head == c1.getSymbol()) {
			c1 = c1.getNextHeadB();
		}else if(head == c2.getSymbol()) {
			c2 = c2.getNextHeadB();
		}
	}

}
