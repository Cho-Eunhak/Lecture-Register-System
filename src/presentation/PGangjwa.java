package presentation;

import java.util.Scanner;
import java.util.Vector;

import model.MMiridamgi;
import service.SHakgwa;
import service.SLogin;
import service.SMiridamgi;
import valueObject.VGangjwa;
import valueObject.VHakgwa;
import valueObject.VPersonalInfo;

public class PGangjwa {
	public PGangjwa() {
	}

	public VGangjwa show( Scanner scanner, String fileName) {
		System.out.println("������ �̸���� �ϼ���");
		SHakgwa sCampus = new SHakgwa();
		Vector<VGangjwa> vLecture = sCampus.getGangjwaData(fileName);
		PSugangsincheong pSugangsincheong = new PSugangsincheong();
		if (vLecture != null) {
			for (VGangjwa vDatum: vLecture) {
				System.out.println("���¹�ȣ: "+vDatum.getId());
				System.out.println("���¸�: "+vDatum.getGangjwaName());
				System.out.println("������: "+vDatum.getGyosuName());
				System.out.println("����: "+vDatum.getHakjum());
				System.out.println("�ð�: "+vDatum.getTime());
				System.out.print("\r\n");
			}
			System.out.print("���¹�ȣ�� �Է��ϼ���: ");
			int selection = scanner.nextInt();
			//////////////////////////////////////
			// 2020-05-27
			
			for(VGangjwa vDatum: vLecture) {
				if(vDatum.getId()==selection) {
					return vDatum;
				}
				
			
			}
		}
		return null;
	}

}
