package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class MMypage {

	public Vector<VGangjwa> getmiridamgidata(String fileName) {
		
		Vector<VGangjwa> vGangjwas = null;
		try {
			File file = new File("miridamgidata/"+fileName+"miridamgi.txt");
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
	
	public Vector<VGangjwa> getsincheongdata(String fileName) {
		
		Vector<VGangjwa> vGangjwas = null;
		try {
			File file = new File("sincheongdata/"+fileName+"sugangsincheong.txt");
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

