package HMM;

public class Phrase {
	public String first;
	public String second;
	public int num;
	public Phrase(String f, String s) {
		first = f;
		second = s;
		num = 0;
	}
	public void add() {
		++num;
	}
	@Override
	public boolean equals(Object o) {
		Phrase p = (Phrase)o;
		return this.first.equals(p.first)&&this.second.equals(p.second);
	}
}
