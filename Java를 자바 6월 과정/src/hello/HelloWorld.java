package hello;

import java.util.Scanner; // 스캐너 복사
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0 ;
		int i = 0 ;
		
		while( i < num + 1 ) {
			
			sum += i;
			i++;
			
		}
		
		System.out.printf("1부터 %d까지의 합은 %d입니다", num, sum);
		
	
		sc.close(); //잊지 말기!!
	}

}
