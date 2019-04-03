package Veterbi;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import HMM.nominal;
import NLU.Word;

public class Veterbi {
	public int linecount;
	public ArrayList<Word> moveProba = new ArrayList<Word>();
	public ArrayList<nominal> launchProba = new ArrayList<nominal>();
	public ArrayList<Word> startProba = new ArrayList<Word>();
	public Veterbi(int line, ArrayList<Word> moveProba, ArrayList<nominal> launchProba,ArrayList<Word> startProba) {
		this.moveProba = moveProba;
		this.launchProba = launchProba;
		this.startProba = startProba;
		linecount = line;
	}
	
	public void deal(String inputfile, String outputfile) throws Exception{
		InputStream inputStream = new FileInputStream(inputfile);
		Scanner input = new Scanner(inputStream,"UTF-8");
		while(input.hasNext()) {
			String line = input.nextLine();
			String[] words = line.split("\\s+");
			String last = "";
			boolean isStart = true;
			for(int i = 0;i<words.length;i++) {
				if(isStart) {
					isStart = false;
					
				}else {
					
				}
			}
		}
		input.close();
	}
}
