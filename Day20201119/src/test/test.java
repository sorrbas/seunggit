package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      ArrayList<HashMap<String, String>> haksaList = new ArrayList <HashMap<String, String>>();
      
      while(true) {      
         System.out.println("R: ��� L: ��ü���");
         String protocol = sc.next();   
         if(protocol.equals("R") || protocol.equals("r") ) {   
            HashMap<String, String>haksaHash = new HashMap<String, String>();   
            System.out.println("���� �Է�: ");
            String age = sc.next();
            System.out.println("�̸� �Է�: ");
            String name = sc.next();
            haksaHash.put("age", age);         
            haksaHash.put("name", name);      
            haksaList.add(haksaHash);      
            System.out.println("�л��� ��ϵǾ����ϴ�.");
            System.out.println(haksaHash.get("age"));      
            System.out.println(haksaHash.get("name"));
         }
         else if(protocol.equals("L") || protocol.equals("l") ) {
            for (int i=0; i<haksaList.size(); i++) {
               HashMap<String, String> haksaHash = haksaList.get(i);
               System.out.println(haksaHash.get("age"));
               System.out.println(haksaHash.get("name"));
            }
         }
      }
   }

}