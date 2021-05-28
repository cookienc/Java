package hello;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.print("개행문자 없이 그냥 출력되는 print");
	System.out.print("줄을 바꾸려면 개행문자 입력!!\n\n");
	
	System.out.println("개행문자가 포함되어 었는 println");
	System.out.println("바로 띄어쓰기 가능!!\n");
	
	String a = "c언어와 같은 자바의 printf" ;
	String b = "배우기가 좀 더 수월하겠어요.";
	String c = "Java를 자바 6월 과정 5일차";
	
	System.out.printf("%s\n", a);
	System.out.printf("%s\n\n", b);
	System.out.printf("%s\n", c);
	}

}
