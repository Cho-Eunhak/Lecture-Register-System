package service;

import java.util.Vector;

import model.MGangjwa;
import model.MMiridamgiapply;
import model.MMypage;
import model.Mchangepersonalinfo;
import model.Mmiradmgicancel;
import model.Msincheongcancel;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class SMypage {

	
	public Vector<VGangjwa> getmiridamgiData(String fileName) {
		MMypage mMypage = new MMypage();
		return mMypage.getmiridamgidata(fileName);
	}
	
	public Vector<VGangjwa> getsincheongData(String fileName) {
		MMypage mMypage = new MMypage();
		return mMypage.getsincheongdata(fileName);
	}
	
	public String sincheongcancel(int sel4, Vector<VGangjwa> vLecture1, VPersonalInfo vPersonalInfo) {
		String name = null;
		for(VGangjwa vDatum: vLecture1) {
			if(vDatum.getId()==sel4) {
				Msincheongcancel msincheongcancel = new Msincheongcancel();
				String k=vDatum.getId()+" "+vDatum.getGangjwaName()+" "+vDatum.getGyosuName()+" "+vDatum.getHakjum()+" "+vDatum.getTime();
				msincheongcancel.cancel(vPersonalInfo, k);
				name=vDatum.getGangjwaName();
			}
			}
		return name;
	}
	
	public String damgiapply(int sel3, Vector<VGangjwa> vLecture, VPersonalInfo vPersonalInfo) {
		String name = null;
		for(VGangjwa vDatum: vLecture) {
			if(vDatum.getId()==sel3) {
			MMiridamgiapply mMiridamgiapply = new MMiridamgiapply();
			String k=vDatum.getId()+" "+vDatum.getGangjwaName()+" "+vDatum.getGyosuName()+" "+vDatum.getHakjum()+" "+vDatum.getTime();
			mMiridamgiapply.cancel(vPersonalInfo, k);
			name=vDatum.getGangjwaName();
		}
		}
		return name;
	}
	
	public String damgicancel(int sel2, Vector<VGangjwa> vLecture, VPersonalInfo vPersonalInfo) {
		String name = null;
		for(VGangjwa vDatum: vLecture) {
			if(vDatum.getId()==sel2) {
				Mmiradmgicancel mapplycancel = new Mmiradmgicancel();
				String k=vDatum.getId()+" "+vDatum.getGangjwaName()+" "+vDatum.getGyosuName()+" "+vDatum.getHakjum()+" "+vDatum.getTime();
				mapplycancel.cancel(vPersonalInfo, k);
				name=vDatum.getGangjwaName();}}
		return name;
	}
	
	public void changepw(String id, String oldpw, String newpw) {
		Mchangepersonalinfo mchangepersonalinfo = new Mchangepersonalinfo();
		mchangepersonalinfo.changepw(id, oldpw, newpw);
	}
	
	public Vector<VGangjwa> getmiridamgidata(String id) {
		MMypage mMyPage = new MMypage();
		Vector<VGangjwa> abc=mMyPage.getmiridamgidata(id);
		return abc;
	}
	
	public Vector<VGangjwa> getsincheongdata(String id) {
		MMypage mMyPage = new MMypage();
		Vector<VGangjwa> abc=mMyPage.getsincheongdata(id);
		return abc;
	}
	

}
