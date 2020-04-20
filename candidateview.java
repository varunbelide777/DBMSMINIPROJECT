import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class candidateview extends JFrame {
	          private JPanel panel;
	          private JLabel label;
	          private JTextField t1;
	          private JLabel label1;
	          private JTextField t2;
	          private JLabel label2;
	          private JTextField t3;
	          private JTextField t4;
	          private JLabel label3;
	          private JLabel label4;
	          private JTextField t5;
	          private JButton view;
	          private JMenuItem menuinsert;
        	  private JMenuItem menudelete;
        	  private JMenuItem menuview;
        	  private JMenuItem insert1;
        	  private JMenuItem delete1;
        	  private JMenuItem view1;
        	  private JMenuItem insert2;
        	  private JMenuItem delete2;
        	  private JMenuItem view2;
        	  private JFrame frame;
        	  private JMenuBar menubar;
        	  private JMenu candidate;
        	  private JMenu vaccine;
        	  private JMenu data; 
        	  private JTextArea txtSelect;
        	  private JLabel lblselect;
        	  private JTextField txtSelectPrimary;
        	  private JButton btnview;
        	  
	          public candidateview() 

	          {
	        	  txtSelect=new JTextArea(10,20);
	        	  lblselect=new JLabel("Select ");
	        	  txtSelectPrimary=new JTextField(20);
	        	  btnview=new JButton("view");
                  view=new JButton("update");

	        	  panel=new JPanel(new FlowLayout());
	        	  label=new JLabel("candidatename");
	        	  t1=new JTextField(20);
	        	  label2=new JLabel("registration number");
	        	  label1=new JLabel("DOB");
	        	  label3=new JLabel("gender");
	        	  label4=new JLabel("Healthisssuesatbirth");
	        	 
	        	  t2=new JTextField(10);
	        	  t3=new JTextField(10);
	        	  t4=new JTextField(15);
	        	  t5=new JTextField(30);
	        	  candidate=new JMenu("candidate");
	           	    vaccine=new JMenu("vaccine");
	           	    data=new JMenu("data");
	           	    menuinsert=new JMenuItem("insert");
	           	   menudelete=new JMenuItem("delete");
	           	   menuview=new JMenuItem("view");
	           	   insert1=new JMenuItem("insert");
	           	  delete1=new JMenuItem("delete");
	           	   view1=new JMenuItem("view");
	           	  insert2=new JMenuItem("insert");
	           	   delete2=new JMenuItem("delete");
	           	   view2=new JMenuItem("view");
	           	frame=new JFrame("Menu");
	           	menubar=new JMenuBar();
	            this.add(panel);
	        	 
	        	  this.setVisible(true);
	        	  this.setDefaultCloseOperation(3);
	        	  this.setSize(1000,300);
	        	 
         	   this.setJMenuBar(menubar);
                 panel.add(txtSelect);
                 panel.add(lblselect);
                 panel.add(txtSelectPrimary);
                 panel.add(btnview);
         	  
	        	  panel.add(label);
	        	  panel.add(t1);
	        	  panel.add(label2);
	        	  panel.add(t2);
	        	  panel.add(label1);
	        	  panel.add(t3);
	        	  panel.add(label3);
	        	  panel.add(t4);
	        	  panel.add(label4);
	        	  panel.add(t5);
	        	  panel.add(view);
	        	  
	        	 
           	   
           	  
  
           	  
           	  menubar.add(candidate);

           	  candidate.add(menuinsert);
           	  candidate.add(menudelete);
           	  candidate.add(menuview);
           	  
           	  menubar.add(vaccine);
           	  vaccine.add(insert1);
           	vaccine.add(delete1);
           	vaccine.add(view1);
           	  menubar.add(data);
           	  data.add(insert2);
                 data.add(delete2);
                 data.add(view2);
                 menuinsert.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new candidateinsert();
						dispose();
						
					}
                 }
                 );
                 menuview.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
					       new candidateview();
					       dispose();
					}
				}
                 
                
                 
               );
                 menudelete.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 				
 					       new candidatedelete();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 insert1.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 					
 					       new vaccineinsert();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 delete1.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 						
 					       new vaccinedelete();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 view1.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 					
 						
 					       new vaccineview();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 insert2.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 						
 					       new datainsert();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 delete2.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 					
 					       new datadelete();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 view2.addActionListener(new ActionListener() {
 					
 					@Override
 					public void actionPerformed(ActionEvent e) {
 			
 					       new dataview();
 					       dispose();
 					}
 				}
                  
                 
                  
                );
                 
                 try{  
                	 
                	 Class.forName("oracle.jdbc.driver.OracleDriver");   
                	   
                	 Connection con=DriverManager.getConnection(  
                	 "jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
                	   
                	 Statement stmt=con.createStatement();  
           
                	 ResultSet rs=stmt.executeQuery("select * from candidate");  
                	 while(rs.next())  
                		txtSelect.append(rs.getInt(1)+"\n"); 
                	   
                	   
                	 con.close();  
                	   
                	 }catch(Exception e){ System.out.println(e);}   
                 btnview.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(txtSelectPrimary.getText().compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Enter Registartion Number");
						}
						else
						{
							try{  
								 
								Class.forName("oracle.jdbc.driver.OracleDriver");   
								  
								Connection con=DriverManager.getConnection(  
								"jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
								  
								Statement stmt=con.createStatement();  
								   
								ResultSet rs=stmt.executeQuery("select * from candidate where REGISTRATIONID="+txtSelectPrimary.getText()+"");  
								while(rs.next())  
								{
									t2.setText(rs.getInt(1)+"");
									t1.setText(rs.getString(2)+"");
									t3.setText(rs.getString(3)+"");
									t4.setText(rs.getString(4)+"");
									t5.setText(rs.getString(5));
								}
								  
								  
								con.close();  
								  
								}catch(Exception ex){ System.out.println(ex);}  
						}
					}
				});
                view.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(t1.getText().compareTo("")==0 || t2.getText().compareTo("")==0 || t3.getText().compareTo("")==0 || t4.getText().compareTo("")==0 || t5.getText().compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null, "Enter All Fields");
						}
						else
						{
							try{  
								 
								Class.forName("oracle.jdbc.driver.OracleDriver");   
								  
								Connection con=DriverManager.getConnection(  
								"jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
								  
								Statement stmt=con.createStatement();  
								   
								int x=stmt.executeUpdate("update candidate set REGISTRATIONID="+t2.getText()+",NAME='"+t1.getText()+"',GENDER='"+t4.getText()+"',HEALTHISSUES='"+t5.getText()+"' where  REGISTRATIONID="+txtSelect.getText()+"");
								System.out.println("Total Updated Rows "+x);
								con.commit();
							
								txtSelect.setText("");
								txtSelectPrimary.setText("");
								t1.setText("");
								t2.setText("");
								t3.setText("");
								t4.setText("");
								t5.setText("");
			                	 ResultSet rs=stmt.executeQuery("select * from candidate");  
			                	 while(rs.next())  
			                		txtSelect.append(rs.getInt(1)+"\n"); 
								con.close();  
								  
								}catch(Exception ex){ System.out.println(ex);}
						}
					}
				});
                
	          }
	          public static void main(String args[])
	          {
	        	  new candidateview();
	        	  
	          }
	          
}