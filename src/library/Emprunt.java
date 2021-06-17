package library;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import conn.Connec;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.Console;
import java.sql.*;



public class Emprunt extends JFrame implements ActionListener {
	java.sql.Statement st;
	ResultSet rst;
	Connec cn=new Connec();
	JComboBox jcb,jcb2;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lbimg;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton jb,jb2,btabonn,btnlivre,btnactial;
	public Emprunt(){
		this.setTitle("Gestion de biblioteque");
		this.setSize(700,400);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(210,236,237));
		add(pn);
		//background image/////
		 lbimg=new JLabel("");
		 lbimg.setBounds(0,0,700,400);
		   Image phot=new ImageIcon(this.getClass().getResource("image//ban.jpg")).getImage();
		   Image poo5=phot.getScaledInstance(700, 400, java.awt.Image.SCALE_SMOOTH);
		   lbimg.setIcon(new ImageIcon(poo5));
		   pn.add(lbimg);
		
		//titre
		
		//label
		lb3=new JLabel("Emprunt des livres");
		lb3.setBounds(120,10,180,25);
		//lb3.setForeground(Color.blue);
		lb3.setFont(new Font("Arial",Font.BOLD,18));
		lbimg.add(lb3);
				
		
		//label
    	lb1=new JLabel("IdAbonné");
		lb1.setBounds(30,50,100,30);
		lbimg.add(lb1);
		
		tf1=new JTextField();
		tf1.setBounds(100,50,140,30);
		lbimg.add(tf1);
		//
		lb2=new JLabel("Nom");
		lb2.setBounds(30,90,100,30);
		lbimg.add(lb2);
		
		tf2=new JTextField();
		tf2.setBounds(100,90,140,30);
		lbimg.add(tf2);
		//
		lb2=new JLabel("Prenom");
		lb2.setBounds(30,130,100,30);
		lbimg.add(lb2);
		
		tf3=new JTextField();
		tf3.setBounds(100,130,140,30);
		lbimg.add(tf3);
		
		lb2=new JLabel("Liste de Livre");
		lb2.setBounds(280,60,130,25);
		lbimg.add(lb2);
		
		jcb=new JComboBox();
		jcb.setBounds(280,90,200,30);
		//*********liste de livre******/////
		String kk4="select titre from livre";
try{
	st=cn.connecion().createStatement();
	rst=st.executeQuery(kk4);
	while(rst.next()){
	jcb.addItem(rst.getString("titre"));

	}
}
catch(SQLException ex){
	
}
lbimg.add(jcb);
		
		//button
		jb=new JButton("Valider");
		jb.setBounds(100,170,100,25);
		jb.addActionListener(this);
		lbimg.add(jb);
		
		///bouton abonné//////////		  
		btabonn=new JButton("");
		btabonn.setBounds(80,250,100,50);
		   Image pho=new ImageIcon(this.getClass().getResource("image//5555.jpg")).getImage();
		   Image p=pho.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
		   btabonn.setIcon(new ImageIcon(p));
		   btabonn.addActionListener(this);
		   lbimg.add(btabonn);
		   
		//////******liver******////  
		   btnlivre=new JButton("");
		   btnlivre.setBounds(250,250,100,50);
		   Image photo=new ImageIcon(this.getClass().getResource("image//dictionary.jpg")).getImage();
		   Image poo=photo.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
		   btnlivre.setIcon(new ImageIcon(poo));
		   btnlivre.addActionListener(this);
		   lbimg.add(btnlivre);
		   
	 /////////acceuille********////////////
			btnactial=new JButton("");
			btnactial.setBounds(600,25,50,60);
			Image ph4=new ImageIcon(this.getClass().getResource("image//home.png")).getImage();
			  Image povo4=ph4.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
			  btnactial.setIcon(new ImageIcon(povo4));
			  lbimg.add(btnactial);
			btnactial.addActionListener(this);
			lbimg.add(btnactial);
	}

	public static void main(String[] args) {
		Emprunt ep=new Emprunt();
		ep.setVisible(true);

	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb){
			String a,b,c,d;
			a=tf1.getText();
			b=tf2.getText();
			c=tf3.getText();
			d=jcb.getSelectedItem().toString();
			String qre="update livre set disponible='NON',Idabonne='"+a+"' where titre='"+d+"'";
			
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"ajouter?",null,JOptionPane.
                        OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qre);
					JOptionPane.showMessageDialog(this,"validaton reussie!");


				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			}
		}
	
		//livres
		if(e.getSource()==btnlivre){
			dispose();
			Livree lv=new Livree();
			lv.setVisible(true);
			
		}
		//acceuil
		if(e.getSource()==btnactial){
			dispose();
			Acceuil acu=new Acceuil();
			acu.setVisible(true);
			
		}
		//
		if(e.getSource()==btabonn){
			dispose();
			Abonne ab=new Abonne();
			ab.setVisible(true);
			
		}
	}

}
