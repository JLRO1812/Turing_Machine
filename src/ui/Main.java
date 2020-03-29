package ui;

import model.*;

import java.io.*;

public class Main {
	
	static Machine tMachine;
	
	private static final String FILE_NAME = "data" + File.separator + "in_turing.txt";
	
	public static void main (String [] args) throws IOException{
		
		ObjectOutputStream end = null;
		BufferedWriter bw = null;
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		
		long start = System.currentTimeMillis();
		
		String input = br.readLine();	
		String result = "";
		
		while(input != null) {
			
			tMachine  = new Machine();
			
			char head;
			char action;
			char letter;
			
			int newInstruccion = 0;
			
			while(newInstruccion<input.length()) {
				
				head = (input.charAt(newInstruccion));
				action = (input.charAt(newInstruccion + 1));
				
				if(action == '0') {
					result = result + tMachine.readChar(head)+ "\n";
					newInstruccion = newInstruccion + 2;
				}else if (action == '1') {
					letter = (input.charAt(newInstruccion + 2));
					
					if(head == '0') {
						tMachine.addFirstChar(letter);
					}else if(head == '1') {
						tMachine.addMiddleChar(letter);
					}else if(head == '2') {
						tMachine.addEndChar(letter);
					}newInstruccion = newInstruccion + 3;
					
				}else if(action == '2') {
					tMachine.removeChar(head);
					newInstruccion = newInstruccion + 2;
				}else {
					System.out.println("Action "+action+" is invalid.");
				}
			}
			end = new ObjectOutputStream(new FileOutputStream("data" + File.separator + "out_turing.txt"));
			end.writeObject(result);
			
			long finish = System.currentTimeMillis();
			long time = (long) ((finish-start) * 0.001);
			
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			System.out.println(time+" Second");
			
			input = br.readLine();
			
		}end.close();
		bw.close();
		br.close();
	}
}