package gui;
import entities.MusicPlayer;
import javax.swing.*;

public class MusicPlayerGUI {
	public MusicPlayerGUI() {
		MusicPlayer player = new MusicPlayer();
		
		JFrame frame = new JFrame("Music Player");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 360, 240);
		panel.setLayout(null);
		frame.add(panel);
		
		JButton playButton = new JButton("Play");
		playButton.setBounds(50, 50, 80, 30);
		panel.add(playButton);
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.setBounds(150, 50, 80, 30);
		panel.add(pauseButton);
		
		JTextField filePathField = new JTextField("Enter file path here...");
		filePathField.setBounds(50, 150, 250, 30);
		panel.add(filePathField);
	
        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(250, 50, 80, 30);
        panel.add(stopButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(310, 150, 80, 30);
		panel.add(confirmButton);
		
		JButton resumeButton = new JButton("Resume");
			resumeButton.setBounds(310, 150, 80, 30);
			panel.add(resumeButton);
		
		playButton.addActionListener(e -> {
			String filePath = filePathField.getText();
			System.out.println("Tocando: " + filePath);
		});
		
		JLabel statusLabel = new JLabel("Status: Idle");
		statusLabel.setBounds(50, 200, 300, 30);
		panel.add(statusLabel);
		
		playButton.addActionListener(e -> {
			String filePath = filePathField.getText();
			statusLabel.setText("Status: Playing " + filePath);
		});
		
		playButton.addActionListener(e -> {
			String filePath = filePathField.getText();
			if(!filePath.isEmpty()) {
				player.play(filePath);
				statusLabel.setText("Status: Playing " + filePath);
			}
			else {
				statusLabel.setText("Satus: No file selected!");
			}
		});
		
		pauseButton.addActionListener(e -> {
			if (player.isPlaying()) {
				player.pause();
				statusLabel.setText("Status: paused");
			}
			else {
				statusLabel.setText("Status: Nithing is playing to pause");
			}
		});
		
		resumeButton.addActionListener(e ->{
			if (!player.isPlaying() && player.getCurrentPosition() > 0) {
				player.resume();
				statusLabel.setText("Stauts: resumed");
			}
			else {
				statusLabel.setText("Status: Nothing to resume");
			}
		});
		
		stopButton.addActionListener(e -> {
			if (player.isPlaying()){
				player.stop();
				statusLabel.setText("Status: Stopped");
			}
			else {
				statusLabel.setText("Status: Nothing is playing to stop");
			}
		});
		
		confirmButton.addActionListener(e -> {
			String filePath = filePathField.getText();
			if (!filePath.isEmpty()) {
				player.play(filePath);
				statusLabel.setText("Status: Playing" + filePath);
			}
			else {
				statusLabel.setText("Status: Please enter a file path!");
			}
		}); 
		
		frame.setVisible(true);
	}

}
