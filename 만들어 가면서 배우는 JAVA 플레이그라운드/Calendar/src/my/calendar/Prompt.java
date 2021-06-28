package my.calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal> ";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		while(true) {
			
			System.out.println("년도을 입력하세요");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			System.out.println("월을 입력하세요");
			System.out.print("MONTH>");
			int month = scanner.nextInt();
			if (month < 1 || month > 12) break;
			cal.printCalendar(year, month);
		}
		
		System.out.println("반복이 끝났습니다.%n");
		scanner.close();
	
	}

	public static void main(String[] args) {
		
		Prompt p = new Prompt();
		p.runPrompt();

	}
}