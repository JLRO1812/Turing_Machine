package model;

public class HeadBand {
	
	private char symbol;
	private HeadBand nextHeadB;
	
	public HeadBand(char s) {
		s = symbol;
		nextHeadB = null;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public HeadBand getNextHeadB() {
		return nextHeadB;
	}
	
	public void setNextHeadB(HeadBand nextHeadB) {
		this.nextHeadB = nextHeadB;
	}
	
	public void addAfter(HeadBand addA) {
		addA.nextHeadB = nextHeadB;
		nextHeadB = addA;
	}
}