package com.kh.silsub2.controller;

import java.util.Scanner;

import com.kh.silsub2.model.vo.Member;

public class MemberManager {
	Scanner sc = new Scanner(System.in);
	public static final int SIZE = 10; // ������ �� �ִ� ȸ���� �ִ� ũ���
										// ��𼭵� ���� �����ϰ� ������ �ʰ�

	public static Member[] mar = new Member[SIZE]; // ��ũ�� ��ŭ ��ü �迭 ����

	private int memberCount = 0; // ��ü�迭�� ��� ���� �ο���

	{
		mar[0] = new Member("kim123", "������", "pwkkk34!", "kim123@naver.com", 'M', 35);
		mar[1] = new Member("dlagon777", "����", "bclass11@", "dlagon777@google.com", 'M', 20);
		mar[2] = new Member("yksrose77", "�̼���", "yksrose77#", "yksrose77@daum.net", 'F', 29);
		memberCount = 3;
	}

	public MemberManager() {

	}

	// ���� �ο��� ��ȯ �뵵
	public int getMemberCount() {
		return memberCount;
	}

	// 1. �� ȸ�� ���
	public void memberInput() {
		if (memberCount >= SIZE) {
			System.out.println("�� á���� ���ư�~");
			return;
		}
		while (true) {
			mar[memberCount] = new Member();

			System.out.print((memberCount + 1) + "��° ���̵� : ");
			mar[memberCount].setId(sc.next());
			System.out.print("�н����� : ");
			mar[memberCount].setPassword(sc.next());
			System.out.print("�̸� : ");
			mar[memberCount].setName(sc.next());
			System.out.print("�̸��� : ");
			mar[memberCount].setEmail(sc.next());
			System.out.print("����(��/��) : ");
			mar[memberCount].setGender(sc.next().charAt(0));
			System.out.print("���� : ");
			mar[memberCount].setAge(sc.nextInt());

			System.out.println("ȸ�� ������ ���������� ���� �Ǿ����ϴ�.");
			memberCount++; // ������ ��ġ�� ���� �ο����� �������� ����

			if (memberCount >= SIZE) {
				System.out.println("������ ȸ���� �Ǽ̽��ϴ�. ��ī��~");
				break;
			}

			while (true) {
				System.out.println("�߰��� �ٸ� ȸ�� ������ �Է��Ͻðڽ��ϱ�?(y/n)");
				String str = sc.next();
				if (str.equalsIgnoreCase("n")) {
					return;
				} else if (str.equalsIgnoreCase("y")) {
					break;
				} else {
					System.out.println("y�� n�� �Ⱥ���?");
				}
			}
		}
	}

	// 6. ��ü ȸ�� ���
	public void printAllMember() {
		// ��ü �迭 ��� ���
		for (int i = 0; i < memberCount; i++) {
			System.out.println("ȸ�� ���� : " + mar[i].toString());
		}
		if (memberCount == 0) {
			System.out.println("ȸ�� �� ������");
		}

	}

	// ȸ����
	// ���̵�� �˻�
	public int searchMemberId(String id) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getId().equals(id)) {
				return i; // �˻� ��� ��ġ�ϴ� ��ü�� �ε����� ��ȯ����.
			}
		}
		return -1;
	}

	// �˻��� index��° ȸ���� ���(�Ѹ� ���)
	public void printMember(int index) {
		System.out.println("�˻��� ȸ�� ���� : " + mar[index]);

	}

	public int searchMemberName(String name) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getName().equals(name)) {
				return i; // �˻� ��� ��ġ�ϴ� ��ü�� �ε����� ��ȯ����.
			}
		}
		return -1;
	}

	public int searchMemberEmail(String email) {
		for (int i = 0; i < memberCount; i++) {
			if (mar[i].getEmail().equals(email)) {
				return i; // �˻� ��� ��ġ�ϴ� ��ü�� �ε����� ��ȯ����.
			}
		}
		return -1;
	}

	// 5. ȸ�� ��ü ����
	public void deleteAllMember() {
		mar = new Member[SIZE];
		memberCount = 0;
		System.out.println("ȸ���� ��� ���� �Ǿ����ϴ�.");
	}

	// 4. ����
	// ���̵� ��������
	public void sortIDAsc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				int result = mar[i].getId().compareTo(mar[j].getId());
				// 1. i�� ũ�� >0 (���)�� ������,
				// 2. i�� ������ <0 (����)�� ������,
				// 3. ���ϴ� String �� ���� ������ =0 (0)�� ����.

				if (result > 0) {
					// �ڸ� �ٲ�
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

	// ���̵� ��������
	public void sortIDDesc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				int result = mar[i].getId().compareTo(mar[j].getId());
				// 1. i�� ũ�� >0 (���)�� ������,
				// 2. i�� ������ <0 (����)�� ������,
				// 3. ���ϴ� String �� ���� ������ =0 (0)�� ����.

				if (result < 0) {
					// �ڸ� �ٲ�
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

	// ���� ��������
	public void sortAgeAsc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getAge() > mar[j].getAge()) {
					// �ڸ� �ٲ�
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

	// ���� ��������
	public void sortAgeDesc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getAge() < mar[j].getAge()) {
					// �ڸ� �ٲ�
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

	// ���� ��������
	public void sortGenderAsc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getGender() > mar[j].getGender()) {
					// �ڸ� �ٲ�
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

	// ���� ��������
	public void sortGenderDesc() {
		// ���� ���� �񽺹����ϰ� �غ���
		Member tmp; // ����Ī(�ڸ��ٲ�)�� ���� ��� ���� ������ ����
		for (int i = 0; i < memberCount -1 ; i++) {
			for (int j = i + 1; j < memberCount; j++) {
				if (mar[i].getGender() < mar[j].getGender()) {
					// �ڸ� �ٲ�
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
