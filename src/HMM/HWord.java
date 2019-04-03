package HMM;

public class HWord {
	public String content;
	public int fre;
	public HWord(String content) {
		this.content = content;
		fre = 1;
	}
	
	public HWord add() {
		++fre;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		HWord h = (HWord)o;
		return content.equals(h.content);
	}
	
	@Override
	public String toString() {
		return content+" "+fre;
	}
}
