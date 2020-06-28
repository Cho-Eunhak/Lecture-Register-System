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
		System.out.println(vPersonalInfo.name + "��!, �ȳ��ϼ���. ");
		
		
		System.out.println("���� �޴��� ���� �ϼ���");		
		boolean finished = false;		
		while (!finished) {
			String fileName = "root";
			VGangjwa vGangjwa = null;
			System.out.println("1:�̸����, 2:������û, 3:����������, 4:�α׾ƿ�, 5:����");
			System.out.print("�Է�: ");
			int selection = 0;
			selection=scanner.nextInt();
			if (selection == 1) {
				System.out.println("�̸���⸦ �����ϼ̽��ϴ�.");
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
					{System.out.println("�̸���⿡ �ߺ��� ���°� �ֽ��ϴ�.");}
				else{
					sMiridamgi.write(vPersonalInfo, vGangjwa);
					System.out.println(vGangjwa.getGangjwaName()+"���°� "+vPersonalInfo.name+"���� ������������ �̸���� �Ǿ����ϴ�.");}
						}
			else if (selection == 2) {
				System.out.println("������û�� �����ϼ̽��ϴ�.");
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
					{System.out.println("������û�� �̹� �ߺ��� ���°� �ֽ��ϴ�.");}
					else if(plus>18) {
					System.out.println("�ִ���������� �ʰ��Ͽ����ϴ�. �ִ���������� 18�����̰� ���� ������û������ "+damgi+"���� �Դϴ�.");
					}
					else{
						sSincheong.write(vPersonalInfo, vGangjwa);
						System.out.println(vGangjwa.getGangjwaName()+"���°� "+vPersonalInfo.name+"���� ���¿� ������û �Ǿ����ϴ�.");}}
			else if (selection == 3) {
				System.out.println(vPersonalInfo.name+"���� �����������Դϴ�.");
				PMypage pMypage = new PMypage();
				pMypage.show(scanner, vPersonalInfo);
					}
			else if(selection == 4){
				System.out.println("�α׾ƿ��մϴ�. ó������ ���ư��ϴ�.");
				finished = true;
				PMain pMain = new PMain();
				pMain.show();
			}
			else if(selection == 5){
				System.out.print("������û �ý����� �����մϴ�.");
				finished = true;
			}
		
			}
		}
	}

