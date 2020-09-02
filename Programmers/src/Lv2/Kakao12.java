package Lv2;

/*
 * 카카오 방금그곡 - 문자열
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */

public class Kakao12 {
	
	public static void main(String[] args) {
		String str1 = "ABCDEFG";
		String[] arr1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String[] arr = {"12:00,12:07,HELLO1,CDEFGAB", "12:00,12:04,HELLO2,CDEFGAB", "12:00,12:04,HELLO3,CDEFGAB"};
		
		String str2 = "CC#BCC#BCC#BCC#B";
		String[] arr2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		
		String str3  = "ABC";
		String[] arr3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		String[] arr4 = {"13:00,13:02,HAPPY,C#A#"};
		String str4 = "A#";
		
		String[] arr5 = {"03:00,03:10,FOO,CBC#CBC", "04:00,04:08,BAR,ABC"};
		String str5 = "CBC";
		solution(str5, arr5);
	}

	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] sharp = {"C#", "D#", "E#", "F#", "G#", "A#"};
        String[] replace = {"c", "d", "e", "f", "g", "a"};
        
        for(int i=0; i<sharp.length; i++) m = m.replaceAll(sharp[i], replace[i]);
        
        int songTime = 0;
        for(int i=0; i<musicinfos.length; i++) {
        	String[] info = musicinfos[i].split(",");
        	String[] start = info[0].split(":");
        	String[] end = info[1].split(":");
        	int playTime = (Integer.parseInt(end[0]) - Integer.parseInt(start[0]))*60 
        			+ (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
        	
        	for(int j=0; j<sharp.length; j++) info[3] = info[3].replaceAll(sharp[j], replace[j]);
        	
        	String temp = "";
        	for(int j=0; j<playTime; j++)
        		temp += info[3].charAt(j%info[3].length());
        	
        	if(temp.contains(m) && songTime<playTime) {
        		songTime = playTime;
    			answer = info[2];
        	}
        	
        }
        
        if(answer.isEmpty()) answer = "(None)";
        System.out.println(answer);
        return answer;
    }
}
