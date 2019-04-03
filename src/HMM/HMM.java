package HMM;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import NLU.Word;
import NLU.WordHandle;

public class HMM {
	public static void main(String[] args) throws Exception{
		String resultPath = "D:\\NLU\\lab2\\.txt";
		ArrayList<Word> moveProba = new ArrayList<Word>();
		ArrayList<nominal> launchProba = new ArrayList<nominal>();
		ArrayList<Word> startProba = new ArrayList<Word>();
		File file = new File(resultPath);
		int linecount = 0;
		if(!file.exists()) {
			String line;
			String path = "D:\\NLU\\lab2\\train.txt";
			String[] temp;
			String last = "";
			String now = "";
			String[] words;
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\NLU\\lab2\\launch.txt"));
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("D:\\NUL\\lab2\\"))
			try {
				InputStream inputStream = new FileInputStream(path);
				Scanner input = new Scanner(inputStream,"UTF-8");
				boolean isStart;
				while(input.hasNext()) {
					++linecount;
					isStart = true;
					line = input.nextLine();
//					System.out.println(line);
					words = line.split("\\s+");
					for(int i = 0;i<words.length;i++) {
	//					System.out.println(words[i]);
						temp = words[i].split("/");
						if(temp.length == 2) {
							System.out.println(temp[0]+"  "+temp[1]);
							now = temp[1];
							if(isStart) {
								//¿ªÊ¼
								isStart = false;
								Word word = new Word("$", now);
								int index = startProba.indexOf(word);
								if(index == -1) {
									startProba.add(word);
								}else {
									startProba.add(startProba.get(i).add());
								}
							}else {
								Word word = new Word(last, now);
								int index = moveProba.indexOf(word);
								if(index == -1) {
									moveProba.add(word);
								}else {
									moveProba.add(moveProba.get(index).add());
								}
							}
							last = now;
							nominal n = new nominal(temp[0],temp[1]);
							int index = launchProba.indexOf(n);
							if(index == -1) {
								launchProba.add(n);								
							}else {
								launchProba.set(index,launchProba.get(index).add(temp[1]));
							}
						}
					}
				}
				input.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

//			ArrayList<Word> moveProba;
//			ArrayList<nominal> launchProba;
//			ArrayList<Word> startProba;
			Iterator iter = launchProba.iterator();
			while(iter.hasNext()) {
				bw.write(iter.next().toString());
				bw.newLine();
				bw.flush();
			}
			bw.close();
			System.out.println("end");
		}
	}
}
