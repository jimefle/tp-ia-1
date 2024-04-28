package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongAgentState extends SearchBasedAgentState {
	
	
	public static final String ONE = "Reactor";
    public static final String TWO = "Upper Engine";
    public static final String THREE = "Lower Engine";
    public static final String FOUR = "Security";
    public static final String FIVE = "Medbay";
    public static final String SIX = "Electrical";
    public static final String SEVEN = "Cafeteria";
    public static final String EIGHT = "Storage";
    public static final String NINE = "Weapons";
    public static final String TEN = "Admin";
    public static final String ELEVEN = "Communication";
    public static final String TWELVE = "Shields";
    public static final String THIRTEEN = "02";
    public static final String FOURTEEN = "Navigation";
	
	private int[][] airship;
	String position;
	private int energy;
	
	private HashMap<String, Collection<String>> movements;
	
	public AmongAgentState(int[][] m, String start_position, int start_energy) {
        airship = m;
        position = start_position;
        energy = start_energy;
    }

    public AmongAgentState() {
        airship = new int[15][3];
        energy = 0;
        this.initState();
    }
    
    @Override
    public SearchBasedAgentState clone() {
        int[][] newAirship = new int[15][3];

        for (int row = 0; row < airship.length; row++) {
            for (int col = 0; col < airship.length; col++) {
                newAirship[row][col] = airship[row][col];
            }
        }
        
        //String newPosition = position;

        AmongAgentState newState = new AmongAgentState(newAirship, this.getPosition(), this.energy);

        return newState;
    }
    
    
    @Override
    public void initState() {
        position = ONE;
        
        String[][] positions = new String[][]{
            {ONE, TWO,THREE, FOUR},
            {TWO, ONE, THREE, FOUR, FIVE, SEVEN},
            {THREE, ONE, TWO, FOUR, SIX, EIGHT},
            {FOUR, TWO, THREE},
            {FIVE, TWO, SEVEN},
            {SIX, THREE, EIGHT},
            {SEVEN, TWO, NINE, FIVE},
            {EIGHT, TEN, SIX, THREE, ELEVEN, TWELVE},
            {NINE, SEVEN, THIRTEEN, FOURTEEN, ELEVEN},
            {TEN, SEVEN, EIGHT},
            {ELEVEN, EIGHT, TWELVE},
            {TWELVE, THIRTEEN, NINE, FOURTEEN},
            {THIRTEEN, NINE, TWELVE, FOURTEEN},
            {FOURTEEN, NINE, THIRTEEN, TWELVE}
        };

        movements = new HashMap<String, Collection<String>>();
        for (int i = 0; i < positions.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < positions[i].length; j++) {
                successors.add(positions[i][j]);
            }
            movements.put(positions[i][0], successors);

        }
        
        this.setPosition(ONE);
        this.setEnergy(50);
    }

    @Override
    public void updateState(Perception p) {
    	
    }
    
    @Override
    public String toString() {
    	
        String str = "Posicion: " + position;
        return str;

    }
    
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof AmongAgentState)) {
            return false;
        }
        return position.equals(((AmongAgentState) obj).getPosition());
    }
    
    
    
    
    
    public int[][] getAirship() {
        return airship;
    }

    public int[] getAirshipPosition(int row) {
        return airship[row];
    }

    public void setAirshipPosition(int row, int[] values) {
    	
        this.airship[row][0] = values[0];
        this.airship[row][1] = values[1];
        this.airship[row][2] = values[2];
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public Collection<String> getPosibleMovements() {
        return movements.get(position);
    }

}