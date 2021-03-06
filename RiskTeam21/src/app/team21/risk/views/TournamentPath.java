package app.team21.risk.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.team21.risk.elements.Player;
import app.team21.risk.mapmodule.MapElements;
import app.team21.risk.mapmodule.MapLoader;

/**
 * Last Updated on: 26/11/2018, Monday
 * This class file handles tournament mode related activities.
 * 
 * @author Yash Sheth and Divyansh Thakar
 * @version 3.0.0
 */
public class TournamentPath {
	JPanel tournament_master_panel,player_maps_master_panel,player_type_panel,maps_panel,number_of_turn_panel,result_panel;
	JButton btn_map1,btn_map2,btn_map3,btn_map4,btn_map5,btn_start_game,btn_back,btn_home;
	JLabel lbl_number_of_turns,lbl_number_of_games,lbl_tournament_mode,lbl_result;
	JTextField tf_player1,tf_player2,tf_player3,tf_player4,tf_turn_value;
	JComboBox cb_player1,cb_player2,cb_player3,cb_player4,cb_games;
	String[] types = {"Aggressive","Benevolent","Random","Cheater"};
	String[] games = {"1","2","3","4","5"};
	JTextArea text_area_result= new JTextArea();
	String browse_file_path1="no_path",browse_file_path2="no_path",browse_file_path3="no_path",browse_file_path4="no_path",browse_file_path5="no_path";
	String file_path = "src/app/team21/risk/maps/";
	MapElements map_elements;
	List<MapElements> mapper=new ArrayList<MapElements>();
	List<String> map_names=new ArrayList<String>();
	JComboBox players;
	JScrollPane scroll_panel;
	public int no_players;
	List<Player> final_player_list=new ArrayList<Player>();

	/**
	 * This method will get final player list.
	 * 
	 * @return the final_player_list
	 */
	public List<Player> getFinalPlayerList() {
		return final_player_list;
	}

	/**
	 * This method will set final player list.
	 * 
	 * @param final_player_list the final_player_list to set
	 */
	public void setFinalPlayerList(List<Player> final_player_list) {
		this.final_player_list = final_player_list;
	}

	/**
	 * This method will ask about various tournament details.
	 */
	public void tournamentButton() {
		JPanel test = new JPanel();
		StartGame sg= new StartGame(); 

		test=sg.getPanel();

		tournament_master_panel = new JPanel();
		tournament_master_panel.setPreferredSize(new Dimension(600, 600));
		tournament_master_panel.setBorder(BorderFactory.createLineBorder(Color.black));

		player_maps_master_panel = new JPanel();
		player_maps_master_panel.setPreferredSize(new Dimension(600, 200));
		player_maps_master_panel.setBorder(BorderFactory.createLineBorder(Color.black));

		player_type_panel = new JPanel();
		player_type_panel.setPreferredSize(new Dimension(400, 190));
		player_type_panel.setBorder(BorderFactory.createLineBorder(Color.black));
		maps_panel = new JPanel();
		maps_panel.setPreferredSize(new Dimension(180, 190));
		maps_panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player_maps_master_panel.add(player_type_panel, BorderLayout.WEST);
		player_maps_master_panel.add(maps_panel, BorderLayout.EAST);

		number_of_turn_panel = new JPanel();
		number_of_turn_panel.setPreferredSize(new Dimension(600, 60));
		number_of_turn_panel.setBorder(BorderFactory.createLineBorder(Color.black));
		lbl_tournament_mode = new JLabel("Tournament Mode");

		result_panel=new JPanel();
		result_panel.setPreferredSize(new Dimension(600, 300));
		result_panel.setBorder(BorderFactory.createLineBorder(Color.black));
		lbl_result=new JLabel("Tournament Result");
		text_area_result.setPreferredSize(new Dimension(500, 250));
		text_area_result.setBorder(BorderFactory.createLineBorder(Color.black));
		text_area_result.setEditable(false);
		scroll_panel = new JScrollPane(text_area_result);
		scroll_panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll_panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		result_panel.add(lbl_result,BorderLayout.NORTH);
		result_panel.add(scroll_panel,BorderLayout.SOUTH);

		tournament_master_panel.add(lbl_tournament_mode, BorderLayout.PAGE_START);
		tournament_master_panel.add(player_maps_master_panel, BorderLayout.NORTH);
		tournament_master_panel.add(number_of_turn_panel, BorderLayout.CENTER);
		tournament_master_panel.add(result_panel, BorderLayout.SOUTH);

		tf_player1 = new JTextField("Player1 Name");
		tf_player2 = new JTextField("Player2 Name");
		tf_player3 = new JTextField("Player3 Name");
		tf_player4 = new JTextField("Player4 Name");

		cb_player1 = new JComboBox(types);
		cb_player2 = new JComboBox(types);
		cb_player3 = new JComboBox(types);
		cb_player4 = new JComboBox(types);

		no_players = Integer.valueOf(players.getSelectedItem().toString());
		if(no_players==2) {
			player_type_panel.add(tf_player1);
			player_type_panel.add(cb_player1);
			player_type_panel.add(tf_player2);
			player_type_panel.add(cb_player2);
		}
		else if(no_players==3) {
			player_type_panel.add(tf_player1);
			player_type_panel.add(cb_player1);
			player_type_panel.add(tf_player2);
			player_type_panel.add(cb_player2);
			player_type_panel.add(tf_player3);
			player_type_panel.add(cb_player3);
		}
		else if(no_players==4) {
			player_type_panel.add(tf_player1);
			player_type_panel.add(cb_player1);
			player_type_panel.add(tf_player2);
			player_type_panel.add(cb_player2);
			player_type_panel.add(tf_player3);
			player_type_panel.add(cb_player3);
			player_type_panel.add(tf_player4);
			player_type_panel.add(cb_player4);
		}


		btn_map1 = new JButton("Map 1");
		btn_map1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_chooser = new JFileChooser();

				file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // For Directory
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MAP file", "map");
				file_chooser.setFileFilter(filter);
				file_chooser.setAcceptAllFileFilterUsed(false);

				int bopen = file_chooser.showOpenDialog(null); //open the dialog box
				browse_file_path1=file_chooser.getSelectedFile().toString();

				map_elements=MapLoader.readMapFile(browse_file_path1);
				if(map_elements.isCorrectMap()){
					int index = browse_file_path1.lastIndexOf("\\");
					String file_name = browse_file_path1.substring(index + 1);
					System.out.println(file_name);
					map_names.add(file_name);
					mapper.add(map_elements);
				}

			}
		});
		btn_map2 = new JButton("Map 2");
		btn_map2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_chooser = new JFileChooser();

				file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // For Directory
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MAP file", "map");
				file_chooser.setFileFilter(filter);
				file_chooser.setAcceptAllFileFilterUsed(false);

				int bopen = file_chooser.showOpenDialog(null); //open the dialog box
				browse_file_path2=file_chooser.getSelectedFile().toString();
				map_elements=MapLoader.readMapFile(browse_file_path2);
				if(map_elements.isCorrectMap()){
					int index = browse_file_path2.lastIndexOf("\\");
					String file_name = browse_file_path2.substring(index + 1);
					System.out.println(file_name);
					map_names.add(file_name);
					mapper.add(map_elements);
				}
			}
		});
		btn_map3 = new JButton("Map 3");
		btn_map3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_chooser = new JFileChooser();

				file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // For Directory
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MAP file", "map");
				file_chooser.setFileFilter(filter);
				file_chooser.setAcceptAllFileFilterUsed(false);

				int bopen = file_chooser.showOpenDialog(null); //open the dialog box
				browse_file_path3=file_chooser.getSelectedFile().toString();
				map_elements=MapLoader.readMapFile(browse_file_path3);
				if(map_elements.isCorrectMap()){
					int index = browse_file_path3.lastIndexOf("\\");
					String file_name = browse_file_path3.substring(index + 1);
					System.out.println(file_name);
					map_names.add(file_name);
					mapper.add(map_elements);
				}
			}
		});
		btn_map4 = new JButton("Map 4");
		btn_map4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_chooser = new JFileChooser();

				file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // For Directory
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MAP file", "map");
				file_chooser.setFileFilter(filter);
				file_chooser.setAcceptAllFileFilterUsed(false);

				int bopen = file_chooser.showOpenDialog(null); //open the dialog box
				browse_file_path4=file_chooser.getSelectedFile().toString();
				map_elements=MapLoader.readMapFile(browse_file_path4);
				if(map_elements.isCorrectMap()){
					int index = browse_file_path4.lastIndexOf("\\");
					String file_name = browse_file_path4.substring(index + 1);
					System.out.println(file_name);
					map_names.add(file_name);
					mapper.add(map_elements);
				}
			}
		});
		btn_map5 = new JButton("Map 5");
		btn_map5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_chooser = new JFileChooser();

				file_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // For Directory
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MAP file", "map");
				file_chooser.setFileFilter(filter);
				file_chooser.setAcceptAllFileFilterUsed(false);

				int bopen = file_chooser.showOpenDialog(null); //open the dialog box
				browse_file_path5=file_chooser.getSelectedFile().toString();
				map_elements=MapLoader.readMapFile(browse_file_path5);
				if(map_elements.isCorrectMap()){
					int index = browse_file_path5.lastIndexOf("\\");
					String file_name = browse_file_path5.substring(index + 1);
					System.out.println(file_name);
					map_names.add(file_name);
					mapper.add(map_elements);
				}
			}
		});

		maps_panel.add(btn_map1);
		maps_panel.add(btn_map2);
		maps_panel.add(btn_map3);
		maps_panel.add(btn_map4);
		maps_panel.add(btn_map5);

		lbl_number_of_turns = new JLabel("Enter number of turns");
		tf_turn_value = new JTextField(10);
		lbl_number_of_games = new JLabel("Select number of games");
		cb_games = new JComboBox(games);
		btn_start_game = new JButton("Start game");


		number_of_turn_panel.add(lbl_number_of_turns);
		number_of_turn_panel.add(tf_turn_value);
		number_of_turn_panel.add(lbl_number_of_games);
		number_of_turn_panel.add(cb_games);
		number_of_turn_panel.add(btn_start_game);


		btn_start_game.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playTournament();
			}
		});

		JFrame jf = new JFrame();
		jf=(JFrame) sg.getFrame();
		jf.add(test);	
		jf.add(tournament_master_panel);
		btn_back = new JButton("Back");
		btn_home = new JButton("Home");
		jf.add(btn_back);
		btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sg.close();
				sg.createStartScreen();
			}
		});
		jf.add(btn_home);
		btn_home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sg.close();
				sg.createStartScreen();
			}
		});
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}
	/**
	 * This method will ask for number of players.
	 */
	public void selectPlayers(){
		JPanel test = new JPanel();
		StartGame sg= new StartGame();

		test=sg.getPanel();

		JLabel choose_number_of_player = new JLabel("Choose number of players :");
		JButton ok = new JButton("Ok");

		players = new JComboBox<Integer>();
		players.addItem("2");
		players.addItem("3");
		players.addItem("4");

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tournamentButton();

			}
		});

		test.add(choose_number_of_player);
		test.add(players);
		test.add(ok);
		JFrame jf = new JFrame();
		jf=(JFrame) sg.getFrame();
		jf.add(test);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	public void playTournament(){
		List<Player> player_list = new ArrayList<Player>();

		if(no_players==2) {

			String type=cb_player1.getSelectedItem().toString();
			Player p=new Player(tf_player1.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player2.getSelectedItem().toString();
			p=new Player(tf_player2.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

		}
		else if(no_players==3) {
			String type=cb_player1.getSelectedItem().toString();
			Player p=new Player(tf_player1.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player2.getSelectedItem().toString();
			p=new Player(tf_player2.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player3.getSelectedItem().toString();
			p=new Player(tf_player3.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

		}
		else if(no_players==4) {
			String type=cb_player1.getSelectedItem().toString();
			Player p=new Player(tf_player1.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player2.getSelectedItem().toString();
			p=new Player(tf_player2.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player3.getSelectedItem().toString();
			p=new Player(tf_player3.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

			type=cb_player4.getSelectedItem().toString();
			p=new Player(tf_player4.getText(),true,type.toLowerCase());
			p.setTournamentMode(true);
			p.turns=10;
			player_list.add(p);

		}else{
			System.out.println("INVALID");
		}
		setFinalPlayerList(player_list);

		int games=Integer.valueOf(cb_games.getSelectedItem().toString());
		String s=tf_turn_value.getText().toString();
		StringBuilder sb=new StringBuilder();
		
		sb.append("M: ");
		for(String me:map_names){
			sb.append(me+", ");
		}
		sb.append("\nP: ");
		for(Player p:player_list){
			sb.append(p.getBotType()+", ");
		}
		sb.append("\nG: "+games);
		sb.append("\nD: "+s);
		
		
		if(s != null && s.matches("^[0-9]*$")){
			int turns=Integer.valueOf(s);
			if(turns<=50 && turns>=10){
				for(int i=0;i<mapper.size();i++){
					sb.append("\n\n"+map_names.get(i));
					for(int j=1;j<=games;j++){
						sb.append("\nGAME "+j);
						for(Player p:getFinalPlayerList()){
							p.resetData(turns);
						}
						player_list=new ArrayList<Player>(getFinalPlayerList());
						MapElements map=mapper.get(i);
						GameScreen gs=new GameScreen();
						gs.tournament_mode=true;
						gs.playerContinueButton(map,player_list, 1);
						sb.append(" "+gs.result);
					}
				}
				text_area_result.setText("\n\n"+sb.toString());
				System.out.println(""+sb.toString());
			}
			else{
				text_area_result.setText("Invalid Number of turns");
			}
		}
		else{
			text_area_result.setText("Invalid Number of turns");
		}
	}
}
