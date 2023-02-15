import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Register extends JFrame {

	private JPanel contentPane;

	Connection conn = null;
	Image img1 = new ImageIcon(this.getClass().getResource("img/1.png")).getImage();
	Image img2 = new ImageIcon(this.getClass().getResource("img/2.png")).getImage();
	Image img3 = new ImageIcon(this.getClass().getResource("img/3.png")).getImage();
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtuname;
	private JTextField txtpword;
	private JTextField txtSqans;
	private JTextField txtAdminPass;
	private JComboBox comboBox;
	
	
	public Register() {
		//addPlaceholderStyle(txtSqans);
		//addPlaceholderStyle(txtAdminPass);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 245, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Employee");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(200, 32, 242, 42);
		contentPane.add(lblNewLabel);
		
        JLabel regIcon = new JLabel();
        regIcon.setIcon(new ImageIcon("1.png"));
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(129, 89, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtfname.setBounds(205, 86, 282, 20);
		contentPane.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(129, 123, 66, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username:");
		lblNewLabel_1_1_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(129, 159, 66, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(129, 192, 66, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtlname.setColumns(10);
		txtlname.setBounds(205, 120, 282, 20);
		contentPane.add(txtlname);
		
		txtuname = new JTextField();
		txtuname.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtuname.setColumns(10);
		txtuname.setBounds(205, 156, 282, 20);
		contentPane.add(txtuname);
		
		txtpword = new JTextField();
		txtpword.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtpword.setColumns(10);
		txtpword.setBounds(205, 192, 282, 20);
		contentPane.add(txtpword);
		
		
		String[] colum = {"Select Security Question","In what city were you born?","What is the name of your favorite pet?","What was your favorite food as a child?","What high school did you attend?"};
		comboBox = new JComboBox(colum);
		comboBox.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		comboBox.setBounds(129, 234, 358, 22);
		contentPane.add(comboBox); 
		
		txtSqans = new JTextField();
		txtSqans.setForeground(new Color(159, 159, 159));
		txtSqans.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtSqans.setText("Provide Answer");
		txtSqans.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				if(txtSqans.getText().equals("Provide Answer")) {
					txtSqans.setText("");
					txtSqans.setForeground(new Color(0, 0, 0));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtSqans.getText().equals("")) {
					txtSqans.setText("Provide Answer");
					txtSqans.setForeground(new Color(159, 159, 159));
				}			
			}
			
		});
		txtSqans.setToolTipText("");
		txtSqans.setBounds(129, 272, 358, 20);
		contentPane.add(txtSqans);
		txtSqans.setColumns(10);
		
		txtAdminPass = new JTextField();
		txtAdminPass.setForeground(new Color(159, 159, 159));
		txtAdminPass.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		txtAdminPass.setText("Enter Admin Password");
		txtAdminPass.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAdminPass.getText().equals("Enter Admin Password")) {
					txtAdminPass.setText("");
					txtAdminPass.setForeground(new Color(0, 0, 0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAdminPass.getText().equals("")) {
					txtAdminPass.setText("Enter Admin Password");
					txtAdminPass.setForeground(new Color(159, 159, 159));
			}
			
		}
		});
		txtAdminPass.setColumns(10);
		txtAdminPass.setBounds(129, 308, 358, 20);
		contentPane.add(txtAdminPass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorder(null);
		btnRegister.setBackground(new Color(225, 167, 48));
		btnRegister.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					conn = sqliteConnection.dbConnector();
					String fname = txtfname.getText();
					String lname = txtlname.getText();
					String uname = txtuname.getText();
					String pword = txtpword.getText();
					String sqans = txtSqans.getText();
					String adpass = txtAdminPass.getText();
					String sq = comboBox.getSelectedItem().toString();
					String adminpass = "";
					
					if(fname.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A field is empty. Please fill up all of the fields.");
					}else if(lname.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A field is empty. Please fill up all of the fields.");
					}else if(uname.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A field is empty. Please fill up all of the fields.");
					}else if(pword.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A field is empty. Please fill up all of the fields.");
					}else if(sq.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A field is empty. Please fill up all of the fields.");
					}else {
					
					Statement stm = conn.createStatement();
					String sql1 = "SELECT pword FROM Employee where employee_id = 1";
					ResultSet rs = stm.executeQuery(sql1);
					while(rs.next()) {
						adminpass = rs.getString("pword");
					}
					rs.close();
					stm.close();
					conn.close();
					
					if (adminpass.equals(adpass)) {
						conn = sqliteConnection.dbConnector();
						String sql = "INSERT INTO Employee(fname,lname,uname,pword,sQuestion,sq_ans) VALUES(?,?,?,?,?,?)";
						PreparedStatement pst = conn.prepareStatement(sql);
						pst.setString(1, fname);
						pst.setString(2, lname);
						pst.setString(3, uname);
						pst.setString(4, pword);
						pst.setString(5, sq);
						pst.setString(6, sqans);
						pst.execute();
						JOptionPane.showMessageDialog(null, "You have successfully registered.");
						
						pst.close();
						conn.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong admin password. Please try again.");
					}
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
					System.out.println(e);
				}
			}
		});
		btnRegister.setBounds(228, 339, 152, 30);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_2 = new JLabel("Go back to Login");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login lpage = new Login();
				lpage.show();
			}
		});
		lblNewLabel_2.setBounds(260, 387, 120, 14);
		contentPane.add(lblNewLabel_2);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
