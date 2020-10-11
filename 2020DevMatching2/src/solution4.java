import java.util.*;
import java.util.Map.Entry;

public class solution4 {
	
	public static void main(String[] args) {
		String[] arr = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
		solution(arr, 2);
	}

	static public String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String string : votes) map.put(string, map.getOrDefault(string, 0)+1);
        System.out.println(map);
        
		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		System.out.println(entries);
		int count = 0;
//		for(int i=0; i<k; i++) count += entries.;
//        while (true) {
//        	int min = Integer.MAX_VALUE;
//        	for( Map.Entry<String, Integer> temp : map.entrySet()) {
//        		if(temp.getValue()<min) {
//        			min = temp.getValue();
//        			answer = temp.getKey();
//        		}
//        	}
//		}
        
        return answer;
    }
}
