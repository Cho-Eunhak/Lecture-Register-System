package presentation;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

// presentation 
public class PPersonalInfo {

	public PPersonalInfo() {
	}

	public void show(Scanner scanner) {
		System.out.println("개인정보 입력 하세요.");
		
		// new valueObject
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		
		
		boolean rightID=false;
		while(!rightID) {
		System.out.print("아이디를 입력 하세요: ");
		vPersonalInfo.id = scanner.next();
		File f = new File("logindata/"+vPersonalInfo.id+"login.txt");//아이디중복검사
		if(f.exists()) 
		{System.out.println("중복된 아이디입니다");rightID=false;}
		else if(vPersonalInfo.id.length()<4 || vPersonalInfo.id.length()>12) {
		System.out.println("아이디의 형식이 잘못되었습니다., 4자리 이상, 12자리 이하로 만들어주십시오.");
		}
		else
		{rightID=true;}
		}
		
		boolean rightPW=false;
		while(!rightPW) {
			System.out.print("패스워드를 입력 하세요: ");
			vPersonalInfo.password = scanner.next();
			if(vPersonalInfo.password.length()<4 || vPersonalInfo.password.length()>12) {
			System.out.println("비밀번호의 형식이 잘못되었습니다., 4자리 이상, 12자리 이하로 만들어주십시오.");}
			else
			{rightPW=true;}}
		
		
		boolean rightname=false;
		boolean namecontain=true;
		while(!rightname) {
			System.out.print("이름을 입력 하세요: ");
			vPersonalInfo.name = scanner.next();
			for(int i=0; i<vPersonalInfo.name.length();i++) {
				char char1=vPersonalInfo.name.charAt(i);
				if((char1>='0'&&char1<='9')) {
					namecontain=false;
					break;}
				else {
					namecontain=true;}}
			if (namecontain==false) {
				System.out.println("숫자가 포함되어 이름의 형식이 잘못되었습니다, 10자리 이하로만 가능하고 숫자, 특수문자는 제한됩니다.");}
			else if(vPersonalInfo.name.length()>10)
			{System.out.println("이름은 10자리 이하로만 가능합니다, 10자리 이하로만 가능하고 숫자, 특수문자는 제한됩니다.");}
			else {rightname=true;}}

		// service
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		sPersonalInfo.write(vPersonalInfo);	
	}

}
