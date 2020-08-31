package Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Kakao11 {

	public static void main(String[] args) {
		String[] arr = {"img12.png", "qimg3.png", "aimg02.png", "qimg1.png", "IMG01.GIF", "img2.JPG"};
		solution(arr);
	}
	
	static String[][] result;
	
	public static String[] solution(String[] files) {
        String[] answer = {};
        result = new String[files.length][4];
        
        for(int i=0; i<files.length; i++) {
        	result[i][3] = String.valueOf(i);
        	
        	int idx = getHead(files[i]);
        	result[i][0] = files[i].substring(0, idx).toLowerCase();
        	
        	int idx2 = getNumber(files[i], idx);
        	if(idx2!=0) result[i][1] = files[i].substring(idx, idx2);
        	else result[i][1] = files[i].substring(idx);
        	
        	if(idx2!=0) result[i][2] = files[i].substring(idx2).toLowerCase();
        	else result[i][2] = "";
        	
        }
        
        Arrays.sort(result, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
//				if(o1[0]==o2[0] && o1[1]==o2[1]) return o1[2].compareTo(o1[2]);
				if(o1[0]==o2[0]) return o1[1].compareTo(o2[1]);
				else return o1[0].compareTo(o2[0]);
			}
        	
		});
        
        for(int i=0; i<result.length; i++)
        System.out.println(Arrays.toString(result[i]));
        
        return answer;
    }
	
	static int getHead(String string) {
		int idx = 0;
		for(int i=0; i<string.length(); i++) {
			char temp = string.charAt(i);
			if(temp>=48 && temp<=57) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	static int getNumber(String string, int start) {
		int idx = 0;
		for(int i=start; i<string.length(); i++) {
			char temp = string.charAt(i);
			if(temp<48 || temp>57) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}
