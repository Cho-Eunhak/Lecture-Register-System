package service;

import model.MMiridamgi;
import model.MSincheong;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class SSincheong {

	public void write(VPersonalInfo vPersonalInfo, VGangjwa Lecture) {
		MSincheong mSincheong = new MSincheong();
		mSincheong.write(vPersonalInfo, Lecture);
	}
}
