package hello;

class Calculator {
	int x, y;
	
	public int sum() {
		return x + y ;	
	}
	public int sub() {
		return x - y;
	}
	public int div() {
		return x / y;
	}
	public int mul() {
		return x * y;
	}
	public void printResult() {
		System.out.printf("%d + %d = %d\n", x, y, sum());
		System.out.printf("%d - %d = %d\n", x, y, sub());
		System.out.printf("%d / %d = %d\n", x, y, div());
		System.out.printf("%d * %d = %d\n", x, y, mul());
	}
}

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Calculator calculator = new Calculator();
		
		calculator.x = 30;
		calculator.y = 50;

		calculator.printResult();
		

	}

}
