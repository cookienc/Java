package hello;

import java.util.Scanner; // ��ĳ�� ����
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� 2���� �Է��ϼ���: ");
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.print("�� �߿� ū ���� : ");
		System.out.println( a > b ? a : (a == b) ? "����" : b);
		
		sc.close(); //���� ����!!
	}

}
