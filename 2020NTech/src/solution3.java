
public class solution3 {
	
	public static void main(String[] args) {
		int[] arr = {6, 5, 7, 3, 4, 2};
		solution(arr);
	}
	
	static public int solution(int[] histogram) {
        int answer = 0;
        int start = 0, end = histogram.length-1;
        
        while (start<end) {
			int width = end-start-1;
			int height = Math.min(histogram[start], histogram[end]);
			int area = width*height;
			System.out.println(start + " " + end + " " + area);
			answer = Math.max(answer, area);
			
			if(histogram[start] == height && histogram[start+1] > height){
	            start++;
	        }
	        else if(histogram[end] == height && histogram[end-1] > height){
	            end--;
	        }
	        else{
	            if(histogram[start] == height) start++;
	            else end--;
	        }
		}
        
//        for(int i=0; i<histogram.length-2; i++) {
//        	for(int j=i+2; j<histogram.length; j++) {
//    			int width = j-i-1;
//    			int height = Math.max(histogram[i], histogram[j]) - Math.abs(histogram[i]-histogram[j]);
//    			int area = width*height;
//    			answer = Math.max(answer, area);
//        	}
//        }

        System.out.print(answer);
        return answer;
    }

}
