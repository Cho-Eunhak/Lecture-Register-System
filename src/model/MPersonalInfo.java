package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import valueObject.VPersonalInfo;

public class MPersonalInfo {

	public MPersonalInfo() {
	}

	public VPersonalInfo read(String id) {
		try {
			
			File file = new File("logindata/"+id+"login.txt");
			Scanner scanner = new Scanner(file);
			
			boolean found = false;
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			while(scanner.hasNext() && !found) {
				vPersonalInfo.id = scanner.next();
				vPersonalInfo.password = scanner.next();
				vPersonalInfo.name = scanner.next();
				if (vPersonalInfo.id.contentEquals(id)) {
					found = true;
				}
			}			
			scanner.close();
			
			if (found) {
				return vPersonalInfo;
			} else {
				return null;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public VPersonalInfo nameread(String id) {
		try {
			
			File file = new File("logindata/"+id+"login.txt");
			Scanner scanner = new Scanner(file);
			
			boolean found = false;
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			while(scanner.hasNext() && !found) {
				vPersonalInfo.id = scanner.next();
				vPersonalInfo.password = scanner.next();
				vPersonalInfo.name = scanner.next();
				if (vPersonalInfo.id.contentEquals(id)) {
					found = true;
				}
			}			
			scanner.close();
			
			if (found) {
				return vPersonalInfo;
			} else {
				return null;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	
	
	public void write(VPersonalInfo vPersonalInfo) {
		try {
			File file = new File("logindata/"+vPersonalInfo.id+"login.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);
			printWriter.println(vPersonalInfo.name);
			
			File file2 = new File("miridamgidata/"+vPersonalInfo.id+"miridamgi.txt");
			File file3 = new File("sincheongdata/"+vPersonalInfo.id+"sugangsincheong.txt");
			File file4 = new File("imsidata/"+vPersonalInfo.id+"imsi.txt");
			

			FileWriter fileWriter2 = new FileWriter(file2, true);
			FileWriter fileWriter3 = new FileWriter(file3, true);
			FileWriter fileWriter4 = new FileWriter(file4, true);

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
