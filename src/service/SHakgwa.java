package service;

import java.util.Vector;

import model.MGangjwa;
import model.MHakgwa;
import valueObject.VGangjwa;
import valueObject.VHakgwa;

public class SHakgwa {
	public SHakgwa() {
		
	}

	public Vector<VHakgwa> getData(String fileName) {
		MHakgwa mCampus = new MHakgwa();
		return mCampus.getData(fileName);
	}
	
	public Vector<VGangjwa> getGangjwaData(String fileName) {
		MGangjwa mCampus = new MGangjwa();
		return mCampus.getData(fileName);
	}

}
