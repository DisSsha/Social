package choice.api;
import java.util.*;

import agents.api.Agent;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * interface Choice :
 * 
 * the method choose has been created to be as more generic as possible,
 * it can be used as well for choosing an action as for choosing a direction ...
 * 
 */
public interface Choice {

	public <T> T choose(Map<String,T> choixPossible);
}
