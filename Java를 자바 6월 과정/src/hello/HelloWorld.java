package hello;

import java.util.Scanner; // ��ĳ�� ����
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // ��ü ����
		
		System.out.print("ù��° ���ڸ� �Է��ϼ���: ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ���: ");
		int num2 = sc.nextInt();
		
		System.out.println("===��Ģ���� ����ϱ�===");
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
		
		sc.close(); //���� ����!!
	}

}
