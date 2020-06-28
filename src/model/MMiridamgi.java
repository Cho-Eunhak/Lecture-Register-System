package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class MMiridamgi {
	public MMiridamgi() {
	}
	public VPersonalInfo read(String id) {
		
		return null;
	}
	
	public void write(VPersonalInfo vPersonalInfo, VGangjwa vDatum) {
		try {
			File file = new File("miridamgidata/"+vPersonalInfo.id+"miridamgi.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(vDatum.getId()+" "+vDatum.getGangjwaName()+" "+vDatum.getGyosuName()+" "+vDatum.getHakjum()+" "+vDatum.getTime());
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
