package judge;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class judge {
	static int correct;
	static int stander;
	static int output;
	public static void main(String[] args) {
		String stanpath = "D:\\NLU\\199801.txt";
		String respath = "D:\\NLU\\output.txt";
		try {
			InputStream standerStream = new FileInputStream(stanpath);
			Scanner staninput = new Scanner(standerStream,"UTF-8");
			InputStream resStream = new FileInputStream(respath);
			Scanner resinput = new Scanner(resStream,"UTF-8");
			String stanline;
			String resline;
			int temp = 0;
			while(staninput.hasNext() && resinput.hasNext()) {
				stanline = staninput.nextLine();
				resline = resinput.nextLine();
				ArrayList<Integer> resstart = new ArrayList<Integer>();
				ArrayList<Integer> resend = new ArrayList<Integer>();
				ArrayList<Integer> stanstart = new ArrayList<Integer>();
				ArrayList<Integer> stanend = new ArrayList<Integer>();
				getpos(resstart, resend, resline);
				getpos(stanstart, stanend, stanline);
//				for(int i = 0;i<stanstart.size();i++) {
//					System.out.print(resstart.get(i)+" ");
//				}
				output += resstart.size();
				stander += stanstart.size();
				int d = 0;
				int i = 0;
				for(;i<resstart.size() && d<stanstart.size();) {

//					System.out.println("resend.get(i) = "+resend.get(i)+" and stanend.get(d) = "+stanend.get(d));
					if(resstart.get(i).intValue() != stanstart.get(d).intValue()) {
						i++;
						d++;
						continue;
					}
//					System.out.println(resend.get(i)>stanend.get(d));
					
					if(resend.get(i).intValue() == stanend.get(d).intValue()) {
						d++;
						i++;
						correct ++;
					}else if(resend.get(i)<stanend.get(d)) {
						i++;
					}else if(stanend.get(d)<resend.get(i)) {
//						System.out.println("here");
						d++;
					}
				}
			}
			resinput.close();
			staninput.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("correct = "+correct+" output = "+output+" stander = "+stander);
			System.out.println("Recall = "+((correct*1.0)/stander));
			System.out.println("Precision = "+((correct*1.0)/output));
		}
		
	}
	public static void getpos(ArrayList<Integer> start, ArrayList<Integer> end, String str) {
		boolean flag = true;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i) == ' ') {
				if(!flag)
					end.add(i);
				flag = true;
			}else {
				if(flag) {
					start.add(i);
				}
				flag = false;
			}
		}
		if(start.size() > end.size()) {
			start.remove(start.size()-1);
		}
	} 
}
