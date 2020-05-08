package Lv2;

import java.util.*;

/*
 * 트럭 - 큐 이용하기
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 
 * 입력 : 
 * 다리 길이 bridge_length, 
 * 다리가 견딜 수 있는 무게 weight, 
 * 트럭별 무게 truck_weights
 * 출력 : 
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
 */

public class Level_2_12 {
	
	class Truck {
	    public int weight; // 트럭의 무게
	    public int enterTime; // 다리에 진입한 시간

	    public Truck(int weight, int enterTime) {
	        this.weight = weight;
	        this.enterTime = enterTime;
	    }
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Truck> bridge = new LinkedList<Truck>(); // 다리를 뜻하는 Truck타입 데이터를 담을 queue
        int bridgeWeight = 0; // 현재 다리에 있는 트럭의 총 무게 
        int lastTruck = 0;
        int totalTruck = truck_weights.length; // 총 트럭의 개수
        
        while (lastTruck < totalTruck) { // 아직 지나가야하는 트럭이 있는 동안 반복문 실행
        	time++; // 1초씩 증가
        	
        	if (!bridge.isEmpty()) { // bridge에 트럭이 지나가고 있는 경우
				Truck FrontTruck = bridge.peek(); // 큐의 맨 앞에 있는 트럭 
				if(time-FrontTruck.enterTime == bridge_length) { // 현재시간-진입시간이 다리 길이와 같다면 다리를 통과함
					Truck passTruck = bridge.poll(); // 트럭을 큐에서 제거 
					bridgeWeight -= passTruck.weight; // 현재 다리 무게를 재조정
				}
			}

        	int compareTruck = truck_weights[lastTruck];
        	if(bridgeWeight+compareTruck <= weight) { // 새 트럭이 들어가도 다리가 견딜 수 있다면 
        		bridge.offer(new Truck(compareTruck, time)); // 새로운 트럭 진입
        		lastTruck++; // 트럭이 새로 들어간 경우 인덱스 +1
        		bridgeWeight += compareTruck; // 현재 다리 무게를 재조정
        	}
		}
        
        time += bridge_length; // 마지막 트럭이 다리에 진입한 후 while문을 빠져나오므로 빠져나올 때까지 걸리는 시간을 임의로 더함 
        return time;
    }

}
