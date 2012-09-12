package ihm.lib;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class Info extends JFrame{
	
	private JPanel container = null;//Déclaration de l’objet JPanel	
	private FlowLayout layout = null ;//Déclaration de notre layout
	public JLabel texte = new JLabel() ;
	
	public Info(){
		super();
		build();//On initialise notre fenêtre
	}
	
	private void build(){
		this.setContentPane(getContainer());//recupere le conteneur
		this.setTitle("Agents"); //On donne un titre à l’application
		this.setSize(400,100); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l’écran
		this.setResizable(false) ; //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //On dit à l’application de se fermer lors du clic sur la croix	
	}
	
	private JPanel getContainer(){
		layout = new FlowLayout(); //Instanciation du layout
		layout.setAlignment(FlowLayout.CENTER);//On centre les composants
		container = new JPanel() ; //On crée notre objet
		container.setLayout(layout); //On applique le layout.
		container.add(texte);//On l'ajoute au container
		return container ;
	}
	public void setTexte(String s){
		this.texte.setText(s);
	}
}