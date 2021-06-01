package hello;

import java.util.Scanner; // 스캐너 복사
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // 객체 생성
		
		System.out.print("첫번째 숫자를 입력하세요: ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요: ");
		int num2 = sc.nextInt();
		
		System.out.println("===사칙연산 출력하기===");
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
		
		sc.close(); //잊지 말기!!
	}

}
