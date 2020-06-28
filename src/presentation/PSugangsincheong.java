package presentation;

import java.util.Scanner;
import java.util.Vector;

import model.MMypage;
import service.SMiridamgi;
import service.SMypage;
import service.SSincheong;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class PSugangsincheong {

//	private PMiridamgi pMiridamgi;
//	private PSincheong pSincheong;
	
	
	public PSugangsincheong() {
	}

	public void show(Scanner scanner, VPersonalInfo vPersonalInfo) {
		System.out.println(vPersonalInfo.name + "님!, 안녕하세요. ");
		
		
		System.out.println("다음 메뉴를 선택 하세요");		
		boolean finished = false;		
		while (!finished) {
			String fileName = "root";
			VGangjwa vGangjwa = null;
			System.out.println("1:미리담기, 2:수강신청, 3:마이페이지, 4:로그아웃, 5:종료");
			System.out.print("입력: ");
			int selection = 0;
			selection=scanner.nextInt();
			if (selection == 1) {
				System.out.println("미리담기를 선택하셨습니다.");
				PHakgwa pCampus = new PHakgwa();
				fileName = pCampus.show(scanner, fileName);
				PHakgwa pCollege = new PHakgwa();
				fileName = pCollege.show(scanner, fileName);
				PHakgwa pHakgwa = new PHakgwa();
				fileName = pHakgwa.show(scanner, fileName);
				PGangjwa pGangjwa = new PGangjwa();
				vGangjwa = pGangjwa.show(scanner, fileName);
				SMypage sMypage = new SMypage();
				Vector<VGangjwa> abc = sMypage.getmiridamgidata(vPersonalInfo.id);
				SMiridamgi sMiridamgi = new SMiridamgi();
				boolean a = false;
				for (VGangjwa vDatum: abc) {
					if(vDatum.getId()==vGangjwa.getId()) {
						a=true;
						break;
					}
					else {
						a=false;}
					}
				if(a==true) 
					{System.out.println("미리담기에 중복된 강좌가 있습니다.");}
				else{
					sMiridamgi.write(vPersonalInfo, vGangjwa);
					System.out.println(vGangjwa.getGangjwaName()+"강좌가 "+vPersonalInfo.name+"님의 마이페이지에 미리담기 되었습니다.");}
						}
			else if (selection == 2) {
				System.out.println("수강신청을 선택하셨습니다.");
				PHakgwa pCampus = new PHakgwa();
				fileName = pCampus.show(scanner, fileName);
				PHakgwa pCollege = new PHakgwa();
				fileName = pCollege.show(scanner, fileName);
				PHakgwa pHakgwa = new PHakgwa();
				fileName = pHakgwa.show(scanner, fileName);
				PGangjwa pGangjwa = new PGangjwa();
				vGangjwa = pGangjwa.show(scanner, fileName);
				SMypage sMypage = new SMypage();
				Vector<VGangjwa> abc = sMypage.getsincheongdata(vPersonalInfo.id);
				SSincheong sSincheong = new SSincheong();
				int a = 0;
				int damgi=0;
				int plus=0;
				for (VGangjwa vDatum: abc) {
					damgi+=vDatum.getHakjum();}
				plus=damgi+vGangjwa.getHakjum();
				for (VGangjwa vDatum: abc) {
					if(vDatum.getId()==vGangjwa.getId()) {
						a=1;
						break;}
					else {a=0;}}
					if(a==1) 
					{System.out.println("수강신청에 이미 중복된 강좌가 있습니다.");}
					else if(plus>18) {
					System.out.println("최대수강학점을 초과하였습니다. 최대수강학점은 18학점이고 현재 수강신청학점은 "+damgi+"학점 입니다.");
					}
					else{
						sSincheong.write(vPersonalInfo, vGangjwa);
						System.out.println(vGangjwa.getGangjwaName()+"강좌가 "+vPersonalInfo.name+"님의 강좌에 수강신청 되었습니다.");}}
			else if (selection == 3) {
				System.out.println(vPersonalInfo.name+"님의 마이페이지입니다.");
				PMypage pMypage = new PMypage();
				pMypage.show(scanner, vPersonalInfo);
					}
			else if(selection == 4){
				System.out.println("로그아웃합니다. 처음으로 돌아갑니다.");
				finished = true;
				PMain pMain = new PMain();
				pMain.show();
			}
			else if(selection == 5){
				System.out.print("수강신청 시스템을 종료합니다.");
				finished = true;
			}
		
			}
		}
	}

