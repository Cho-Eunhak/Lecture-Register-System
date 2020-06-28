package presentation;

import java.util.Scanner;

import valueObject.VFindInfo;
import valueObject.VPersonalInfo;

public class PMain {

	public PMain() {
		// TODO Auto-generated constructor stub
	}
	
	public void show() {
		Scanner scanner = new Scanner(System.in);
		VPersonalInfo vPersonalInfo = this.login(scanner);
		if (vPersonalInfo != null) {
			this.sugangsincheong(scanner, vPersonalInfo);
		}
		this.terminate();
		scanner.close();
	}

	private VPersonalInfo login(Scanner scanner) {
			
		boolean finished = false;		
		VPersonalInfo vPersonalInfo = null;		
		while (!finished) {
			System.out.println("1:�α���, 2:ȸ������, 3:PWã��, 4:������û�ý��� ����");
			System.out.print("�Է�: ");
			int selection = scanner.nextInt();
			if (selection == 1) {
				PLogin pLogin = new PLogin();
				vPersonalInfo = pLogin.show(scanner);
				// print result
				if (vPersonalInfo == null) {
					System.out.println("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�. ");
				} else {
					// �α��� ����
					System.out.println(vPersonalInfo.name + "��!, �α��� �Ǿ����ϴ�. ");
					finished = true;
				}				
			} else if (selection == 2) {
				PPersonalInfo pRegistration = new PPersonalInfo();
				pRegistration.show(scanner);}
			else if (selection == 3) {
				System.out.println("�н����带 ã���ϴ�.");
				VFindInfo vFindInfo = new VFindInfo();
				System.out.print("���̵� �Է��ϼ���: ");
				vFindInfo.id = scanner.next();
				PFindPW PfindIDPW = new PFindPW();
				vPersonalInfo=PfindIDPW.findIDPW(scanner, vFindInfo.id);
				if (vPersonalInfo == null) {
					System.out.println("��ġ�ϴ� ���̵� ���������� �����ϴ�. ");
				} else {
					System.out.println(vFindInfo.id + "���� ��й�ȣ��"+vPersonalInfo.password+"�Դϴ�.");
				}	
			}
			else if (selection == 4) {
				finished = true;
			}
		}		
		return vPersonalInfo;
	}
	
	private void sugangsincheong(Scanner scanner, VPersonalInfo vPersonalInfo) {
		// ������û ����
		PSugangsincheong pSugangsincheong = new PSugangsincheong();
		pSugangsincheong.show(scanner, vPersonalInfo);	
	}
	

	
	private void terminate() {
	}

}
