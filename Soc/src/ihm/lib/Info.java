package ihm.lib;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class Info extends JFrame{
	
	private JPanel container = null;//D�claration de l�objet JPanel	
	private FlowLayout layout = null ;//D�claration de notre layout
	public JLabel texte = new JLabel() ;
	
	public Info(){
		super();
		build();//On initialise notre fen�tre
	}
	
	private void build(){
		this.setContentPane(getContainer());//recupere le conteneur
		this.setTitle("Agents"); //On donne un titre � l�application
		this.setSize(400,100); //On donne une taille � notre fen�tre
		this.setLocationRelativeTo(null); //On centre la fen�tre sur l��cran
		this.setResizable(false) ; //On interdit la redimensionnement de la fen�tre
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //On dit � l�application de se fermer lors du clic sur la croix	
	}
	
	private JPanel getContainer(){
		layout = new FlowLayout(); //Instanciation du layout
		layout.setAlignment(FlowLayout.CENTER);//On centre les composants
		container = new JPanel() ; //On cr�e notre objet
		container.setLayout(layout); //On applique le layout.
		container.add(texte);//On l'ajoute au container
		return container ;
	}
	public void setTexte(String s){
		this.texte.setText(s);
	}
}