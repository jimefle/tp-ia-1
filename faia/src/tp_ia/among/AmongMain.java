package tp_ia.among;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongMain {
	
	public static void main(String[] args) throws PrologConnectorException {
	
		AmongAgent amongAgent = new AmongAgent();
		AmongEnvironment amongEnvironment = new AmongEnvironment();
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongEnvironment, amongAgent);
		simulator.start();
	}
	
}