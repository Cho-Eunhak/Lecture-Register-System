package main;
import presentation.PMain;
import presentation.WMain;

public class Main {
	
	public static void main(String[] args) {
		WMain wMain = new WMain();
		// 메인 화면
		PMain pMain = new PMain();
		pMain.show();
	}
}
