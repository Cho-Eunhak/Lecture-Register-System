package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VHakgwa;

public class MGangjwa {

	
	public Vector<VGangjwa> getData(String fileName) {
		
		Vector<VGangjwa> vGangjwas = null;
		try {
			File file = new File("data/" + fileName);
			Scanner scanner = new Scanner(file);
			
			vGangjwas = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vData = new VGangjwa();
				vData.setId(scanner.nextInt());
				vData.setGangjwaName(scanner.next());
				vData.setGyosuName(scanner.next());
				vData.setHakjum(scanner.nextInt());
				vData.setTime(scanner.next());
				// read
				vGangjwas.add(vData);
			}			
			scanner.close();		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vGangjwas;
	}
}
