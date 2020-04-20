import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class datainsert extends JFrame {
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
	          private JButton insert;
	          private JMenuItem menuinsert;
        	  private JMenuItem delete;
        	  private JMenuItem view;
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
	          public datainsert()
	          {
	        	  panel=new JPanel(new FlowLayout());
	        	  label=new JLabel("vaccinename");
	        	  t1=new JTextField(20);
	        	  label2=new JLabel("registration number");
	        	  label1=new JLabel("day");
	        	  label3=new JLabel("ageatvaccination");
	        	  frame=new JFrame("menu");
	        	  insert=new JButton("insert");
	        	  t2=new JTextField(10);
	        	  t3=new JTextField(10);
	        	  t4=new JTextField(15);
	        	  menubar=new JMenuBar();
           	   this.setJMenuBar(menubar);
           	   candidate=new JMenu("candidate");
           	  
           	    vaccine=new JMenu("vaccine");
           	    data=new JMenu("data");
           	    menuinsert=new JMenuItem("insert");
           	   delete=new JMenuItem("delete");
           	   view=new JMenuItem("view");
           	   insert1=new JMenuItem("insert");
           	  delete1=new JMenuItem("delete");
           	   view1=new JMenuItem("view");
           	  insert2=new JMenuItem("insert");
           	   delete2=new JMenuItem("delete");
           	   view2=new JMenuItem("view");
           	  
           	  
           	  menubar.add(candidate);

           	  candidate.add(menuinsert);
           	  candidate.add(delete);
           	  candidate.add(view);
           	  
           	  menubar.add(vaccine);
           	  vaccine.add(insert1);
           	vaccine.add(delete1);
           	vaccine.add(view1);
           	  menubar.add(data);
           	  data.add(insert2);
                 data.add(delete2);
                 data.add(view2);
	        	  
	        	  panel.add(label);
	        	  panel.add(t1);
	        	  panel.add(label2);
	        	  panel.add(t2);
	        	  panel.add(label1);
	        	  panel.add(t3);
	        	  panel.add(label3);
	        	  panel.add(t4);
	        	  
	        	  panel.add(insert);
	        	  
	        	  this.add(panel);
	        	 
	        	  this.setVisible(true);
	        	  this.setDefaultCloseOperation(3);
	        	  this.setSize(1000,300);
	        	  menuinsert.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new candidateinsert();
							dispose();
							
						}
	                 }
	                 );
	                 view.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
						
						       new candidateview();
						       dispose();
						}
					}
	                 
	                
	                 
	               );
	                 delete.addActionListener(new ActionListener() {
	 					
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
	                 insert.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String VACCINE_NAME=t1.getText();
							String REGISTRATIONID=t2.getText();
							String DAY=t3.getText();
							String  AGEONDAYOFVACCINATION=t4.getText();
							if(VACCINE_NAME.compareTo("")==0 || REGISTRATIONID.compareTo("")==0 || DAY.compareTo("")==0 || AGEONDAYOFVACCINATION.compareTo("")==0)
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
									   
									int x =stmt.executeUpdate("insert into candidate_vaccine values('"+VACCINE_NAME+"',"+REGISTRATIONID+",'"+DAY+"',"+AGEONDAYOFVACCINATION+")");  
									con.commit();
									System.out.println("Inserted rows="+x);
									t1.setText("");
									t2.setText("");
									t3.setText("");
									t4.setText("");  
									con.close();  
									  
									}catch(Exception ex){ System.out.println(ex);}  
							}
						}
					});
	                 
	          }
	          public static void main(String args[])
	          {
	        	  new datainsert();
	        	  
	          }
	          
}

