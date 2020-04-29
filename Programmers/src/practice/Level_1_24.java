package practice;

public class Level_1_24 {
	
	public long solution(long n) {
	      long answer = 0;
	      long temp = (long) Math.sqrt(n);
	      
	      if(temp*temp != n) return -1;
	      else return (temp+1)*(temp+1);

	  }

}
