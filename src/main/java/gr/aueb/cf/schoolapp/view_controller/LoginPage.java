package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public LoginPage() {
		setTitle("Σύνδεση");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/eduv2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnect = new JLabel("Σύνδεση");
		lblConnect.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConnect.setBounds(170, 11, 148, 35);
		contentPane.add(lblConnect);
		
		JLabel lblTextPrompt = new JLabel("Παρακαλώ εισάγετε τους κωδικούς για να συνδεθείτε");
		lblTextPrompt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTextPrompt.setBounds(92, 45, 304, 35);
		contentPane.add(lblTextPrompt);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 469, 2);
		contentPane.add(separator);
		
		JLabel lblUser = new JLabel("Χρήστης:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUser.setBounds(148, 91, 148, 25);
		contentPane.add(lblUser);
		
		username = new JTextField();
		username.setBounds(148, 113, 192, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Κωδικός:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(148, 149, 149, 25);
		contentPane.add(lblPassword);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username.getText().matches("[aA]dmin") && (Arrays.equals(password.getPassword(), "12345".toCharArray()))) {
					Main.getLoginPage().setVisible(false);
					Main.getDashboard().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Λάθος username ή password", "Αδυναμία Σύνδεσης", JOptionPane.ERROR_MESSAGE);
					username.setText("");
					password.setText("");
				}
			}
		});
		btnConnect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		btnConnect.setBackground(new Color(0, 128, 0));
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConnect.setBounds(148, 212, 192, 38);
		contentPane.add(btnConnect);
		
		password = new JPasswordField();
		password.setBounds(148, 172, 192, 25);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/images/gov_logo_small.png")));
		lblNewLabel.setBackground(new Color(0, 52, 117));
		lblNewLabel.setBounds(0, -1, 100, 47);
		contentPane.add(lblNewLabel);
	}
}
