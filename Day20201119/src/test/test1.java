package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test1 {
   public static void main(String[] args) {
      
      ArrayList<Student> studentList = new ArrayList<Student>();
      // ArrayList�ȿ� Student Ŭ������ �־��ش�.
      // �Ʊ��� Hashmap�� ���� �־��ִ� ���̳� �츮�� Ŭ������ ���� ���� �־��ִ� ����̳� ���� ����̴�.
      
      Scanner sc = new Scanner(System.in);
      while(true) {
         System.out.println("R:��� L: ��ü���");
         String protocol = sc.next();
         if(protocol.equals("R") || protocol.equals("r") ) {   
            Student student = new Student();      // ���� �ߺ��Ǹ� �ȵǱ⿡ if�� ������ �־��ش�.
            System.out.println("���� �Է�: ");
            String age = sc.next();
            System.out.println("�̸� �Է�: ");
            String name = sc.next();
            
            student.setAge(age);
            student.setName(name);
            studentList.add(student);
            
            System.out.println("�л��� ��ϵǾ����ϴ�.");
            
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