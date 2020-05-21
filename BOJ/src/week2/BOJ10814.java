package week2;

import java.util.*;

/*
 * 백준 나이순 정렬 - 클래스 타입 배열 정렬, comparable
 * https://www.acmicpc.net/problem/10814
 */

class Person implements Comparable<Person>{
	int age;
	String name;
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		return Integer.compare(age, o.age);
	}
	public String print() {
		return age + " " + name;
	}
}
public class BOJ10814 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Person[] person = new Person[n];
		for(int i=0; i<n; i++) person[i] = new Person(scanner.nextInt(), scanner.next());
		Arrays.sort(person);
		for(int i=0; i<n; i++) System.out.println(person[i].print());
	}
}
