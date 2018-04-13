package blockchainInfo.blockInfo;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import org.bitcoinj.core.Block;
import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.Peer;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.store.BlockStoreException;

/**
 * @author Giorgos Topalidis
 */

/*
 * @ DESCRIPTION This class calls the appropriate functions and creates object class in order to run the contest
 */




public class Main {
	
	static BlockStore bs;
	static Block b;
	public static ArrayList<Participant> list=new ArrayList<Participant>();
	public static ArrayList<String> identifiers=new ArrayList<String>();
	static BlockData myBlockData;
	final static File results = new File("C:\\Users\\Guru\\lunaWorkspace\\blockinfo\\Contest_Results.txt");
	public static String resultHash;
	public static MainNetParams params = MainNetParams.get();
	public static WalletAppKit kit;
	public static BlockChain chain;

	public static void main(String[] args) throws BlockStoreException, InterruptedException, ExecutionException {

		  kit = new WalletAppKit(params,new java.io.File("."), "test");
		 kit.startAndWait();
		 chain = kit.chain();
		  bs = chain.getBlockStore();
		 Peer peer = kit.peerGroup().getDownloadPeer();
		  b = peer.getBlock(bs.getChainHead().getHeader().getHash()).get();
		  
		
		BitcoinUtils bitcoinUtils=new BitcoinUtils();
//		System.out.println("----------INFORMATION ABOUT THE BLOCK---------- ");
//		bitcoinUtils.printInfoAboutBlock(b,bs);
//		System.out.println("----------------------------------------");
//		System.out.println("\n");
		
		 myBlockData=createBlockData(bs, b);
//		System.out.println("----------INFORMATION ABOUT THE BLOCKDATA----------");
//		System.out.println(myBlockData.toString());
//		System.out.println("----------------------------------------");
//		System.out.println("\n");
		
		
		//Here i will create my MainFrame
		MainFrame myMainFrame=new MainFrame(myBlockData);
		
		
		
		
//		list=Contest.createParticipants(1000);
//		identifiers =Contest.sortTheIdentifiers(list);
//		Contest.findTheWinner(list, identifiers);
		

//		Participant myparticipant =new Participant(2, "2"); 
//		System.out.println("----------INFORMATION ABOUT THE PARTICIPANT----------");
//		System.out.println(myparticipant.toString());
//		System.out.println("----------------------------------------");
//		System.out.println("\n");
		
		
		
//		System.out.println("----------CREATION OF 100 RANDOM NUMBERS BETWEEN 1-100, ACTING LIKE PARTICIPANT ID----------");
//		int j = 100;
//		ArrayList<Integer> myList = new ArrayList<Integer>();
//		myList =Utils. myRandomNumbers(j);
//		for (int k = 0; k < myList.size(); k++) {
//			System.out.println(myList.get(k));
//		}
//		System.out.println("----------------------------------------");
//		System.out.println("\n");
//		
//		
//		
//		System.out.println("----------SORTING THE 100 NUMBERS IN ORDER TO CHECK THE ORDER AND UNIQUENESS----------");
//		Collections.sort(myList);
//		for (int k = 0; k < myList.size(); k++) {
//			System.out.println(myList.get(k));
//		}
//		System.out.println("----------------------------------------");
//		System.out.println("\n");
		
		
		

	}
	
	
	
	
// Create an object of BlockData class with the attributes of: 
	// height
	// blockHash
	// timestamp
	// seed=sha256(blockHash)
	
	public static BlockData createBlockData(BlockStore bs,Block b) throws BlockStoreException{
		String blockHash= b.getHashAsString();  //Creation of an object of
		int height= bs.getChainHead().getHeight();
		String seed=Utils.SHA256(blockHash);
		Timestamp blockDate=Utils.getTimeStamp(b.getTime());
		BlockData myBlockData=new BlockData(height, blockHash, blockDate, seed);
		return myBlockData;
		
	}
	
	

}
