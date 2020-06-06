package aesproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	
	AESAlgorithm aesAlgo;
	
	private byte[] keyValue = new byte[] {'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

	private JPanel contentPane;

	/** This application is developed by Nilay Ingle
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		aesAlgo = new AESAlgorithm(keyValue);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Simple Text");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 13, 181, 22);
		contentPane.add(lblNewLabel);
		
		JTextArea jtaText = new JTextArea();
		jtaText.setBounds(12, 51, 363, 164);
		contentPane.add(jtaText);
		
		JLabel lblEncryptedText = new JLabel("Encrypted/Decrypted Text");
		lblEncryptedText.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEncryptedText.setBounds(400, 13, 263, 22);
		contentPane.add(lblEncryptedText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 215, 363, -162);
		contentPane.add(scrollPane);
		
		JTextArea jtaResult = new JTextArea();
		jtaResult.setBounds(400, 51, 363, 164);
		contentPane.add(jtaResult);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String plainText = jtaText.getText();
					String encryptedText = aesAlgo.encrypt(plainText);
					jtaResult.setText(encryptedText);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEncrypt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEncrypt.setBounds(278, 228, 97, 25);
		contentPane.add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String encryptedText = jtaResult.getText();
					String plainText = aesAlgo.decrypt(encryptedText);
					jtaResult.setText(plainText);
				}catch(Exception e) {
					
				}
			}
		});
		btnDecrypt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDecrypt.setBounds(666, 228, 97, 25);
		contentPane.add(btnDecrypt);
	}
}
