//import java.lang.Comparable;
//import java.util.Arrays;
//
//class Student implements Comparable<Student> {
//	String name; //이름
//	int id; //학번
//	public Student(String name, int id){
//		this.name = name;
//		this.id = id;
//	}
//	public String print(){
//		return "이름 : "+name+", 학번: "+id;
//	}
//	/* 기본 정렬 기준: 학번 오름차순 */
//	public int compareTo(Student compareStydent) {
//		return Integer.compare(id, compareStydent.id);
//	}
//	
////	// 내림차순
////	public int compareTo(Student compareStudent) {
////		return compareStudent.id - id;
////	}
////	
////	// 오름차순
////	public int compareTo(Student compareStudent) {
////		System.out.println("this.id" + this.id);
////		System.out.println("compareStudent.id" + compareStudent.id);
////		return this.id - compareStudent.id;
////	}
//}
//
//public class ComparableTest{
//	public static void main(String[] args) {
//		Student student[] = new Student[4];
//		//순서대로 "이름", 학번, 학점
//		student[0] = new Student("김예진", 20161091);
//		student[1] = new Student("양시연", 20173922);
//		student[2] = new Student("김찬영", 20146037);
//		student[3] = new Student("최예원", 20209384);
//		
//		Arrays.sort(student); //퀵소트
//		for(int i=0;i<4;i++) //toString에 정의된 형식으로 출력
//			System.out.println(student[i].print());
//	}
//}