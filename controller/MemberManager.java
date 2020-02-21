package com.kh.silsub2.controller;

import java.util.Scanner;

import com.kh.silsub2.model.vo.Member;

public class MemberManager {
	Scanner sc = new Scanner(System.in);
	public static final int SIZE = 10; // 관리할 수 있는 회원의 최대 크기로
										// 어디서든 접근 가능하고 변하지 않게

	public static Member[] mar = new Member[SIZE]; // 그크기 만큼 객체 배열 생성

	private int memberCount = 0; // 객체배열에 담긴 현재 인원수

	{
		mar[0] = new Member("kim123", "김유신", "pwkkk34!", "kim123@naver.com", 'M', 35);
		mar[1] = new Member("dlagon777", "김용승", "bclass11@", "dlagon777@google.com", 'M', 20);
		mar[2] = new Member("yksrose77", "이수한", "yksrose77#", "yksrose77@daum.net", 'F', 29);
		memberCount = 3;
	}

	public MemberManager() {

	}

	// 현재 인원수 반환 용도
	public int getMemberCount() {
		return memberCount;
	}

	// 1. 새 회원 등록
	public void memberInput() {
		if (memberCount >= SIZE) {
			System.out.println("다 찼으니 돌아가~");
			return;
		}
		while (true) {
			mar[memberCount] = new Member();

			System.out.print((memberCount + 1) + "번째 아이디 : ");
			mar[memberCount].setId(sc.next());
			System.out.print("패스워드 : ");
			mar[memberCount].setPassword(sc.next());
			System.out.print("이름 : ");
			mar[memberCount].setName(sc.next());
			System.out.print("이메일 : ");
			mar[memberCount].setEmail(sc.next());
			System.out.print("성별(남/여) : ");
			mar[memberCount].setGender(sc.next().charAt(0));
			System.out.print("나이 : ");
			mar[memberCount].setAge(sc.nextInt());

			System.out.println("회원 정보가 정상적으로 저장 되었습니다.");
			memberCount++; // 가입을 마치면 현재 인원수를 증가시켜 놓자

			if (memberCount >= SIZE) {
				System.out.println("마지막 회원이 되셨습니다. 추카요~");
				break;
			}

			while (true) {
				System.out.println("추가로 다른 회원 정보를 입력하시겠습니까?(y/n)");
				String str = sc.next();
				if (str.equalsIgnoreCase("n")) {
					return;
				} else if (str.equalsIgnoreCase("y")) {
					break;
				} else {
					System.out.println("y나 n이 안보임?");
				}
			}
		}
	}

	// 6. 전체 회원 출력
	public void printAllMember() {
		// 객체 배열 모두 출력
		for (int i = 0; i < memberCount; i++) {
			System.out.println("회원 정보 : " + mar[i].toString());
		}
		if (memberCount == 0) {
			System.out.println("회원 다 도망감");
		}

	}

	// 회원을
	// 아이디로 검색
	public int searchMemberId(String id) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getId().equals(id)) {
				return i; // 검색 결과 일치하는 객체의 인덱스를 반환하자.
			}
		}
		return -1;
	}

	// 검색된 index번째 회원을 출력(한명 출력)
	public void printMember(int index) {
		System.out.println("검색된 회원 정보 : " + mar[index]);

	}

	public int searchMemberName(String name) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getName().equals(name)) {
				return i; // 검색 결과 일치하는 객체의 인덱스를 반환하자.
			}
		}
		return -1;
	}

	public int searchMemberEmail(String email) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getEmail().equals(email)) {
				return i; // 검색 결과 일치하는 객체의 인덱스를 반환하자.
			}
		}
		return -1;
	}

	// 5. 회원 전체 삭제
	public void deleteAllMember() {
		mar = new Member[SIZE];
		memberCount = 0;
		System.out.println("회원이 모두 삭제 되었습니다.");
	}

	// 4. 정렬
	// 아이디 오름차순
	public void sortIDAsc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				int result = mar[i].getId().compareTo(mar[j].getId());
				// 1. i가 크면 >0 (양수)가 나오고,
				// 2. i가 작으면 <0 (음수)가 나오고,
				// 3. 비교하는 String 두 개가 같으면 =0 (0)이 나옴.

				if (result > 0) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//			System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}
	}

	// 아이디 내림차순
	public void sortIDDesc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				int result = mar[i].getId().compareTo(mar[j].getId());
				// 1. i가 크면 >0 (양수)가 나오고,
				// 2. i가 작으면 <0 (음수)가 나오고,
				// 3. 비교하는 String 두 개가 같으면 =0 (0)이 나옴.

				if (result < 0) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//			System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}

	}

	// 나이 오름차순
	public void sortAgeAsc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getAge() > mar[j].getAge()) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//			System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}

	}

	// 나이 내림차순
	public void sortAgeDesc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getAge() < mar[j].getAge()) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//				System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}

	}

	// 성별 오름차순
	public void sortGenderAsc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getGender() > mar[j].getGender()) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//						System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}

	}

	// 성별 내림차순
	public void sortGenderDesc() {
		// 선택 정렬 비스무리하게 해보자
		Member tmp; // 스위칭(자리바꿈)을 위한 잠시 저장 공간용 변수
		for (int i = 0; i < memberCount -1 ; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getGender() < mar[j].getGender()) {
					// 자리 바꿈
					tmp = mar[i];
					mar[i] = mar[j];
					mar[j] = tmp;
				}
			}
		}

		for (int c = 0; c < memberCount; c++) {
//						System.out.println(mar[c].toString());
			System.out.println(mar[c]);
		}

	}

}
