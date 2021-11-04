package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GUI {

	private JPanel panelMenu;
	private JPanel panelJuego;
	private JLabel labels[][] = new JLabel[20][20];

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(0, 0, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
		
	    panelJuego = new Panel("/Images/fondoVampiros.jpg");
	    panelJuego.setBounds(0, 0, 1200, 720);
	    panelJuego.setVisible(false);
	    frame.getContentPane().add(panelJuego);
	    panelJuego.setLayout(null);
	    panelJuego.setVisible(false);
	
		panelMenu = new Panel("/Images/menu.png");
		panelMenu.setBounds(0, 0, 1200, 720);
		panelMenu.setVisible(true);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		
		JPanel grillaNivel1 = new Panel("/Images/nivelvampiro1.png");
		grillaNivel1.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel1);
		
		JPanel grillaNivel2 = new Panel("/Images/nivelvampiro2.png");
		grillaNivel1.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel2);
		
		JPanel grillaNivel3 = new Panel("/Images/nivelvampiro3.png");
		grillaNivel1.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel3);
		
		
		
		JButton btnJugarMetalero = new JButton("Jugar metal fight");
		btnJugarMetalero.setForeground(Color.RED);
		btnJugarMetalero.setBackground(Color.BLACK);
		btnJugarMetalero.setBounds(314, 238, 226, 58);
		panelMenu.add(btnJugarMetalero);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setForeground(Color.RED);
		btnAyuda.setBackground(Color.BLACK);
		btnAyuda.setBounds(406, 351, 226, 58);
		panelMenu.add(btnAyuda);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.RED);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setSelectedIcon(null);
		btnSalir.setBounds(406, 451, 226, 58);
		panelMenu.add(btnSalir);
		
		JButton btnJugarVampiros = new JButton("Jugar Jardin de sangre");
		btnJugarVampiros.setForeground(Color.RED);
		btnJugarVampiros.setBackground(Color.BLACK);
		btnJugarVampiros.setBounds(49, 238, 226, 58);
		panelMenu.add(btnJugarVampiros);
		
		JButton btnJugarSCP = new JButton("Jugar laboratorio SCP");
		btnJugarSCP.setForeground(Color.RED);
		btnJugarSCP.setBackground(Color.BLACK);
		btnJugarSCP.setBounds(581, 238, 226, 58);
		panelMenu.add(btnJugarSCP);
		
		JButton btnNivel1 = new JButton("Nivel 1");
		btnNivel1.setForeground(Color.RED);
		btnNivel1.setBackground(Color.BLACK);
		btnNivel1.setBounds(74, 237, 226, 58);
		panelJuego.add(btnNivel1);
		
		JButton btnNivel2 = new JButton("Nivel 2");
		btnNivel2.setForeground(Color.RED);
		btnNivel2.setBackground(Color.BLACK);
		btnNivel2.setBounds(72, 314, 226, 58);
		panelJuego.add(btnNivel2);
		
		JButton btnNivel3 = new JButton("Nivel 3");
		btnNivel3.setForeground(Color.RED);
		btnNivel3.setBackground(Color.BLACK);
		btnNivel3.setBounds(74, 410, 226, 58);
		panelJuego.add(btnNivel3);
		
		JButton btnVolverMenu = new JButton("Volver al menu");
		btnVolverMenu.setForeground(Color.WHITE);
		btnVolverMenu.setBackground(Color.BLACK);
		btnVolverMenu.setBounds(50, 100, 226, 58);
		panelJuego.add(btnVolverMenu);
		grillaNivel1.setLayout(null);
		

		
		//labels de la grilla
		
		for (int filas =0; filas < 20; filas++){
		for (int columna =0; columna < 20; columna++) {
			labels[filas][columna] = new JLabel("");
		    labels[filas][columna].setBounds(40+30*columna, 30+30*filas , 30, 30);
			grillaNivel1.add(labels[filas][columna]);
			labels[filas][columna].setVisible(true);
			labels[filas][columna].setIcon(new ImageIcon(GUI.class.getResource("/Images/dotVampiro.png")));
		}
		}
		
		
		// acciones botones
		
		btnJugarMetalero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((Panel) panelJuego).changeImage("/Images/fondoMetaleros.jpg");
				panelJuego.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		
		btnJugarVampiros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((Panel) panelJuego).changeImage("/Images/fondoVampiros.jpg");
				panelJuego.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		
		btnJugarSCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((Panel) panelJuego).changeImage("/Images/fondoSCP.jpg");
				panelJuego.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		
		btnVolverMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelJuego.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		
		btnNivel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(true);
				grillaNivel2.setVisible(false);
				grillaNivel3.setVisible(false);
				
			}
		});
		btnNivel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(true);
				grillaNivel3.setVisible(false);
			}
		});
		btnNivel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(false);
				grillaNivel3.setVisible(true);
			}
		});
	}
}
