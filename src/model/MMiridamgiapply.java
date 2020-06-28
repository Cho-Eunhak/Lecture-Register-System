package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


import service.SMypage;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class MMiridamgiapply {
	
	public void cancel(VPersonalInfo vPersonalInfo, String k) {
		
		try {
			Vector<VGangjwa> vGangjwas = null;
			vGangjwas = new Vector<VGangjwa>();
			
			FileReader file = new FileReader("miridamgidata/"+vPersonalInfo.id+"miridamgi.txt");
			FileWriter file2 = new FileWriter("imsidata/"+vPersonalInfo.id+"imsi.txt", false);
			FileWriter file3 = new FileWriter("sincheongdata/"+vPersonalInfo.id+"sugangsincheong.txt", true);
			  int data =0;
			 while(true)//���� �״�� �ӽ����Ͽ� �����ϱ�
			   {
			    data = file.read();
			    if( data == -1) break;
			    file2.write((char)data); 
			   }
			 file.close();
			 file2.close();
			 
			File a = new File("miridamgidata/"+vPersonalInfo.id+"miridamgi.txt");
			File b = new File("imsidata/"+vPersonalInfo.id+"imsi.txt");
			
			FileWriter fileWriter = new FileWriter(a);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			Vector<String> Lecture = new Vector<String>();
			
			Scanner scanner = new Scanner(b);
			while(scanner.hasNextLine()) {
				Lecture.add(scanner.nextLine());
			}
			  for(String s : Lecture) {
					  if(!s.equals(k)) {
							fileWriter.write(s+"\r\n");}
			  }
			  
			  file3.write(k+"\r\n");//������û���Ͽ� �߰��ϱ�
			
			fileWriter.close();
			scanner.close();
			printWriter.close();
			file3.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}


