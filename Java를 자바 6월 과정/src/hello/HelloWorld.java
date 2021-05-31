package hello;

import java.util.Scanner; // 스캐너 복사
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // 객체 생성
		
		System.out.println("========자기소개========");
			
		System.out.print("이름을 입력해주세요 : ");
		String sentence1 = sc.nextLine();
				
		System.out.print("모각코 어떤 과정을 하고 있나요? : ");
		String sentence2 = sc.nextLine();
		
		System.out.print("모각코 며칠째 과정인가요? : ");
		int num1 = sc.nextInt();
		
		System.out.print("모각코 과정 몇 개나 참여했나요? : ");	
		float num2 = sc.nextFloat();
		
		System.out.printf("%s님 모각코 %s 과정 %d일차, %.1f번째 과정입니다.\n", sentence1, sentence2, num1, num2);	
		
		sc.close(); //잊지 말기!!
	}

}
