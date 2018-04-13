package blockchainInfo.blockInfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contest {
	
	private int id; // this is the id of the contest and is useful for identification of a contest if we want to store the contest details to a database
	private Timestamp timestamp; // this attribute gives information about the time that the contest took place
	static ArrayList<Participant> participants; // the list of all participants in the contest
	private String seed; // this is the SHA256(blockHash) value. Normally the seed is the blockHash, but in our application we define the seed as the SHA256(blockHash)
	private static Participant winner; // the number of the id participant, whose ticket is based on this unique id. Winner is the participant whose the outcome of
	                   // SHA256(SHA256(blockHash) || ticket)  is the smallest among all the other
	
	public Contest(int id, Timestamp timestamp, ArrayList<Participant> participants, BlockData seed ) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.participants = participants;
		this.seed=seed.getSeed(); // this is the SHA256(blockHash)	
	}
	
	public Contest(ArrayList<Participant> participants, BlockData seed ) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.participants = participants;
		this.seed=seed.getSeed(); // this is the SHA256(blockHash)	
	}
	
	
	
	public static ArrayList<Participant> createParticipants(int numberOfParticipants){
		ArrayList<Participant> participants=new ArrayList<Participant>();
		ArrayList<Integer> mynumbers=new ArrayList<Integer>();
		 mynumbers=Utils.myRandomNumbers(numberOfParticipants);
		int i;
		for (i=0; i<mynumbers.size(); i++){
		int current=mynumbers.get(i);
		Participant currentParticipant=new Participant(current, Integer.toString(current));
		participants.add(currentParticipant);
		}
		return participants;
		
	}
		
		public static ArrayList<String> getMajorInfoAboutParticipants(ArrayList<Participant> pList){
			ArrayList<String> listOfMajorInfo = new ArrayList<String>();

			for(int k=0; k<pList.size(); k++){
				String currentString="Participant with id :  "  +  pList.get(k).getId()  + "  " +
						             "participates in the contest with identifiier :  "  +  pList.get(k).getIdentifier()+"\n";
				listOfMajorInfo.add(currentString);
				
 				
			}
			return listOfMajorInfo;
		}
		
	
	
	public static ArrayList<String> sortTheIdentifiers(ArrayList<Participant> participantList){
		ArrayList<String> identifiers = new ArrayList<String>();
		
		for(int k=0; k<participantList.size(); k++){
			String currentIdentifier=participantList.get(k).getIdentifier();
			identifiers.add(currentIdentifier);
		}
		
		Collections.sort(identifiers);
		return identifiers;
	
	}
	
	public static Participant findTheWinner(ArrayList<Participant> participantList,ArrayList<String> identifiers){
		
		String winningString=identifiers.get(0);
		for (int k=0; k<participantList.size(); k++){
			if(participantList.get(k).getIdentifier().equals(winningString)){
				
				 winner=participantList.get(k);
//				System.out.println("*************************************************************************");
//				System.out.println("The winner of the contest is the participant with the below information:\n");
//				System.out.println(participantList.get(k).toString());
//				System.out.println("*************************************************************************");
				

			}
		}
		
		return winner;

		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}



	public static Participant getWinner() {
		return winner;
	}



	public static void setWinner(Participant winner) {
		Contest.winner = winner;
	}

	
	
	
	

}
