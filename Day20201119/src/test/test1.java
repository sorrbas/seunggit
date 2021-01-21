package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test1 {
   public static void main(String[] args) {
      
      ArrayList<Student> studentList = new ArrayList<Student>();
      // ArrayList안에 Student 클래스를 넣어준다.
      // 아까의 Hashmap을 만들어서 넣어주는 것이나 우리가 클래스를 따로 만들어서 넣어주는 방식이나 같은 방식이다.
      
      Scanner sc = new Scanner(System.in);
      while(true) {
         System.out.println("R:등록 L: 전체출력");
         String protocol = sc.next();
         if(protocol.equals("R") || protocol.equals("r") ) {   
            Student student = new Student();      // 값이 중복되면 안되기에 if문 안으로 넣어준다.
            System.out.println("나이 입력: ");
            String age = sc.next();
            System.out.println("이름 입력: ");
            String name = sc.next();
            
            student.setAge(age);
            student.setName(name);
            studentList.add(student);
            
            System.out.println("학생이 등록되었습니다.");
            
         }
         else if(protocol.equals("L") || protocol.equals("l") ) {
            for (int i=0; i<studentList.size(); i++) {
               Student student = studentList.get(i);
               System.out.println(student.getAge());
               System.out.println(student.getName());
            }
         }
      }
   }

}