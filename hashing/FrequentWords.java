package hashing;


import java.util.*;
import java.util.Map.Entry;

class Pair {
	private String word;
	private Integer count;
	Pair(String word, Integer count) {
		this.word = word;
		this.count = count;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
class SortByCount implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.getCount()>o2.getCount()) return -1;
		else if(o1.getCount() == o2.getCount()) {
			if(o1.getWord().compareTo(o2.getWord())<=0) return -1;
		}
		return 1;
	}
	
}
class FrequentWords{
	
	public static Vector<String> frequentWords(Vector<String> vec,int k)
	{
		Vector<String>ans = new Vector<String>();
		Map<String,Integer>mp = new HashMap<String,Integer>();
		for(String c:vec) {
			mp.putIfAbsent(c,0);
			mp.put(c, mp.get(c)+1);
		}
		ArrayList<Pair>list = new ArrayList<Pair>();
		int i=0;
		for(Entry<String,Integer>m:mp.entrySet()) {
			list.add(new Pair(m.getKey(),m.getValue()));
		}
		Collections.sort(list,new SortByCount());
		//System.out.println(list);
		for(i=0;i<list.size();i++) {
			ans.add(list.get(i).getWord());
		}
		return ans;
 	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Vector<String> vec=new Vector<String>();
		for(int i=0;i<n;i++)
			vec.add(sc.next());
		int k=sc.nextInt();
		Vector<String> ans = frequentWords(vec, k);
		for(int i=0;i<k;i++)
			System.out.println(ans.get(i));
	}
}