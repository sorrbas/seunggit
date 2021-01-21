package Database;
import java.util.Scanner;
public class ddd {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 System.out.print("등록할 학생의 이름을 적어주세요 =>");
		   String name  = sc.next();
		   System.out.print(name+"학생의 성별을 적어주세요 =>");
		   String gender = sc.next();
		   System.out.print(name+"학생의 생년월일을 적어주세요 \nex)920727 => ");
		   int birth = sc.nextInt();
		   System.out.print(name+"학생의 주소를 적어주세요  \nex)경기도 광명시 => ");
		   String address = sc.next();
		   System.out.print(name+"학생의 인스타 주소를 적어주세요 ㅎㅎ");
		   String insta = sc.next();
	   
	   
	}
	
	
}
