import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class login implements ActionListener
{
	JFrame f;
	JPanel p1;
	JLabel l,l1,l2;
	JTextField t1;
	JPasswordField p;
	JButton b,b1;
	login()
	{
		f=new JFrame("Login");
		p1=new ImagePanel(new ImageIcon("1.png").getImage());
		f.getContentPane().add(p1);
		f.setVisible(true);
		f.setSize(1000,1000);
		p1.setLayout(null);
		//f.getContentPane().setBackground(Color.gray);
		Font f1=new Font("Arial",Font.BOLD,16);
		Font f2=new Font("Arial",Font.BOLD,25);
		l=new JLabel("LOGIN");
		l.setFont(f2);
		l.setForeground(Color.blue);
		l1=new JLabel("User name");
		l1.setFont(f1);
		t1=new JTextField(30);
		l2=new JLabel("password");
		l2.setFont(f1);
		p=new JPasswordField(30);
		b=new JButton("Login");
		b.addActionListener(this);
		b1=new JButton("Close");
		b1.addActionListener(this);
			l.setBounds(650,150,100,40);
			l1.setBounds(550,200,100,30);
			t1.setBounds(660,200,100,30);
			l2.setBounds(550,250,100,30);
			p.setBounds(660,250,100,30);
			b.setBounds(570,300,70,50);
			b1.setBounds(650,300,70,50);
			p1.add(l);
			p1.add(l1);
			p1.add(t1);
			p1.add(l2);
			p1.add(p);
			p1.add(b);
			p1.add(b1);
		}
		public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from login");
			if(ae.getSource()==b)
			{
				int success=0;
				while(rs.next())
				{
			    if( (t1.getText()).equals(rs.getString(1) )&&(p.getText()).equals(rs.getString(2) ))
			    {
			     JOptionPane.showMessageDialog(f,new String("Welcome "+rs.getString(1) ) );
				new homepage();
				f.setVisible(false);
				success++;
			    }
		   	    }

				if(success==0)
				{
				JOptionPane.showMessageDialog(f,new String("Invalid User"));
				t1.setText("");
				p.setText("");
				}
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
		new login();
		}
	}