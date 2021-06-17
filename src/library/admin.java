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



public class admin extends JFrame implements ActionListener {
	JLabel lb1,lb2,lbtitre,lbimg;
	JTextField user,password;
	JButton btnlogin;
	 

public admin() {
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
	   Image phot8=new ImageIcon(this.getClass().getResource("image//bak2.jpg")).getImage();
	   Image poo5=phot8.getScaledInstance(700, 400, java.awt.Image.SCALE_SMOOTH);
	   lbimg.setIcon(new ImageIcon(poo5));
	   pn.add(lbimg);
	
 

	/* lbimg=new JLabel("");
	 lbimg.setBounds(0,0,700,350);
	   Image photo1=new ImageIcon(this.getClass().getResource("accueill11.png")).getImage();
	   Image poo=photo1.getScaledInstance(370, 350, java.awt.Image.SCALE_SMOOTH);
	   lbimg.setIcon(new ImageIcon(poo));
	   pn.add(lbimg);*/
	
	
	
	 ///////creation titer//////
    lbtitre=new JLabel("Login To Systeme");
    lbtitre.setBounds(220,40,300,30);
    lbtitre.setFont(new Font("Arial",Font.ITALIC,30));
    lbimg.add(lbtitre);
////////label
    lb1=new JLabel("");
	lb1.setBounds(240,110,55,40);
	Image phot=new ImageIcon(this.getClass().getResource("image//uss.png")).getImage();
	Image poo4=phot.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	lb1.setIcon(new ImageIcon(poo4));
	lbimg.add(lb1);
	
	user=new JTextField();
	user.setBounds(280,110,160,40);
	lbimg.add(user);
	///////////
	lb2=new JLabel("");
	lb2.setBounds(240,170,55,40);
	Image phot1=new ImageIcon(this.getClass().getResource("image//pass.png")).getImage();
	Image po=phot1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	lb2.setIcon(new ImageIcon(po));
	lbimg.add(lb2);
	
	password=new JPasswordField();
	password.setBounds(280,170,160,40);
	lbimg.add(password);
	//button//
	btnlogin=new JButton("");
	btnlogin.setBounds(310,230,105,30);
	Image phot2=new ImageIcon(this.getClass().getResource("image//log.png")).getImage();
	Image p1=phot2.getScaledInstance(122, 70, java.awt.Image.SCALE_SMOOTH);
	btnlogin.setIcon(new ImageIcon(p1));
	btnlogin.addActionListener(this);
	lbimg.add(btnlogin);
	
}


public static void main(String[] args) {
            admin ad=new admin();
            ad.setVisible(true);
}



public void actionPerformed(ActionEvent e) {
	//aller vers l'interface graphique de gestion des abonnés
   String name=user.getText();
   String pass=password.getText();
   if(name.equals("neji") & pass.equals("123456")) {
	
			dispose();
			Acceuil ac=new Acceuil();
		    ac.setVisible(true);
   }
		
		else {
			admin ad= new admin();
			JOptionPane.showMessageDialog(ad, "invalid login");
			
		}
			
		}
	
}




