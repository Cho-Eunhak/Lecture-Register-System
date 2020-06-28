package service;
import java.util.Scanner;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SPersonalInfo {

	public SPersonalInfo() {
		// TODO Auto-generated constructor stub
	}

	public void write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		mPersonalInfo.write(vPersonalInfo);
	}
	
	public VPersonalInfo findIDPW(Scanner scanner, String id) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		VPersonalInfo vPersonalInfo = mPersonalInfo.nameread(id);
		
		if (vPersonalInfo == null) {
			return null;
		} else {
			if (id.equals(vPersonalInfo.id)) {
				return vPersonalInfo;
			} else {
				return null;
			}
		}
	}

}
