package presentation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import model.MMiridamgiapply;
import model.MMypage;
import model.Mchangepersonalinfo;
import model.Mmiradmgicancel;
import model.Msincheongcancel;
import service.SHakgwa;
import service.SMypage;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class PMypage {

	public VGangjwa show(Scanner scanner, VPersonalInfo vPersonalInfo) {
		boolean finished = false;	
		
		while (!finished) {
		System.out.println("1:�̸������ ���� ����, 2:������û�� ���� ����, 3:��й�ȣ ���� , 4: ���������� ����");
		System.out.print("�Է�: ");
		SMypage sMypage = new SMypage();
		int selection = 0;
		selection=scanner.nextInt();
		if (selection == 1) {
			boolean finish = false;	
			System.out.println(vPersonalInfo.id+"���� �̸������ �����Դϴ�.");
			int damgihakjum=0;
			Vector<VGangjwa> vLecture = sMypage.getmiridamgiData(vPersonalInfo.id);
			if (vLecture != null) {
				for (VGangjwa vDatum: vLecture) {
					System.out.println("���¹�ȣ: "+vDatum.getId());
					System.out.println("���¸�: "+vDatum.getGangjwaName());
					System.out.println("������: "+vDatum.getGyosuName());
					System.out.println("����: "+vDatum.getHakjum());
					System.out.println("�ð�: "+vDatum.getTime());
					System.out.print("\r\n");
					damgihakjum+=vDatum.getHakjum();
				}}
			System.out.println("������� �̸������ ������ �� ������ "+damgihakjum+"�Դϴ�");
			while (!finish) {
			System.out.println("1: �̸���� ����ϱ�, 2:�̸������ ���� ������û�ϱ�, 3: �̸������ ���񺸱� ����");
			System.out.print("�Է�: ");
			int sel=0;
			sel=scanner.nextInt();
			if(sel==1) {
				System.out.println("����� ������ �����ϼ���");
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				int sel2=0;
				String name = null;
				sel2=scanner.nextInt();
				name=sMypage.damgicancel(sel2, vLecture, vPersonalInfo);
				System.out.println(name+" ���°� �̸���� ��ҵǾ����ϴ�.");
				}
			else if(sel==2) {
				System.out.println("������û�� ������ �����ϼ���");
				System.out.print("���¹�ȣ�� �Է��ϼ���: ");
				int sel3=0;
				String name = null;
				sel3=scanner.nextInt();
				Vector<VGangjwa> abc = sMypage.getsincheongdata(vPersonalInfo.id);
				boolean a = false;
				for (VGangjwa vDatum: abc) {
					if(vDatum.getId()==sel3) {
						a=true;
						break;
					}
					else {
						a=false;}}
				if(a==true) 
					{System.out.println("������û�� �ߺ��� ���°� �ֽ��ϴ�.");}
				else{
					name=sMypage.damgiapply(sel3, vLecture, vPersonalInfo);
					System.out.println(name+" ���°� "+vPersonalInfo.name+"���� ���¿� ������û �Ǿ����ϴ�.");}
			}
			else if(sel==3) {
				System.out.println("�̸������ ���񺸱⸦ �����մϴ�.");
				finish=true;
			}
			
			}
			
			}
			
		
		else if (selection == 2) {
			boolean finish2 = false;	
			System.out.println(vPersonalInfo.id+"���� ������û�� �����Դϴ�.");
			int sincheonghakjum=0;
			Vector<VGangjwa> vLecture1 = sMypage.getsincheongData(vPersonalInfo.id);
			if (vLecture1 != null) {
				for (VGangjwa vDatum: vLecture1) {
					System.out.println("���¹�ȣ: "+vDatum.getId());
					System.out.println("���¸�: "+vDatum.getGangjwaName());
					System.out.println("������: "+vDatum.getGyosuName());
					System.out.println("����: "+vDatum.getHakjum());
					System.out.println("�ð�: "+vDatum.getTime());
					System.out.print("\r\n");
					sincheonghakjum+=vDatum.getHakjum();
				}
		}
			System.out.println("������� ������û�� ������ �� ������ "+sincheonghakjum+"�Դϴ�");
			
			
			while (!finish2) {
				System.out.println("1: ������û ����ϱ�, 2: ������û�� ���񺸱� ����");
				System.out.print("�Է�: ");
				int sel=0;
				sel=scanner.nextInt();
				if(sel==1) {
					System.out.println("����� ������ �����ϼ���");
					System.out.print("���¹�ȣ�� �Է��ϼ���: ");
					int sel4=0;
					String name = null;
					sel4=scanner.nextInt();
					name=sMypage.sincheongcancel(sel4, vLecture1, vPersonalInfo);
					System.out.println(name+" ���°� ������û ��ҵǾ����ϴ�.");
					}
				else if(sel==2) {
					System.out.println("������û�� ���񺸱⸦ �����մϴ�.");
					finish2=true;
				}
				
				}
			
		}
		else if(selection == 3){
			System.out.println("��й�ȣ�� �����մϴ�.");
			
			System.out.print("���� ��й�ȣ�� �Է��ϼ���: ");
			String oldpw = null;
			String newpw = null;
			oldpw=scanner.next();
			if(!oldpw.equals(vPersonalInfo.password)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
			}
			else {
				boolean rightPW=false;
				while(!rightPW) {
					System.out.print("���ο� ��й�ȣ�� �Է��ϼ���: ");
					newpw=scanner.next();
					if(newpw.length()<4 || newpw.length()>12) {
					System.out.println("��й�ȣ�� ������ �߸��Ǿ����ϴ�., 4�ڸ� �̻�, 12�ڸ� ���Ϸ� ������ֽʽÿ�.");}
					else
					{rightPW=true;}}
				sMypage.changepw(vPersonalInfo.id, oldpw, newpw);
				System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
				vPersonalInfo.password=newpw;
			}
			
		}
		
		else if(selection == 4){
			System.out.println("������������ �����մϴ�.");
			finished = true;
		}

			}
		
		return null;}
}
