package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScoreSelect extends JInternalFrame {
	private JLabel label;
	private JButton btnNewButton;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSelect frame = new ScoreSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScoreSelect() {
		super("���� ��ȸ", false, true, true, true);
		setVisible(true);
		
		setTitle("\uC131\uC801 \uC815\uBCF4 \uC870\uD68C");
		setBounds(358, 311, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getTextField());
		getContentPane().add(getScrollPane());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC131\uC801 \uC870\uD68C");
			label.setOpaque(true);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBackground(new Color(152, 251, 152));
			label.setBounds(12, 10, 410, 29);
		}
		return label;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC870\uD68C");
			btnNewButton.setBounds(325, 49, 97, 23);
		}
		return btnNewButton;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(197, 50, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 81, 410, 174);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
