import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class bookrenewal implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t5,t6,t7;
	JTextArea t4;
	JButton b,b1,b2,b3;
	int count;
	bookrenewal()
	{
		f=new JFrame("Book renewal");
		p=new ImagePanel(new ImageIcon("1.png").getImage());
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setSize(1000,1000);
		p.setLayout(null);
		//f.getContentPane().setBackground(Color.gray);
		Font f1=new Font("Arial",Font.BOLD,16);
		Font f2=new Font("Arial",Font.BOLD,25);
		l=new JLabel("BOOK RENEWAL");
		l.setFont(f2);
		l1=new JLabel("Student Id");
		l1.setFont(f1);
		t1=new JTextField(30);
		l2=new JLabel("Student Name");
		l2.setFont(f1);
		t2=new JTextField(30);
		l3=new JLabel("Department");
		l3.setFont(f1);
		t3=new JTextField(30);
		l4=new JLabel("Book Name");
		l4.setFont(f1);
		t4=new JTextArea(5,5);
		l5=new JLabel("No_of_Book");
		l5.setFont(f1);
		t5=new JTextField(30);
		l6=new JLabel("Issue Date");
		l6.setFont(f1);
		t6=new JTextField(30);
		l7=new JLabel("Return Date");
		l7.setFont(f1);
		t7=new JTextField(30);
		b=new JButton("Edit");
		b.addActionListener(this);
		b1=new JButton("Renewal");
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.addActionListener(this);
		b3=new JButton("Back");
		b3.addActionListener(this);
		l.setBounds(600,150,200,30);
		l1.setBounds(500,200,100,30);
		t1.setBounds(610,200,100,30);
		l2.setBounds(500,250,150,30);
		t2.setBounds(610,250,100,30);
		l3.setBounds(500,300,100,30);
		t3.setBounds(610,300,100,30);
		l4.setBounds(500,350,100,30);
		t4.setBounds(610,350,100,30);
		l5.setBounds(500,400,100,30);
		t5.setBounds(610,400,100,30);
		l6.setBounds(500,450,100,30);
		t6.setBounds(610,450,100,30);
		l7.setBounds(500,500,100,30);
		t7.setBounds(610,500,100,30);
		b.setBounds(450,550,90,30);
		b1.setBounds(550,550,90,30);
		b2.setBounds(650,550,90,30);
		b3.setBounds(750,550,90,30);
		p.add(l);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(l5);
		p.add(t5);
		p.add(l6);
		p.add(t6);
		p.add(l7);
		p.add(t7);
		p.add(b);
		p.add(b1);
		p.add(b2);
		p.add(b3);
	}
	public void actionPerformed(ActionEvent a)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
			Statement s=c.createStatement();
			ResultSet rs;
			if(a.getSource()==b)
			{
			
			rs=s.executeQuery("Select * from info where Student_Id='"+t1.getText()+"'");
			while(rs.next())
			{
				count++;
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
				}
				if(count==0)
				{
					JOptionPane.showMessageDialog(f,"not found");
					t1.setText("");
				}

			}
			if(a.getSource()==b1)
			{
			int r=s.executeUpdate("Update info set Student_Id='"+t1.getText()+"',Student_Name='"+t2.getText()+"',Department='"+t3.getText()+"',Book_Name='"+t4.getText()+"',No_of_Book='"+t5.getText()+"',Issue_Date='"+t6.getText()+"',Return_Date='"+t7.getText()+"'where Student_Id='"+t1.getText()+"'");
			if(r!=0)
			{
				JOptionPane.showMessageDialog(f,new String("Renewal"));
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			}
			if(a.getSource()==b2)
			{
				System.exit(0);
			}
			if(a.getSource()==b3)
			{
				new homepage();
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
		new bookrenewal();
		}
	}