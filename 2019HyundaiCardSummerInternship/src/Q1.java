import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Q1 {
	static int[] answer = new int[5];
	
	static public int[] solution(String[] purchase){
		int[] answer = new int[5];
        
        String[] date = new String[purchase.length]; // 구매 날짜 
        String[] eDate= new String[purchase.length]; // 금액 만료 날짜 
        String[] price = new String[purchase.length]; // 구매 금액
        int[] ePrice = new int[purchase.length]; // 만료되는 금액
        String[] tDate = new String[purchase.length*2]; // 두 날짜 배열을 합칠 배열
        String[] temp1 = new String[purchase.length]; // 두 날짜 배열을 합칠 배열
        String[] temp2 = new String[purchase.length]; // 두 날짜 배열을 합칠 배열
        
        //배열에 값 할당
        for(int i=0; i<purchase.length; i++) {
        	date[i] = purchase[i].split(" ")[0];
        	price[i] = purchase[i].split(" ")[1];
        	eDate[i] = doDateAdd(date[i]);
        	ePrice[i] = 0 - Integer.parseInt(price[i]);
        	temp1[i] = date[i] + " " + price[i];
        	temp2[i] = eDate[i] + " " + ePrice[i];
        }
        
        System.arraycopy(temp1, 0, tDate, 0, temp1.length);
        System.arraycopy(temp2, 0, tDate, temp1.length, temp2.length);
        Arrays.parallelSort(tDate);
        
        //date, price 확인 출력
        for(int i=0; i<tDate.length; i++) {
        	System.out.println(tDate[i]);
        }
        
        level(Integer.parseInt(price[0]), getBetDays(date[0], date[1]));
        for(int i=1; i<tDate.length; i++) {
        	for(int j=i+1; j<tDate.length; j++) {
        		
        		int bDays = getBetDays(tDate[i], tDate[j]);
        		if(bDays>30) {
        			System.out.println("betDays>30");
        			level(Integer.parseInt(tDate[i].split(" ")[1]), bDays);
        			break;
        		} else if (bDays<=30 && bDays>=0){
        			System.out.println("betDays<=30 && betDays>=0");
        			int price2 = Integer.parseInt(price[i])+Integer.parseInt(price[j]);
        			level(price2, bDays);
        			System.out.println(price2);
        			break;
        		}
        	} 
    		
        }
        
        // 정답 배열 출력
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
	
	static int getBetDays(String a, String b) throws ParseException { // 두 매개변수 사이에 며칠이나 있는지 세는 함수
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = formatter.parse(a.split("/")[0] + '-' + a.split("/")[1] +'-' + a.split("/")[2]);
		Date endDate = formatter.parse(b.split("/")[0] + '-' + b.split("/")[1] +'-' + b.split("/")[2]);
		// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
		long between = endDate.getTime() - beginDate.getTime();
		long betDays = between / (24 * 60 * 60 * 1000);
		return (int)betDays;
	}
	
	static void level(int amount, int days) { // 등급을 체크하는 함수
		if(0<=amount && amount<10000) { // 브론즈 
			System.out.println("브론즈");
			answer[0] += days;
		} else if (10000<=amount && amount<20000) { // 실버 
			answer[1] += days;
		}	else if (20000<=amount && amount<50000) { // 골드 
			answer[2] += days;
		} else if (50000<=amount && amount<100000) { // 플래티넘
			answer[3] += days;
		} else if (100000<=amount) { // 다이아몬드
			answer[4] += days;
		}
	}
	
	static java.lang.String doDateAdd(String d){ // 만료날짜(30일이 지난 후)를 계산하는 함수
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");
		
		cal.set(Integer.parseInt(d.split("/")[0]), Integer.parseInt(d.split("/")[1])-1, Integer.parseInt(d.split("/")[2]));
		cal.add(Calendar.DAY_OF_YEAR, 30); // 30일을 더한다.
		return fm.format(cal.getTime());
	}

	public static void main(String[] args) throws ParseException {
		
		String[] p = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		solution(p);
	}
}
