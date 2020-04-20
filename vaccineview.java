import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class vaccineview extends JFrame {
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
	          public vaccineview()
	          {
	        	  txtSelect=new JTextArea(10,20);
	        	  lblselect=new JLabel("Select ");
	        	  txtSelectPrimary=new JTextField(20);
	        	  btnview=new JButton("View");



	        	  panel=new JPanel(new FlowLayout());
	        	  label=new JLabel("vaccine name");
	        	  t1=new JTextField(20);
	        	  label2=new JLabel("to prevent disease");
	        	  label1=new JLabel("maxagecantake");
	        	  label3=new JLabel("genderspecification");
	        	  label4=new JLabel("dosage");
	        	  view=new JButton("update");
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
           	   menudelete=new JMenuItem("delete");
           	   menuview=new JMenuItem("view");
           	   insert1=new JMenuItem("insert");
           	  delete1=new JMenuItem("delete");
           	   view1=new JMenuItem("view");
           	  insert2=new JMenuItem("insert");
           	   delete2=new JMenuItem("delete");
           	   view2=new JMenuItem("view");
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
	                	 txtSelect.append("Vaccines Avaliable\n");   
	                	 ResultSet rs=stmt.executeQuery("select vaccine_name from vaccine");  
	                	 while(rs.next())  
	                		 txtSelect.append(rs.getString(1)+"\n");
	                	   
	                	   
	                	 con.close();  
	                	   
	                	 }catch(Exception e){ System.out.println(e);} 
	                 btnview.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(txtSelectPrimary.getText().compareTo("")==0)
							{
								JOptionPane.showMessageDialog(null, "Enter Vaccine Name To View");
							}
							else
							{
								try{  
									 
									Class.forName("oracle.jdbc.driver.OracleDriver");   
									  
									Connection con=DriverManager.getConnection(  
									"jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
									  
									Statement stmt=con.createStatement();  
									   
									ResultSet rs=stmt.executeQuery("select * from vaccine where vaccine_name='"+txtSelectPrimary.getText()+"'");  
									while(rs.next())  
									{
										t1.setText(rs.getString(1));
										t3.setText(rs.getString(2));
										t4.setText(rs.getString(3));
										t5.setText(rs.getString(4));
										t2.setText(rs.getString(5));
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
				   
									int x=stmt.executeUpdate("update vaccine set vaccine_name='"+vaccine_name+"',maxagetogetvaccine="+maxagetogetvaccine+",gender='"+gender+"',dosage="+dosage+",toprevent='"+toprevent+"' where  vaccine_name='"+txtSelectPrimary.getText()+"'");
									con.commit();
									System.out.println("Updated rows="+x);
									t1.setText("");
									t2.setText("");
									t3.setText("");
									t4.setText("");
									t5.setText("");
									txtSelectPrimary.setText("");  
									txtSelect.setText("");
									txtSelect.append("Vaccines Avaliable\n");   
				                	 ResultSet rs=stmt.executeQuery("select vaccine_name from vaccine");  
				                	 while(rs.next())  
				                		 txtSelect.append(rs.getString(1)+"\n");  
									con.close();  
									  
									}catch(Exception ex){ System.out.println(ex);} 
							}
						}
					});
	          }
	          public static void main(String args[])
	          {
	        	  new vaccineview();
	        	  
	          }
	          
}



