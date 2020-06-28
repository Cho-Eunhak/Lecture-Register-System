package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class MSincheong {

	
	public void write(VPersonalInfo vPersonalInfo, VGangjwa vDatum) {
		try {
			
			File file = new File("sincheongdata/"+vPersonalInfo.id+"sugangsincheong.txt");
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
