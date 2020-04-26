import java.util.Arrays;

/*
 * 
 */

public class Q2 {
	static int[] money = new int[366];
	static String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(purchase)));
	}

	static public int[] solution(String[] purchase) {
		int[] answer = new int[5];
		
		for (int i = 0; i < purchase.length; i++) {
			String date = purchase[i].split(" ")[0]; //날짜
			int amount = Integer.parseInt(purchase[i].split(" ")[1]); //구매 금액
			int month = Integer.parseInt(date.split("/")[1]);
			int day = Integer.parseInt(date.split("/")[2]);
			int idx = 0;
			switch (month) {
			case 12:
				idx += 30;
				System.out.println("12");
			case 11:
				idx += 31;
				System.out.println("11");
			case 10:
				idx += 30;
				System.out.println("10");
			case 9:
				idx += 31;
				System.out.println("9");
			case 8:
				idx += 31;
				System.out.println("8");
			case 7:
				idx += 30;
				System.out.println("7");
			case 6:
				idx += 31;
				System.out.println("6");
			case 5:
				idx += 30;
				System.out.println("5");
			case 4:
				idx += 31;
				System.out.println("4");
			case 3:
				idx += 28;
				System.out.println("3");
			case 2:
				idx += 31;
				System.out.println("2");
			case 1:
				idx += day;
				System.out.println(idx + " : break");
				break;
			}
			for (int k = idx; k < idx + 30; k++) {
				money[k] += amount;
			}

		}
		
		for(int i=1;i<money.length;i++) {
			if(money[i]<10000) {
				answer[0]++;
			}else if(money[i]<20000) {
				answer[1]++;
			}else if(money[i]<50000) {
				answer[2]++;
			}else if(money[i]<100000) {
				answer[3]++;
			}else {
				answer[4]++;
			}
		}
		return answer;
	}

}
