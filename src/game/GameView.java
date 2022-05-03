/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

//All these imports are for the GUI
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;

/**
 * Game View is part of the MVC Design. It will create the GUI which will not only inform the Controller of 
 * any events, but it will also take direction from the Controller to display what the Model provides
 */
public class GameView extends JFrame {
	
	//Coordinates from clicking a cell on the table
	private int xCoordinate;
	private int yCoordinate;
	
	//These values are strictly for helping with placing the ships at the start
	private String orientation;
	private String shipType;
	
	//Tables to populate throughout the game
	private JTable shipPlacementTable;
	private JTable strikeHistoryTable;
	private JTable shipLocationTable;
	
	//Text Fields to get the names of the players during setup
	private JTextField player1TextField;
	private JTextField player2TextField;
	
	//Spinners to allow us to choose different ship types and orientations
	JSpinner shipTypeSpinner;
	JSpinner orientationSpinner;
	
	//Buttons
	private JButton setupButton;

	//Labels used during the setup of the ships
	JLabel currentPlayerLabel;
	JLabel carrierShipLabel;
	JLabel battleshipShipLabel;
	JLabel destroyerShipLabel;
	JLabel submarineLabel;
	JLabel errorLabel;
	
	//Other Labels
	private JTextField strikeMessageTextField;
	
	//The names of the two created Player Objects
	private String player1Name;
	private String player2Name;

	/**
	 * Constructor for our Class. Note that since we are extending JFrame this constructor
	 * will reflect all of the changes we made to our GUI. All of this code is critical to the GUI
	 * that drives our entire game. I tried to make it robust and informative to help guide the player
	 * during gameplay
	 */
	public GameView() {
		//Main JFrame Settings
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		
		/**
		 * All of the code below is for the selection of player name's as well as an outline of the rules for the game
		 */
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.BLACK);
		getContentPane().add(welcomePanel, "name_200566103698134");
		GridBagLayout gbl_welcomePanel = new GridBagLayout();
		gbl_welcomePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_welcomePanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_welcomePanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_welcomePanel.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		welcomePanel.setLayout(gbl_welcomePanel);
		
		JFormattedTextField frmtdtxtfldWelcomeToDigital = new JFormattedTextField();
		frmtdtxtfldWelcomeToDigital.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		frmtdtxtfldWelcomeToDigital.setBorder(null);
		frmtdtxtfldWelcomeToDigital.setEditable(false);
		frmtdtxtfldWelcomeToDigital.setForeground(Color.WHITE);
		frmtdtxtfldWelcomeToDigital.setBackground(Color.BLACK);
		frmtdtxtfldWelcomeToDigital.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldWelcomeToDigital.setText("Welcome to Digital Battleship!");
		GridBagConstraints gbc_frmtdtxtfldWelcomeToDigital = new GridBagConstraints();
		gbc_frmtdtxtfldWelcomeToDigital.insets = new Insets(0, 0, 5, 5);
		gbc_frmtdtxtfldWelcomeToDigital.gridx = 1;
		gbc_frmtdtxtfldWelcomeToDigital.gridy = 1;
		welcomePanel.add(frmtdtxtfldWelcomeToDigital, gbc_frmtdtxtfldWelcomeToDigital);
		
		JButton btnNewButton = new JButton("Start Game");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		welcomePanel.add(btnNewButton, gbc_btnNewButton);
		JPanel setupPanel = new JPanel();
		setupPanel.setBackground(Color.BLACK);
		setupPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		getContentPane().add(setupPanel, "name_137956129768271");
		GridBagLayout gbl_setupPanel = new GridBagLayout();
		gbl_setupPanel.columnWidths = new int[]{0, 0};
		gbl_setupPanel.rowHeights = new int[]{400, 0, 0, 0};
		gbl_setupPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_setupPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setupPanel.setLayout(gbl_setupPanel);
		
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setBackground(Color.BLACK);
		GridBagConstraints gbc_instructionsPanel = new GridBagConstraints();
		gbc_instructionsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_instructionsPanel.fill = GridBagConstraints.BOTH;
		gbc_instructionsPanel.gridx = 0;
		gbc_instructionsPanel.gridy = 0;
		setupPanel.add(instructionsPanel, gbc_instructionsPanel);
		GridBagLayout gbl_instructionsPanel = new GridBagLayout();
		gbl_instructionsPanel.columnWidths = new int[]{19, 375, -128, 0};
		gbl_instructionsPanel.rowHeights = new int[]{0, 0};
		gbl_instructionsPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_instructionsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		instructionsPanel.setLayout(gbl_instructionsPanel);
		
		JTextArea informationTextArea = new JTextArea();
		informationTextArea.setText("Battleship is a strategy type guessing game for two players. Each player has two boards. One board contains  the locations of the player's the fleet of ships and the other is used to keep track of strikes you have made against your opponent.\n\nThe objective of the game is to simply destroy the opposing player's fleet before they destroy yours. Players will alternate turns calling \"shots\" at the other player's ships, and after each attack, the boards of each player are updated to reflect the events of that turn. \n\nBefore play begins, each player secretly arranges their ships. Each ship occupies a number of consecutive squares on the grid, arranged either horizontally or vertically. The number of squares for each ship is outlined below. Note that the ships cannot overlap (i.e., only one ship can occupy any given square in the grid) and must be confined to the available space on your board. The types and numbers of ships allowed are the same for each player.\n\nIn this game you will have 4 ships:\n(1) Carrier - Occupies 5 Spaces\n(1) Battleship - Occupies 4 Spaces\n(1) Destroyer - Occupies 4 Spaces\n(1) Submarine - Occupies 3 Spaces\n\nGood luck and have fun! ");
		informationTextArea.setBackground(Color.BLACK);
		informationTextArea.setForeground(Color.WHITE);
		informationTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		informationTextArea.setBorder(null);
		informationTextArea.setWrapStyleWord(true);
		informationTextArea.setLineWrap(true);
		informationTextArea.setEditable(false);
		informationTextArea.setAutoscrolls(false);
		GridBagConstraints gbc_informationTextArea = new GridBagConstraints();
		gbc_informationTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_informationTextArea.fill = GridBagConstraints.BOTH;
		gbc_informationTextArea.gridx = 1;
		gbc_informationTextArea.gridy = 0;
		instructionsPanel.add(informationTextArea, gbc_informationTextArea);
		
		JPanel informationPanel = new JPanel();
		informationPanel.setBackground(Color.BLACK);
		informationPanel.setForeground(Color.BLACK);
		GridBagConstraints gbc_informationPanel = new GridBagConstraints();
		gbc_informationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_informationPanel.fill = GridBagConstraints.BOTH;
		gbc_informationPanel.gridx = 0;
		gbc_informationPanel.gridy = 1;
		setupPanel.add(informationPanel, gbc_informationPanel);
		GridBagLayout gbl_informationPanel = new GridBagLayout();
		gbl_informationPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_informationPanel.rowHeights = new int[]{0, 0, 0};
		gbl_informationPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_informationPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		informationPanel.setLayout(gbl_informationPanel);
		
		JLabel lblNewLabel = new JLabel("Player One Name:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		informationPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		player1TextField = new JTextField();
		GridBagConstraints gbc_player1TextField = new GridBagConstraints();
		gbc_player1TextField.insets = new Insets(0, 0, 5, 5);
		gbc_player1TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_player1TextField.gridx = 2;
		gbc_player1TextField.gridy = 0;
		informationPanel.add(player1TextField, gbc_player1TextField);
		player1TextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player Two Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		informationPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		player2TextField = new JTextField();
		GridBagConstraints gbc_player2TextField = new GridBagConstraints();
		gbc_player2TextField.insets = new Insets(0, 0, 0, 5);
		gbc_player2TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_player2TextField.gridx = 2;
		gbc_player2TextField.gridy = 1;
		informationPanel.add(player2TextField, gbc_player2TextField);
		player2TextField.setColumns(10);
		
		JPanel setupButtonPanel = new JPanel();
		setupButtonPanel.setBackground(Color.BLACK);
		GridBagConstraints gbc_setupButtonPanel = new GridBagConstraints();
		gbc_setupButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_setupButtonPanel.gridx = 0;
		gbc_setupButtonPanel.gridy = 2;
		setupPanel.add(setupButtonPanel, gbc_setupButtonPanel);
		GridBagLayout gbl_setupButtonPanel = new GridBagLayout();
		gbl_setupButtonPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_setupButtonPanel.rowHeights = new int[]{0, 0};
		gbl_setupButtonPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_setupButtonPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setupButtonPanel.setLayout(gbl_setupButtonPanel);
		
		setupButton = new JButton("Begin Setup");
		
		//Add Event Listener for clicking on a cell of the Table
		setupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				player1Name = player1TextField.getText();
				player2Name = player2TextField.getText();
			}
		});
		//End Event Listener
		
		GridBagConstraints gbc_setupButton = new GridBagConstraints();
		gbc_setupButton.insets = new Insets(0, 0, 0, 5);
		gbc_setupButton.gridx = 1;
		gbc_setupButton.gridy = 0;
		setupButtonPanel.add(setupButton, gbc_setupButton);
		
		
		
		
		
		/**
		 * All of the code below is for the portion of the game where each player is able to place their ships on the board
		 */
		JPanel shipPlacementPanel = new JPanel();
		shipPlacementPanel.setBackground(Color.WHITE);
		getContentPane().add(shipPlacementPanel, "name_145361543912693");
		GridBagLayout gbl_shipPlacementPanel = new GridBagLayout();
		gbl_shipPlacementPanel.columnWidths = new int[]{0, 0};
		gbl_shipPlacementPanel.rowHeights = new int[]{463, 0, 0, 0};
		gbl_shipPlacementPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_shipPlacementPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		shipPlacementPanel.setLayout(gbl_shipPlacementPanel);
		
		//Create a default for the table to use
		String[][] strikeHistoryTableDefault = {
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
		};
		
		//Create another default for the second table to use
		String[][] shipLocationTableDefault = {
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
				{new String(" "), new String(" "), new String(" "), new String(" "), new String(" "),
					new String(" "), new String(" "), new String(" "), new String(" "), new String(" ")
					}, 
		};
		
		//We want their to be headers and we are introducing a new table for to serve as headers for each row
		String[] numberColumnNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String[] letterColumnNames = {" "};
		String[][] letterTable = {{new String("A")}, {new String("B")}, {new String("C")}, {new String("D")}, {new String("E")}, {new String("F")}, {new String("G")}, {new String("H")}, {new String("I")}, {new String("J")}};
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		shipPlacementPanel.add(scrollPane, gbc_scrollPane);	
		shipPlacementTable = new JTable(shipLocationTableDefault, numberColumnNames);
		shipPlacementTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(shipPlacementTable);
		shipPlacementTable.setCellSelectionEnabled(true);
		shipPlacementTable.setBorder(new LineBorder(Color.BLACK));
		shipPlacementTable.setAutoCreateColumnsFromModel(false);
		shipPlacementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//This Mouse Event is used during the setting up of each ship
		shipPlacementTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Coordinates
				xCoordinate = shipPlacementTable.getSelectedColumn();
				yCoordinate = shipPlacementTable.getSelectedRow();
				
				//Ship Type
				shipType = (String)shipTypeSpinner.getValue();
				orientation = (String)orientationSpinner.getValue();
				
			}
		});
		//End of Event
		
		shipPlacementTable.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		shipPlacementTable.setGridColor(Color.BLACK);
		shipPlacementTable.setRowHeight(40);
		shipPlacementTable.setRowSelectionAllowed(false);
		shipPlacementTable.setColumnSelectionAllowed(false);
		shipPlacementTable.setAutoscrolls(false);
		
		JPanel placementOptionsPanel = new JPanel();
		placementOptionsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_placementOptionsPanel = new GridBagConstraints();
		gbc_placementOptionsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_placementOptionsPanel.fill = GridBagConstraints.BOTH;
		gbc_placementOptionsPanel.gridx = 0;
		gbc_placementOptionsPanel.gridy = 1;
		shipPlacementPanel.add(placementOptionsPanel, gbc_placementOptionsPanel);
		GridBagLayout gbl_placementOptionsPanel = new GridBagLayout();
		gbl_placementOptionsPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_placementOptionsPanel.rowHeights = new int[]{0, 0};
		gbl_placementOptionsPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_placementOptionsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		placementOptionsPanel.setLayout(gbl_placementOptionsPanel);
		
		JLabel shipOrientationLabel = new JLabel("Ship Orientation:");
		GridBagConstraints gbc_shipOrientationLabel = new GridBagConstraints();
		gbc_shipOrientationLabel.anchor = GridBagConstraints.EAST;
		gbc_shipOrientationLabel.insets = new Insets(0, 0, 0, 5);
		gbc_shipOrientationLabel.gridx = 0;
		gbc_shipOrientationLabel.gridy = 0;
		placementOptionsPanel.add(shipOrientationLabel, gbc_shipOrientationLabel);
		
		//Creating the preset values for our Spinner
		String[] orientations = {"North", "East", "South", "West"};
		SpinnerListModel orientationModel = new SpinnerListModel(orientations);
		orientationSpinner = new JSpinner(orientationModel);
		GridBagConstraints gbc_orientationSpinner = new GridBagConstraints();
		gbc_orientationSpinner.fill = GridBagConstraints.BOTH;
		gbc_orientationSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_orientationSpinner.gridx = 1;
		gbc_orientationSpinner.gridy = 0;
		placementOptionsPanel.add(orientationSpinner, gbc_orientationSpinner);
		
		JLabel shipTypeLabel = new JLabel("Ship Type:");
		GridBagConstraints gbc_shipTypeLabel = new GridBagConstraints();
		gbc_shipTypeLabel.anchor = GridBagConstraints.EAST;
		gbc_shipTypeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_shipTypeLabel.gridx = 2;
		gbc_shipTypeLabel.gridy = 0;
		placementOptionsPanel.add(shipTypeLabel, gbc_shipTypeLabel);
		
		//Creating the preset values for our Spinner
		String[] shipType = {"Carrier", "Battleship", "Destroyer", "Submarine"};
		SpinnerListModel shipTypeModel = new SpinnerListModel(shipType);
		shipTypeSpinner = new JSpinner(shipTypeModel);
		GridBagConstraints gbc_shipTypeSpinner = new GridBagConstraints();
		gbc_shipTypeSpinner.fill = GridBagConstraints.BOTH;
		gbc_shipTypeSpinner.gridx = 3;
		gbc_shipTypeSpinner.gridy = 0;
		placementOptionsPanel.add(shipTypeSpinner, gbc_shipTypeSpinner);
		
		JPanel labelsPanel = new JPanel();
		labelsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelsPanel = new GridBagConstraints();
		gbc_labelsPanel.fill = GridBagConstraints.BOTH;
		gbc_labelsPanel.gridx = 0;
		gbc_labelsPanel.gridy = 2;
		shipPlacementPanel.add(labelsPanel, gbc_labelsPanel);
		GridBagLayout gbl_labelsPanel = new GridBagLayout();
		gbl_labelsPanel.columnWidths = new int[]{0, 0};
		gbl_labelsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_labelsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_labelsPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		labelsPanel.setLayout(gbl_labelsPanel);
		
		currentPlayerLabel = new JLabel("Select you orientation and ship type, then click on one of the squares to place your ship!");
		GridBagConstraints gbc_currentPlayerLabel = new GridBagConstraints();
		gbc_currentPlayerLabel.insets = new Insets(0, 0, 5, 0);
		gbc_currentPlayerLabel.gridx = 0;
		gbc_currentPlayerLabel.gridy = 0;
		labelsPanel.add(currentPlayerLabel, gbc_currentPlayerLabel);
		
		carrierShipLabel = new JLabel("Carrier Ship Count: -");
		GridBagConstraints gbc_carrierShipLabel = new GridBagConstraints();
		gbc_carrierShipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_carrierShipLabel.gridx = 0;
		gbc_carrierShipLabel.gridy = 1;
		labelsPanel.add(carrierShipLabel, gbc_carrierShipLabel);
		
		battleshipShipLabel = new JLabel("Battleship Ship Count: -");
		GridBagConstraints gbc_battleshipShipLabel = new GridBagConstraints();
		gbc_battleshipShipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_battleshipShipLabel.gridx = 0;
		gbc_battleshipShipLabel.gridy = 2;
		labelsPanel.add(battleshipShipLabel, gbc_battleshipShipLabel);
		
		destroyerShipLabel = new JLabel("Destroyer Ship Count: -");
		GridBagConstraints gbc_destroyerShipLabel = new GridBagConstraints();
		gbc_destroyerShipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_destroyerShipLabel.gridx = 0;
		gbc_destroyerShipLabel.gridy = 3;
		labelsPanel.add(destroyerShipLabel, gbc_destroyerShipLabel);
		
		submarineLabel = new JLabel("Submarine Count: -");
		GridBagConstraints gbc_submarineLabel = new GridBagConstraints();
		gbc_submarineLabel.insets = new Insets(0, 0, 5, 0);
		gbc_submarineLabel.gridx = 0;
		gbc_submarineLabel.gridy = 4;
		labelsPanel.add(submarineLabel, gbc_submarineLabel);
		
		errorLabel = new JLabel("");
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.gridx = 0;
		gbc_errorLabel.gridy = 5;
		labelsPanel.add(errorLabel, gbc_errorLabel);
		
		
		
		
		
		/**
		 * All of the code below is for the portion of the game where each player is able to place their ships on the board
		 */
		JPanel gameplayPanel = new JPanel();
		gameplayPanel.setBackground(Color.WHITE);
		getContentPane().add(gameplayPanel, "name_128954067863682");
		GridBagLayout gbl_gameplayPanel = new GridBagLayout();
		gbl_gameplayPanel.columnWidths = new int[]{15, 0, 0, 0};
		gbl_gameplayPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_gameplayPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_gameplayPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gameplayPanel.setLayout(gbl_gameplayPanel);
		
		JTable strikeHistoryColumn = new JTable(letterTable, letterColumnNames);
		strikeHistoryColumn.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		strikeHistoryColumn.setBorder(new LineBorder(new Color(0, 0, 0)));
		strikeHistoryColumn.setRowSelectionAllowed(false);
		strikeHistoryColumn.setRowHeight(25);
		strikeHistoryColumn.setGridColor(Color.BLACK);
		strikeHistoryColumn.setAutoscrolls(false);
		strikeHistoryColumn.setAutoCreateColumnsFromModel(false);
		GridBagConstraints gbc_strikeHistoryColumn = new GridBagConstraints();
		gbc_strikeHistoryColumn.weightx = 0.015;
		gbc_strikeHistoryColumn.insets = new Insets(0, 0, 5, 5);
		gbc_strikeHistoryColumn.fill = GridBagConstraints.HORIZONTAL;
		gbc_strikeHistoryColumn.gridx = 0;
		gbc_strikeHistoryColumn.gridy = 0;
		gameplayPanel.add(strikeHistoryColumn, gbc_strikeHistoryColumn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		gameplayPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		strikeHistoryTable = new JTable(strikeHistoryTableDefault, numberColumnNames);
		strikeHistoryTable.setForeground(Color.RED);
		strikeHistoryTable.setSelectionBackground(Color.RED);
		strikeHistoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_1.setViewportView(strikeHistoryTable);
		
		//Add Event Listener for clicking on a cell of the Table
		strikeHistoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//When you clikc on the table it means you are trying to send an attack
				xCoordinate = strikeHistoryTable.getSelectedColumn();
				yCoordinate = strikeHistoryTable.getSelectedRow();
			}
		});
		//End of Event Listener
		
		strikeHistoryTable.setCellSelectionEnabled(true);
		strikeHistoryTable.setBorder(new LineBorder(Color.BLACK));
		strikeHistoryTable.setRowHeight(25);
		strikeHistoryTable.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		strikeHistoryTable.setAutoscrolls(false);
		strikeHistoryTable.setRowSelectionAllowed(false);
		strikeHistoryTable.setColumnSelectionAllowed(false);
		strikeHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		strikeHistoryTable.setGridColor(Color.RED);
		
		strikeMessageTextField = new JTextField();
		strikeMessageTextField.setHorizontalAlignment(SwingConstants.CENTER);
		strikeMessageTextField.setText("Please click on one of the squares above to launch an attack against your opponent!");
		strikeMessageTextField.setEditable(false);
		GridBagConstraints gbc_strikeMessageTextField = new GridBagConstraints();
		gbc_strikeMessageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_strikeMessageTextField.fill = GridBagConstraints.BOTH;
		gbc_strikeMessageTextField.gridx = 1;
		gbc_strikeMessageTextField.gridy = 1;
		gameplayPanel.add(strikeMessageTextField, gbc_strikeMessageTextField);
		strikeMessageTextField.setColumns(10);
		
		JTable shipLocationColumn = new JTable(letterTable, letterColumnNames);
		shipLocationColumn.setRowSelectionAllowed(false);
		shipLocationColumn.setRowHeight(25);
		shipLocationColumn.setGridColor(Color.BLACK);
		shipLocationColumn.setBorder(new LineBorder(new Color(0, 0, 0)));
		shipLocationColumn.setAutoscrolls(false);
		shipLocationColumn.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		shipLocationColumn.setAutoCreateColumnsFromModel(false);
		GridBagConstraints gbc_shipLocationColumn = new GridBagConstraints();
		gbc_shipLocationColumn.weightx = 0.015;
		gbc_shipLocationColumn.insets = new Insets(0, 0, 0, 5);
		gbc_shipLocationColumn.fill = GridBagConstraints.HORIZONTAL;
		gbc_shipLocationColumn.gridx = 0;
		gbc_shipLocationColumn.gridy = 2;
		gameplayPanel.add(shipLocationColumn, gbc_shipLocationColumn);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 2;
		gameplayPanel.add(scrollPane_2, gbc_scrollPane_2);
		
		shipLocationTable = new JTable(shipLocationTableDefault, numberColumnNames);
		shipLocationTable.setForeground(Color.WHITE);
		shipLocationTable.setSelectionBackground(Color.WHITE);
		shipLocationTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_2.setViewportView(shipLocationTable);
		shipLocationTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		shipLocationTable.setRowHeight(25);
		shipLocationTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		shipLocationTable.setAutoCreateColumnsFromModel(false);
		shipLocationTable.setAutoscrolls(false);
		shipLocationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shipLocationTable.setRowSelectionAllowed(false);
		shipLocationTable.setColumnSelectionAllowed(false);
		shipLocationTable.setGridColor(Color.BLUE);
		
		JPanel gameOverPanel = new JPanel();
		gameOverPanel.setBackground(Color.BLACK);
		getContentPane().add(gameOverPanel, "name_202757045339875");
		GridBagLayout gbl_gameOverPanel = new GridBagLayout();
		gbl_gameOverPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_gameOverPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_gameOverPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_gameOverPanel.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gameOverPanel.setLayout(gbl_gameOverPanel);
		
		JTextArea txtrGameOver = new JTextArea();
		txtrGameOver.setTabSize(9);
		txtrGameOver.setText("Game Over!");
		txtrGameOver.setWrapStyleWord(true);
		txtrGameOver.setLineWrap(true);
		txtrGameOver.setForeground(Color.WHITE);
		txtrGameOver.setEditable(false);
		txtrGameOver.setBackground(Color.BLACK);
		GridBagConstraints gbc_txtrGameOver = new GridBagConstraints();
		gbc_txtrGameOver.insets = new Insets(0, 0, 5, 5);
		gbc_txtrGameOver.fill = GridBagConstraints.BOTH;
		gbc_txtrGameOver.gridx = 1;
		gbc_txtrGameOver.gridy = 1;
		gameOverPanel.add(txtrGameOver, gbc_txtrGameOver);
	}
	
	/**
	 * Create the GUI for our game
	 */
	public void createGUI() {
		this.setTitle("Digital Battleship");
		this.setSize(650, 650);
		this.setVisible(true);
	}
	
	/**
	 * We want the Controller in our MVC to respond to button events
	 * @param listener - The object you want to listen to your event
	 */
	public void setActionListener(ActionListener listener) {
		//Button to setup the game
		setupButton.setActionCommand("SETUP");
		setupButton.addActionListener(listener);
	}
	
	/**
	 * We want the Controller in our MVC to respond to mouse events. Notice that we use
	 * .setName() to help the controller understand which event was triggered and what to do
	 * @param listener - The object you want to listen to your event
	 */
	public void setMouseListener(MouseListener listener) {
		//This table holds the active ships
		shipLocationTable.addMouseListener(listener);
		shipLocationTable.setName("Game Table");
		
		//This table allows you to place ships on the board
		shipPlacementTable.addMouseListener(listener);
		shipPlacementTable.setName("Placement Table");
	}
	
	/**
	 * Get the names that each Player entered during the setup/rules screen
	 * @return - An array of the strings of the players
	 */
	public String[] getPlayerNames() {
		return new String[]{this.player1Name, this.player2Name};
	}
	
	/**
	 * This method will advance you to the next card in the sequence.
	 * SHOULD ONLY BE USED BY EVENT HANDLERS!
	 */
	public void advanceCard() {
		//Advanced to the next card
		((CardLayout)getContentPane().getLayout()).next(getContentPane());
	}
	
	/**
	 * Get the cell coordinates that the player chose to strike
	 * @return - An array of the (X,Y) pair that the user clicked on
	 */
	public int[] getStrikeCoordinates(){
		return new int[]{this.xCoordinate, this.yCoordinate};
	}
	
	/**
	 * This method is used to ensure the ship table in the GUI is reflecting the correct information
	 * @param player - The player whose information we need to display
	 * @param shipPlacement - The array of valeus usedto update the table
	 */
	public void refreshShipBoard(Player player, int[][] shipPlacement) {
		
		JTable table = this.shipLocationTable;
		//Remember that the table is rows and columns
		for(int m = 0; m < table.getColumnCount(); m++) {
			for(int n = 0; n < table.getRowCount(); n++) {
				if(shipPlacement[m][n] == 0) {
					//Nothing on the board
					table.setValueAt(" ", m, n);
				}else if(shipPlacement[m][n] == 1) {
					//Your ship locations
					table.setValueAt("S", m, n);
				}else if(shipPlacement[m][n] == 2) {
					//Opponents Misses
					table.setValueAt("X", m, n);
				}else if(shipPlacement[m][n] == 3) {
					//Opponents HITS
					table.setValueAt("X", m, n);
				}
			}
		}
	}
	
	/**
	 * This method is used to ensure the strike table in the GUI is reflecting the correct information
	 * @param player - The player whose information we need to display
	 * @param shipPlacement - The array of valeus usedto update the table
	 */
	public void refreshStrikeBoard(Player player, int[][] strikeHistory, String message) {
		//Update the message box
		strikeMessageTextField.setText(message);
		
		JTable table = this.strikeHistoryTable;
		//Remember that the table is rows and columns
		for(int m = 0; m < table.getColumnCount(); m++) {
			for(int n = 0; n < table.getRowCount(); n++) {
				if(strikeHistory[m][n] == 0) {
					//Nothing on the board
					table.setValueAt(" ", m, n);
				}else if(strikeHistory[m][n] == 1) {
					//You hit a ship!
					table.setValueAt("X", m, n);
				}else if(strikeHistory[m][n] == 2) {
					//You missed!
					table.setValueAt("O", m, n);
				}
			}
		}
	}
	
	/**
	 * Get the orientation of the ship during placement
	 * @return - A string representing the orientation (North, East, South, West);
	 */
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Get the type of ship being placed down
	 * @return - A string representing the Ship Type (Carrier, Battleship, Destroyer, Submarine);
	 */
	public String getShipType() {
		return this.shipType;
	}
	
	/**
	 * This method is used to help setup the initial game. The same player will keep placing ships until they can't. Then
	 * the next player will follow suit until both players have fully placed their ships
	 * @param player - The player whose information we need to display
	 * @param shipPlacement - The array of values to update the table with
	 * @Param message - This is a message to inform the user of a successful or unsuccessful Ship Placement
	 * @return - A boolean indicating false until we get a null player which then returns TRUE
	 */
	public boolean placeShips(Player player, int[][] shipPlacements, String message) {
		
		//This means both players have placed all of their ships so advance to the next stage of the game
		if(player == null) {
			//Advanced to the next card
			this.advanceCard();
			return true;
		}else {
			//Update the game window to reflect the current players information
			this.currentPlayerLabel.setText(player.getName() + " has to place more ships!");
			this.carrierShipLabel.setText("Carrier Ship Count: " + player.getLocationBoard().getCarrierCount() + "/" + player.getLocationBoard().getCarrierLimit());
			this.battleshipShipLabel.setText("Battleship Ship Count: " + player.getLocationBoard().getBattleshipCount() + "/" + player.getLocationBoard().getBattleshipLimit());
			this.destroyerShipLabel.setText("Destroyer Ship Count: " + player.getLocationBoard().getDestroyerCount() + "/" + player.getLocationBoard().getDestroyerLimit());
			this.submarineLabel.setText("Submarine Count: " + player.getLocationBoard().getSubmarineCount() + "/" + player.getLocationBoard().getSubmarineLimit());
			this.errorLabel.setText(message);
		}
		
		//Update the table with the given nested array of Ship Placements so that the user knows where they have already placed their ships
		JTable table = this.shipPlacementTable;
		for(int m = 0; m < table.getRowCount(); m++) {
			for(int n = 0; n < table.getColumnCount(); n++) {
				if(shipPlacements[m][n] == 0) {
					//Nothing on the board
					table.setValueAt(" ", m, n);
				}else if(shipPlacements[m][n] == 1) {
					//Your ship locations
					table.setValueAt("S", m, n);
				}
			}
		}
		return false;
		
	}
	
}
