package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import constants.Actions;
import constants.Directions;
import controller.Game;
import interfaces.ControllerInterface;

public class Frame extends JFrame {

	private JLabel boatLabel; 
	private JButton boatLeftButton;
	private JButton boatRightButton;
	private JLabel foxLabel; 
	private JButton foxLeftButton;
	private JButton foxRightButton;
	private JLabel gooseLabel; 
	private JButton gooseLeftButton;
	private JButton gooseRightButton;
	private JLabel beansLabel; 
	private JButton beansLeftButton;
	private JButton	beansRightButton;
	private JLabel farmerLabel; 
	private JButton farmerLeftButton;
	private JButton farmerRightButton;


	private JLabel beanImageLabel;

	private JLabel farmerImageLabel;
	private JLabel gooseImageLabel; 
	private JLabel foxImageLabel; 
	private ImagePanel pane1Right;
	private ImagePanel pane2Right;
	private ImagePanel pane3Right;
	private ImagePanel pane4Right;
	private ImagePanel pane1Left;
	private ImagePanel pane2Left;
	private ImagePanel pane3Left;
	private ImagePanel pane4Left;
	private JLabel shipLabel;
	private ImagePanel waterPaneRight;
	private ImagePanel waterPaneLeft;
	private ControllerInterface cInterface;
	private JPanel boatPanelRight = new JPanel(new GridLayout(2,1));
	private JPanel objectsInTheboat = new JPanel(new GridLayout(1,2));
	private Frame frame;
	//	private JPanel boatPanelLeft = new JPanel(new GridLayout(2,1));

	public JPanel getObjectsInTheboat() {
		return objectsInTheboat;
	}

	public Frame(ImageIcon farmerIcon,ImageIcon gooseIcon,ImageIcon beanIcon,ImageIcon foxIcon,ImageIcon shipIcon, Game game){
		cInterface = game;
		frame = this;


		try {


			BufferedImage grassImage = ImageIO.read(new File("src/grass.jpg"));
			ImageIcon grassIcon = new ImageIcon(grassImage);
			Image image = grassIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			grassIcon = new ImageIcon(newimg);  // transform it LeftButton

			new JLabel(grassIcon);


		} catch (IOException e) {
			e.printStackTrace();
		}
		beanImageLabel = new JLabel(beanIcon);
		farmerImageLabel = new JLabel(farmerIcon);
		gooseImageLabel = new JLabel(gooseIcon);
		foxImageLabel = new JLabel(foxIcon);
		shipLabel = new JLabel(shipIcon);

		boatLabel = new JLabel("Boat");
		foxLabel = new JLabel("Fox");
		gooseLabel = new JLabel("Goose");
		beansLabel = new JLabel("Beans");
		farmerLabel = new JLabel("Farmer");


		boatLeftButton = new JButton(" < ");
		boatRightButton = new JButton(" > ");

		foxLeftButton = new JButton(" < ");
		foxRightButton = new JButton(" > ");

		gooseLeftButton = new JButton(" < ");
		gooseRightButton = new JButton(" > ");

		beansLeftButton = new JButton(" < ");
		beansRightButton = new JButton(" > ");

		farmerLeftButton = new JButton(" < ");
		farmerRightButton = new JButton(" > ");

		setLayout(new BorderLayout());

		JPanel jpCenter = new JPanel();
		JPanel jpWest = new JPanel();
		JPanel jpEast = new JPanel();
		JPanel jpSouth = new JPanel();


		this.add(jpCenter, BorderLayout.CENTER);
		this.add(jpWest, BorderLayout.WEST);
		this.add(jpEast, BorderLayout.EAST);
		this.add(jpSouth, BorderLayout.SOUTH);




		jpSouth.setLayout(new GridLayout(1, 15));
		jpSouth.add(boatLabel);
		jpSouth.add(boatLeftButton);
		jpSouth.add(boatRightButton);
		jpSouth.add(foxLabel);
		jpSouth.add(foxLeftButton);
		jpSouth.add(foxRightButton);
		jpSouth.add(gooseLabel);
		jpSouth.add(gooseLeftButton);
		jpSouth.add(gooseRightButton);
		jpSouth.add(beansLabel);
		jpSouth.add(beansLeftButton);
		jpSouth.add(beansRightButton);
		jpSouth.add(farmerLabel);
		jpSouth.add(farmerLeftButton);
		jpSouth.add(farmerRightButton);

		try {
			BufferedImage grassImage = ImageIO.read(new File("src/grass.jpg"));
			pane1Right = new ImagePanel(grassImage);
			pane2Right = new ImagePanel(grassImage);
			pane3Right = new ImagePanel(grassImage);
			pane4Right = new ImagePanel(grassImage);
			pane1Left = new ImagePanel(grassImage);
			pane2Left = new ImagePanel(grassImage);
			pane3Left = new ImagePanel(grassImage);
			pane4Left = new ImagePanel(grassImage);
			BufferedImage waterImage = ImageIO.read(new File("src/water.jpg"));
			waterPaneRight = new ImagePanel(waterImage);
			waterPaneLeft = new ImagePanel(waterImage);
		} catch (IOException e) {
			e.printStackTrace();
		}


		boatPanelRight.add(shipLabel);

		boatPanelRight.add(objectsInTheboat);
		boatPanelRight.setOpaque(false);
		objectsInTheboat.setOpaque(false);

		waterPaneRight.add(boatPanelRight);

		beanImageLabel.setHorizontalAlignment(JLabel.CENTER);
		beanImageLabel.setVerticalAlignment(JLabel.CENTER);

		farmerImageLabel.setHorizontalAlignment(JLabel.CENTER);
		farmerImageLabel.setVerticalAlignment(JLabel.CENTER);

		gooseImageLabel.setHorizontalAlignment(JLabel.CENTER);
		gooseImageLabel.setVerticalAlignment(JLabel.CENTER);

		foxImageLabel.setHorizontalAlignment(JLabel.CENTER);
		foxImageLabel.setVerticalAlignment(JLabel.CENTER);

		beanImageLabel.setPreferredSize(new Dimension(250,250));
		farmerImageLabel.setPreferredSize(new Dimension(250,250));
		gooseImageLabel.setPreferredSize(new Dimension(250,250));
		foxImageLabel.setPreferredSize(new Dimension(250,250));


		pane1Right.add(beanImageLabel);
		pane2Right.add(farmerImageLabel);
		pane3Right.add(gooseImageLabel);
		pane4Right.add(foxImageLabel);

		pane1Left.setPreferredSize(new Dimension(250,250));
		pane2Left.setPreferredSize(new Dimension(250,250));
		pane3Left.setPreferredSize(new Dimension(250,250));
		pane4Left.setPreferredSize(new Dimension(250,250));

		pane1Right.setPreferredSize(new Dimension(250,250));
		pane2Right.setPreferredSize(new Dimension(250,250));
		pane3Right.setPreferredSize(new Dimension(250,250));
		pane4Right.setPreferredSize(new Dimension(250,250));

		jpEast.setLayout(new GridLayout(4,1));
		jpWest.setLayout(new GridLayout(4,1));
		jpEast.add(pane1Right);
		jpEast.add(pane2Right);
		jpEast.add(pane3Right);
		jpEast.add(pane4Right);

		jpWest.add(pane1Left);
		jpWest.add(pane2Left);
		jpWest.add(pane3Left);
		jpWest.add(pane4Left);

		jpCenter.setLayout(new GridLayout(1,2));		
		jpCenter.add(waterPaneLeft);
		jpCenter.add(waterPaneRight);
		// calling the cinterface for each movement
		boatLeftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cInterface.move(4, Directions.LEFT) == Actions.MOVED){
					waterPaneLeft.add(boatPanelRight);
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});
		boatRightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cInterface.move(4, Directions.RIGHT) == Actions.MOVED){
					waterPaneRight.add(boatPanelRight);
					SwingUtilities.updateComponentTreeUI(frame);
				}

			}
		});
		
		farmerLeftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cInterface.move(0, Directions.LEFT);
			}
		});
		farmerRightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(0, Directions.RIGHT);


			}
		});

		gooseLeftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(1, Directions.LEFT);

			}
		});
		gooseRightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(1, Directions.RIGHT);


			}
		});

		beansLeftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(2, Directions.LEFT);

			}
		});
		beansRightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(2, Directions.RIGHT);
			}
		});
		foxLeftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(3, Directions.LEFT);
			}
		});
		foxRightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cInterface.move(3,Directions.RIGHT);

			}
		});

		this.pack();
		this.setVisible(true);


	}

	public JLabel getBoatLabel() {
		return boatLabel;
	}

	public JButton getBoatLeftButton() {
		return boatLeftButton;
	}

	public JButton getBoatRightButton() {
		return boatRightButton;
	}

	public JLabel getFoxLabel() {
		return foxLabel;
	}

	public JButton getFoxLeftButton() {
		return foxLeftButton;
	}

	public JButton getFoxRightButton() {
		return foxRightButton;
	}

	public JLabel getGooseLabel() {
		return gooseLabel;
	}

	public JButton getGooseLeftButton() {
		return gooseLeftButton;
	}

	public JButton getGooseRightButton() {
		return gooseRightButton;
	}

	public JLabel getBeansLabel() {
		return beansLabel;
	}

	public JButton getBeansLeftButton() {
		return beansLeftButton;
	}

	public JButton getBeansRightButton() {
		return beansRightButton;
	}

	public JLabel getFarmerLabel() {
		return farmerLabel;
	}

	public JButton getFarmerLeftButton() {
		return farmerLeftButton;
	}

	public JButton getFarmerRightButton() {
		return farmerRightButton;
	}

	public JLabel getBeanImageLabel() {
		return beanImageLabel;
	}

	public JLabel getFarmerImageLabel() {
		return farmerImageLabel;
	}

	public JLabel getGooseImageLabel() {
		return gooseImageLabel;
	}

	public JLabel getFoxImageLabel() {
		return foxImageLabel;
	}

	public ImagePanel getPane1Right() {
		return pane1Right;
	}

	public ImagePanel getPane2Right() {
		return pane2Right;
	}

	public ImagePanel getPane3Right() {
		return pane3Right;
	}

	public ImagePanel getPane4Right() {
		return pane4Right;
	}

	public ImagePanel getPane1Left() {
		return pane1Left;
	}

	public ImagePanel getPane2Left() {
		return pane2Left;
	}

	public ImagePanel getPane3Left() {
		return pane3Left;
	}

	public ImagePanel getPane4Left() {
		return pane4Left;
	}

	public JLabel getShipLabel() {
		return shipLabel;
	}

	public ImagePanel getWaterPaneRight() {
		return waterPaneRight;
	}

	public ImagePanel getWaterPaneLeft() {
		return waterPaneLeft;
	}

	public ControllerInterface getcInterface() {
		return cInterface;
	}

	public JPanel getBoatPanelRight() {
		return boatPanelRight;
	}
	public void updateUI(){
		SwingUtilities.updateComponentTreeUI(frame);
	}

}

