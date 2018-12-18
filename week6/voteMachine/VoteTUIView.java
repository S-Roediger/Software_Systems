package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Set;

public class VoteTUIView implements Observer, VoteView {

	private VoteMachine vm;
	
	public VoteTUIView(VoteMachine vm) {
		this.vm = vm;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")) {
			System.out.println("A vote was added");
		}
		if (arg.equals("party")) {
			System.out.println("A party was added");
		}
		
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		Boolean check = true;
		while (check) {
			System.out.println("Please choose one of the following options: VOTE [party], ADD PARTY [party], VOTES, PARTIES, EXIT, HELP");
			input = "";
			if (sc.hasNextLine()) {
				input = sc.next();
				switch (input) {
					case "VOTE":
						vm.vote(sc.next());
						break;
					case ("ADD"):
						String temp = sc.next();
						vm.addParty(sc.next());
						break;
					case "VOTES":
						this.showVotes(vm.getVotes());
						break;
					case "PARTIES":
						this.showParties(vm.getParties());
						break;
					case "EXIT":
						input = "";
						break;
					case "HELP":
						this.showError("Sorry, we experience some issues currently.");
						break;
					default:
						System.out.println("Unfortunately we do not support this option (yet). Please choose one of the given options.");
				}				
			}
			if (input.length() == 0) {
				check = false;
			}
			
			
		}
		System.out.println("Thanks for using our services. Goodbye!");
	}

	@Override
	public void showVotes(Map<String, Integer> votes) {
		Set<String> parties = votes.keySet();
		for (String p:parties) {
			System.out.println(p + " : " + votes.get(p) + " vote(s)" + "\r");
		}
		
	}

	@Override
	public void showParties(List<String> parties) {
		for (int i = 0; i < parties.size(); i++) {
			System.out.println(parties.get(i) + "\r");
	
		}
		
	}

	@Override
	public void showError(String message) {
		System.out.println(message);
		
	}

}
