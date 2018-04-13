package blockchainInfo.blockInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.bitcoinj.store.BlockStoreException;


public class MainFrame extends JFrame {
	
	
	private JPanel panel;
	private JButton drawButton;
	private JLabel imageLabel;
	private JLabel textlabel;
	public static String combinedInformation;

	public MainFrame(BlockData myBlockData) {
		panel = new JPanel();
		ImageIcon image = new ImageIcon("C:\\Users\\Maria\\workspace\\blockInfo\\src\\main\\java\\blockchainInfo\\blockInfo\\BlockChain-Animated-Proof.gif");
		Font font = new Font("Blue", Font.BOLD, 17);

		textlabel = new JLabel(
				"This contest is based on an algorithm which uses the blockHash as a seed in order to run transparent and secure draws!");
		textlabel.setFont(font);
		panel.add(textlabel);

		drawButton = new JButton("Run a Contest");
		panel.add(drawButton);

		ButtonListener listener = new ButtonListener();

		drawButton.addActionListener(listener);

		imageLabel = new JLabel(image);
		panel.add(imageLabel);

		this.setContentPane(panel);
		this.setSize(1000, 1000);
		this.setTitle("Main Screen of Draw Implementation");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			
		try {
			String informationAboutTheBlock=BitcoinUtils.printInfoAboutBlock2(Main.b,Main.bs);
			String informationAboutTheBlockData="Seed : " + Main.myBlockData.getSeed();
			 combinedInformation=informationAboutTheBlock + "\n" + informationAboutTheBlockData;
			
			//Creation of second frame
			try {
				SecondFrame secondFrame = new SecondFrame(combinedInformation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (BlockStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		}

	}


}
