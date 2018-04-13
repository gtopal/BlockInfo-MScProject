package blockchainInfo.blockInfo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.bitcoinj.core.Sha256Hash;

import blockchainInfo.blockInfo.SecurityFrame.ButtonListenerPrivate;

public class ThirdFrame extends JFrame {

	JList myList;
	JScrollPane scrollpane;

	JPanel mypanela;
	JPanel mypanelb;

	JLabel listLabel;
	JLabel winnerLabel;

	private JTextArea winnerArea;
	private JButton blockchainButton;

	private JLabel imageLabel3;
	private JPanel panelImage;
	static Participant winnerOfContest;
	static ArrayList<String> listOfMajorInfo;
	public static String concatenated;
	//static org.apache.shiro.crypto.hash.Sha256Hash mySha;

	public ThirdFrame(int numberOfParticipants) {

		// Participant winnerOfContest;
		ArrayList<Participant> list = null;
		ArrayList<String> listOfIdentifiers;
		// ArrayList<String> listOfMajorInfo;

		Contest myContest = new Contest(list, Main.myBlockData);

		list = Contest.participants = Contest.createParticipants(numberOfParticipants);
		// System.out.println("********************************************************");
		// System.out.println("The size of my list of participants is :" +
		// list.size());
		// System.out.println(list);
		// System.out.println("********************************************************");

		listOfIdentifiers = myContest.sortTheIdentifiers(list);

		// System.out.println("********************************************************");
		// System.out.println(listOfIdentifiers.size());
		// System.out.println(listOfIdentifiers);
		// System.out.println("********************************************************");

		winnerOfContest = Contest.findTheWinner(list, listOfIdentifiers);
		// System.out.println(winnerOfContest.toString());

		mypanela = new JPanel();
		mypanelb = new JPanel();
		panelImage = new JPanel();

		Font secondfont = new Font("Blue", Font.BOLD, 17);
		listLabel = new JLabel("List of Participants : ");
		listLabel.setFont(secondfont);
		mypanela.add(listLabel);

		listOfMajorInfo = Contest.getMajorInfoAboutParticipants(list);

		myList = new JList(listOfMajorInfo.toArray());
		scrollpane = new JScrollPane(myList);
		getContentPane().add(scrollpane);
		mypanela.add(scrollpane);

		// mypanela.add(myList);

		winnerLabel = new JLabel("Information about the winner :");
		winnerLabel.setFont(secondfont);
		mypanelb.add(winnerLabel);

		winnerArea = new JTextArea(10, 45);
		JScrollPane scrollPane = new JScrollPane(winnerArea);
		winnerArea.setEditable(false);
		winnerArea.append(winnerOfContest.toString());
		// mypanelb.add(winnerArea);
		
		
		
		
		SecondFrame.estimatedTime = System.nanoTime() - SecondFrame.startTime;
		System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
		System.out.println("Execution of a Draw with "+SecondFrame.mySumOfParticipants+ " takes " +SecondFrame.estimatedTime+ " time in nanoseconds");
		System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
		
		
		
		

		scrollPane.setBounds(10, 11, 455, 249);
		getContentPane().add(scrollPane);
		mypanelb.add(scrollPane);

		blockchainButton = new JButton("Store draw result in Blockchain!");
		mypanelb.add(blockchainButton);

		ButtonListener3 listener3 = new ButtonListener3();
		blockchainButton.addActionListener(listener3);

		ImageIcon image = new ImageIcon(
				"C:\\Users\\Maria\\workspace\\blockInfo\\src\\main\\java\\blockchainInfo\\blockInfo\\BGG-Infographic-Header-News.jpg");
		imageLabel3 = new JLabel(image);
		panelImage.add(imageLabel3);

		this.add(mypanela, BorderLayout.NORTH);
		this.add(mypanelb, BorderLayout.CENTER);
		this.add(panelImage, BorderLayout.SOUTH);

		this.setSize(1000, 750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("List of Participants");

	}

	class ButtonListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			concatenated = "--------------------Information about the block--------------------" + "\n"
					+ MainFrame.combinedInformation + "\n"
					+ "---------------------------------------------------------------------------" + "\n"
					+ "--------------------Information about the winner--------------------" + "\n"
					+ winnerOfContest.toString() + "\n"
					+ "---------------------------------------------------------------------------" + "\n"
					+ "-------------------Information about the participants-------------------" + "\n"
					+ listOfMajorInfo + "\n"
					+ "---------------------------------------------------------------------------";
			System.out.println(concatenated);

			Writer w = new Writer();
			File writtenFile;

			// write the results of my draw to a file
			writtenFile = w.writeToFile(Main.results);

			// hash the contents of the file
			
			
			
			//mySha = Writer.hashTheFile(writtenFile);

			Main.resultHash = Writer.hashTheFile(writtenFile).toString();
			
			
			
		

			SecurityFrame securityFrame = new SecurityFrame();

			

		}

	}

}
