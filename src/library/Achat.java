package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class Achat extends JFrame implements ActionListener {
	JLabel lb1,lb2,lbtitre,lbimg;
	JTextField user,password;
	JButton btnlivre,btnemprunt,btnlogin,btnactial;
	 

public Achat() {
	this.setTitle("Gestion de biblioteque");
	this.setSize(700,500);
	this.setLocationRelativeTo(null);
	JPanel pn=new JPanel();
	pn.setLayout(null);
	pn.setBackground(new Color(210,236,237));
	add(pn);
	
	//background image/////
	 lbimg=new JLabel("");
	 lbimg.setBounds(0,0,700,500);
	   Image phot=new ImageIcon(this.getClass().getResource("image//bak.jpg")).getImage();
	   Image poo5=phot.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
	   lbimg.setIcon(new ImageIcon(poo5));
	   pn.add(lbimg);

//titer

lbtitre=new JLabel("WELCOME !!!");
lbtitre.setBounds(10,150,500,30);
lbtitre.setForeground(new Color(0,0,0));
lbtitre.setFont(new Font("Arial",Font.BOLD,40));
lbimg.add(lbtitre);

//******liver******////setBounds(540,300,180,30);
lb1=new JLabel("Emprunter");
lb1.setBounds(340,300,180,30);
lb1.setFont(new Font("Arial",Font.BOLD,25));
lbimg.add(lb1);
btnlivre=new JButton("");
btnlivre.setBounds(305,130,150,150);
Image photo=new ImageIcon(this.getClass().getResource("image//acha.jpg")).getImage();
Image poo=photo.getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH);
btnlivre.setIcon(new ImageIcon(poo));
btnlivre.addActionListener(this);
lbimg.add(btnlivre);

//*****emprunt*****/////setBounds(510,130,150,150);
lb2=new JLabel("Retour");
lb2.setBounds(520,300,180,30);
lb2.setFont(new Font("Arial",Font.BOLD,25));
lbimg.add(lb2);
btnemprunt=new JButton("");
btnemprunt.setBounds(485,130,150,150);
Image photo1=new ImageIcon(this.getClass().getResource("image//rendre.png")).getImage();
Image poo1=photo1.getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH);
btnemprunt.setIcon(new ImageIcon(poo1));
btnemprunt.addActionListener(this);
lbimg.add(btnemprunt);

////////acceuille////////////
	btnactial=new JButton("");
	btnactial.setBounds(620,25,50,60);
	Image photo4=new ImageIcon(this.getClass().getResource("image//home.png")).getImage();
	  Image poo4=photo4.getScaledInstance(80, 70, java.awt.Image.SCALE_SMOOTH);
	  btnactial.setIcon(new ImageIcon(poo4));
	  lbimg.add(btnactial);
	btnactial.addActionListener(this);
	lbimg.add(btnactial);
	///////valide//////////
/*btnlogin=new JButton("");
btnlogin.setBounds(330,310,105,30);
Image phot2=new ImageIcon(this.getClass().getResource("log.png")).getImage();
Image p1=phot2.getScaledInstance(122, 70, java.awt.Image.SCALE_SMOOTH);
btnlogin.setIcon(new ImageIcon(p1));
btnlogin.addActionListener(this);
lbimg.add(btnlogin);*/
	
	
	
}

public static void main(String[] args) {
    Achat ach=new Achat();
    ach.setVisible(true);
}



public void actionPerformed(ActionEvent e) {
	
	//*****Liver********////
	if((e.getSource()==btnlivre)){
		
		dispose();
		Emprunt lv=new Emprunt();
		lv.setVisible(true);
		
	}
	
	//*****Emprunt******////
	if(e.getSource()==btnemprunt){
		dispose();
		Retour em=new Retour();
		em.setVisible(true);
		
	}
	//acceuil
	if(e.getSource()==btnactial){
		dispose();
		Acceuil ab=new Acceuil();
		ab.setVisible(true);
		
	}
}
}

