package k_io;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class ServerFrame extends JFrame implements Runnable {
	
	ServerSocket server;
	
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	
	List<ServerThread> clients = new ArrayList<ServerThread>();
	DefaultListModel<String> model = new DefaultListModel<String>();
	

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		setTitle("\uCC44\uD305\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getComboBox());
		contentPane.add(getTextField_2());
		contentPane.add(getBtnNewButton_4());
	}
	
	@Override
	public void run() {
		try {
			int p = Integer.parseInt(port.getText());
			server = new ServerSocket(p);
			String html = "<font size = '3' color = #ff00ff'>서버가 시작됨</font>";
			kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);			
						
			
			while(true) {
				html = "[클라이언트 접속 대기중]";
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				
				Socket clientSocket = server.accept();
				ServerThread st = new ServerThread(ServerFrame.this, clientSocket);
				st.start();
				clients.add(st);
				
				
			    InetSocketAddress addr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
			    
			    html= "<div style = 'booder:5px solid #ff0000;padding:3px;width:150px'>" + addr.getAddress().getHostAddress() +"님이 접속함"+"</div>";
			    kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
			    
			    textPane.scrollRectToVisible(new Rectangle(0, textPane.getHeight()+100, 1, 1));
			}
			
		}catch(Exception ex) {
			
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("IP");
			lblNewLabel.setBounds(18, 10, 16, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(46, 7, 89, 21);
			textField.setColumns(10);
			
			try {
				InetAddress local = InetAddress.getLocalHost();
				textField.setText(local.getHostAddress());
				
			}catch(Exception ex) {
				
			}
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setBounds(157, 10, 33, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setBounds(202, 7, 57, 21);
			port.setColumns(10);
		}
		return port;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2DC\uC791");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Thread t = new Thread(ServerFrame.this);
					t.start();		
					
				}
			});
			btnNewButton.setBounds(271, 6, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC885\uB8CC");
			btnNewButton_1.setBounds(380, 6, 97, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(18, 38, 133, 217);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setModel(model);
		}
		return list;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790 \uBAA9\uB85D");
			lblNewLabel_2.setPreferredSize(new Dimension(64, 20));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(167, 35, 331, 247);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
		}
		return textPane;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC15\uD1F4");
			btnNewButton_2.setBounds(18, 265, 57, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uD574\uC81C");
			btnNewButton_3.setBounds(87, 265, 57, 23);
		}
		return btnNewButton_3;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(18, 298, 133, 21);
			comboBox.addItem("전  체");
			comboBox.addItem("귓속말");
		
			
		}
		return comboBox;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(166, 292, 260, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("\uC804\uC1A1");
			btnNewButton_4.setBounds(441, 292, 57, 23);
		}
		return btnNewButton_4;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC138\uC9C0");
			lblNewLabel_3.setPreferredSize(new Dimension(36, 20));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
}
