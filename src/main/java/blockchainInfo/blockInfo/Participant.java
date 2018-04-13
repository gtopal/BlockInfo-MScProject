package blockchainInfo.blockInfo;

public class Participant {
	
	
	private int id;
	private String ticket; // this ticket is a unique identifier for every participant
	private int order;
	private String seed; // this is the SHA256(blockHash)
	private String identifier; // this is the outcome of SHA256(SHA256(blockHash) || ticket) and is the unique evidence of every participant to the contest
	
	public Participant(int id, String ticket, String identifier,BlockData seed) {
		super();
		this.id = id;// for example 1
		this.ticket=Integer.toString(id); // convert int to string 
		this.seed=seed.getSeed(); // this is the SHA256(blockHash)
		this.identifier=Utils.SHA256(seed+ticket);
		
	}

	
	public Participant(int id, String ticket){
		super();
		this.id = id;
		this.ticket = Integer.toString(id);
		seed=BlockData.getSeed(); // this is the SHA256(blockHash)
		this.identifier=Utils.SHA256(seed+ticket);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTicket() {
		return ticket;
	}


	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getSeed() {
		return seed;
	}


	public void setSeed(String seed) {
		this.seed = seed;
	}


	@Override
	public String toString() {
		return "Participant [id=" + id + "\nticket=" + ticket +"\nseed=" + seed + "\nidentifier=" + identifier + "]";
	}
	
	
}
