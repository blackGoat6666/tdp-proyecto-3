package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logica.LogicaColisiones;
import logica.LogicaGeneral;
import ranking.Nombres;
import ranking.Ranking;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JPanel panelMenu;
	private JPanel panelJuego;
	private JPanel panelAyuda;
	private JFrame frame;
	private LogicaColisiones miLogicaColisiones;
	private LogicaGeneral miLogicaGeneral;
	private JLabel vida1;
	private JLabel vida2;
	private JLabel vida3;
	private JLabel lblPuntuacion;
	private JLabel puntajes[] = new JLabel[5];
	private JLabel puntajes2[] = new JLabel[5];
	private JPanel grillaActual;
	private JPanel panelPerdiste;
	private JPanel panelGanaste;
	private JButton btnMusicaJuego;
	private JButton btnMusicaMenu;
	
	private static Ranking ranking;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ranking =new Ranking();

        try {

            FileInputStream fileInputStream = new FileInputStream("./score.tdp");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.print("cargando...");
            ranking = (Ranking) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch(FileNotFoundException e) {

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
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
		btnMusicaMenu = new JButton("");
		btnMusicaMenu.setForeground(Color.RED);
		btnMusicaMenu.setBackground(Color.BLACK);
		btnMusicaMenu.setBounds(1079, 574, 64, 58);
		btnMusicaJuego = new JButton("");
		btnMusicaJuego.setForeground(Color.RED);
		btnMusicaJuego.setBackground(Color.BLACK);
		btnMusicaJuego.setBounds(1079, 574, 64, 58);
		miLogicaGeneral=new LogicaGeneral(this);
		this.miLogicaColisiones= this.miLogicaGeneral.getLogicaColisiones();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
	
	    Image icon = new ImageIcon(getClass().getResource("/Images/Icono.png")).getImage();
	    frame.setIconImage(icon);
	    frame.setTitle("Fifteen-Chan-Game");
	
	    panelJuego = new Panel("/Images/fondo.png");
	    panelJuego.setBounds(0, 0, 1200, 720);
	    panelJuego.setVisible(false);
	    frame.getContentPane().add(panelJuego);
	    panelJuego.setLayout(null);
	    panelJuego.setVisible(false);
	    
        this.miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Oh Klahoma 8bit.wav");

		panelMenu = new Panel("/Images/menu.png");
		panelMenu.setBounds(0, 0, 1200, 720);
		panelMenu.setVisible(true);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		panelAyuda = new Panel("/Images/ayuda.png");
		panelAyuda.setBounds(0, 0, 1200, 720);
		panelAyuda.setVisible(true);
		frame.getContentPane().add(panelAyuda);
		panelAyuda.setLayout(null);
		
		
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
		
		JLabel labelNombre = new JLabel("Nombre Jugador:");
        labelNombre.setForeground(Color.RED);
        labelNombre.setBackground(Color.BLACK);
        labelNombre.setBounds(360, 564, 120, 20);
        panelMenu.add(labelNombre);


        JTextField textField = new JTextField();
        textField.setBounds(477, 564, 86, 20);
        panelMenu.add(textField);
        textField.setColumns(10);
		
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
		btnVolverMenu.setForeground(Color.RED);
		btnVolverMenu.setBackground(Color.BLACK);
		btnVolverMenu.setBounds(50, 100, 226, 58);
		btnVolverMenu.setEnabled(false);
		panelJuego.add(btnVolverMenu);
		
		JButton btnVolverMenu2 = new JButton("Volver al menu");
		btnVolverMenu2.setForeground(Color.RED);
		btnVolverMenu2.setBackground(Color.BLACK);
		btnVolverMenu2.setBounds(50, 100, 226, 58);
		btnVolverMenu2.setEnabled(false);
		panelAyuda.add(btnVolverMenu2);
		
		vida1= new JLabel("");
		vida1.setBounds(25, 259, 64, 64);
		panelJuego.add(vida1);
		vida2= new JLabel("");
		vida2.setBounds(130, 259, 64, 64);
		panelJuego.add(vida2);
		vida3= new JLabel("");
		vida3.setBounds(240, 259, 64, 64);
		panelJuego.add(vida3);
		
		
		Font Chiller= new Font("Chiller", Font.BOLD | Font.ITALIC, 40);
		
		
		
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
		
		
		panelJuego.add(btnMusicaJuego);

		
		panelMenu.add(btnMusicaMenu);
		btnMusicaMenu.setIcon(new ImageIcon(GUI.class.getResource("/resources/Musica/musicola.png")));
		
		
		panelPerdiste = new Panel("/Images/fondo.png");
        panelPerdiste.setBounds(0, 0, 1200, 720);
        panelPerdiste.setVisible(false);
        frame.getContentPane().add(panelPerdiste);
        panelPerdiste.setLayout(null);
		
        JLabel lblPerdiste = new JLabel("PERDISTE");
        lblPerdiste.setFont(Chiller);
        lblPerdiste.setForeground(Color.RED);
        lblPerdiste.setVerticalAlignment(SwingConstants.TOP);
        lblPerdiste.setBounds(400, 80, 260, 65);
        panelPerdiste.add(lblPerdiste);
		
        panelGanaste = new Panel("/Images/fondo.png");
        panelGanaste.setBounds(0, 0, 1200, 720);
        panelGanaste.setVisible(false);
        frame.getContentPane().add(panelGanaste);
        panelGanaste.setLayout(null);
        
        for (int i = 0 ; i < 5; i++) {
			puntajes[i] = new JLabel("..............");
			puntajes[i].setBounds(200, 150+i*100, 700, 65);
			puntajes[i].setFont(Chiller);
			puntajes[i].setForeground(Color.RED);
			puntajes[i].setVerticalAlignment(SwingConstants.TOP);
			puntajes2[i] = new JLabel("..............");
			puntajes2[i].setBounds(200, 150+i*100, 700, 65);
			puntajes2[i].setFont(Chiller);
			puntajes2[i].setForeground(Color.RED);
			puntajes2[i].setVerticalAlignment(SwingConstants.TOP);
			panelPerdiste.add(puntajes[i]);
			panelGanaste.add(puntajes2[i]);
			
			
		}
		
		Chiller = new Font("Chiller", Font.BOLD | Font.ITALIC, 50);
		
		// acciones botones
		
        btnJugarMetalero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelJuego.setVisible(true);
                panelMenu.setVisible(false);
                miLogicaGeneral.setFabrica("metaleros");
                miLogicaGeneral.comenzarJuego(textField.getText());
            }
        });
        btnJugarVampiros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelJuego.setVisible(true);
                panelMenu.setVisible(false);
                miLogicaGeneral.setFabrica("vampiros");
                miLogicaGeneral.comenzarJuego(textField.getText());
            }
        });


        btnJugarSCP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelJuego.setVisible(true);
                panelMenu.setVisible(false);
                miLogicaGeneral.setFabrica("scp");
                miLogicaGeneral.comenzarJuego(textField.getText());
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
				panelAyuda.setVisible(false);
				btnVolverMenu.setEnabled(false);
				btnVolverMenu2.setEnabled(false);
				miLogicaGeneral.PararSonido();
				miLogicaGeneral.clean();
				miLogicaColisiones= miLogicaGeneral.getLogicaColisiones();
				miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Oh Klahoma 8bit.wav");
				
			}
			
		});
		
		btnVolverMenu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelJuego.setVisible(false);
				panelMenu.setVisible(true);
				panelAyuda.setVisible(false);
				btnVolverMenu.setEnabled(false);
				btnVolverMenu2.setEnabled(false);
				miLogicaGeneral.PararSonido();
				miLogicaGeneral.clean();
				miLogicaColisiones= miLogicaGeneral.getLogicaColisiones();
				miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Oh Klahoma 8bit.wav");
				
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
					miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Oh Klahoma 8bit.wav");
			}
		});
		
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelJuego.setVisible(false);
				panelMenu.setVisible(false);
				panelAyuda.setVisible(true);
				btnVolverMenu2.setEnabled(true);
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

	public void terminarJuego() {
        panelJuego.setVisible(false);
        panelMenu.setVisible(false);
        panelAyuda.setVisible(false);
        panelPerdiste.setVisible(true);
        this.miLogicaGeneral.PararSonido();
        this.miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Milk.wav");
        Nombres jugador= new Nombres(miLogicaGeneral.getPuntos(),miLogicaGeneral.getNombre());
        GUI.ranking.addRanking(jugador);
        GUI.ranking.printPlayers(puntajes);
        guardar();
		}
	
	public void ganaste() {
		panelJuego.setVisible(false);
        panelMenu.setVisible(false);
        panelAyuda.setVisible(false);
        panelGanaste.setVisible(true);
        this.miLogicaGeneral.PararSonido();
        this.miLogicaGeneral.ReproducirSonido("/src/resources/Musica/Coffee.wav");
        JLabel vampirito= new JLabel("");
        vampirito.setIcon(new ImageIcon(GUI.class.getResource("/resources/Vampiro/vampiro bomba adelante.gif")));
        vampirito.setBounds(460, 80, 100, 65);
        
        JLabel metalerito= new JLabel("");
        metalerito.setIcon(new ImageIcon(GUI.class.getResource("/resources/Metalero/metaleroBomba.gif")));
        metalerito.setBounds(540, 80, 100, 65);
        
        JLabel scpcito= new JLabel("");
        scpcito.setIcon(new ImageIcon(GUI.class.getResource("/resources/SCP/999bomba.gif")));
        scpcito.setBounds(620, 80, 100, 65);
        
        JLabel lblganaste = new JLabel("Ganaste");
        lblganaste.setForeground(Color.RED);
        lblganaste.setVerticalAlignment(SwingConstants.TOP);
        lblganaste.setBounds(200, 80, 260, 65);
        panelGanaste.add(lblganaste);
        panelGanaste.add(scpcito);
        panelGanaste.add(vampirito);
        panelGanaste.add(metalerito);
        frame.repaint();
        
	}
	
	public void setIconMusiquita(String imagen) {
		this.btnMusicaMenu.setIcon(new ImageIcon(GUI.class.getResource(imagen)));
		this.btnMusicaJuego.setIcon(new ImageIcon(GUI.class.getResource(imagen)));
	}
	
	private void guardar() {
        try {
            System.out.println("guardando...");
            FileOutputStream fileOutputStream = new FileOutputStream("./score.tdp");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(GUI.ranking);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
	
}
