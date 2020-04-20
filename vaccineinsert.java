
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class vaccineinsert extends JFrame {
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
	          public vaccineinsert()
	          {
	        	  panel=new JPanel(new FlowLayout());
	        	  label=new JLabel("vaccine name");
	        	  t1=new JTextField(20);
	        	  label2=new JLabel("to prevent disease");
	        	  label1=new JLabel("maxagecantake");
	        	  label3=new JLabel("genderspecification");
	        	  label4=new JLabel("dosage");
	        	  insert=new JButton("insert");
	        	  t2=new JTextField(10);
	        	  t3=new JTextField(10);
	        	  t4=new JTextField(15);
	        	  t5=new JTextField(30);
	        	  menubar=new JMenuBar();
           	   this.setJMenuBar(menubar);
           	   candidate=new JMenu("candidate");
           	 frame=new JFrame("Menu");
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
	        	  panel.add(insert);
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
							String vaccine_name=t1.getText();
							String maxagetogetvaccine=t3.getText();
							String gender=t4.getText();
							String dosage=t5.getText();
							String toprevent=t2.getText();
							if(vaccine_name.compareTo("")==0 || maxagetogetvaccine.compareTo("")==0 || gender.compareTo("")==0 || dosage.compareTo("")==0 || toprevent.compareTo("")==0)
							{
								JOptionPane.showMessageDialog(null, "Enter all fields");
							}
							else
							{
								try{  
									 
									Class.forName("oracle.jdbc.driver.OracleDriver");   
									  
									Connection con=DriverManager.getConnection(  
									"jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
									  
									Statement stmt=con.createStatement();  
									   
									int x=stmt.executeUpdate("insert into vaccine values('"+vaccine_name+"',"+maxagetogetvaccine+",'"+gender+"',"+dosage+",'"+toprevent+"')");
									con.commit();
									System.out.println("Inserted rows="+x);
									t1.setText("");
									t2.setText("");
									t3.setText("");
									t4.setText("");
									t5.setText("");
									  
									  
									con.close();  
									  
									}catch(Exception ex){ System.out.println(ex);} 
							}
						}
					});
	                 
	          }
	          public static void main(String args[])
	          {
	        	  new vaccineinsert();
	        	  
	          }
	          
}




