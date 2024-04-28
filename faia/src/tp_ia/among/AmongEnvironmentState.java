package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.state.EnvironmentState;

public class AmongEnvironmentState extends EnvironmentState {


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

    /**
     * This map has a point of the world (A, B, C, ...) as key, and a collection
     * of successors of that point.
     */
    private HashMap<String, Collection<String>> movements;

    public static final String[][] POSITIONS = new String[][]{
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


    AmongEnvironmentState() {
        movements = new HashMap<String, Collection<String>>();
    }

    @Override
    public Object clone() {
        return movements.clone();
    }

    @Override
    public void initState() {
        /**
         * In this matrix the first element of each row represents a position
         * in the map and the seccessors of that position.
         */
        movements = new HashMap<String, Collection<String>>();
        
        for (int i = 0; i < POSITIONS.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < POSITIONS[i].length; j++) {
                successors.add(POSITIONS[i][j]);
            }
            movements.put(POSITIONS[i][0], successors);

        }
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

	@Override
	public String toString() {
		
		return null;
	}
}
