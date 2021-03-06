package l_ftp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class FileTransfer extends JPanel implements Runnable {
	int port;
	String ip;
	long fileSize;
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public FileTransfer() {
		setPreferredSize(new Dimension(450, 64));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());

	}
	public FileTransfer(String file) {
		this();
		getFileName().setText(file);
		File f = new File(file);
		fileSize = f.length();
		getStatus().setText("0/"+fileSize);
		
	}
	@Override
	public void run() {
		//지정된 파일을 FileInputStream으로 읽어서
		//Socket의 DataOutputStream 으로 전송
		byte[] readData = new byte[4096]; //한번에 4키로바이트만 읽어서 전송
		int readSize = 0;
		long readTotSize = 0;
		getProgressBar().setValue(0);
		
		try {
		Socket socket = new Socket(ip, port);
		OutputStream os = socket.getOutputStream();
			
		FileInputStream fis = new FileInputStream(getFileName().getText());
		
		
		while((readSize = fis.read(readData)) != -1) {
			readTotSize += readSize;
			getStatus().setText(readTotSize + "/"+fileSize);
			getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
			os.write(readData, 0, readSize);
			
		}
		os.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public JLabel getFileName() {
		if (fileName == null) {
			fileName = new JLabel("\uD30C\uC77C\uBA85");
			fileName.setBounds(12, 6, 426, 15);
		}
		return fileName;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(12, 24, 369, 14);
		}
		return progressBar;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC9C4\uD589\uC0C1\uD0DC");
			status.setHorizontalAlignment(SwingConstants.RIGHT);
			status.setBounds(12, 41, 426, 15);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCDE8\uC18C");
			btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
			btnNewButton.setMargin(new Insets(0, 0, 0, 0));
			btnNewButton.setBounds(390, 23, 48, 15);
		}
		return btnNewButton;
	}
}
