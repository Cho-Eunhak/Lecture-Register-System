package presentation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import model.MMiridamgiapply;
import model.MMypage;
import model.Mchangepersonalinfo;
import model.Mmiradmgicancel;
import model.Msincheongcancel;
import service.SHakgwa;
import service.SMypage;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class PMypage {

	public VGangjwa show(Scanner scanner, VPersonalInfo vPersonalInfo) {
		boolean finished = false;	
		
		while (!finished) {
		System.out.println("1:미리담기한 과목 보기, 2:수강신청한 과목 보기, 3:비밀번호 변경 , 4: 마이페이지 종료");
		System.out.print("입력: ");
		SMypage sMypage = new SMypage();
		int selection = 0;
		selection=scanner.nextInt();
		if (selection == 1) {
			boolean finish = false;	
			System.out.println(vPersonalInfo.id+"님의 미리담기한 과목입니다.");
			int damgihakjum=0;
			Vector<VGangjwa> vLecture = sMypage.getmiridamgiData(vPersonalInfo.id);
			if (vLecture != null) {
				for (VGangjwa vDatum: vLecture) {
					System.out.println("강좌번호: "+vDatum.getId());
					System.out.println("강좌명: "+vDatum.getGangjwaName());
					System.out.println("교수명: "+vDatum.getGyosuName());
					System.out.println("학점: "+vDatum.getHakjum());
					System.out.println("시간: "+vDatum.getTime());
					System.out.print("\r\n");
					damgihakjum+=vDatum.getHakjum();
				}}
			System.out.println("현재까지 미리담기한 과목의 총 학점은 "+damgihakjum+"입니다");
			while (!finish) {
			System.out.println("1: 미리담기 취소하기, 2:미리담기한 과목 수강신청하기, 3: 미리담기한 과목보기 종료");
			System.out.print("입력: ");
			int sel=0;
			sel=scanner.nextInt();
			if(sel==1) {
				System.out.println("취소할 과목을 선택하세요");
				System.out.print("강좌번호를 입력하세요: ");
				int sel2=0;
				String name = null;
				sel2=scanner.nextInt();
				name=sMypage.damgicancel(sel2, vLecture, vPersonalInfo);
				System.out.println(name+" 강좌가 미리담기 취소되었습니다.");
				}
			else if(sel==2) {
				System.out.println("수강신청할 과목을 선택하세요");
				System.out.print("강좌번호를 입력하세요: ");
				int sel3=0;
				String name = null;
				sel3=scanner.nextInt();
				Vector<VGangjwa> abc = sMypage.getsincheongdata(vPersonalInfo.id);
				boolean a = false;
				for (VGangjwa vDatum: abc) {
					if(vDatum.getId()==sel3) {
						a=true;
						break;
					}
					else {
						a=false;}}
				if(a==true) 
					{System.out.println("수강신청에 중복된 강좌가 있습니다.");}
				else{
					name=sMypage.damgiapply(sel3, vLecture, vPersonalInfo);
					System.out.println(name+" 강좌가 "+vPersonalInfo.name+"님의 강좌에 수강신청 되었습니다.");}
			}
			else if(sel==3) {
				System.out.println("미리담기한 과목보기를 종료합니다.");
				finish=true;
			}
			
			}
			
			}
			
		
		else if (selection == 2) {
			boolean finish2 = false;	
			System.out.println(vPersonalInfo.id+"님의 수강신청한 과목입니다.");
			int sincheonghakjum=0;
			Vector<VGangjwa> vLecture1 = sMypage.getsincheongData(vPersonalInfo.id);
			if (vLecture1 != null) {
				for (VGangjwa vDatum: vLecture1) {
					System.out.println("강좌번호: "+vDatum.getId());
					System.out.println("강좌명: "+vDatum.getGangjwaName());
					System.out.println("교수명: "+vDatum.getGyosuName());
					System.out.println("학점: "+vDatum.getHakjum());
					System.out.println("시간: "+vDatum.getTime());
					System.out.print("\r\n");
					sincheonghakjum+=vDatum.getHakjum();
				}
		}
			System.out.println("현재까지 수강신청한 과목의 총 학점은 "+sincheonghakjum+"입니다");
			
			
			while (!finish2) {
				System.out.println("1: 수강신청 취소하기, 2: 수강신청한 과목보기 종료");
				System.out.print("입력: ");
				int sel=0;
				sel=scanner.nextInt();
				if(sel==1) {
					System.out.println("취소할 과목을 선택하세요");
					System.out.print("강좌번호를 입력하세요: ");
					int sel4=0;
					String name = null;
					sel4=scanner.nextInt();
					name=sMypage.sincheongcancel(sel4, vLecture1, vPersonalInfo);
					System.out.println(name+" 강좌가 수강신청 취소되었습니다.");
					}
				else if(sel==2) {
					System.out.println("수강신청한 과목보기를 종료합니다.");
					finish2=true;
				}
				
				}
			
		}
		else if(selection == 3){
			System.out.println("비밀번호를 변경합니다.");
			
			System.out.print("원래 비밀번호를 입력하세요: ");
			String oldpw = null;
			String newpw = null;
			oldpw=scanner.next();
			if(!oldpw.equals(vPersonalInfo.password)) {
				System.out.println("비밀번호가 일치하지 않습니다!");
			}
			else {
				boolean rightPW=false;
				while(!rightPW) {
					System.out.print("새로운 비밀번호를 입력하세요: ");
					newpw=scanner.next();
					if(newpw.length()<4 || newpw.length()>12) {
					System.out.println("비밀번호의 형식이 잘못되었습니다., 4자리 이상, 12자리 이하로 만들어주십시오.");}
					else
					{rightPW=true;}}
				sMypage.changepw(vPersonalInfo.id, oldpw, newpw);
				System.out.println("비밀번호가 변경되었습니다.");
				vPersonalInfo.password=newpw;
			}
			
		}
		
		else if(selection == 4){
			System.out.println("마이페이지를 종료합니다.");
			finished = true;
		}

			}
		
		return null;}
}
