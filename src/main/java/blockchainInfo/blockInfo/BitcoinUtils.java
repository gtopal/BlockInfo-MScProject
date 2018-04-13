  package blockchainInfo.blockInfo;
import org.bitcoinj.core.Block;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.store.BlockStoreException;

/**
 * @author Giorgos Topalidis
 */

/*
 * @ DESCRIPTION This class fetches the last Block of the Bitcoin Blockchain and
 * gives back to the user some important information which is going to be used
 * as a seed in the process of implementing the draw algorithm
 */

public class BitcoinUtils {

	public void printInfoAboutBlock(Block b, BlockStore bs) throws BlockStoreException {

		System.out.println("BlockHash : " + b.getHashAsString()+ "\n");
		System.out.println("Difficulty : " + b.getDifficultyTarget()+ "\n");
		System.out.println("Nonce : " + b.getNonce()+ "\n"); 
		System.out.println("Time : " + b.getTime()+ "\n");
		System.out.println("Previous : " + b.getPrevBlockHash()+ "\n");
		System.out.println("Block Height : " + bs.getChainHead().getHeight()+ "\n");
		System.out.println("Number of transactions : " + b.getTransactions().size()+ "\n");
	}
	
	public static String  printInfoAboutBlock2(Block b, BlockStore bs) throws BlockStoreException {
		String myInfoBlockOutcome="BlockHash : " + b.getHashAsString() + "\n" + "Difficulty : " + b.getDifficultyTarget()
		+ "\n" + "Nonce : " + b.getNonce() + "\n" + "Time : " + b.getTime() + "\n" + "Previous : " + b.getPrevBlockHash()
		+ "\n" + "Block Height : " + bs.getChainHead().getHeight() + "\n" + "Number of transactions : " + b.getTransactions().size();
		
		return myInfoBlockOutcome;
	}
	
}
