import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class datadelete extends JFrame {
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
	          private JButton delete;
	          private JMenuItem menuinsert;
        	  private JMenuItem menudelete;
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
        	  private JTextArea txtSelect;
        	  private JLabel lblselectvaccine;
        	  private JTextField txtSelectvaccine;
        	  private JLabel lblselectid;
        	  private JTextField txtSelectid;
        	  private JButton btnview;
	          public datadelete()
	          {
	        	  lblselectvaccine=new JLabel("Select Vaccine");
	        	  txtSelectvaccine=new JTextField(20);
	        	  lblselectid=new JLabel("Select Registration Id");
	        	  txtSelectid=new JTextField(20);
	        	  txtSelect=new JTextArea(10,20);
	        	  lblselectvaccine=new JLabel("Select Vaccine");
	        	  txtSelectvaccine=new JTextField(20);
	        	  lblselectid=new JLabel("Select Registration Id");
	        	  txtSelectid=new JTextField(20);
	        	  btnview=new JButton("View");



	        	  panel=new JPanel(new FlowLayout());
	        	  label=new JLabel("vaccinename");
	        	  t1=new JTextField(20);
	        	  label2=new JLabel("registration number");
	        	  label1=new JLabel("day");
	        	  label3=new JLabel("ageatvaccination");
	        	  frame=new JFrame("menu");
	        	  delete=new JButton("delete");
	        	  t2=new JTextField(10);
	        	  t3=new JTextField(10);
	        	  t4=new JTextField(15);
	        	  menubar=new JMenuBar();
           	   this.setJMenuBar(menubar);
           	   candidate=new JMenu("candidate");
           	  
           	    vaccine=new JMenu("vaccine");
           	    data=new JMenu("data");
           	    menuinsert=new JMenuItem("insert");
           	   menudelete=new JMenuItem("delete");
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
	        	  panel.add(txtSelect);
	        	  panel.add(lblselectvaccine);
	        	  panel.add(txtSelectvaccine);
	        	  panel.add(lblselectid);
	        	  panel.add(txtSelectid);
	        	  panel.add(btnview);
	        	
	        	  panel.add(label);
	        	  panel.add(t1);
	        	  panel.add(label2);
	        	  panel.add(t2);
	        	  panel.add(label1);
	        	  panel.add(t3);
	        	  panel.add(label3);
	        	  panel.add(t4);
	        	  
	        	  panel.add(delete);
	        	  
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
	                	 txtSelect.append("Vaccine      RegistrationID\n");   
	                	 ResultSet rs=stmt.executeQuery("select vaccine_name,registrationid from takes");  
	                	 while(rs.next())  
	                		 txtSelect.append(rs.getString(1)+"             "+rs.getString(2)+"\n");  
	                	   
	                	   
	                	 con.close();  
	                	   
	                	 }catch(Exception e){ System.out.println(e);}  
	                btnview.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(txtSelectvaccine.getText().compareTo("")==0 || txtSelectid.getText().compareTo("")==0)
							{
								JOptionPane.showMessageDialog(null, "Enter All Fields for View");
							}
							else
							{
								try{  
									 
									Class.forName("oracle.jdbc.driver.OracleDriver");   
									  
									Connection con=DriverManager.getConnection(  
									"jdbc:oracle:thin:@localhost:1521:xe","varun","varun");  
									  
									Statement stmt=con.createStatement();  
									   
									ResultSet rs=stmt.executeQuery("select * from takes where vaccine_name='"+txtSelectvaccine.getText()+"'and registrationid="+txtSelectid.getText());  
									while(rs.next())  
									{
										t1.setText(rs.getString(1));
										t2.setText(rs.getString(2));
										t3.setText(rs.getString(3));
										t4.setText(rs.getString(4));
									}
									  
									  
									con.close();  
									  
									}catch(Exception ex){ System.out.println(ex);}  
							}
						}
					});
	                delete.addActionListener(new ActionListener() {
						
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
									   
									int x =stmt.executeUpdate("delete from candidate_vaccine  where vaccine_name='"+txtSelectvaccine.getText()+"' and registrationid="+txtSelectid.getText());  
									
									con.commit();
									
									System.out.println("Deleted rows="+x);
									t1.setText("");
									t2.setText("");
									t3.setText("");
									t4.setText("");  
									txtSelectid.setText("");
									txtSelectvaccine.setText("");
									txtSelect.setText("");
									 txtSelect.append("Vaccine      RegistrationID\n");   
				                	 ResultSet rs=stmt.executeQuery("select vaccine_name,registrationid from takes");  
				                	 while(rs.next())  
				                		 txtSelect.append(rs.getString(1)+"             "+rs.getString(2)+"\n");  
									con.close();  
									  
									}catch(Exception ex){ System.out.println(ex);}  
							}
						}
					});
	                 
	                 
	          }
	          public static void main(String args[])
	          {
	        	  new datadelete();
	        	  
	          }
	          
}
