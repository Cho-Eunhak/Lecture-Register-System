package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WMain() {
		
		Font f1;
		f1 =new Font("돋움", Font.PLAIN, 25);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("수강신청 화면입니다. 다음 메뉴를 선택 하세요");//글자 입력시키기
		frame.pack();
		label.setFont(f1);
		panel.add(label, BorderLayout.CENTER);//가운데에 고정
		frame.add(panel);//panel을 frame에 넣는다.
		frame.setTitle("수강신청시스템");
		frame.setVisible(true);//보이게하기
		frame.setPreferredSize(new Dimension(600,400));//크기
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램 끄면 꺼지게하기
		frame.setLocationRelativeTo(null);//가운데에 출력하기
		frame.setResizable(false);//크기 고정시키기
		JLabel label2 = new JLabel("1:로그인, 2:회원가입, 3:ID/PW찾기, 4:취소");
		panel.add(label2, BorderLayout.CENTER);
	}

	
	
}
