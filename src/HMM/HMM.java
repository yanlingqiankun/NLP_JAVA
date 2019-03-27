package HMM;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import NLU.WordHandle;

public class HMM {
	public static void main(String[] args) throws Exception{
		String filename = "D:\\NLU\\result.txt";
		ArrayList<WordHandle> counter = getList(filename);
		Scanner input = new Scanner(new FileInputStream("D:\\NLU\\lab2\\train.txt"));
		ArrayList<Phrase> data = new ArrayList<Phrase>();
		while(input.hasNext()) {
			String str = input.nextLine();
			str.split("[#(\\s+)]");
		}
		input.close();
	}
	public static ArrayList<WordHandle> getList(String filename) throws Exception{
		ArrayList<WordHandle> list= new ArrayList<WordHandle>();
		InputStream inputStream = new FileInputStream(filename);
		Scanner input = new Scanner(inputStream,"UTF-8");
		String[] temp;
		String line;
		while(input.hasNextLine()) {
			line = input.nextLine();
			temp = line.split("[#(\\s+)]");
//			System.out.println(temp[0]);
			if(temp.length == 4) {
				list.add(new WordHandle(temp[1],temp[2],Integer.valueOf(temp[3])));
			}
//			else	System.out.println("Error str: "+line);
		}
		input.close();
		return list;
	}
}
