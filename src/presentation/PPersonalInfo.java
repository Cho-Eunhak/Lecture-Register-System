package presentation;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

// presentation 
public class PPersonalInfo {

	public PPersonalInfo() {
	}

	public void show(Scanner scanner) {
		System.out.println("�������� �Է� �ϼ���.");
		
		// new valueObject
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		
		
		boolean rightID=false;
		while(!rightID) {
		System.out.print("���̵� �Է� �ϼ���: ");
		vPersonalInfo.id = scanner.next();
		File f = new File("logindata/"+vPersonalInfo.id+"login.txt");//���̵��ߺ��˻�
		if(f.exists()) 
		{System.out.println("�ߺ��� ���̵��Դϴ�");rightID=false;}
		else if(vPersonalInfo.id.length()<4 || vPersonalInfo.id.length()>12) {
		System.out.println("���̵��� ������ �߸��Ǿ����ϴ�., 4�ڸ� �̻�, 12�ڸ� ���Ϸ� ������ֽʽÿ�.");
		}
		else
		{rightID=true;}
		}
		
		boolean rightPW=false;
		while(!rightPW) {
			System.out.print("�н����带 �Է� �ϼ���: ");
			vPersonalInfo.password = scanner.next();
			if(vPersonalInfo.password.length()<4 || vPersonalInfo.password.length()>12) {
			System.out.println("��й�ȣ�� ������ �߸��Ǿ����ϴ�., 4�ڸ� �̻�, 12�ڸ� ���Ϸ� ������ֽʽÿ�.");}
			else
			{rightPW=true;}}
		
		
		boolean rightname=false;
		boolean namecontain=true;
		while(!rightname) {
			System.out.print("�̸��� �Է� �ϼ���: ");
			vPersonalInfo.name = scanner.next();
			for(int i=0; i<vPersonalInfo.name.length();i++) {
				char char1=vPersonalInfo.name.charAt(i);
				if((char1>='0'&&char1<='9')) {
					namecontain=false;
					break;}
				else {
					namecontain=true;}}
			if (namecontain==false) {
				System.out.println("���ڰ� ���ԵǾ� �̸��� ������ �߸��Ǿ����ϴ�, 10�ڸ� ���Ϸθ� �����ϰ� ����, Ư�����ڴ� ���ѵ˴ϴ�.");}
			else if(vPersonalInfo.name.length()>10)
			{System.out.println("�̸��� 10�ڸ� ���Ϸθ� �����մϴ�, 10�ڸ� ���Ϸθ� �����ϰ� ����, Ư�����ڴ� ���ѵ˴ϴ�.");}
			else {rightname=true;}}

		// service
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		sPersonalInfo.write(vPersonalInfo);	
	}

}
