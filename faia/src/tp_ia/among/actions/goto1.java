package tp_ia.among.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.AmongAgentState;

public class goto1 extends SearchAction{
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s){
        AmongAgentState agentState = (AmongAgentState) s; // trata a s del tipo AmongAgentState
        int energy = agentState.getEnergy();

        ArrayList<String> possibleMovments = new ArrayList<String>(); // para ver a donde se puede mover
        possibleMovments.addAll(agentState.getPosibleMovements());


        if (possibleMovments != null) {
            int index = possibleMovments.indexOf(AmongAgentState.ONE); // si ONE esta en la lista, establece la posicion del agente en ONE
            if (index >= 0) {
                agentState.setPosition(AmongAgentState.ONE);
                agentState.setEnergy(energy-1);

                return agentState;
            }

        }

        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        this.execute((SearchBasedAgentState) ast);

        return null;
    }

    @Override
    public String toString() {
        return "GoTo1";
    }

    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }
    
}
