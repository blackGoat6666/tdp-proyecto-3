package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	private Point [] paredes = {new Point(1,1), new Point(2,1), new Point(3,1), new Point(4,1), new Point(1,2), new Point(2,2), new Point(3,2), new Point(4,2),new Point(5,4),new Point(14,4),
			new Point(5,5),new Point(14,5),new Point(5,7),new Point(14,7),
			new Point(15,1), new Point(16,1), new Point(17,1), new Point(18,1), new Point(15,2), new Point(16,2), new Point(17,2), new Point(18,2),
			new Point(0,4), new Point(1,4), new Point(2,4), new Point(3,4),  new Point(16,4), new Point(17,4), new Point(18,4), new Point(19,4),
			new Point(10,0),new Point(10,1), new Point(10,2),new Point(9,0),new Point(9,1), new Point(9,2),new Point(7,1),new Point(7,2), new Point(6,2),
			new Point(12,2),new Point(12,1),new Point(13,2),new Point(7,4),  new Point(8,4), new Point(9,4), new Point(10,4), new Point(11,4),new Point(12,4),
			new Point(9,5),new Point(9,6),new Point(12,2),new Point(12,1),new Point(1,18),new Point(2,18),new Point(3,18),new Point(4,18),new Point(5,18),new Point(6,18),
			new Point(7,18),new Point(9,18),new Point(11,18),new Point(12,18),new Point(13,18),new Point(14,18),new Point(15,18),new Point(16,18),new Point(17,18),new Point(18,18),
			new Point(1,6),new Point(2,6),new Point(3,6),new Point(4,6),new Point(5,6),new Point(6,6),new Point(7,6),new Point(18,6),new Point(17,6),new Point(16,6),new Point(15,6),new Point(14,6),
			new Point(12,6),new Point(13,6),
			new Point(0,8),new Point(1,8),new Point(2,8),new Point(3,8),new Point(5,8),new Point(7,8),new Point(8,8),new Point(9,8),new Point(10,8),new Point(11,8),new Point(12,8),
			new Point(14,8),new Point(16,8),new Point(17,8),new Point(18,8),new Point(19,8),new Point(0,9),new Point(1,9),new Point(2,9),new Point(3,9),new Point(7,9),new Point(8,9),new Point(9,9),new Point(10,9),new Point(11,9),new Point(12,9),
			new Point(16,9),new Point(17,9),new Point(18,9),new Point(19,9), new Point(0,11),new Point(1,11),new Point(2,11),new Point(3,11),new Point(5,10),new Point(7,10),new Point(8,10),new Point(9,10),new Point(10,10),new Point(11,10),new Point(12,10),
			new Point(14,10),new Point(14,11),new Point(5,11),new Point(16,11),new Point(17,11),new Point(18,11),new Point(19,11),
			new Point(0,12),new Point(1,12),new Point(2,12),new Point(3,12),new Point(5,12),new Point(7,12),new Point(8,12),new Point(9,12),new Point(10,12),new Point(11,12),new Point(12,12),
			new Point(14,12),new Point(16,12),new Point(17,12),new Point(18,12),new Point(19,12),new Point(10,13),new Point(10,14),
			new Point(7,14),new Point(6,14),new Point(5,14),new Point(3,14),new Point(2,14),new Point(1,14),new Point(12,14),new Point(13,14),new Point(14,14),new Point(16,14),new Point(17,14),new Point(18,14),new Point(3,15),new Point(16,15),
			new Point(0,16),new Point(1,16),new Point(3,16),new Point(5,16),new Point(7,16),new Point(8,16),new Point(9,16),new Point(10,16),new Point(11,16),new Point(12,16),new Point(14,16),new Point(16,16),new Point(18,16),new Point(19,16),
			new Point(5,17),new Point(9,17),new Point(14,17)};

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
		for (int i = 0; i<paredes.length; i++) {
			labels[(int) paredes[i].getY()][(int) paredes[i].getX()].setVisible(false);
		}
		labels[0][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels[0][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels[19][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels[19][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		
		for (int filas =0; filas < 20; filas++){
			for (int columna =0; columna < 20; columna++) {
				labels2[filas][columna] = new JLabel("");
			    labels2[filas][columna].setBounds(40+30*columna, 30+30*filas , 30, 30);
				grillaNivel2.add(labels2[filas][columna]);
				labels2[filas][columna].setVisible(true);
				labels2[filas][columna].setIcon(new ImageIcon(GUI.class.getResource("/Images/dotVampiro.png")));
			}
		}
		for (int i = 0; i<paredes.length; i++) {
			labels2[(int) paredes[i].getY()][(int) paredes[i].getX()].setVisible(false);
		}

		labels2[0][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels2[0][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels2[19][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels2[19][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		for (int filas =0; filas < 20; filas++){
			for (int columna =0; columna < 20; columna++) {
				labels3[filas][columna] = new JLabel("");
			    labels3[filas][columna].setBounds(40+30*columna, 30+30*filas , 30, 30);
				grillaNivel3.add(labels3[filas][columna]);
				labels3[filas][columna].setVisible(true);
				labels3[filas][columna].setIcon(new ImageIcon(GUI.class.getResource("/Images/dotVampiro.png")));
			}
		}
		for (int i = 0; i<paredes.length; i++) {
				labels3[(int) paredes[i].getY()][(int) paredes[i].getX()].setVisible(false);
		}
		
		labels3[0][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels3[0][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels3[19][0].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		labels3[19][19].setIcon(new ImageIcon(GUI.class.getResource("/Images/ppVampiro.png")));
		
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
				miLogica= new Logica(this, "vampiros");
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
		FabricaVampiro vampiro= new FabricaVampiro();
		miLogica= new Logica(vampiro, null, null);
		pacMan= vampiro.getPacman();
		pacMan.setBounds(308, 360, 60, 60);
		frame.setFocusable(true);
		grillaNivel1.add(pacMan);
		
		btnNivel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(true);
				grillaNivel2.setVisible(false);
				grillaNivel3.setVisible(false);
				pacMan.setLocation(308,369);
				grillaNivel1.add(pacMan);
			}
		});
		btnNivel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(true);
				grillaNivel3.setVisible(false);
				pacMan.setLocation(308,369);
				grillaNivel2.add(pacMan);
			}
		});
		btnNivel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grillaNivel1.setVisible(false);
				grillaNivel2.setVisible(false);
				grillaNivel3.setVisible(true);
				pacMan.setLocation(308,369);
				grillaNivel3.add(pacMan);
			}
		});
		frame.addKeyListener(new KeyListener() {
	        public void keyPressed(KeyEvent e) {
	        	int presiona=e.getKeyCode();
	        	Point posicion = pacMan.getLocation();	
	    		int movimiento = 4;
	    		switch (presiona) 
	            {
	      	      case KeyEvent.VK_UP: {
                    if(posicion.y>=35) {
                      int ubicacion = posicion.y - movimiento;
  	      	          posicion.setLocation(posicion.x, ubicacion);
  	      	          pacMan.setLocation(posicion);
	      	    	}
                    break;
	      	      }
	      	      case KeyEvent.VK_LEFT:{
	      	    	if(posicion.x>=25) {
	      	    	  int ubicacion = posicion.x - movimiento;
			    	  posicion.setLocation(ubicacion, posicion.y);
			    	  pacMan.setLocation(posicion);
			    	}
	      	        break;	
	      	      }	               
	    		  case KeyEvent.VK_RIGHT: {
	    			if(posicion.x<=585)  {
			    	  int ubicacion = posicion.x +movimiento;
			    	  posicion.setLocation(ubicacion, posicion.y);
			    	  pacMan.setLocation(posicion);
			    	}
	    			break;
		    	  }
		          case KeyEvent.VK_DOWN: {
		    		if(posicion.y<=605){
		        	  int ubicacion = posicion.y + movimiento;
		    		  posicion.setLocation(posicion.x, ubicacion);
		    		  pacMan.setLocation(posicion);
		    		}
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
		case 1: vida1.setIcon(icono); break;
		case 2:  vida2.setIcon(icono);break;
		case 3:  vida3.setIcon(icono); break;
	}
}

public void actualizar() {
	this.repaint();
	
}
}
