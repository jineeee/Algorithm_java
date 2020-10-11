
public class solution2 {
	public static void main(String[] args) {
//		solution("AM 11:59:59", 200000);
//		solution("PM 01:00:00", 10);
//		solution("PM 12:01:00", 200000);
		solution("PM 05:05:05", 0);
	}
	
	static public String solution(String p, int n) {
        String answer = null;
        System.out.println(calcTime(p));
        int second = calcTime(p) + n;
        System.out.println(second);
        int hour = 0;
        hour = second/3600;
    	second -= hour*3600;
		if (hour > 24) {
			while (hour >= 0) {
				System.out.println("hour : " + hour);
				hour -= 24;
				if (hour <= 24)
					break;
			}
		}
        if(hour==24) hour = 0;
        int min = second/60;
        second -= min*60;
        answer = String.format("%02d:%02d:%02d", hour, min, second);
        System.out.println(answer);
        return answer;
    }
	
	static int calcTime(String input) {
			String[] arr = input.split(" ");
			String section = arr[0];
			String time = arr[1]; // 시작 시간
			String[] timeArr = time.split(":");
			int hour = Integer.parseInt(timeArr[0]);
			int min = Integer.parseInt(timeArr[1]);
			int sec = Integer.parseInt(timeArr[2]);
			
			if(section.equals("PM") && hour<12) hour+=12;
			
			System.out.println(hour + " " + min + " " + sec);
			int startSec = hour * 60 * 60;
			startSec += min * 60;
			startSec += sec;
			
			return startSec;
	}

}
