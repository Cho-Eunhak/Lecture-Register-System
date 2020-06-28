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
		System.out.println("과목을 미리담기 하세요");
		SHakgwa sCampus = new SHakgwa();
		Vector<VGangjwa> vLecture = sCampus.getGangjwaData(fileName);
		PSugangsincheong pSugangsincheong = new PSugangsincheong();
		if (vLecture != null) {
			for (VGangjwa vDatum: vLecture) {
				System.out.println("강좌번호: "+vDatum.getId());
				System.out.println("강좌명: "+vDatum.getGangjwaName());
				System.out.println("교수명: "+vDatum.getGyosuName());
				System.out.println("학점: "+vDatum.getHakjum());
				System.out.println("시간: "+vDatum.getTime());
				System.out.print("\r\n");
			}
			System.out.print("강좌번호를 입력하세요: ");
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
