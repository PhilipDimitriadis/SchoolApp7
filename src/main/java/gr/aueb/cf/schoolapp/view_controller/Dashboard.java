package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;

	public Dashboard() {
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//				String sql = "jdbc:mysql://localhost:3306/school7dbpro?serverTimezone=UTC";
//				String username = "user7pro";
//				String password = "12345";
//
//				try {
//					// Class.forName("com.mysql.cj.jdbc.Driver");
//					connection = DriverManager.getConnection(sql, username, password);
//					System.out.println("Connection Success");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
////				catch (ClassNotFoundException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			};
//		});
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/eduv2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 697, 56);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(Dashboard.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(10, 0, 151, 56);
		header.add(govImage);
		
		JLabel lbfFirstLastName = new JLabel("ΔΗΜΗΤΡΙΑΔΗΣ ΦΙΛΙΠΠΟΣ");
		lbfFirstLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbfFirstLastName.setForeground(new Color(255, 255, 255));
		lbfFirstLastName.setBounds(501, 11, 186, 34);
		header.add(lbfFirstLastName);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBackground(UIManager.getColor("Button.background"));
		footer.setBounds(0, 335, 697, 58);
		contentPane.add(footer);
		
		JLabel lblManual = new JLabel("Εγχειρίδιο Χρήσης");
		lblManual.setForeground(Color.BLUE);
		lblManual.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblManual.setBounds(77, 11, 129, 36);
		footer.add(lblManual);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setForeground(Color.BLUE);
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuestions.setBounds(283, 11, 129, 36);
		footer.add(lblQuestions);
		
		JLabel lblSupport = new JLabel("Υποστήριξη Πολιτών");
		lblSupport.setForeground(Color.BLUE);
		lblSupport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSupport.setBounds(489, 11, 129, 36);
		footer.add(lblSupport);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setBounds(0, 0, 697, 3);
		footer.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 52, 117));
		panel.setBounds(0, 56, 149, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_teachers = new JLabel("Εκπαιδευτές");
		lbl_teachers.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_teachers.setForeground(new Color(255, 255, 255));
		lbl_teachers.setBounds(10, 45, 76, 23);
		panel.add(lbl_teachers);
		
		JLabel lbl_home = new JLabel("Αρχική");
		lbl_home.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_home.setBounds(10, 11, 56, 23);
		lbl_home.setForeground(new Color(255, 255, 0));
		panel.add(lbl_home);
		
		JLabel lbl_teachersView = new JLabel("Προβολή Εκπαιδευτών");
		lbl_teachersView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teachersView.setText("<html><font color='grey'>Προβολή Εκπαιδευτών</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teachersView.setText("Προβολή Εκπαιδευτών");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});
		lbl_teachersView.setForeground(Color.WHITE);
		lbl_teachersView.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_teachersView.setBounds(20, 79, 123, 23);
		panel.add(lbl_teachersView);
		
		JLabel lbl_teachersInsert = new JLabel("Εισαγωγή Εκπαιδευτή");
		lbl_teachersInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teachersInsert.setText("<html><font color='grey'>Εισαγωγή Εκπαιδευτή</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teachersInsert.setText("Εισαγωγή Εκπαιδευτή");
			}
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});
		lbl_teachersInsert.setForeground(Color.WHITE);
		lbl_teachersInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_teachersInsert.setBounds(20, 113, 123, 23);
		panel.add(lbl_teachersInsert);
		
		JLabel lblQuality = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblQuality.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuality.setForeground(new Color(0, 0, 0));
		lblQuality.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuality.setBounds(237, 67, 352, 43);
		contentPane.add(lblQuality);
		
		JLabel lblShowTeachers = new JLabel("Προβολή Μητρώων Εκπαιδευτών");
		lblShowTeachers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblShowTeachers.setBounds(185, 121, 221, 20);
		contentPane.add(lblShowTeachers);
		
		JLabel lblNewLabel = new JLabel("Προβολή Μητρώου Εκπαιδευτών στο Μητρώο του Coding Factory");
		lblNewLabel.setBounds(185, 143, 438, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnContinue = new JButton("Συνέχεια");
		btnContinue.setForeground(new Color(255, 255, 255));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getViewTeachersPage().setVisible(true);
			}
		});
		btnContinue.setBackground(new Color(0, 128, 0));
		btnContinue.setBounds(185, 174, 122, 35);
		contentPane.add(btnContinue);
		
		JLabel lblInsertTeachers = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο Εκπαιδευτών");
		lblInsertTeachers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsertTeachers.setBounds(185, 220, 289, 20);
		contentPane.add(lblInsertTeachers);
		
		JLabel lblNewLabel_1 = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο του Coding Factory");
		lblNewLabel_1.setBounds(185, 242, 438, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnContinue_1 = new JButton("Συνέχεια");
		btnContinue_1.setForeground(new Color(255, 255, 255));
		btnContinue_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});
		btnContinue_1.setBackground(new Color(0, 128, 0));
		btnContinue_1.setBounds(185, 273, 122, 35);
		contentPane.add(btnContinue_1);
	}
	
//	public static Connection getConnection() {
//		return connection;
//	}
}
