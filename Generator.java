import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

class Generator
{
	private JFrame rbx;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton homeBtn;
	private JButton connectBtn;
	private JButton indexBtn;
	private JButton cssBtn;
	private JButton jsBtn;

	// Left Label
	private JLabel rbxLogo;
	
	// Right Label
	private JLabel homeLabel;
	private JLabel connectLabel;
	private JLabel indexLabel;
	private JLabel cssLabel;
	private JLabel jsLabel;

	// Right panel content
	private CardLayout card;
	private JPanel homePanel;
	private JPanel connectPanel;
	private JPanel indexPanel;
	private JPanel cssPanel;
	private JPanel jsPanel;

	// TextField
	private JTextField hostField;
	private JTextField usrField;
	private JTextField passField;
	private JTextField dbField;

	// Connect button
	private JButton createConnectBtn;
	// Index button
	private JButton createIndexBtn;
	// Css button
	private JButton createCssBtn;
	// Js button
	private JButton createJsBtn;

	// File writer
	public FileWriter file;


	public Generator()
	{
		// Application Settings
		rbx = new JFrame("RBX File Generator");
		mainPanel();
		rbx.add(mainPanel);
		rbx.pack();
		rbx.setVisible(true);
		rbx.setSize(600, 500);
		rbx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rbx.setResizable(false);
		rbx.setLocationRelativeTo(null);
	}
	
	public void mainPanel()
	{
		// Main panel - Container
		mainPanel = new JPanel(new BorderLayout());
		leftPanel();
		rightPanel();
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
	}

	public void leftPanel()
	{
		// Left panel
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(153, 500));
		leftPanel.setBackground(Color.decode("#ECDFEE"));
		label();
		button();
		eventListener();
		leftPanel.add(homeBtn);
		leftPanel.add(connectBtn);
		leftPanel.add(indexBtn);
		leftPanel.add(cssBtn);
		leftPanel.add(jsBtn);
	}

	public void rightPanel()
	{
		// Right panel
		rightPanel = new JPanel();
		card = new CardLayout();
		rightPanel.setLayout(card);
		rightPanel.setPreferredSize(new Dimension(440, 500));

		homePanel = new JPanel();
		connectPanel = new JPanel();
		indexPanel = new JPanel();
		cssPanel = new JPanel();
		jsPanel = new JPanel();

		// Text field
		textField();
		
		homePanel.setBackground(Color.decode("#ECDFEE"));
		connectPanel.setBackground(Color.decode("#ECDFEE"));
		indexPanel.setBackground(Color.decode("#ECDFEE"));
		cssPanel.setBackground(Color.decode("#ECDFEE"));
		jsPanel.setBackground(Color.decode("#ECDFEE"));

		rightPanel.add(homePanel, "home");
		rightPanel.add(connectPanel, "connect");
		rightPanel.add(indexPanel, "index");
		rightPanel.add(cssPanel, "css");
		rightPanel.add(jsPanel, "js");
		
		homePanel.add(homeLabel);
		connectPanel.add(connectLabel);

		connectPanel.add(hostField);
		connectPanel.add(usrField);
		connectPanel.add(passField);
		connectPanel.add(dbField);
		connectPanel.add(createConnectBtn);

		indexPanel.add(indexLabel);
		indexPanel.add(createIndexBtn);
		cssPanel.add(cssLabel);
		cssPanel.add(createCssBtn);
		jsPanel.add(jsLabel);
		jsPanel.add(createJsBtn);

		card.show(rightPanel, "home");	// Default homepage
	}

	public void textField()
	{
		hostField = new JTextField("localhost");
		usrField = new JTextField("izzat");
		passField = new JTextField("123");
		dbField = new JTextField("rbx_db");

		hostField.setPreferredSize(new Dimension(300, 35));
		hostField.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
		usrField.setPreferredSize(new Dimension(300, 35));
		usrField.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
		passField.setPreferredSize(new Dimension(300, 35));
		passField.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
		dbField.setPreferredSize(new Dimension(300, 35));
		dbField.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
	}

	public void button()
	{
		homeBtn = new JButton("Homepage");
		connectBtn = new JButton("Koneksi");
		indexBtn = new JButton("Index");
		cssBtn = new JButton("CSS");
		jsBtn = new JButton("JS");

		createConnectBtn = new JButton("Buat Koneksi");
		createConnectBtn.setPreferredSize(new Dimension(140, 35));
		createConnectBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createConnectBtn.setBackground(Color.decode("#AF00C7"));
		createConnectBtn.setForeground(Color.white);
		createConnectBtn.setFocusPainted(false);
		
		createIndexBtn = new JButton("Buat Index");
		createIndexBtn.setPreferredSize(new Dimension(140, 35));
		createIndexBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createIndexBtn.setBackground(Color.decode("#AF00C7"));
		createIndexBtn.setForeground(Color.white);
		createIndexBtn.setFocusPainted(false);

		createCssBtn = new JButton("Buat CSS");
		createCssBtn.setPreferredSize(new Dimension(140, 35));
		createCssBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createCssBtn.setBackground(Color.decode("#AF00C7"));
		createCssBtn.setForeground(Color.white);
		createCssBtn.setFocusPainted(false);
		
		createJsBtn = new JButton("Buat JavaScript");
		createJsBtn.setPreferredSize(new Dimension(140, 35));
		createJsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createJsBtn.setBackground(Color.decode("#AF00C7"));
		createJsBtn.setForeground(Color.white);
		createJsBtn.setFocusPainted(false);

		homeBtn.setPreferredSize(new Dimension(140, 35));
		connectBtn.setPreferredSize(new Dimension(140, 35));
		indexBtn.setPreferredSize(new Dimension(140, 35));
		cssBtn.setPreferredSize(new Dimension(140, 35));
		jsBtn.setPreferredSize(new Dimension(140, 35));
		homeBtn.setFocusPainted(false);
		connectBtn.setFocusPainted(false);
		indexBtn.setFocusPainted(false);
		cssBtn.setFocusPainted(false);
		jsBtn.setFocusPainted(false);
		homeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connectBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indexBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cssBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		homeBtn.setBackground(Color.decode("#AF00C7"));
		homeBtn.setForeground(Color.white);
		connectBtn.setBackground(Color.decode("#AF00C7"));
		connectBtn.setForeground(Color.white);
		indexBtn.setBackground(Color.decode("#AF00C7"));
		indexBtn.setForeground(Color.white);
		cssBtn.setBackground(Color.decode("#AF00C7"));
		cssBtn.setForeground(Color.white);
		jsBtn.setBackground(Color.decode("#AF00C7"));
		jsBtn.setForeground(Color.white);
	}

	public void label()
	{
		// Left label
		rbxLogo = new JLabel("<html><h2>RBX Family</h2></html>");
		rbxLogo.setForeground(Color.decode("#AF00C7"));
		rbxLogo.setPreferredSize(new Dimension(150, 70));
		rbxLogo.setHorizontalAlignment(JLabel.CENTER);
		rbxLogo.setFont(rbxLogo.getFont().deriveFont(20f));
		leftPanel.add(rbxLogo);

		// Right Label
		homeLabel = new JLabel();
		connectLabel = new JLabel();
		indexLabel = new JLabel();
		cssLabel = new JLabel();
		jsLabel = new JLabel();

		// Welcome message
		homeLabel.setText(
			"<html>"
			+
			"<style>"
			+
			"h1 { width: 100%; text-align: center; }"
			+
			"</style>"
			+
			"<h3 color='#AF00C7'>WEB APPLICATION TOOLS</h3>"
			+
			"<h4 color='#6D6D6D'>By RBX Family Jagapura</h4>"
			+
			"</html>"
		);
		// Connect Label
		connectLabel.setText(
			"<html>"
			+
			"<style>"
			+
			"h1 { width: 100%; text-align: center; }"
			+
			"</style>"
			+
			"<h3 color='#AF00C7'>MEMBUAT FILE KONEKSI</h3>"
			+
			"</html>"
		);
		// Index Label
		indexLabel.setText(
			"<html>"
			+
			"<style>"
			+
			"h1 { width: 100%; text-align: center; }"
			+
			"</style>"
			+
			"<h3 color='#AF00C7'>MEMBUAT FILE INDEX</h3>"
			+
			"</html>"
		);
		// CSS Label
		cssLabel.setText(
			"<html>"
			+
			"<style>"
			+
			"h1 { width: 100%; text-align: center; }"
			+
			"</style>"
			+
			"<h3 color='#AF00C7'>MEMBUAT FILE CSS</h3>"
			+
			"</html>"
		);
		// Connect Label
		jsLabel.setText(
			"<html>"
			+
			"<style>"
			+
			"h1 { width: 100%; text-align: center; }"
			+
			"</style>"
			+
			"<h3 color='#AF00C7'>MEMBUAT FILE JAVASCRIPT</h3>"
			+
			"</html>"
		);

		// Font size
		homeLabel.setFont(homeLabel.getFont().deriveFont(15f));
		connectLabel.setFont(connectLabel.getFont().deriveFont(15f));
		indexLabel.setFont(indexLabel.getFont().deriveFont(15f));
		cssLabel.setFont(cssLabel.getFont().deriveFont(15f));
		jsLabel.setFont(jsLabel.getFont().deriveFont(15f));
		
		homeLabel.setPreferredSize(new Dimension(300, 90));
		connectLabel.setPreferredSize(new Dimension(300, 90));
		indexLabel.setPreferredSize(new Dimension(300, 90));
		cssLabel.setPreferredSize(new Dimension(300, 90));
		jsLabel.setPreferredSize(new Dimension(300, 90));

		homeLabel.setHorizontalAlignment(JLabel.CENTER);
		connectLabel.setHorizontalAlignment(JLabel.CENTER);
		indexLabel.setHorizontalAlignment(JLabel.CENTER);
		cssLabel.setHorizontalAlignment(JLabel.CENTER);
		jsLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	// System.getProperty("user.name")

	public void eventListener()
	{
		homeBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				card.show(rightPanel, "home");
			}
		});
		connectBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				card.show(rightPanel, "connect");
			}
		});
		indexBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				card.show(rightPanel, "index");
			}
		});
		cssBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				card.show(rightPanel, "css");
			}
		});
		jsBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				card.show(rightPanel, "js");
			}
		});

		createConnectBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				String host = hostField.getText();
				String usr = usrField.getText();
				String pass = passField.getText();
				String db = dbField.getText();
				//Create the file
				String path = "c:/Users/" + System.getProperty("user.name") + "/Desktop/";
				new File(path + "RBX").mkdir();
				try {
					file = new FileWriter(path + "RBX/koneksi.php");
					file.write(
						"<?php \n\n"
						+
						"$host = '" + host +"';\n"
						+
						"$usr = '" + usr +"';\n"
						+
						"$pass = '" + pass + "';\n"
						+
						"$db = '" + db + "';\n"
						+
						"$connect = mysqli_connect($host, $usr, $pass, $db) OR DIE ('Gagal terhubung ke database/ server!');\n\n"
						+
						"/*\n\n"
						+
						"	<|===> Created by RBX Generator <===|>\n\n"
						+
						"		Email: izzatalharist@gmail.com\n"
						+
						"		Phone/ WhatsApp: 0819-0659-0037\n"
						+
						"		Paypal: paypal.me/izzat.alharis\n\n"
						+
						"!!! -- Please show me your support -- !!!\n\n*/"
					);    
					file.close();  
				}
				catch (IOException e) { System.out.println(e); }
				System.out.println("File created!");
				JOptionPane.showMessageDialog(rbx, "Berhasil membuat file Koneksi!");
			}
		});

		createIndexBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				//Create the file
				String path = "c:/Users/" + System.getProperty("user.name") + "/Desktop/";
				new File(path + "RBX").mkdir();
				try {
					file = new FileWriter(path + "RBX/index.php");
					file.write(
						"<!DOCTYPE html>\n"
						+
						"<html lang='en'>\n"
						+
						"<head>\n"
						+
						"	<meta charset='UTF-8'>\n"
						+
						"	<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
						+
						"	<meta http-equiv='X-UA-Compatible' content='ie=edge'>\n"
						+
						"	<title>RBX Family</title>\n"
						+
						"	<link rel='stylesheet' href='./main.css' type='text/css'>\n"
						+
						"</head>\n"
						+
						"<body>\n\n"
						+
						"	<h1>Created By RBX Family - Jagapura</h1>\n"
						+
						"	<h4>Email: izzatalharist@gmail.com</h4>\n"
						+
						"	<h4>Phone: 0819-0659-0037</h4>\n"
						+
						"	<h4>Paypal: <a href='https://paypal.me/izzat.alharis'>PayPal.Me/izzat.alharis</a></h4>\n\n"
						+
						"	<script src='./main.js'>/* Load file Javascript */</script>\n"
						+
						"</body>\n"
						+
						"</html>"
					);    
					file.close();  
				}
				catch (IOException e) { System.out.println(e); }
				System.out.println("File created!");
				JOptionPane.showMessageDialog(rbx, "Berhasil membuat file Index!");
			}
		});

		createCssBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				//Create the file
				String path = "c:/Users/" + System.getProperty("user.name") + "/Desktop/";
				new File(path + "RBX").mkdir();
				try {
					file = new FileWriter(path + "RBX/main.css");
					file.write(
						"* {\n"
						+
						"	padding: 0;\n"
						+
						"	margin: 0;\n"
						+
						"	box-sizing: border-box;\n"
						+
						"	text-decoration: none;\n"
						+
						"}\n\n"
						+
						"body {\n"
						+
						"	background: lightgrey;\n"
						+
						"}\n\n"
						+
						"/*\n\n"
						+
						"	<|===> Created by RBX Generator <===|>\n\n"
						+
						"		Email: izzatalharist@gmail.com\n"
						+
						"		Phone/ WhatsApp: 0819-0659-0037\n"
						+
						"		Paypal: paypal.me/izzat.alharis\n\n"
						+
						"!!! -- Please show me your support -- !!!\n\n*/"
					);    
					file.close();  
				}
				catch (IOException e) { System.out.println(e); }
				System.out.println("File created!");
				JOptionPane.showMessageDialog(rbx, "Berhasil membuat file CSS!");
			}
		});

		createJsBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent d)
			{
				//Create the file
				String path = "c:/Users/" + System.getProperty("user.name") + "/Desktop/";
				new File(path + "RBX").mkdir();
				try {
					file = new FileWriter(path + "RBX/main.js");
					file.write(
						"\n"
						+
						"var x = 'Welcome to RBX Family !';\n"
						+
						"alert( x );\n\n"
						+
						"/*\n\n"
						+
						"	<|===> Created by RBX Generator <===|>\n\n"
						+
						"		Email: izzatalharist@gmail.com\n"
						+
						"		Phone/ WhatsApp: 0819-0659-0037\n"
						+
						"		Paypal: paypal.me/izzat.alharis\n\n"
						+
						"!!! -- Please show me your support -- !!!\n\n*/"
					);    
					file.close();  
				}
				catch (IOException e) { System.out.println(e); }
				System.out.println("File created!");
				JOptionPane.showMessageDialog(rbx, "Berhasil membuat file CSS!");
			}
		});


	}

	public static void main(String[] args) 
	{
		new Generator();
	}
}

// RBX Family - Jagapura