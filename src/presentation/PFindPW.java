package presentation;

import java.util.Scanner;

import model.MPersonalInfo;
import service.SPersonalInfo;
import valueObject.VPersonalInfo;

public class PFindPW {

	public VPersonalInfo findIDPW(Scanner scanner, String id) {
		
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		VPersonalInfo vPersonalInfo = sPersonalInfo.findIDPW(scanner, id);
		
		return vPersonalInfo;
		
	}
}
