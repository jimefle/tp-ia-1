package tp_ia.among;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import tp_ia.among.AmongGoal;
import tp_ia.among.actions.*;

public class AmongAgent extends SearchBasedAgent {
	
	public AmongAgent() {
		
		AmongGoal goal = new AmongGoal();
		AmongAgentState amongState = new AmongAgentState();
		this.setAgentState(amongState);
		
		Vector<SearchAction> operators = new Vector<SearchAction>();
		operators.addElement(new goto1());
		operators.addElement(new goto2());
		operators.addElement(new goto3());
		operators.addElement(new goto4());
		operators.addElement(new goto5());
		operators.addElement(new goto6());
		operators.addElement(new goto7());
		operators.addElement(new goto8());
		operators.addElement(new goto9());
		operators.addElement(new goto10());
		operators.addElement(new goto11());
		operators.addElement(new goto12());
		operators.addElement(new goto13());
		operators.addElement(new goto14());
		operators.addElement(new kill());
		operators.addElement(new sabotage());
		
		Problem problem = new Problem(goal, amongState, operators);
		this.setProblem(problem);
	}

	@Override
	public Action selectAction(){

		DepthFirstSearch strategy = new DepthFirstSearch();

		Search searchSolver = new Search(strategy);
		searchSolver.setVisibleTree(Search.XML_TREE);
		this.setSolver(searchSolver);

		Action selectedAction = null;
		try{
			selectedAction= this.getSolver().solve(new Object[]{this.getProblem()}); //devuelve el problema que el agente debe resolver
		} catch (Exception ex){
			Logger.getLogger(AmongAgent.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return selectedAction;
	}

	@Override
	public void see(Perception perception){
		this.getAgentState().updateState(perception);
	}
}