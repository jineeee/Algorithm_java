package Lv2;

import java.util.*;

public class Kakao11 {

	public static void main(String[] args) {
		String[] arr = {"img122222222.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] arr2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		solution(arr);
	}
	
	static String[][] result;
	
	public static String[] solution(String[] files) {
        result = new String[files.length][4];
        
        for(int i=0; i<files.length; i++) {
        	result[i][3] = String.valueOf(i);
        	
        	int idx = getHead(files[i]);
        	result[i][0] = files[i].substring(0, idx).toLowerCase();
        	
        	int numIdx1 = getNumber(files[i], idx)[0];
        	int numIdx2 = getNumber(files[i], idx)[1];
        	if(numIdx2-numIdx1 > 5) {
        		System.out.println(numIdx2-numIdx1);
        		result[i][1] = files[i].substring(numIdx1, numIdx1+5);
        	}
        	else if(numIdx2!=0) result[i][1] = files[i].substring(numIdx1, numIdx2);
        	else result[i][1] = files[i].substring(idx);
        	
        	if(numIdx2!=0) result[i][2] = files[i].substring(numIdx2).toLowerCase();
        	else result[i][2] = "";
        	
        }
        
        Arrays.sort(result, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0]) && o1[1].equals(o2[1]) && o1[2].equals(o2[2])) 
					return Integer.compare(Integer.parseInt(o1[3]), Integer.parseInt(o2[3]));
				if(o1[0].equals(o2[0]) && o1[1].equals(o2[1])) return o1[2].compareTo(o1[2]);
				if(o1[0].equals(o2[0])) {
//					System.out.println("if -> " + o1[1] + " " + o2[1]);
					return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
				}
				else {
//					System.out.println("else -> " + o1[0] + " " + o2[0]);
					return o1[0].compareTo(o2[0]);
				}
			}
		});
        String[] answer = new String[result.length];
        for(int i=0; i<result.length; i++) {
        	answer[i] = files[Integer.parseInt(result[i][3])];
        	System.out.println(Arrays.toString(result[i]));
//        	System.out.println(answer[i]);
        }
        System.out.println(Arrays.toString(answer));
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
	
	static int[] getNumber(String string, int start) {
		int sIdx = 0, eIdx = 0;
		boolean flag = false;
		for(int i=start; i<string.length(); i++) {
			char temp = string.charAt(i);
			if(temp<48 || temp>57) { // 숫자가 끝나는 시점
				eIdx = i;
				break;
			}
			if(temp!=48) {
				if(flag) continue;
				sIdx = i;
				flag = true;
			}
		}
		
		int[] result= {sIdx, eIdx};
		return result;
	}
}
