package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Acceuil extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lbtitre,lbimg,lbimgg;
	JTextField Livre,Emprunt,Abonne;
	JButton btnlivre,btnemprunt,btnabonne,btdecnx;
	
public Acceuil() {
	this.setTitle("Gestion de biblioteque");
	this.setSize(800,490);
	this.setLocationRelativeTo(null);
	JPanel pn=new JPanel();
	JPanel pn1=new JPanel();
	pn.setLayout(null);
	pn.setBackground(new Color(210,236,237));
	add(pn);
	//background image/////
	 lbimg=new JLabel("");
	 lbimg.setBounds(0,0,800,490);
	   Image phot8=new ImageIcon(this.getClass().getResource("image//xxx.jpg")).getImage();
	   Image poo5=phot8.getScaledInstance(800, 490, java.awt.Image.SCALE_SMOOTH);
	   lbimg.setIcon(new ImageIcon(poo5));
	   pn.add(lbimg);
	
	
	
	
		/* lbimgg=new JLabel("");
		 lbimgg.setBounds(0,0,276,490);
		   Image phot=new ImageIcon(this.getClass().getResource("m2.jpg")).getImage();
		   lbimgg.setIcon(new ImageIcon(phot));
		   lbimg.add(lbimgg);*/
	
	//titer//////////	
	  /* lbimgg=new JLabel("");
		 lbimgg.setBounds(100,5,600,80);
		   Image pho1=new ImageIcon(this.getClass().getResource("image//an2.png")).getImage();
		   Image po1=pho1.getScaledInstance(600, 80, java.awt.Image.SCALE_SMOOTH);
		   lbimgg.setIcon(new ImageIcon(po1));
		   lbimg.add(lbimgg);*/
  lbtitre=new JLabel("WELCOME TO LIBRARY");
   lbtitre.setBounds(180,50,500,30);
   lbtitre.setForeground(new Color(0,0,0));
   lbtitre.setFont(new Font("Arial",Font.BOLD,40));
   lbimg.add(lbtitre);
   
   //******liver******////
   lb1=new JLabel("Livre");
   lb1.setBounds(350,300,180,30);
   lb1.setFont(new Font("Arial",Font.BOLD,25));
   lbimg.add(lb1);
   btnlivre=new JButton("");
   btnlivre.setBounds(310,130,150,150);
   Image photo=new ImageIcon(this.getClass().getResource("image//p1.jpg")).getImage();
   Image poo=photo.getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH);
   btnlivre.setIcon(new ImageIcon(poo));
   btnlivre.addActionListener(this);
   lbimg.add(btnlivre);
   
   //*****emprunt*****/////setBounds(510,130,150,150);
   lb2=new JLabel("Emprunt");
   lb2.setBounds(145,300,180,30);
   lb2.setFont(new Font("Arial",Font.BOLD,25));
   lbimg.add(lb2);
   btnemprunt=new JButton("");
   btnemprunt.setBounds(120,130,150,150);
   Image photo1=new ImageIcon(this.getClass().getResource("image//lec1.png")).getImage();
   Image poo1=photo1.getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH);
   btnemprunt.setIcon(new ImageIcon(poo1));
   btnemprunt.addActionListener(this);
   lbimg.add(btnemprunt);
   
   //****Abonne*******//////
   lb3=new JLabel("Abonne");
   lb3.setBounds(520,300,180,30);
   lb3.setFont(new Font("Arial",Font.BOLD,25));
   lbimg.add(lb3);
   btnabonne=new JButton("");
   btnabonne.setBounds(490,130,150,150);
   Image photo3=new ImageIcon(this.getClass().getResource("image//abb.png")).getImage();
  Image poo3=photo3.getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH);
  btnabonne.setIcon(new ImageIcon(poo3));
   btnabonne.addActionListener(this);
   lbimg.add(btnabonne);
   ////deconnexion////
   btdecnx=new JButton("");
   btdecnx.setBounds(700,380,50,50);
   btdecnx.addActionListener(this);
 
   Image photo4=new ImageIcon(this.getClass().getResource("image//aaaa.png")).getImage();
  Image poo4=photo4.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
  btdecnx.setIcon(new ImageIcon(poo4));
  lbimg.add(btdecnx);
}


public static void main(String[] args) {
    Acceuil ac=new Acceuil();
    ac.setVisible(true);
}



public void actionPerformed(ActionEvent e) {
	
	//*****Liver********////
	if(e.getSource()==btnlivre){
		dispose();
		Livree lv=new Livree();
		lv.setVisible(true);
		
	}
	//*****Emprunt******////
	if(e.getSource()==btnemprunt){
		dispose();
		Achat em=new Achat();
		em.setVisible(true);
		
	}
	//********abonne*****////
	if(e.getSource()==btnabonne){
		dispose();
		Abonne ab=new Abonne();
		ab.setVisible(true);
		
	}
	//////Dexonexion/////
	//********abonne*****////
	if(e.getSource()==btdecnx){
		dispose();
		admin ad=new admin();
		ad.setVisible(true);
		
	}
	
}

}




///******create par Beb Moussa Anwer***//////
