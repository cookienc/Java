package hello;

import java.util.Scanner; // 스캐너 복사
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 5개를 띄어쓰기로 구분하여 입력하세요 : ");
		int[] arr = new int[5];
		
		for(int i = 0; i<5 ; i++) {
		
		arr[i] = sc.nextInt();
			
		}
		System.out.println("=====입력완료=====");
		System.out.println("=====출력시작=====");
		
		for(int i = 4; i >= 0 ;i--) {
			
			System.out.println(arr[i]);
		}
		
		
		
	
		sc.close(); //잊지 말기!!
	}

}
