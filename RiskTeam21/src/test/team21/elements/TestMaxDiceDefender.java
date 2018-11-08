/**
 * 
 */
package test.team21.elements;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.team21.risk.elements.Dice;
import app.team21.risk.elements.Player;
import app.team21.risk.gamemodule.GamePlay;
import app.team21.risk.mapmodule.MapElements;
import app.team21.risk.mapmodule.MapLoader;
import app.team21.risk.views.GameScreen;


/**
 * @author Yash Sheth
 *
 */
public class TestMaxDiceDefender {
	private MapElements elements;
    private MapLoader loader;
    private GamePlay game_play;
    private GameScreen game_view;
    Player player1,player2; 
    String file_path="C:/Users/yashe/OneDrive/Documents/GitHub/RiskTeam21/RiskTeam21/src/app/team21/risk/maps/India.map";
    
    @Before
    public void init() {
    	loader = new MapLoader();
    	elements = loader.readMapFile(file_path);
    	
    	player1 = new Player("Player 1");
    	player2 = new Player("Player 2");
    	
    	game_play = new GamePlay();
    	game_view = new GameScreen();
    	game_view.map_elements=elements;
    	List<Player> player_list=new ArrayList<>();
    	player_list.add(player1);
    	player_list.add(player2);
    	
		game_play.distributeCountries(player_list, elements.getCountries());
		game_play.setInitialArmies(player_list);
		game_play.placeInitialArmiesInRR(player_list);
		
    }
    
    @Test
    public void testMaxDiceDefender(){
    	player1.getAssignedCountries().get(0).setCurrentArmiesDeployed(1);
    	int result=player1.getMaxDiceDefender(player1.getAssignedCountries().get(0));
    	assertEquals(1,result);
    	
    	player1.getAssignedCountries().get(0).setCurrentArmiesDeployed(2);
    	result=player1.getMaxDiceDefender(player1.getAssignedCountries().get(0));
    	assertEquals(2,result);
    }
    

}