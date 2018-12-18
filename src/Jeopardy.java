import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Check out the Jeopardy Handout to see what the end result should look like: #http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private AudioClip sound;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("jepordy");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel panel = createHeader("games");
		// 4. Add the header component to the quizPanel
		quizPanel.add(panel);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		button1 = createButton("200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(button1);
		// 8. Write the code to complete the createButton() method below. Check that
		// your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.

		// 9. Use the secondButton variable hold a button using the createButton
		// method

		button2 = createButton("400");

		// 10. Add the secondButton to the quizPanel

		quizPanel.add(button2);
		// 11. Add action listeners to the buttons (2 lines of code)
		button1.addActionListener(this);
		button2.addActionListener(this);
		// frame.pack();
		// 12. Write the code to complete the actionPerformed() method below

		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions

		/*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */

		// frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}

	private JButton createButton(String dollarAmount) {

		// Create a new JButton
		JButton button = new JButton();
		// Set the text of the button to the dollarAmount
		button.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount += 1;
		// Return your new button instead of the temporary button

		return button;
	}

	public void actionPerformed(ActionEvent e) {

		
		// Complete the code in the askQuestion() method. When you play the game, the
		// score should change.
if (e.getSource()==button1) {
askQuestion("what's the first nintendo consle sold?", "the NES", 200);
	
}
		// If the buttonPressed was the secondButton
		//if (buttonPressed == button2) {
			if(e.getSource()==button2) {
			askQuestion("what was the first 3D mario sandbox game", "mario 64", 400);}
		}
	
	// Call the askQuestion() method with a harder question

	// Clear the text on the button that was pressed (set the button text to
	// nothing)
	// button1.setText("");
	// button2.setText("");

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		// Remove this temporary message and replace it with a pop-up that asks the user
		// the question

		String answer1 = JOptionPane.showInputDialog(null, question);
		// Use the playJeopardyTheme() method to play music while the use thinks of an
		// answer
		playJeopardyTheme();
		// Stop the theme music when they have entered their response. Hint: use the
		// sound variable

		// If the answer is correct
		if (answer1.equals(correctAnswer)) {
			JOptionPane.showMessageDialog(null, "correct");
			score += prizeMoney;
			updateScore();
			sound.stop();
		}
		// Increase the score by the prizeMoney

		// Pop up a message to tell the user they were correct

		// Otherwise
		else {
			JOptionPane.showMessageDialog(null,
					"that's incorrrect. The correct answer is " + correctAnswer);
			score -= prizeMoney;
			updateScore();
			sound.stop();
		}

		
	}
	// Decrement the score by the prizeMoney

	// Pop up a message to tell the user they were wrong and give them the correct
	// answer

	// Call the updateScore() method

	public void playJeopardyTheme() {
		try {
			sound = JApplet.newAudioClip(getClass().getResource("jeopardy.wav"));
			sound.play();
			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
