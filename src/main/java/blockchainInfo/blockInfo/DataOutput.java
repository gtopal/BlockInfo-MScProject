package blockchainInfo.blockInfo;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import org.bitcoinj.script.ScriptOpCodes;

public class DataOutput {
	
	
	

	private org.bitcoinj.core.Transaction transaction;
	ScriptBuilder scriptbuilder;
	static Script myScript;
	static String myData;

	public DataOutput() {

		

		transaction = new org.bitcoinj.core.Transaction(Main.params);
		scriptbuilder = new ScriptBuilder();

	}

	public TransactionOutput createOpReturnTransaction(org.bitcoinj.core.Transaction tx,
			ScriptBuilder sb) {
		

		 myData = Main.resultHash;

		byte[] sha256 = org.apache.commons.codec.digest.DigestUtils
				.sha256(myData);
		
		
		
		 myScript = sb.op(ScriptOpCodes.OP_RETURN).data(sha256).build();
		TransactionOutput transactionOutput = tx.addOutput(
				org.bitcoinj.core.Transaction.MIN_NONDUST_OUTPUT, myScript);
		
		
		
		
		

		System.out.println("My script is :" + myScript);
		System.out.println("My transaction output is : " + transactionOutput);
		System.out
				.println("The size of my message after hashing with SHA256 is : "
						+ sha256.length + " bytes.");
		return transactionOutput;
	}

	public org.bitcoinj.core.Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(org.bitcoinj.core.Transaction transaction) {
		this.transaction = transaction;
	}

	public ScriptBuilder getScriptbuilder() {
		return scriptbuilder;
	}

	public void setScriptbuilder(ScriptBuilder scriptbuilder) {
		this.scriptbuilder = scriptbuilder;
	}

	
	
	
}
