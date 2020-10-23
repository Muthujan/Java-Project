import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class library implements ActionListener
{
	JFrame f;
	JPanel p1;
	JLabel l;
	JButton b,b1;
	library()
	{
		f=new JFrame("Library Management System");
		p1=new ImagePanel(new ImageIcon("169825.jpg").getImage());
		f.getContentPane().add(p1);
		f.setVisible(true);
		f.setSize(1024,768);
		p1.setLayout(null);
		Font f2=new Font("Arial",Font.BOLD,50);
		l=new JLabel("Library Management System");
		l.setFont(f2);
		l.setForeground(Color.white);
		b=new JButton("Login");
		b.addActionListener(this);
		b1=new JButton("Exit");
		b1.addActionListener(this);

			l.setBounds(300,150,700,60);
			b.setBounds(500,300,70,30);
			b1.setBounds(580,300,70,30);
			p1.add(l);
			p1.add(b);
			p1.add(b1);
		}
		public void actionPerformed(ActionEvent ae)
	{
		try
		{
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/emp","root","root");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from login");*/	
			if(ae.getSource()==b)
			{
				
				new login();
				f.dispose();
				f.setVisible(false);
			 }
		   	  

				
			
			if(ae.getSource()==b1)
			{
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(f,e);
			//System.out.println(e);
		}
	}
		public static void main(String ar[])
		{
		new library();
		}
	}