package gui;

import java.awt.Color;
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

import logica.LogicaColisiones;
import logica.LogicaGeneral;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JPanel panelMenu;
	private JPanel panelJuego;
	private JFrame frame;
	private LogicaColisiones miLogicaColisiones;
	private LogicaGeneral miLogicaGeneral;
	private JLabel vida1;
	private JLabel vida2;
	private JLabel vida3;
	private JLabel lblPuntuacion;
	private JPanel grillaActual;

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
		miLogicaGeneral=new LogicaGeneral(this);
		miLogicaColisiones= new LogicaColisiones(this,miLogicaGeneral);
		miLogicaGeneral.setLogicaColisiones(miLogicaColisiones);
		
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
	    
<<<<<<< Updated upstream
	    this.miLogicaGeneral.ReproducirSonido("\\resources\\Musica\\pac-man-fever.wav");
=======
	    this.miLogicaGeneral.ReproducirSonido("/resources/Musica/Oh Klahoma 8bit.wav");
>>>>>>> Stashed changes
	
		panelMenu = new Panel("/Images/menu.png");
		panelMenu.setBounds(0, 0, 1200, 720);
		panelMenu.setVisible(true);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		
		
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
		
		
		JButton btnVolverMenu = new JButton("Volver al menu");
		btnVolverMenu.setForeground(Color.WHITE);
		btnVolverMenu.setBackground(Color.BLACK);
		btnVolverMenu.setBounds(50, 100, 226, 58);
		panelJuego.add(btnVolverMenu);
		
		vida1= new JLabel("");
		vida1.setBounds(25, 259, 64, 64);
		panelJuego.add(vida1);
		vida2= new JLabel("");
		vida2.setBounds(130, 259, 64, 64);
		panelJuego.add(vida2);
		vida3= new JLabel("");
		vida3.setBounds(240, 259, 64, 64);
		panelJuego.add(vida3);
		
		Font Chiller= new Font("Chiller", Font.BOLD | Font.ITALIC, 50);
		
		JLabel lblPuntuacionLetra = new JLabel("Puntuacion");
		lblPuntuacionLetra.setForeground(Color.RED);
		lblPuntuacionLetra.setFont(Chiller);
		lblPuntuacionLetra.setVerticalAlignment(SwingConstants.TOP);
		lblPuntuacionLetra.setBounds(31, 502, 340, 170);
		panelJuego.add(lblPuntuacionLetra);
		
		lblPuntuacion = new JLabel("0");
		lblPuntuacion.setFont(Chiller);
		lblPuntuacion.setForeground(Color.RED);
		lblPuntuacion.setVerticalAlignment(SwingConstants.TOP);
		lblPuntuacion.setBounds(72, 574, 259, 186);
		panelJuego.add(lblPuntuacion);
		
		JButton btnMusicaJuego = new JButton("");
		btnMusicaJuego.setForeground(Color.RED);
		btnMusicaJuego.setBackground(Color.BLACK);
		btnMusicaJuego.setBounds(1079, 574, 64, 58);
		panelJuego.add(btnMusicaJuego);
		
		JButton btnMusicaMenu = new JButton("");
		btnMusicaMenu.setForeground(Color.RED);
		btnMusicaMenu.setBackground(Color.BLACK);
		btnMusicaMenu.setBounds(1079, 574, 64, 58);
		panelMenu.add(btnMusicaMenu);
		
		
		
		
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
				miLogicaGeneral.setFabrica("vampiros");
				miLogicaGeneral.comenzarJuego();
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
				miLogicaGeneral.PararSonido();
				miLogicaGeneral.ReproducirSonido("\\resources\\Musica\\pac-man-fever.wav");
			}
			
		});
		
		btnMusicaJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(miLogicaGeneral.getBooleanMusica()==true) {
					miLogicaGeneral.PararSonido();
				}
				else
					miLogicaGeneral.ReproducirSonido(miLogicaGeneral.getFabrica().getMusica(miLogicaGeneral.getNivel()));
			}
		});
		
		btnMusicaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(miLogicaGeneral.getBooleanMusica()==true) {
					miLogicaGeneral.PararSonido();
				}
				else
					miLogicaGeneral.ReproducirSonido("\\resources\\Musica\\pac-man-fever.wav");
			}
		});
		
	
		frame.setFocusable(true);
		frame.addKeyListener(new KeyListener() {
	        public void keyPressed(KeyEvent e) {
	        	int presiona=e.getKeyCode();
	        	switch (presiona) 
	            {
	      	      case KeyEvent.VK_UP: {
                    miLogicaColisiones.moverPacman(new Point(0, -1));
                    frame.repaint();
                    break;
	      	      }
	      	      case KeyEvent.VK_LEFT:{
	      	    	miLogicaColisiones.moverPacman(new Point(-1, 0));
	      	    	frame.repaint();
	      	    	break;	
	      	      }	               
	    		  case KeyEvent.VK_RIGHT: {
	    			miLogicaColisiones.moverPacman(new Point(1, 0));
	    			frame.repaint();
			    	
	    			break;
		    	  }
		          case KeyEvent.VK_DOWN: {
		    		miLogicaColisiones.moverPacman(new Point(0, 1));
		    		frame.repaint();
		    		break;
		          }
		          case KeyEvent.VK_F: {
			    	miLogicaColisiones.activarBomba();
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


	public void addGrilla(JLabel imagen) {
		this.grillaActual.add(imagen);
		this.frame.repaint();
	}
	public void cambiarNivel(String fondito) {
		if(grillaActual!=null) {
			grillaActual.setVisible(false);		
		}
		grillaActual=new Panel(fondito);
		grillaActual.setVisible(true);
		grillaActual.setBounds(365, 10, 660, 660);
		panelJuego.add(grillaActual);
		grillaActual.setVisible(true);
		grillaActual.setLayout(null);
		this.actualizar();
		
	}
}
