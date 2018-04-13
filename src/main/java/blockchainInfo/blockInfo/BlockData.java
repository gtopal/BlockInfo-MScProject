package blockchainInfo.blockInfo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Giorgos Topalidis
 */

/*
 * @ DESCRIPTION This class contains all the appropriate information concerning
 * the data of a block
 */

public class BlockData {

	private int height; // the block height
	private String blockHash; // the hash of the block
	private Timestamp blockDate; // the time at which the block was solved and
									// broadcast, according to the clock of the
									// solving node
	private static String seed; // the sha256(blockHash)

	public BlockData(int height, String blockHash, Timestamp blockDate) {
		this(blockHash, blockDate);
		this.height = height;

	}

	public BlockData(int height, String blockHash, Timestamp blockDate, String seed) {
		this(height, blockHash, blockDate);
		BlockData.seed = seed;
	}

	public BlockData(String blockHash, Timestamp blockDate) {
		super();
		this.blockHash = blockHash;
		this.blockDate = blockDate;
		BlockData.seed = Utils.SHA256(blockHash);
	}

	public int getHeight() {
		return height;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public Timestamp getBlockDate() {
		return blockDate;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static String getSeed() {
		return seed;
	}

	@Override
	public String toString() {
		return "BlockData [height=" + height + "\nblockHash=" + blockHash + "\nblockDate=" + blockDate + "\nseed="
				+ seed + "]";
	}

}
