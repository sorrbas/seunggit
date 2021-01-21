package test;


import java.io.Serializable;

public class Student implements Serializable{      
   private String name;
   private String age;
   
   public Student() {            super();
   }
   
   public Student(String name, String age) {               super();
         this.name = name;
         this.age = age;
      }   
   
   @Override            public String toString(){      
      return "Student [name=" + name + ", age=" + age + "]";
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   
   
   public String getAge() {
      return age;
   }
   public void setAge(String age) {
      this.age = age;
   }
   
   
   
}