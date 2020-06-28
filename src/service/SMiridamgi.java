package service;

import java.util.Vector;

import model.MMiridamgi;
import model.MPersonalInfo;
import valueObject.VGangjwa;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class SMiridamgi {
	public void write(VPersonalInfo vPersonalInfo, VGangjwa Lecture) {
		MMiridamgi mMiridamgi = new MMiridamgi();
		mMiridamgi.write(vPersonalInfo, Lecture);
	}


}
