package hello;

import java.util.Scanner; // ��ĳ�� ����
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // ��ü ����
		
		System.out.println("========�ڱ�Ұ�========");
			
		System.out.print("�̸��� �Է����ּ��� : ");
		String sentence1 = sc.nextLine();
				
		System.out.print("���� � ������ �ϰ� �ֳ���? : ");
		String sentence2 = sc.nextLine();
		
		System.out.print("���� ��ĥ° �����ΰ���? : ");
		int num1 = sc.nextInt();
		
		System.out.print("���� ���� �� ���� �����߳���? : ");	
		float num2 = sc.nextFloat();
		
		System.out.printf("%s�� ���� %s ���� %d����, %.1f��° �����Դϴ�.\n", sentence1, sentence2, num1, num2);	
		
		sc.close(); //���� ����!!
	}

}
