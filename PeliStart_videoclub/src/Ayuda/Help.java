package Ayuda;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.net.URL;

import javax.swing.JDialog;


public class Help extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	public static principal padre;
	

	/**
	 * @param owner
	 */
	public Help() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(0, 0);
		this.setTitle("ayuda");
		this.setModal(true);
		this.setLocation(-150,35);
		this.setContentPane(getJContentPane());
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
			}
		});
		
		/******************COLOCANDO JAVAHELP**************************/
			
				 DefaultHelpBroker help = new DefaultHelpBroker();
				 try {
					
				 File fichero = new File("help/help_set.hs");
				 URL hsURL = fichero.toURI().toURL();
				 help.setHelpSet(new HelpSet(getClass().getClassLoader(), hsURL));
				 help.initPresentation();
				 help.setActivationWindow(this);
				 help.setDisplayed(true);
				//-----------------CENTRO AL JAVAHELP-------------------------/
				 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();            
				 Point p = new Point((int)screenSize.getWidth()/4,(int)screenSize.getHeight()/4);
				 help.setLocation(p);
				 help.getWindowPresentation().getHelpWindow().addWindowListener(new java.awt.event.WindowAdapter() {
			          public void windowClosing(java.awt.event.WindowEvent e) {
			        	         //-----------cierro el dialog por defecto y listo
				                   dispose();
		              	}
	           	    });
		
				 } 
				 catch (Exception e) 
				 {
				    e.printStackTrace();
				 }
	
				

		
		/*******************************************/
		
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}
	
	

}
