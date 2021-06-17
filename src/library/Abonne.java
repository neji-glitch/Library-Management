package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import conn.Connec;

import java.sql.*;

public class Abonne extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre,lbimg,im;
	JTextField tf1,tf2,tf3,tf4;
	JButton btnact,btrecherche,btinsert,btsupp,btmotif,btnactial,btemprunt,blivre,btnactual;
	ResultSet rst;
	Statement st;
	Connec cn=new Connec();
	JTable jt;
	JScrollPane js;
	
	
	public Abonne(){
		this.setTitle("Gestion de biblioteque");
		this.setSize(740,540);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(210,236,237));
		add(pn);
		//background image/////
		
		 lbimg=new JLabel("");
		 lbimg.setBounds(0,0,740,540);
		   Image phot=new ImageIcon(this.getClass().getResource("image//ban.jpg")).getImage();
		   Image poo5=phot.getScaledInstance(740, 540, java.awt.Image.SCALE_SMOOTH);
		   lbimg.setIcon(new ImageIcon(poo5));
		   pn.add(lbimg);
		
		/////////
		 im=new JLabel("");
		 im.setBounds(110,5,450,100);
		   Image photo1=new ImageIcon(this.getClass().getResource("image//an2.png")).getImage();
		   im.setIcon(new ImageIcon(photo1));
		   lbimg.add(im);
		//titre
		lbtitre=new JLabel("Enregistrement des abonnés");
		lbtitre.setBounds(190,110,300,30);
        lbtitre.setFont(new Font("Arial",Font.BOLD,20));
        lbimg.add(lbtitre,BorderLayout.CENTER);
		
		//label
    	lb1=new JLabel("IdAbonné");
		lb1.setBounds(30,150,100,30);
		lbimg.add(lb1);
		
		tf1=new JTextField();
		tf1.setBounds(100,150,140,30);
		lbimg.add(tf1);
		//
		lb2=new JLabel("Nom");
		lb2.setBounds(30,190,100,30);
		lbimg.add(lb2);
		
		tf2=new JTextField();
		tf2.setBounds(100,190,140,30);
		lbimg.add(tf2);
		//
		lb2=new JLabel("Prenom");
		lb2.setBounds(30,230,100,30);
		lbimg.add(lb2);
		
		tf3=new JTextField();
		tf3.setBounds(100,230,140,30);
		lbimg.add(tf3);
		
		
         /*//button actualise
		btnactual=new JButton("actualise");
		btnactual.setBounds(500,300,200,140);
		Image photoo=new ImageIcon(this.getClass().getResource("att.png")).getImage();
		btnactual.setIcon(new ImageIcon(photoo));
		btnactual.addActionListener(this);
		pn.add(btnactual);*/
		
		//button
		btrecherche=new JButton("Recherche");
		btrecherche.setBounds(250,150,110,30);
		btrecherche.addActionListener(this);
		lbimg.add(btrecherche);
		
		btinsert=new JButton("Insertion");
		btinsert.setBounds(250,190,110,30);
		btinsert.addActionListener(this);
		lbimg.add(btinsert);
		
		btsupp=new JButton("Suppression");
		btsupp.setBounds(250,230,110,30);
		btsupp.addActionListener(this);
		lbimg.add(btsupp);
		
		
		btmotif=new JButton("Modification");
		btmotif.setBounds(380,230,110,30);
		btmotif.addActionListener(this);
		lbimg.add(btmotif);
////////acceuille////////////
	btnactial=new JButton("");
	btnactial.setBounds(650,25,50,60);
	Image photo4=new ImageIcon(this.getClass().getResource("image//home.png")).getImage();
	  Image poo4=photo4.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
	  btnactial.setIcon(new ImageIcon(poo4));
	  lbimg.add(btnactial);
	btnactial.addActionListener(this);
	lbimg.add(btnactial);
		///////////////****refrech*******///////
		btnact=new JButton("");
		btnact.setBounds(650,390,50,60);
		Image photo5=new ImageIcon(this.getClass().getResource("image//ref.png")).getImage();
		  Image po5=photo5.getScaledInstance(90, 70, java.awt.Image.SCALE_SMOOTH);
		  btnact.setIcon(new ImageIcon(po5));
		  lbimg.add(btnact);
		btnact.addActionListener(this);
		lbimg.add(btnact);
		
		
		DefaultTableModel df=new DefaultTableModel();
		jt=new JTable();
		js=new JScrollPane();
		js.setViewportView(jt);
		js.setBounds(80,280,500,200);
		df.addColumn("IdAbonne");
		df.addColumn("Nom");
		df.addColumn("Prenom");
		jt.setModel(df);
		lbimg.add(js);
		
		jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        
		
		String rq="select * from abonne";
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(rq);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("Idabonne"),rst.getString("Nom"),rst.getString("Prenom")
				});
				
			}
		}
		catch(SQLException ex){
			
		}
	}
	
	   private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)jt.getModel();

	        // get the selected row index
	       int selectedRowIndex = jt.getSelectedRow();
	       
	        // set the selected row data into jtextfields
	       tf1.setText(model.getValueAt(selectedRowIndex, 0).toString());
	       tf2.setText(model.getValueAt(selectedRowIndex, 1).toString());
	       tf3.setText(model.getValueAt(selectedRowIndex, 2).toString());
	       
	        
	    }                                  


	public static void main(String[] args) {
		
    Abonne ab=new Abonne();
    ab.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		
		//ajoute Abonne
				if(e.getSource()==btinsert){
				String a,b,c;
				a=tf1.getText();
				b=tf2.getText();
				c=tf3.getText();
				String qr="insert into abonne values('"+a+"','"+b+"','"+c+"')";
				try{
					st=cn.connecion().createStatement();
					if(JOptionPane.showConfirmDialog(this,"voulez vous inserer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(qr);
						JOptionPane.showMessageDialog(this,"Insertion reussie!");
					}
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Erreur,insertion impossible!",null,JOptionPane.ERROR_MESSAGE);
				}
					
				}
				/////**********supression*****///////
				if(e.getSource()==btsupp){
					String a;
					a=tf1.getText();
					String qr="delete from abonne where Idabonne='"+a+"'";
					try{
						st=cn.connecion().createStatement();
						if(JOptionPane.showConfirmDialog(this,"voulez vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							st.executeUpdate(qr);
							JOptionPane.showMessageDialog(this,"suppression reussie!");
						}
					}
					catch(SQLException ex){
						JOptionPane.showMessageDialog(this,"Erreur,supression impossible!",null,JOptionPane.ERROR_MESSAGE);
					}
				}
				
				/////******modification*****/////
				if(e.getSource()==btmotif){
					String a,b,c;
					a=tf1.getText();
					b=tf2.getText();
					c=tf3.getText();
					String qr="update abonne set Nom='"+b+"',Prenom='"+c+"' where Idabonne='"+a+"'";
					try{
						st=cn.connecion().createStatement();
						if(JOptionPane.showConfirmDialog(this,"voulez vous modifier?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							st.executeUpdate(qr);
							JOptionPane.showMessageDialog(this,"modification reussie!");
						}
					}
					catch(SQLException ex){
						JOptionPane.showMessageDialog(this,"Erreur,modification impossible!",null,JOptionPane.ERROR_MESSAGE);
					}
						
					}
				//////****recherche****///////
				if(e.getSource()==btrecherche){
			    	  String a,b,c;
						a=tf1.getText();
						b=tf1.getText();
						c=tf1.getText();
						String qr="select * from abonne where Idabonne='"+a+"'";
						//String qr="select * from abonne where Idabonne='"+a+"'OR Nom='"+b+" OR Prenom='"+c+"'";
						try{
							st=cn.connecion().createStatement();
							rst=st.executeQuery(qr);
							if(rst.next()){
								tf2.setText(rst.getString("Nom"));
								tf3.setText(rst.getString("Prenom"));
								JOptionPane.showMessageDialog(this,"trouvee!",null,JOptionPane.INFORMATION_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(this,"introuvable!",null,JOptionPane.ERROR_MESSAGE);
						}
						catch(SQLException ex){
						
						}
			    	  
			      }
				
    	 
		
		//aller vers l'interface graphique de gestion des livres
		if(e.getSource()==btnact){
				dispose();
				Abonne lv=new Abonne();
				lv.setVisible(true);	
			}
		//emprunt
		if(e.getSource()==btnactial){
			dispose();
			Acceuil ep=new Acceuil();
			ep.setVisible(true);	
		}
	}

}
