package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class Mchangepersonalinfo {
	public Mchangepersonalinfo() {
	}

	
	public void changepw(String id, String oldpw, String newpw) {
		
		try {
			
			 FileReader file = new FileReader("logindata/"+id+"login.txt");
			  FileWriter file2 = new FileWriter("imsidata/"+id+"imsi.txt", false);
			  int data =0;
			 while(true)//���� �״�� �ӽ����Ͽ� �����ϱ�
			   {
			    data = file.read();
			    if( data == -1) break;
			    file2.write((char)data); 
			   }
			 file.close();
			 file2.close();
			 
			File a = new File("logindata/"+id+"login.txt");
			File b = new File("imsidata/"+id+"imsi.txt");
			
			FileWriter fileWriter = new FileWriter(a);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			Vector<String> Lecture = new Vector<String>();
			
			Scanner scanner = new Scanner(b);//�ӽ����Ͽ� �ִ� ���� ���Ϳ��ٰ� �����س���
			while(scanner.hasNextLine()) {
				Lecture.add(scanner.nextLine());
			}
			Lecture.set(1, newpw);
			for(String s : Lecture) {
				fileWriter.write(s+"\r\n");
		  }
			fileWriter.close();
			scanner.close();
			printWriter.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
