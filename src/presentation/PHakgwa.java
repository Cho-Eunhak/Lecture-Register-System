package presentation;

import java.util.Scanner;
import java.util.Vector;

import service.SHakgwa;
import valueObject.VHakgwa;

public class PHakgwa {

	public PHakgwa() {
	}
	public String show(Scanner scanner, String fileName) {
		SHakgwa sCampus = new SHakgwa();
		Vector<VHakgwa> vData = sCampus.getData(fileName);
		if (vData != null) {
			for (VHakgwa vDatum: vData) {
				System.out.println(vDatum.getId() + " " + vDatum.getText());
			}
			System.out.print("앞에 번호를 입력하세요: ");
			int selection = scanner.nextInt();
			//////////////////////////////////////
			// 2020-05-27
			for(VHakgwa vDatum: vData) {
				if(vDatum.getId()==selection) {
					return vDatum.getFileName();
				}
			}
		}
		return null;
	}

}
