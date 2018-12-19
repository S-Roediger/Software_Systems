package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {

	private PartyList partyList;
	private VoteList voteList;
	
	
	public VoteMachine(PartyList partyList, VoteList voteList) {
		this.partyList = partyList;
		this.voteList = voteList;
	}
	
	public void start() {
		VoteGUIView view = new VoteGUIView(this);
		partyList.addObserver(view);
		voteList.addObserver(view);
		view.start();
	}
	
	public void addParty(String party) {
		partyList.addParty(party);
	}
	
	public void vote(String party) {
		voteList.addVote(party);
		if (!partyList.getParties().contains(party)) {
			partyList.addParty(party);
		}
	}
	
	public ArrayList<String> getParties() {
		return partyList.getParties();
	}
	
	public Map<String, Integer> getVotes() {
		return voteList.getVotes();
	}
	
	public static void main(String[] args) {
		PartyList partyList = new PartyList();
		
		VoteList voteList = new VoteList();
		VoteMachine vm = new VoteMachine(partyList, voteList);
		vm.start();
	}
}
