package my.calendar;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 ( 0 = Sunday, ...), -1 = 오류
	 */
	public int parseDay(String week) {
		if (week == "SU") return 0;
		else if (week.equals("MO")) return 1; 
		else if (week.equals("TU")) return 2; 
		else if (week.equals("WE")) return 3; 
		else if (week.equals("TH")) return 4; 
		else if (week.equals("FR")) return 5; 
		else if (week.equals("SA")) return 6; 
		else return 0;
	}
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		while(true) {
			
			System.out.println("년도을 입력하세요(exit : -1)");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			if (year == -1) break;
			
			System.out.println("월을 입력하세요");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();
			
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("WEEKDAY> ");
			String str_weekday = scanner.next();
			int weekday = parseDay(str_weekday);
			
			
			if (month < 1 || month > 12) 
				System.out.println("잘못된 입력입니다.");;
			cal.printCalendar(year, month, weekday);
		}
		
		System.out.println("반복이 끝났습니다.%n");
		scanner.close();
	
	}

	public static void main(String[] args) {
		
		Prompt p = new Prompt();
		p.runPrompt();

	}
}