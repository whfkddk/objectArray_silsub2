package com.kh.silsub2.view;

import java.util.Scanner;

import com.kh.silsub2.controller.MemberManager;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberManager mm = new MemberManager();
	
	public void mainMenu() {
		do {
			System.out.println("최대 등록 가능한 회원 수는" + MemberManager.SIZE + "명 입니다.");
			System.out.println("현재 등록된 회원 수는 " + mm.getMemberCount() + "명 입니다.");
			
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println();
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 조회");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 정렬");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 회원 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			sc.nextLine();	// 엔터 제거용
			switch(input) {
				case 1: 
					mm.memberInput();
					break;
				case 2: 
					searchMenu();	// 서브메뉴1
					break;
				case 3: 
					modifyMenu();	// 서브메뉴2
					break;
				case 4: 
					sortMenu();		// 서브메뉴3
					break;
				case 5: 
					mm.deleteAllMember();
					break;
				case 6: 
					mm.printAllMember();
					break;
				case 9: 
					char result = ' ';
					while(true) {
						System.out.println("정말로 끝내시겠습니까?(y/n)");
						result = sc.nextLine().toLowerCase().charAt(0);      
						if(result=='y'||result=='n') {
							break;
						}else {
							System.out.println("y 또는 n을 누르시라구요!");
						}
					}
					if(result=='y') {
						return;
					}
					break;
				default : System.out.println("지대로 확인하고 눌러 주십쇼");
			}
			
			
		}while(true);
	}

	// 정렬 부메뉴
	private void sortMenu() {
		do {
			System.out.println();
			System.out.println("***** 회원 정보 정렬 및 출력 메뉴 *****");
			System.out.println("1. 아이디 오름차순 정렬 출력");
			System.out.println("2. 아이디 내림차순 정렬 출력");
			System.out.println("3. 나이 오름차순 정렬 출력");
			System.out.println("4. 나이 내림차순 정렬 출력");
			System.out.println("5. 성별 오름차순 정렬 출력");
			System.out.println("6. 성별 내림차순 정렬 출력");
			System.out.println("9. 이전 메뉴로 돌아가기");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			
			switch(input) {
			case 1: 
				mm.sortIDAsc();
				break;
			case 2: 
				mm.sortIDDesc();
				break;
			case 3:
				mm.sortAgeAsc();
				break;
			case 4: 
				mm.sortAgeDesc();
				break;
			case 5: 
				mm.sortGenderAsc();
				break;
			case 6: 
				mm.sortGenderDesc();
				break;
			case 9: 
				System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
			}
			
			
		}while(true);
		
	}
	
	// 수정 부메뉴
	private void modifyMenu() {
		do {
			System.out.println();
			System.out.println("***** 회원 정보 수정 메뉴 *****");
			System.out.println("1. 암호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 나이 변경");
			System.out.println("9. 이전 메뉴로 돌아가기");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			
			int index = -1; 
			switch(input) {
				case 1: 
					System.out.print("변경할 아이디를 입력하세요 : ");
					index = mm.searchMemberId(sc.next());
					
					// 조회가 되었는지 체크
					if(index > -1) {
						// 해당 멤버 출력
						mm.printMember(index);	// 변경전 출력
						// 변경할 패스워드 입력 후 변경
						System.out.print("변경할 패스워드를 입력하세요 : ");
						MemberManager.mar[index].setPassword(sc.next());
						mm.printMember(index);	// 변경된 패스워드를 가지게 되었는지 체크용도로 출력
						System.out.println("회원님의 정보가 변경 되었습니다.");
						
					}else {
						System.out.println("회원의 정보가 존재하지 않습니다.");
					}
					break;
				case 2:
					System.out.print("변경할 아이디를 입력하세요 : ");
					index = mm.searchMemberId(sc.next());
					
					// 조회가 되었는지 체크
					if(index > -1) {
						// 해당 멤버 출력
						mm.printMember(index);	// 변경전 출력
						// 변경할 이메일 입력 후 변경
						System.out.print("변경할 이메일을 입력하세요 : ");
						MemberManager.mar[index].setEmail(sc.next());
						mm.printMember(index);	// 변경된 이메일을 가지게 되었는지 체크용도로 출력
						System.out.println("회원님의 정보가 변경 되었습니다.");
						
					}else {
						System.out.println("회원의 정보가 존재하지 않습니다.");
					}
					break;
				case 3: 
					System.out.print("변경할 아이디를 입력하세요 : ");
					index = mm.searchMemberId(sc.next());
					
					// 조회가 되었는지 체크
					if(index > -1) {
						// 해당 멤버 출력
						mm.printMember(index);	// 변경전 출력
						// 변경할 나이 입력 후 변경
						System.out.print("변경할 나이를 입력하세요 : ");
						MemberManager.mar[index].setAge(sc.nextInt());
						mm.printMember(index);	// 변경된 나이를 가지게 되었는지 체크용도로 출력
						System.out.println("회원님의 정보가 변경 되었습니다.");
						
					}else {
						System.out.println("회원의 정보가 존재하지 않습니다.");
					}
					break;
				case 9: 
					System.out.println("메인 메뉴로 돌아갑니다.");
					return;
				default:System.out.println("번호를 잘 못 누른듯?");
			}
			
		}while(true);
		
	}

	// 회원 조회용 서브 메뉴
	private void searchMenu() {
		do {
			System.out.println();
			System.out.println("***** 회원 정보 검색 메뉴 *****");
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 이메일로 검색");
			System.out.println("9. 이전 메뉴로 가기");
			System.out.print("메뉴 선택 : ");
			int input = sc.nextInt();
			int index = -1;
			
			switch(input) {
				case 1: 
					System.out.print("검색할 아이디를 입력하세요 : ");
					index = mm.searchMemberId(sc.next());
					break;
				case 2: 
					System.out.print("검색할 이름을 입력하세요 : ");
					index = mm.searchMemberName(sc.next());
					break;
				case 3: 
					System.out.print("검색할 이메일을 입력하세요 : ");
					index = mm.searchMemberEmail(sc.next());
					break;
				case 9: 
					System.out.println("메인 메뉴로 돌아갑니다.");
					return;
				default:System.out.println("번호를 잘 못 누른듯?");
			}
			
			// 검색이 됐던 안됐던 그 결과를 알려주자
			if(index > -1) {	// 검색이 되었다면..
				mm.printMember(index);
			}else {				// 검색이 되지 않았다면..
				System.out.println("찾고자 하시는 회원의 정보가 존재하지 않습니다.");
			}
			
		}while(true);
		
	}
	
	
	
	

}
