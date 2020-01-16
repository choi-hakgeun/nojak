package m_jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MemberMain extends JFrame {
	List<MemberVo> list = new ArrayList<MemberVo>();

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnSql;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 680);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnSql());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD559\uC0DD\uAD00\uB9AC");
			mnNewMenu.add(getMenuItem());
			mnNewMenu.add(getMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("\uD559\uC0DD\uC815\uBCF4\uC785\uB825");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberInsert panal = new MemberInsert();
					contentPane.add(panal);
					panal.toFront();
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMenuItem_1() {
		if (menuItem_1 == null) {
			menuItem_1 = new JMenuItem("\uD559\uC0DD\uC815\uBCF4\uC218\uC815");
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberUpdate panal = new MemberUpdate();
					contentPane.add(panal);
					panal.toFront();
				}
			});
		}
		return menuItem_1;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uD559\uC0DD\uC815\uBCF4\uC0AD\uC81C");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDelete panal = new MemberDelete();
					contentPane.add(panal);
					panal.toFront();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uD559\uC0DD\uC815\uBCF4\uC870\uD68C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberSelect panal = new MemberSelect();
					contentPane.add(panal);
					panal.toFront();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenu getMnSql() {
		if (mnSql == null) {
			mnSql = new JMenu("Query");
			mnSql.add(getMntmNewMenuItem_2());
		}
		return mnSql;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("sql");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Query panal = new Query();
					contentPane.add(panal);
					panal.toFront();
				}
			});
		}
		return mntmNewMenuItem_2;
	}
}
