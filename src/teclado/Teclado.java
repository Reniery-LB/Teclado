package teclado;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Font;

public class Teclado implements KeyListener{

	private JFrame frame;
	private JLabel[] teclas;
	private JLabel esperando;
	private char[] letras = {
			'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
	        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ñ',
	        'Z', 'X', 'C', 'V', 'B', 'N', 'M'
	};
	
    private String[] palabras = {
            "java", "programa", "teclado", "computadora", "desarrollo", 
            "software", "hardware", "algoritmo", "variable", "funcion",
            "clase", "objeto", "metodo", "herencia", "polimorfismo",
            "interfaz", "abstracto", "paquete", "importar", "publico",
            "privado", "protegido", "estatico", "final", "void",
            "retorno", "cadena", "entero", "decimal", "booleano",
            "verdadero", "falso", "nulo", "arreglo", "matriz",
            "lista", "coleccion", "mapa", "conjunto", "iterador",
            "bucle", "condicion", "switch", "caso", "defecto",
            "excepcion", "error", "captura", "lanzar", "finally",
            "hilo", "proceso", "sincronizacion", "concurrente", "paralelo",
            "serial", "socket", "red", "protocolo", "http",
            "html", "css", "javascript", "xml", "json",
            "base", "datos", "consulta", "tabla", "registro",
            "campo", "clave", "foranea", "primaria", "indice",
            "transaccion", "commit", "rollback", "vista", "procedimiento",
            "funcion", "disparador", "backup", "restore", "seguridad",
            "usuario", "permiso", "rol", "auditoria", "encriptacion",
            "hash", "token", "sesion", "cookie", "cache"
        };
    
    private StringBuilder textoIngresado = new StringBuilder();
    private JLabel escribir;
    private JLabel time;
	private JLabel teclaActual = null;
	private int mil;
	private int seg = 0;
	Timer timer;
	private boolean juegoIniciado = false;
	private String palabraActual;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado window = new Teclado();
					window.frame.setVisible(true);
					window.frame.addKeyListener(window);
					String instrucciones = "INSTRUCCIONES:\n\n"
				            + "1. Se mostrará una palabra aleatoria\n"
				            + "2. Debes escribirla exactamente igual\n"
				            + "3. El temporizador comenzará al primer caracter\n"
				            + "4. Presiona ENTER cuando termines\n"
				            + "5. Verás tu tiempo y una nueva palabra aparecerá\n\n"
				            + "¡Buena suerte!";
					
					JOptionPane.showMessageDialog(window.frame, instrucciones,"Instrucciones del Juego", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Teclado() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Tecladito Mamalon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl_norte = new JPanel();
		pnl_norte.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(pnl_norte, BorderLayout.NORTH);
		pnl_norte.setLayout(null);
		pnl_norte.setLayout(new GridLayout(2, 1, 0, 0));
		pnl_norte.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		esperando = new JLabel("Esperando");
		esperando.setFont(new Font("Dialog", Font.BOLD, 40));
		esperando.setForeground(new Color(255, 255, 255));
		pnl_norte.add(esperando);
		
		time = new JLabel("0:0");
		time.setFont(new Font("Dialog", Font.BOLD, 40));
		time.setForeground(new Color(255, 255, 255));
		time.setHorizontalAlignment(JLabel.RIGHT);
		pnl_norte.add(time);
		
		escribir = new JLabel();
		escribir.setForeground(new Color(255, 255, 255));
		escribir.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_norte.add(escribir);
		
		JPanel pnl_teclado = new JPanel();
		pnl_teclado.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(pnl_teclado, BorderLayout.CENTER);
		pnl_teclado.setLayout(new GridLayout(3, 9, 0, 0));
		
		teclas = new JLabel[letras.length];
		
		for (int i = 0; i < letras.length; i++) {
			teclas[i] = new JLabel(String.valueOf(letras[i]));
			teclas[i].setHorizontalAlignment(JLabel.CENTER);
			teclas[i].setFont(new Font("Dialog", Font.BOLD, 14));
            teclas[i].setOpaque(true);
            teclas[i].setBackground(new Color(192,192,192));
            teclas[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            pnl_teclado.add(teclas[i]);
		}
		
		JPanel pnl_sur = new JPanel();
		pnl_sur.setBackground(new Color(0, 0, 160));
		frame.getContentPane().add(pnl_sur, BorderLayout.SOUTH);
		pnl_sur.setLayout(new GridLayout(1, 2, 20, 20));
		pnl_sur.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		
		JLabel borrando = new JLabel("BORRANDO");
		borrando.setForeground(new Color(255, 255, 255));
		borrando.setFont(new Font("Dialog", Font.BOLD, 40));
		borrando.setHorizontalAlignment(JLabel.CENTER);
		pnl_sur.add(borrando);
		
		JLabel espacio = new JLabel("ESPACIO");
		espacio.setForeground(new Color(255, 255, 255));
		espacio.setFont(new Font("Dialog", Font.BOLD, 40));
		espacio.setHorizontalAlignment(JLabel.CENTER);
		pnl_sur.add(espacio);
		
		Random randomNumbers = new Random();
		String palabraAleatoria = palabras[randomNumbers.nextInt(palabras.length)];
		escribir.setText("Palabra a escribir: " + palabraAleatoria);
		
			ActionListener taskPerfomer = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String [] split_string = time.getText().split(":");
					mil = Integer.parseInt(split_string[1]);
					
					mil +=1;
					
					if(mil >= 10) {
						seg++;
						mil = 1;
					}
					
					time.setText(seg+":"+mil+"");
				}
			
		};
		timer = new Timer(100, taskPerfomer);
	}
	
	private Color color_rand() {
		Random rand = new Random();
		return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	    	   if(textoIngresado.length() > 0) {
	    		   textoIngresado.deleteCharAt(textoIngresado.length() - 1);
	    		   esperando.setText(textoIngresado.toString());
	    	   }
	    	   return;
	     }
		 char teclaPresionada = Character.toUpperCase(e.getKeyChar());
		 
		 timer.start();
		 textoIngresado.append(e.getKeyChar());
		 esperando.setText(textoIngresado.toString());
		 	
	       for (int i = 0; i < letras.length; i++) {
	            if (letras[i] == teclaPresionada) {
	                if (teclaActual != null) {
	                    teclaActual.setBackground(new Color(192,192,192));
	                    
	                }
	      
	                teclaActual = teclas[i];
	                teclaActual.setBackground(color_rand());
	                break;
	            }
	        }
	       
	       if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	    	   timer.stop();
				String tiempoFinal = seg + ":" +  mil;
				JOptionPane.showMessageDialog(frame, 
	                    "¡Palabra completada correctamente!\nTiempo: " + tiempoFinal + " segundos\n\nPresiona OK para la siguiente palabra", 
	                    "¡Bien hecho!", JOptionPane.INFORMATION_MESSAGE);
				
				palabraActual = palabras[new Random().nextInt(palabras.length)];
				escribir.setText("Palabra a escribir: " + palabraActual);
				textoIngresado.setLength(0);
				esperando.setText("Esperando");
				time.setText("0:0");
				seg = 0;
				mil = 0;
	       }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
