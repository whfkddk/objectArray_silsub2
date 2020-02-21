package com.kh.silsub2.view;

import java.util.Scanner;

import com.kh.silsub2.controller.MemberManager;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberManager mm = new MemberManager();
	
	public void mainMenu() {
		do {
			System.out.println("�ִ� ��� ������ ȸ�� ����" + MemberManager.SIZE + "�� �Դϴ�.");
			System.out.println("���� ��ϵ� ȸ�� ���� " + mm.getMemberCount() + "�� �Դϴ�.");
			
			System.out.println("***** ȸ�� ���� ���α׷� *****");
			System.out.println();
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ȸ�� ��ȸ");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("6. ȸ�� ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ���� : ");
			int input = sc.nextInt();
			sc.nextLine();	// ���� ���ſ�
			switch(input) {
				case 1: 
					mm.memberInput();
					break;
				case 2: 
					searchMenu();	// ����޴�1
					break;
				case 3: 
					modifyMenu();	// ����޴�2
					break;
				case 4: 
					sortMenu();		// ����޴�3
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
						System.out.println("������ �����ðڽ��ϱ�?(y/n)");
						result = sc.nextLine().toLowerCase().charAt(0);      
						if(result=='y'||result=='n') {
							break;
						}else {
							System.out.println("y �Ǵ� n�� �����ö󱸿�!");
						}
					}
					if(result=='y') {
						return;
					}
					break;
				default : System.out.println("����� Ȯ���ϰ� ���� �ֽʼ�");
			}
			
			
		}while(true);
	}

	// ���� �θ޴�
	private void sortMenu() {
		do {
			System.out.println();
			System.out.println("***** ȸ�� ���� ���� �� ��� �޴� *****");
			System.out.println("1. ���̵� �������� ���� ���");
			System.out.println("2. ���̵� �������� ���� ���");
			System.out.println("3. ���� �������� ���� ���");
			System.out.println("4. ���� �������� ���� ���");
			System.out.println("5. ���� �������� ���� ���");
			System.out.println("6. ���� �������� ���� ���");
			System.out.println("9. ���� �޴��� ���ư���");
			System.out.print("�޴� ���� : ");
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
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			default:
			}
			
			
		}while(true);
		
	}
	
	// ���� �θ޴�
	private void modifyMenu() {
		do {
			System.out.println();
			System.out.println("***** ȸ�� ���� ���� �޴� *****");
			System.out.println("1. ��ȣ ����");
			System.out.println("2. �̸��� ����");
			System.out.println("3. ���� ����");
			System.out.println("9. ���� �޴��� ���ư���");
			System.out.print("�޴� ���� : ");
			int input = sc.nextInt();
			
			int index = -1; 
			switch(input) {
				case 1: 
					System.out.print("������ ���̵� �Է��ϼ��� : ");
					index = mm.searchMemberId(sc.next());
					
					// ��ȸ�� �Ǿ����� üũ
					if(index > -1) {
						// �ش� ��� ���
						mm.printMember(index);	// ������ ���
						// ������ �н����� �Է� �� ����
						System.out.print("������ �н����带 �Է��ϼ��� : ");
						MemberManager.mar[index].setPassword(sc.next());
						mm.printMember(index);	// ����� �н����带 ������ �Ǿ����� üũ�뵵�� ���
						System.out.println("ȸ������ ������ ���� �Ǿ����ϴ�.");
						
					}else {
						System.out.println("ȸ���� ������ �������� �ʽ��ϴ�.");
					}
					break;
				case 2:
					System.out.print("������ ���̵� �Է��ϼ��� : ");
					index = mm.searchMemberId(sc.next());
					
					// ��ȸ�� �Ǿ����� üũ
					if(index > -1) {
						// �ش� ��� ���
						mm.printMember(index);	// ������ ���
						// ������ �̸��� �Է� �� ����
						System.out.print("������ �̸����� �Է��ϼ��� : ");
						MemberManager.mar[index].setEmail(sc.next());
						mm.printMember(index);	// ����� �̸����� ������ �Ǿ����� üũ�뵵�� ���
						System.out.println("ȸ������ ������ ���� �Ǿ����ϴ�.");
						
					}else {
						System.out.println("ȸ���� ������ �������� �ʽ��ϴ�.");
					}
					break;
				case 3: 
					System.out.print("������ ���̵� �Է��ϼ��� : ");
					index = mm.searchMemberId(sc.next());
					
					// ��ȸ�� �Ǿ����� üũ
					if(index > -1) {
						// �ش� ��� ���
						mm.printMember(index);	// ������ ���
						// ������ ���� �Է� �� ����
						System.out.print("������ ���̸� �Է��ϼ��� : ");
						MemberManager.mar[index].setAge(sc.nextInt());
						mm.printMember(index);	// ����� ���̸� ������ �Ǿ����� üũ�뵵�� ���
						System.out.println("ȸ������ ������ ���� �Ǿ����ϴ�.");
						
					}else {
						System.out.println("ȸ���� ������ �������� �ʽ��ϴ�.");
					}
					break;
				case 9: 
					System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				default:System.out.println("��ȣ�� �� �� ������?");
			}
			
		}while(true);
		
	}

	// ȸ�� ��ȸ�� ���� �޴�
	private void searchMenu() {
		do {
			System.out.println();
			System.out.println("***** ȸ�� ���� �˻� �޴� *****");
			System.out.println("1. ���̵�� �˻�");
			System.out.println("2. �̸����� �˻�");
			System.out.println("3. �̸��Ϸ� �˻�");
			System.out.println("9. ���� �޴��� ����");
			System.out.print("�޴� ���� : ");
			int input = sc.nextInt();
			int index = -1;
			
			switch(input) {
				case 1: 
					System.out.print("�˻��� ���̵� �Է��ϼ��� : ");
					index = mm.searchMemberId(sc.next());
					break;
				case 2: 
					System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
					index = mm.searchMemberName(sc.next());
					break;
				case 3: 
					System.out.print("�˻��� �̸����� �Է��ϼ��� : ");
					index = mm.searchMemberEmail(sc.next());
					break;
				case 9: 
					System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				default:System.out.println("��ȣ�� �� �� ������?");
			}
			
			// �˻��� �ƴ� �ȵƴ� �� ����� �˷�����
			if(index > -1) {	// �˻��� �Ǿ��ٸ�..
				mm.printMember(index);
			}else {				// �˻��� ���� �ʾҴٸ�..
				System.out.println("ã���� �Ͻô� ȸ���� ������ �������� �ʽ��ϴ�.");
			}
			
		}while(true);
		
	}
	
	
	
	

}
