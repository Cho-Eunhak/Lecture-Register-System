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
		f1 =new Font("����", Font.PLAIN, 25);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("������û ȭ���Դϴ�. ���� �޴��� ���� �ϼ���");//���� �Է½�Ű��
		frame.pack();
		label.setFont(f1);
		panel.add(label, BorderLayout.CENTER);//����� ����
		frame.add(panel);//panel�� frame�� �ִ´�.
		frame.setTitle("������û�ý���");
		frame.setVisible(true);//���̰��ϱ�
		frame.setPreferredSize(new Dimension(600,400));//ũ��
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷� ���� �������ϱ�
		frame.setLocationRelativeTo(null);//����� ����ϱ�
		frame.setResizable(false);//ũ�� ������Ű��
		JLabel label2 = new JLabel("1:�α���, 2:ȸ������, 3:ID/PWã��, 4:���");
		panel.add(label2, BorderLayout.CENTER);
	}

	
	
}
