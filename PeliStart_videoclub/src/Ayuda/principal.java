package Ayuda;
import Ayuda.Help;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	public static JButton bto_ayuda = null;
	private JLabel jLabel = null;

	/**
	 * This method initializes bto_ayuda	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBto_ayuda() {
		if (bto_ayuda == null) {
			bto_ayuda = new JButton();
			bto_ayuda.setBounds(new Rectangle(147, 15, 86, 59));
			bto_ayuda.setIcon(new ImageIcon(getClass().getResource("/Ayuda/1344873626_system-help.png")));
			bto_ayuda.setContentAreaFilled(false);
			bto_ayuda.setBorderPainted(false);
			bto_ayuda.setToolTipText("AYUDA");
			bto_ayuda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Help ayuda=new Help();
					ayuda.setVisible(true);
				}
			});
		}
		return bto_ayuda;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				principal thisClass = new principal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public principal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(390, 508);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("JavaHelp--by javaface-elblogdelprogramador");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(88, 61, 210, 403));
			jLabel.setIcon(new ImageIcon(getClass().getResource("/Ayuda/13177815-hombre-de-negocios-levantando-la-mano--aislados-en-un-fondo-blanco.jpg")));
			jLabel.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.white);
			jContentPane.add(getBto_ayuda(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
