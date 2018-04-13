package blockchainInfo.blockInfo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SecondFrame extends JFrame {
	
	private JPanel secondPanela;
	private JPanel secondPanelb;
	private JPanel panelImage;

	private JLabel blockInformationLabel;// these components will be added to
											// the panela
	private JTextArea textArea;

	private JLabel participantsNumberLabel;// these components will be added to
											// the panelb
	private JTextField participantsNumberField;
	private JButton participantsButton;

	private JLabel imageLabel2;
	
	static long startTime; // start time of running the algorithm of implementing a draw
	static long estimatedTime; // estimated time after the successful implementation of a draw
	static int mySumOfParticipants;
	

	public SecondFrame(String myInput) throws IOException {

		secondPanela = new JPanel();
		secondPanelb = new JPanel();
		panelImage = new JPanel();

		Font secondfont = new Font("Blue", Font.BOLD, 17);
		blockInformationLabel = new JLabel("Information about the Block :");
		blockInformationLabel.setFont(secondfont);
		secondPanela.add(blockInformationLabel);

		textArea = new JTextArea(8, 47);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.append(myInput);
	//	secondPanela.add(textArea);
		
		scrollPane.setBounds(10, 11, 455, 249); 
		getContentPane().add(scrollPane);
		secondPanela.add(scrollPane);

		ImageIcon image = new ImageIcon("C:\\Users\\Maria\\workspace\\blockInfo\\src\\main\\java\\blockchainInfo\\blockInfo\\image-COGWHEEL_649.jpg");
		imageLabel2 = new JLabel(image);
		panelImage.add(imageLabel2);

		participantsNumberLabel = new JLabel("Enter the number of participants :");
		participantsNumberLabel.setFont(secondfont);
		secondPanelb.add(participantsNumberLabel);

		participantsNumberField = new JTextField("Type the number of participants");
		participantsNumberField.setBounds(50, 50, 150, 20);
		secondPanelb.add(participantsNumberField);
		
		

		participantsButton = new JButton("Run a Draw");
		secondPanelb.add(participantsButton);
		
		ButtonListener2 listener2 = new ButtonListener2();

		participantsButton.addActionListener(listener2);
		

		this.add(secondPanela, BorderLayout.NORTH);
		this.add(panelImage, BorderLayout.SOUTH);
		this.add(secondPanelb, BorderLayout.CENTER);

		this.setSize(700, 700);
		this.setTitle("Block information and Selection of number of Participants");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			startTime = System.nanoTime();
			
			
			String numberofParticipants = participantsNumberField.getText();
			 mySumOfParticipants = Integer.parseInt(numberofParticipants);
			//ArrayList<Participant> participants=new ArrayList<Participant>(); // create the empty list of participants

			
			System.out.println("***********************************************");
			System.out.println("The participants of this contest are : " +mySumOfParticipants+"\n");
			System.out.println("***********************************************");

		//	System.out.println(participants.size()+ "\n");
			
				ThirdFrame thirdFrame = new ThirdFrame(mySumOfParticipants);
			

		

	}
	}
}


