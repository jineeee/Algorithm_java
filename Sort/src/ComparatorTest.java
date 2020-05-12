import java.util.Arrays;
import java.util.Comparator;

class Student{
	String name;
	int id;
	int age;
	public Student(String name, int id, int age){
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String print(){
		return "이름 : "+name+", 학번: "+id+", 나이 : "+age;
	}
}

public class ComparatorTest{
	public static void main(String[] args) {
		Student student[] = new Student[4];
		//순서대로 "이름", 학번, 학점
		student[0] = new Student("김예진", 20161091, 24);
		student[1] = new Student("양시연", 20173922, 24);
		student[2] = new Student("김찬영", 20146037, 26);
		student[3] = new Student("최예원", 20209384, 20);
		
		Arrays.sort(student, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				if(s1.age == s2.age){ // 나이가 같은 경우
					return Integer.compare(s1.id, s2.id); // 학번 오름차순으로 정렬
				}
				return Integer.compare(s2.age, s1.age); // 나이는 내림차순으로 정렬
			}
		});
		
		Arrays.sort(student, (s1,s2) -> Integer.compare(s2.age, s1.age) // 나이는 내림차순으로 정렬
		);
		
//		Comparator<Student> comparator = new Comparator<Student>(){
//			public int compare(Student s1, Student s2) {
//				if(s1.age == s2.age){ //학점이 같으면
//					return Double.compare(s1.id, s2.id); //학번 오름차순
//				}
//				return Double.compare(s2.age, s1.age);//내림차순
//				return Integer.compare(s1.age, s2.age);
//			}
//		};
//		
//		Arrays.sort(student, comparator);
		
		for(int i=0;i<4;i++)
			System.out.println(student[i].print());
	}
}