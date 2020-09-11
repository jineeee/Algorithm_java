package Lv3;

/*
 * 카카오 추석트래픽 - 슬라이딩 윈도우, 문자열 처리
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 */

public class Kakao14_slideWindow {
	
	public static void main(String[] args) {
		String[] arr = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] arr2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] arr3 = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
		solution(arr3);
	}
	
	static int[][] time;
	static int answer = 0;
	
	static int solution(String[] lines) {
        time = new int[lines.length][2];
        calcStartTime(lines); 
        slide();
        System.out.print(answer);
        return answer;
    }
	
	// 슬라이딩윈도우 알고리즘을 사용해 1초씩 범위를 옮겨가며 탐색
	static void slide() {
		for (int i = 0; i < time.length; i++) {
			int startSection = time[i][0]; // 첫번째 작업의 시작시간을 시작시간으로 설정
			int endSection = startSection + 1000 - 1; // 시작시간부터 1초 후
			
			int cnt = 0;
			
			for (int j = 0; j < time.length; j++) {
				if(time[j][0] >= startSection && time[j][0] <= endSection) cnt++;
				else if(time[j][1] >= startSection && time[j][1] <= endSection) cnt++;
				else if(time[j][0]<=startSection && time[j][1]>=endSection) cnt++;
			}

			answer = Math.max(answer, cnt);
		}
		
		for (int i = 0; i < time.length; i++) {
			int startSection = time[i][1]; // 첫번째 작업의 시작시간을 시작시간으로 설정
			int endSection = startSection + 1000 - 1; // 시작시간부터 1초 후
			
			int cnt = 0;
			
			for (int j = 0; j < time.length; j++) {
				if(time[j][0] >= startSection && time[j][0] <= endSection) cnt++;
				else if(time[j][1] >= startSection && time[j][1] <= endSection) cnt++;
				else if(time[j][0]<=startSection && time[j][1]>=endSection) cnt++;
			}
			
			answer = Math.max(answer, cnt);
		}
	}

	// 시작 시간과 종료 시간을 밀리세컨드 단위로 저장
	static void calcStartTime(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			String[] arr = lines[i].split(" ");
			String s = arr[1];
			String t = arr[2];
			String[] timeStr = s.split(":");

			int endSecond = Integer.parseInt(timeStr[0]) * 60 * 60 * 1000;
			endSecond += Integer.parseInt(timeStr[1]) * 60 * 1000;
			endSecond += (int) (Double.parseDouble(timeStr[2]) * 1000);

			int processTime = (int) (Double.parseDouble(t.substring(0, t.length() - 1)) * 1000);

			int startSecond = endSecond - processTime + 1;
			time[i][0] = startSecond;
			time[i][1] = endSecond;
		}
	}
}
