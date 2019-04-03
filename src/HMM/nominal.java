package HMM;

import java.util.ArrayList;
import java.util.Iterator;


public class nominal {
	public ArrayList<HWord> nomi;
	public String str;
	public nominal(String str,String prop) {
		this.str = str;
		nomi = new ArrayList<HWord>();
		nomi.add(new HWord(prop));
	}
	
	public void addprop(String prop) {
		nomi.add(new HWord(prop));
	}
	
	public nominal add(String a) {
		int index = nomi.indexOf(new HWord(a));
		if(index == -1) {
			nomi.add(new HWord(a));
		}else {
			nomi.set(index, nomi.get(index).add());
		}
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		nominal n = (nominal)o;
		return n.str.equals(str);
	}
	
	@Override
	public String toString() {
		String result = str;
		Iterator<HWord> iter = nomi.iterator();
		while(iter.hasNext()) {
			result = result+" "+iter.next();
		}
		return result;
	}
}
