package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entidades.EntidadGrafica;
import entidades.EntidadGraficaDinamica;
import entidades.Personaje;
import fabricas.FabricaEntidades;
import fabricas.FabricaVampiro;
import logica.Logica;

import javax.swing.JLabel;

public class GUI {

	private JPanel panelMenu;
	private JPanel panelJuego;
	private JLabel labels[][] = new JLabel[20][20];
	private JLabel labels2[][] = new JLabel[20][20];
	private JLabel labels3[][] = new JLabel[20][20];
    private JLabel pacMan;
	private JFrame frame;
	private JPanel grillaNivel1;
	private JPanel grillaNivel2;
	private JPanel grillaNivel3;
	private Logica miLogica;
	private Thread sonido;
	private JLabel vida1;
	private JLabel vida2;
	private JLabel vida3;
	private JLabel lblPuntuacion;
	

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
		miLogica= new Logica(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
	    panelJuego = new Panel("/Images/fondo.png");
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
		
		
		grillaNivel1 = new Panel("/Images/nivelvampiro1.png");
		grillaNivel1.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel1);
		
		grillaNivel2 = new Panel("/Images/nivelvampiro2.png");
		grillaNivel2.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel2);
		grillaNivel2.setLayout(null);
		
		grillaNivel3 = new Panel("/Images/nivelvampiro3.png");
		grillaNivel3.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaNivel3);
		grillaNivel3.setLayout(null);
		
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
		
		JButton btnJugarMetalero = new JButton("Jugar metal fight");
		btnJugarMetalero.setForeground(Color.RED);
		btnJugarMetalero.setBackground(Color.BLACK);
		btnJugarMetalero.setBounds(314, 238, 226, 58);
		panelMenu.add(btnJugarMetalero);
		
		
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
		
		vida1= new JLabel("");
		vida1.setBounds(1066, 30, 64, 64);
		panelJuego.add(vida1);
		vida2= new JLabel("");
		vida2.setBounds(1066, 110, 64, 64);
		panelJuego.add(vida2);
		vida3= new JLabel("");
		vida3.setBounds(1066, 180, 64, 64);
		panelJuego.add(vida3);
		
		
		JLabel lblPuntuacionLetra = new JLabel("Puntuacion");
		lblPuntuacionLetra.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 70));
		lblPuntuacionLetra.setForeground(Color.RED);
		lblPuntuacionLetra.setVerticalAlignment(SwingConstants.TOP);
		lblPuntuacionLetra.setBounds(25, 500, 340, 170);
		panelJuego.add(lblPuntuacionLetra);
		
		lblPuntuacion = new JLabel("0");
		lblPuntuacion.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 70));
		lblPuntuacion.setForeground(Color.RED);
		lblPuntuacion.setVerticalAlignment(SwingConstants.TOP);
		lblPuntuacion.setBounds(72, 574, 259, 186);
		panelJuego.add(lblPuntuacion);
		
		
		
		// acciones botones
		
		btnJugarMetalero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelJuego.setVisible(true);
				panelMenu.setVisible(false);
				
			}
		});
		btnJugarVampiros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelJuego.setVisible(true);
				panelMenu.setVisible(false);
				miLogica.setFabrica("vampiros");
			}
		});
		
		
		btnJugarSCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				frame.repaint();
				miLogica.comenzarJuego();
			}
		});
		btnNivel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(true);
				grillaNivel3.setVisible(false);
				pacMan.setLocation(300, 345);
				grillaNivel2.add(pacMan);
			}
		});
		btnNivel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(false);
				grillaNivel3.setVisible(true);
				pacMan.setLocation(300, 345);
				grillaNivel3.add(pacMan);
			}
		});
		
		frame.setFocusable(true);
		frame.addKeyListener(new KeyListener() {
	        public void keyPressed(KeyEvent e) {
	        	int presiona=e.getKeyCode();
	        	switch (presiona) 
	            {
	      	      case KeyEvent.VK_UP: {
                    miLogica.moverPacman(new Point(0, -1));
                    frame.repaint();
                    break;
	      	      }
	      	      case KeyEvent.VK_LEFT:{
	      	    	miLogica.moverPacman(new Point(-1, 0));
	      	    	frame.repaint();
	      	    	break;	
	      	      }	               
	    		  case KeyEvent.VK_RIGHT: {
	    			miLogica.moverPacman(new Point(1, 0));
	    			frame.repaint();
			    	
	    			break;
		    	  }
		          case KeyEvent.VK_DOWN: {
		    		miLogica.moverPacman(new Point(0, 1));
		    		frame.repaint();
		    		break;
		    	  }
	           }
	    	 frame.repaint();
	        }
			public void keyReleased(KeyEvent e) {
			}
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
   }

public void setVida(int vida, String icono) {
	switch(vida) {
		case 1: vida1.setIcon(new ImageIcon(GUI.class.getResource(icono))); break;
		case 2: vida2.setIcon(new ImageIcon(GUI.class.getResource(icono)));break;
		case 3: vida3.setIcon(new ImageIcon(GUI.class.getResource(icono))); break;
	}
}


public void actualizarPuntos(int ptos) {
	lblPuntuacion.setText(String.valueOf(ptos));
}

public void actualizar() {
	frame.repaint();
}


public void addGrillaNivel1(JLabel imagen) {
	this.frame.getContentPane().add(imagen);
	this.grillaNivel1.add(imagen);
	this.frame.repaint();
	
}
}
