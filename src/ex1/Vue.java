package ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

@SuppressWarnings("deprecation")
public class Vue extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Modele m;
	private JLabel[][] tabG;
	private JLabel menu = new JLabel();
	private JLabel mag = new JLabel();
	private JLabel graine = new JLabel();
	private JLabel legume = new JLabel();
	private JLabel score = new JLabel();
	private JLabel argent = new JLabel();
	private JLabel date = new JLabel();
	private JLabel temp = new JLabel();
	private JLabel ensol = new JLabel();
	private JLabel humid = new JLabel();
	private JLabel invSal = new JLabel();
	private JLabel invCar = new JLabel();
	private JLabel invTom = new JLabel();
	private JLabel prixSal = new JLabel();
	private JLabel prixCar = new JLabel();
	private JLabel prixTom = new JLabel();
	private JLabel grSal = new JLabel();
	private JLabel grCar = new JLabel();
	private JLabel grTom = new JLabel();
	private JSlider speed = new JSlider(0,50);
	private ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
	
	
	
	private BufferedImage image;
	
	{
		try {
			image = ImageIO.read(new File("terre.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}
	
	BufferedImage terre = image; // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icTerre = new ImageIcon(terre.getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH)); 
	
	{
		try {
			image = ImageIO.read(new File("terreArrose.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}
	
	BufferedImage terreArr = image; // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icTerreArr = new ImageIcon(terreArr.getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH));

	{
		try {
			image = ImageIO.read(new File("terreHerbe.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}
	
	BufferedImage terreHer = image; // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)
	
	ImageIcon icTerreHer = new ImageIcon(terreHer.getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH));
	{
		try {
			image = ImageIO.read(new File("data.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}

	BufferedImage salade = image.getSubimage(0, 0, 150, 150); // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icSal = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	
	
	BufferedImage tomate = image.getSubimage(3120 , 1170, 150, 150); // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icTom = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	BufferedImage carotte = image.getSubimage(390 , 390 , 150, 150); // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icCar = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	


	
	
	public Vue(Modele m) {
		list.add(salade);
		list.add(carotte);
		list.add(tomate);
		this.m = m;
		tabG = new JLabel[m.getSize()][m.getSize()];
		setTitle("Potager");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		JPanel panelPrincipal = new JPanel();
		this.add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout());
		
		JPanel panelMenu = new JPanel();
		panelMenu.setSize(400,700);
		
		
		
		menu.setForeground(Color.BLACK);
		menu.setText("Menu principal : ");
		
		panelMenu.add(menu);
		
		JButton vid = new JButton("Tout récolter");
		panelMenu.add(vid);
		vid.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vider();
			}
		});
		
		JButton sal = new JButton("Salade");
		panelMenu.add(sal);
		sal.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(0);
			}
		});
		
		JButton car = new JButton("Carotte");
		panelMenu.add(car);
		car.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(1);
			}
		});
		
		JButton tom = new JButton("Tomate");
		panelMenu.add(tom);
		tom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(2);
			}
		});
		
		JPanel panelMag = new JPanel();
		panelMag.setSize(400,700);
		
		mag.setForeground(Color.BLACK);
		mag.setText("Magasin : ");
		
		panelMag.add(mag);
		
		argent.setForeground(Color.BLACK);
		argent.setText("Argent : 0 euro(s)");
		
		panelMag.add(argent);
		
		panelMag.add(legume);
		
		panelMag.add(invSal);
		panelMag.add(invCar);
		panelMag.add(invTom);
		
		JButton acSal = new JButton("Acheter une graine de salade");
		panelMag.add(acSal);
		acSal.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.acheter(0);
			}
		});
		
		JButton acCar = new JButton("Acheter une graine de carotte");
		panelMag.add(acCar);
		acCar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.acheter(1);
			}
		});
		JButton acTom = new JButton("Acheter une graine de tomate");
		panelMag.add(acTom);
		acTom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.acheter(2);
			}
		});
		
		JButton vdSal = new JButton("Vendre une salade");
		panelMag.add(vdSal);
		vdSal.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vendre(0);
			}
		});
		
		JButton vdCar = new JButton("Vendre une carotte");
		panelMag.add(vdCar);
		vdCar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vendre(1);
			}
		});
		JButton vdTom = new JButton("Vendre une tomate");
		panelMag.add(vdTom);
		vdTom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vendre(2);
			}
		});
		
		JButton vdTous = new JButton("Tout vendre");
        panelMag.add(vdTous);
        vdTous.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                m.vendreTous();
            }
        });
		
		
		score.setForeground(Color.BLACK);
		
	date.setForeground(Color.BLACK);
		
		panelMenu.add(score);
		
		panelMenu.add(date);
		
		graine.setText("Graines en stock : ");
		
		legume.setText("Légumes en stock : ");
		
		
		invSal.setForeground(Color.BLACK);
		invCar.setForeground(Color.BLACK);
		invTom.setForeground(Color.BLACK);
		graine.setForeground(Color.BLACK);
		legume.setForeground(Color.BLACK);
		grSal.setForeground(Color.BLACK);
		grCar.setForeground(Color.BLACK);
		grTom.setForeground(Color.BLACK);
		temp.setForeground(Color.BLACK);
		ensol.setForeground(Color.BLACK);
		humid.setForeground(Color.BLACK);
		speed.setBackground(Color.WHITE);
		panelMenu.add(graine);
		panelMenu.add(grSal);
		panelMenu.add(grCar);
		panelMenu.add(grTom);
		panelMenu.add(temp);
		panelMenu.add(ensol);
		panelMenu.add(humid);
		panelMag.add(prixSal);
		panelMag.add(prixCar);
		panelMag.add(prixTom);
		
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setVisible(true);
		
		panelMag.setBackground(Color.WHITE);
		panelMag.setVisible(true);
		
		panelMenu.add(speed);
		panelMenu.setLayout(new GridLayout(20,1, 20, 20));
		panelMag.setLayout(new GridLayout(20,1,20,20));
		panelPrincipal.add(panelMenu, BorderLayout.WEST);
		panelPrincipal.add(panelMag, BorderLayout.EAST);
		panelPrincipal.setVisible(true);
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(m.getSize(),m.getSize()));
		
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		
		
		
		

		JLabel a;
		
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				a = new JLabel(icTerre, JLabel.CENTER);
				a.setBackground(Color.WHITE);
				a.setBorder(BorderFactory.createLineBorder(Color.black));
				panelCentral.add(a);
				
				final int fi = i;
				final int fj = j;
				tabG[i][j] = a;
				tabG[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						m.maj(fi, fj);
					}
				});
			}
		}
		
		
		
		
		panelCentral.setVisible(true);
		
		
			
	}

	@Override
	public void update(Observable o, Object arg) {
		m.setSpeed(speed.getValue());
		argent.setText("Argent : "+m.getArg()+" euro(s)");
		temp.setText(m.getMet().getTemp());
		ensol.setText(m.getMet().getEnsol());
		humid.setText(m.getMet().getHumid());
		score.setText("Score : "+((Integer)(m.getNb()*10)).toString());
		date.setText("Date : "+m.getMet().getDate());
		invSal.setText("Salade : "+ m.getInv(0));
		invCar.setText("Carotte : "+ m.getInv(1));
		invTom.setText("Tomate : "+ m.getInv(2));
		grSal.setText("Salade : "+ m.getGr(0));
		grCar.setText("Carotte : "+ m.getGr(1));
		grTom.setText("Tomate : "+ m.getGr(2));
		prixSal.setText("Prix d'une salade : "+m.getMet().getPrix(0)+" euros");
		prixCar.setText("Prix d'une carotte : "+m.getMet().getPrix(1)+" euros");
		prixTom.setText("Prix d'une tomate : "+m.getMet().getPrix(2)+" euros");
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				for(int g =0; g<list.size(); g++) {
				if(m.getTab()[i][j].hasLegume()) {
					
					ImageIcon ic = new ImageIcon(list.get(m.getTab()[i][j].getLegume().getType()).getScaledInstance(Math.min(100,m.getTab()[i][j].getLegume().getTmp()+1), Math.min(100,m.getTab()[i][j].getLegume().getTmp()+1),java.awt.Image.SCALE_SMOOTH)); 
					tabG[i][j].setIcon(ic);
				}
				
				else {
					if(m.getTab()[i][j].getArr()) {
						tabG[i][j].setIcon(icTerreArr);
					}
					else {
						if(m.getTab()[i][j].getLab()) {
							tabG[i][j].setIcon(icTerre);
						}
						else {
							tabG[i][j].setIcon(icTerreHer);
						}
						
					}
					

				}
			}
		}
	}
}
}
