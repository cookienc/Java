package hello;

import java.util.Scanner; // ��ĳ�� ����
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� 5���� ����� �����Ͽ� �Է��ϼ��� : ");
		int[] arr = new int[5];
		
		for(int i = 0; i<5 ; i++) {
		
		arr[i] = sc.nextInt();
			
		}
		System.out.println("=====�Է¿Ϸ�=====");
		System.out.println("=====��½���=====");
		
		for(int i = 4; i >= 0 ;i--) {
			
			System.out.println(arr[i]);
		}
		
		
		
	
		sc.close(); //���� ����!!
	}

}
