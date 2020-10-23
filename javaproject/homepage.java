import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class homepage implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel l;
	JButton b,b1,b2,b3;
	homepage()
	{
		f=new JFrame("Homepage");
		p=new ImagePanel(new ImageIcon("1.png").getImage());
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setSize(1024,768);
		p.setLayout(null);
		//f.getContentPane().setBackground(Color.gray);
		Font f1=new Font("Arial",Font.BOLD,30);
		l=new JLabel("Library Management System");
		l.setFont(f1);
		l.setForeground(Color.blue);
		b=new JButton("Book issue");
		b.addActionListener(this);
		b1=new JButton("Book return");
		b1.addActionListener(this);
		b2=new JButton("Book renewal");
		b2.addActionListener(this);
		b3=new JButton("Report");
		b3.addActionListener(this);
			l.setBounds(500,200,500,50);
			b.setBounds(600,300,150,30);
			b1.setBounds(600,350,150,30);
			b2.setBounds(600,400,150,30);
			b3.setBounds(600,450,150,30);
			p.add(l);
			p.add(b);
		 	p.add(b1);
			p.add(b2);
			p.add(b3);
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
				
				new bookissue();
				f.dispose();
				f.setVisible(false);
			 }
		   	  if(ae.getSource()==b1)
			{
				
				new bookreturn();
				f.dispose();
				f.setVisible(false);
			 }
				if(ae.getSource()==b2)
			{
				
				new bookrenewal();
				f.dispose();
				f.setVisible(false);
			 }
			if(ae.getSource()==b3)
			{
				
				new report();
				f.dispose();
				f.setVisible(false);
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
		new homepage();
		}
}

