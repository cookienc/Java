package hello;

import java.util.Scanner; // ��ĳ�� ����
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int sum = 0 ;
		
		for( int i = 0 ; i < num + 1 ; i++) {
			
			sum += i ; 
			
		}
		
		System.out.printf("1���� %d������ ���� %d�Դϴ�", num, sum);
		
	
		sc.close(); //���� ����!!
	}

}
