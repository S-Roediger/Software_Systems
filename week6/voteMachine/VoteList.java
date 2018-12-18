package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class VoteList extends Observable {

	private Map<String, Integer> voteList = new HashMap<>();
	
	public void addVote(String party) {
		Set<String> parties = voteList.keySet();
		Boolean check = false;
		
		for (String p:parties) {
			if (p.equals(party)) {
				voteList.put(party, voteList.get(party)+1);
			}
			
		}
		
		if (!check) {
			voteList.put(party, 1);
			
		} else if (check) {
			voteList.put(party, voteList.get(party)+1);
		}
		setChanged();
		notifyObservers("vote");
		
	}
	
	public Map getVotes() {
		return voteList;
	}
}
