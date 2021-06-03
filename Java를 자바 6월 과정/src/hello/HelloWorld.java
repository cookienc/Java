package hello;

import java.util.Scanner; // 스캐너 복사
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 개발자 MBTI 결과 보기 ===");
		System.out.print("당신의 MBTI를 입력하세요 : ");
		String MBTI = sc.nextLine();
		
		switch(MBTI) {
		
		case "intp":
		case "INTP":
			System.out.println("당신은 백엔드형입니다!");
			break;
			
		case "enfj":
		case "ENFJ":
			System.out.println("당신은 프론트엔드형입니다!");
			break;
			
		case "infj":
		case "INFJ":
			System.out.println("당신은 풀스택형입니다!");
			break;
		
			
		case "istj":
		case "ISTJ":
			System.out.println("당신은 퍼블리셔형입니다!");
			break;
		
			
		case "entj":
		case "ENTJ":
			System.out.println("당신은 아키텍쳐형입니다!");
			break;
		
		case "isfj":
		case "ISFJ":
			System.out.println("당신은 보안전문가형입니다!");
			break;
		
		case "intj":
		case "INTJ":
			System.out.println("당신은 데이터분석가형입니다!");
			break;
		
		case "enfp":
		case "ENFP":
			System.out.println("당신은 AI형입니다!");
			break;
		
		case "entp":
		case "ENTP":
			System.out.println("당신은 iOS형입니다!");
			break;
		
		case "esfj":
		case "ESFJ":
			System.out.println("당신은 안드로이드형입니다!");
			break;
		
		case "esfp":
		case "ESFP":
			System.out.println("당신은 게임 개발자형입니다!");
			break;
		
		case "estp":
		case "ESTP":
			System.out.println("당신은 IoT 개발형입니다!");
			break;
		
		case "estj":
		case "ESTJ":
			System.out.println("당신은 QA 형입니다!");
			break;
		
		case "infp":
		case "INFP":
			System.out.println("당신은 블록체인형입니다!");
			break;
		
		case "istp":
		case "ISTP":
			System.out.println("당신은 임베디드 개발자형입니다!");
			break;
		
		case "isfp":
		case "ISFP":
			System.out.println("당신은 네트워크 개발자형입니다!");
			break;
			
		default :
			System.out.println("정확한 MBTI 유형이 아니에요ㅠㅠ");
		
			
		}
		
		sc.close(); //잊지 말기!!
	}

}
