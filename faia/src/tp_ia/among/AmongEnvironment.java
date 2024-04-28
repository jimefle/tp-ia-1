package tp_ia.among;


import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmongEnvironment extends Environment {

    public AmongEnvironment() {
   
        this.environmentState = new AmongEnvironmentState();
    }

    @Override
    public Perception getPercept() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}