package blockchainInfo.blockInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.AddressFormatException;
import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.PeerGroup;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.core.Wallet.SendRequest;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import org.bitcoinj.script.ScriptOpCodes;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.store.BlockStoreException;
import org.bitcoinj.wallet.KeyChain;
import org.bitcoinj.wallet.WalletFiles;

public class SecurityFrame extends JFrame {

	private JPanel privateKeyPanel;
	private JPasswordField privateKeyField;
	private JButton privateKeyButton;
	private JLabel privateKeyLabel;
	static String result;
	private static Address bitcoinAddress;
	//private static String myaddress;
	// private static org.bitcoinj.core.Wallet.SendRequest req;
	static ScriptBuilder sb;
	// static Script script;

	public SecurityFrame() {

		privateKeyPanel = new JPanel();
		privateKeyLabel = new JLabel("Give the private key in order to sign the OP_RETURN transaction :");
		privateKeyPanel.add(privateKeyLabel);

		privateKeyField = new JPasswordField("---------------------------------------------------");
		privateKeyField.setBounds(50, 50, 150, 20);
		privateKeyPanel.add(privateKeyField);

		privateKeyButton = new JButton("Sign my OP_RETURN transaction");
		privateKeyPanel.add(privateKeyButton);

		ButtonListenerPrivate listener = new ButtonListenerPrivate();

		privateKeyButton.addActionListener(listener);

		this.setContentPane(privateKeyPanel);
		this.setSize(500, 500);
		this.setTitle("Private Key insertion!!!");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ButtonListenerPrivate implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			result = privateKeyField.getText();
			// System.out.println(result);

			// create wallet
			org.bitcoinj.core.Wallet wallet = new org.bitcoinj.core.Wallet(Main.params);

			// create my ECKey
			DumpedPrivateKey dumpPrivKey = null;
			try {
				dumpPrivKey = new DumpedPrivateKey(Main.params, result); // Parses
																			// and
																			// generates
																			// private
																			// keys
																			// in
																			// the
																			// form
																			// used
																			// by
																			// the
																			// Bitcoin
																			// "dumpprivkey"
																			// command
			} catch (AddressFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			ECKey myKey = dumpPrivKey.getKey(); // Returns an ECKey created from
												// this encoded private key.

			// set up the connection
//			try {
//				Main.chain = new BlockChain(Main.params, Main.bs);
//				PeerGroup peerGroup = new PeerGroup(Main.params, Main.chain);
//				// peerGroup.addWallet(wallet);
//				// peerGroup.startAndWait();
//			} catch (BlockStoreException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

			bitcoinAddress = myKey.toAddress(Main.params);
			// assert
			// myKey.toAddress(wallet.getNetworkParameters()).equals(bitcoinAddress);
			// assert !c.equals(a);

			// wallet.importKey(myKey);

			// myaddress = myKey.toAddress(Main.params).toString();
			System.out.println("My bitcoin address is : " + bitcoinAddress); // the
																				// Main
																				// network
																				// address
			Coin coin = wallet.getBalance();
			System.out.println("My bitcoin balance is: " + coin); // the balance

			// create the OP_RETURN transaction

			// TransactionOutput
			// output=dataOutput.createOpReturnTransaction(dataOutput.getTransaction(),dataOutput.getScriptbuilder());

			// Script script=new Script(Main.resultHash.getBytes());

			// script =
			// sb.op(ScriptOpCodes.OP_RETURN).data(ThirdFrame.mySha.getBytes()).build();

			// Transaction transaction = new Transaction(wallet.getParams());
			// transaction.addOutput(
			// Coin.ZERO,ScriptBuilder.createOpReturnScript(org.apache.commons.codec.digest.DigestUtils
			// .sha256(Main.resultHash)));
			//
			//
			// //org.apache.commons.codec.digest.DigestUtils
			// System.out.println("------------------------------------------");
			// System.out.println(transaction.toString());
			// System.out.println("------------------------------------------");
			//
			//
			// SendRequest req;
			// req = SendRequest.forTx(transaction);
			//
			// // Fill-in the missing details for our wallet, eg. fees.
			// try {
			// wallet.completeTx(req);
			// } catch (InsufficientMoneyException e2) {
			// try {
			// throw new Exception();
			// } catch (Exception e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			// }
			//
			// // Broadcast and commit transaction
			// Main.kit.peerGroup().broadcastTransaction(transaction);
			// wallet.commitTx(transaction);
			//
			//
			// // Return a reference to the caller
			// System.out.println(transaction.getHashAsString());

			
			// create a transaction output for OP_RETURN transaction
			DataOutput dataOutput = new DataOutput();
			TransactionOutput output = dataOutput.createOpReturnTransaction(dataOutput.getTransaction(),
					dataOutput.getScriptbuilder());
			
			
			
			
			
			// set up the connection
			try {
				Main.chain = new BlockChain(Main.params, Main.bs);
				PeerGroup peerGroup = new PeerGroup(Main.params, Main.chain);
				// peerGroup.addWallet(wallet);
				// peerGroup.startAndWait();
			} catch (BlockStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			//SendRequest req;

			// the following statement will help to create an OP_RETURN with
			// resultHash as the message
			// dataOutput.getTransaction().addOutput(Coin.ZERO,
			// ScriptBuilder.createOpReturnScript(Main.resultHash.getBytes()));
			//
//			req = SendRequest.forTx(dataOutput.getTransaction());
//
//			try {
//				Main.kit.wallet().sendCoins(req);
//			} catch (InsufficientMoneyException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			System.out.println(output.getParentTransaction().getHashAsString());

		}

	}

	public static String getResult() {
		return result;
	}

}