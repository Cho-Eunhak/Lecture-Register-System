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
			System.out.println("1:로그인, 2:회원가입, 3:PW찾기, 4:수강신청시스템 종료");
			System.out.print("입력: ");
			int selection = scanner.nextInt();
			if (selection == 1) {
				PLogin pLogin = new PLogin();
				vPersonalInfo = pLogin.show(scanner);
				// print result
				if (vPersonalInfo == null) {
					System.out.println("아이디나 비밀번호가 일치하지 않습니다. ");
				} else {
					// 로그인 성공
					System.out.println(vPersonalInfo.name + "님!, 로그인 되었습니다. ");
					finished = true;
				}				
			} else if (selection == 2) {
				PPersonalInfo pRegistration = new PPersonalInfo();
				pRegistration.show(scanner);}
			else if (selection == 3) {
				System.out.println("패스워드를 찾습니다.");
				VFindInfo vFindInfo = new VFindInfo();
				System.out.print("아이디를 입력하세요: ");
				vFindInfo.id = scanner.next();
				PFindPW PfindIDPW = new PFindPW();
				vPersonalInfo=PfindIDPW.findIDPW(scanner, vFindInfo.id);
				if (vPersonalInfo == null) {
					System.out.println("일치하는 아이디나 개인정보가 없습니다. ");
				} else {
					System.out.println(vFindInfo.id + "님의 비밀번호는"+vPersonalInfo.password+"입니다.");
				}	
			}
			else if (selection == 4) {
				finished = true;
			}
		}		
		return vPersonalInfo;
	}
	
	private void sugangsincheong(Scanner scanner, VPersonalInfo vPersonalInfo) {
		// 수강신청 시작
		PSugangsincheong pSugangsincheong = new PSugangsincheong();
		pSugangsincheong.show(scanner, vPersonalInfo);	
	}
	

	
	private void terminate() {
	}

}
