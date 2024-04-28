package tp_ia.among;

import java.util.Vector;

import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import tp_ia.among.AmongGoal;

public class AmongAgent extends SearchBasedAgent {
	
	public AmongAgent() {
		
		AmongGoal goal = new AmongGoal();
		AmongAgentState amongState = new AmongAgentState();
		this.setAgentState(amongState);
		
		Vector<SearchAction> operators = new Vector<SearchAction>();
		operators.addElement(goto1());
		operators.addElement(goto2());
		operators.addElement(goto3());
		operators.addElement(goto4());
		operators.addElement(goto5());
		operators.addElement(goto6());
		operators.addElement(goto7());
		operators.addElement(goto8());
		operators.addElement(goto9());
		operators.addElement(goto10());
		operators.addElement(goto11());
		operators.addElement(goto12());
		operators.addElement(goto13());
		operators.addElement(goto14());
		operators.addElement(kill());
		operators.addElement(sabotage());
		
		Problem problem = new Problem(goal, amongState, operators);
		this.setProblem(problem);
	}
}