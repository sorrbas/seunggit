package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      ArrayList<HashMap<String, String>> haksaList = new ArrayList <HashMap<String, String>>();
      
      while(true) {      
         System.out.println("R: 들록 L: 전체출력");
         String protocol = sc.next();   
         if(protocol.equals("R") || protocol.equals("r") ) {   
            HashMap<String, String>haksaHash = new HashMap<String, String>();   
            System.out.println("나이 입력: ");
            String age = sc.next();
            System.out.println("이름 입력: ");
            String name = sc.next();
            haksaHash.put("age", age);         
            haksaHash.put("name", name);      
            haksaList.add(haksaHash);      
            System.out.println("학생이 등록되었습니다.");
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