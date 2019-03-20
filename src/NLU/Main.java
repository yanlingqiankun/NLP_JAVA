package NLU;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String resultPath = "D:\\NLU\\result.txt";
		ArrayList<Word> list;
		ArrayList<WordHandle> hlist;
		File file = new File(resultPath);
		if(!file.exists()) {
			String line;
			String path = "D:\\NLU\\199801.txt";
			String[] temp;
			list = new ArrayList<Word>();
			String[] words;
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\NLU\\result.txt"));
			try {
	//			Scanner input = new Scanner(file);
				InputStream inputStream = new FileInputStream(path);
				Scanner input = new Scanner(inputStream,"UTF-8");
				while(input.hasNext()) {
					line = input.nextLine();
	//				System.out.println(line);
					words = line.split("\\s+");
					for(int i = 0;i<words.length;i++) {
	//					System.out.println(words[i]);
						temp = words[i].split("/");
						if(temp.length == 2) {
							Word word = new Word(temp[0],temp[1],1);
							int index = list.indexOf(word);
							if(index == -1) {
								list.add(word);
							}else {
								list.set(index, list.get(index).add());
							} 
						}
	//					else	System.out.println("error str: "+words[i]);
					}
	//				break;
				}
				input.close();
			}catch(Exception e) {
				System.out.println("error");
			}
			Collections.sort(list);
			Iterator<Word> iter = list.iterator();
			bw.write("total words:"+getSum(list)+"\n");
			while(iter.hasNext()) {
				bw.write(iter.next().toString());
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}
			//result has been create
			hlist = getList(resultPath);
//			outputList(list);
		int max = getMax(hlist);
		System.out.println(max);
//		outputList(hlist);
		handle(hlist,"D:\\NLU\\test.txt","D:\\NLU\\output.txt",max);
		System.out.println("--------end----------");
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
		return list;
	}
	
	public static void outputList(ArrayList<WordHandle> list) {
		Iterator<WordHandle> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static int getMax(ArrayList<WordHandle> list) {
		int max = 0;
		Iterator<WordHandle> iter = list.iterator();
		while(iter.hasNext()) {
			int temp = iter.next().getlength();
			if(max< temp) {
				max = temp;
			}
		}
		return max;
	}
	
	public static void handle(ArrayList<WordHandle> list,String filename,String outfile,int max) throws Exception{
		InputStream inputStream = new FileInputStream(filename);
		Scanner input = new Scanner(inputStream,"UTF-8");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
		String line;
		while(input.hasNextLine()) {
			int begin = 0;
			String outline="";
			int end = 0;
			line = input.nextLine();
			String temp="";
			while(begin<line.length()) {
				int i = max;
				if(begin+i>=line.length())
					i = line.length()-begin;
				for(;i>0;i--) {
					temp = line.substring(begin, begin+i);
//					System.out.println(temp);
					WordHandle tempobj = new WordHandle(temp);
					if(list.contains(tempobj)) {
						break;
					}
				}
				begin += i;
				if(i == 0) {
					temp = line.charAt(begin)+"";
					begin += 1;
				}
				outline = outline + temp + "  "; 
			}
			bw.write(outline);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		input.close();		
	}
	
	public static long getSum(ArrayList<Word> list) {
		Iterator<Word> iter = list.iterator();
		long sum = 0;
		while(iter.hasNext()) {
			sum += iter.next().getFre();
		}
		return sum;
	}
}
