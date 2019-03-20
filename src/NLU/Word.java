package NLU;

public class Word implements Comparable{
	public String str;
	int fre;
	String prop;
	
	public Word(String s) {
		str = s;
	}
	
	public Word(String s, String p, int f) {
		str = s;
		prop = p;
		fre = f;
	}
	
	public Word(String s, String p) {
		str = s;
		prop = p;
		fre = 0;
	}
	
	public int getlength() {
		return str.length();
	}
	
	public Word add() {
		fre ++;
		return this;
	}

	@Override
	public String toString() {
		return "#"+str+":"+fre;
	}
	
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Word temp = (Word)o;
		return temp.fre - this.fre;
	}
	
	@Override
	public boolean equals(Object o) {
		Word temp = (Word)o;
		return str.equals(temp.str)&&prop.equals(temp.prop);
	}
	
	public int getFre() {
		return fre;
	}
	public void getSamble() {
		System.out.println("i am parents");
	}
}

class WordHandle extends Word implements Comparable{
	public WordHandle(String s, String p) {
		super(s, p);
		this.str = s;
		this.prop = p;
		// TODO Auto-generated constructor stub
	}
	
	public WordHandle(String s) {
		super(s);
		this.str = s;
	}
	
	public WordHandle(String s,String p, int f) {
		super(s,p,f);
		this.str = s;
		this.prop = p;
		this.fre = f;
	}

	String str;
	int fre;
	String prop;

	
	public WordHandle add() {
		fre ++;
		return this;
	}	

	@Override
	public void getSamble() {
		System.out.println("i am child");
	}
	
	@Override
	public boolean equals(Object o) {
		WordHandle temp = (WordHandle)o;
//		System.out.println(temp.str);
		return super.str.equals(temp.str);
	}
	
	@Override
	public String toString() {
		return str+"#"+prop+"#"+fre;
	}
}

