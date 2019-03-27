package NLU;


public class WordHandle extends Word implements Comparable{
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