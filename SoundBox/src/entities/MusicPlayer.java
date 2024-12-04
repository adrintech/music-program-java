package entities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.*;

public class MusicPlayer {
	private Clip clip;
	private boolean isPlaying;
	private String currentTrack;
	private long currentPosition;
	private AudioInputStream audioStream;
	
	public MusicPlayer(Clip clip, boolean isPlaying, String currentTrack, long currentPosition) {
		super();
		this.clip = clip;
		this.isPlaying = isPlaying;
		this.currentTrack = currentTrack;
		this.currentPosition = currentPosition;
	}
	
	public MusicPlayer() {
		this.clip = null;
		this.isPlaying = false;
		this.currentPosition = 0;
		this.currentTrack = null;
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public String getCurrentTrack() {
		return currentTrack;
	}

	public void setCurrentTrack(String currentTrack) {
		this.currentTrack = currentTrack;
	}
	
	public long getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPosition(long currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void play(String filePath) {
		if (clip != null && clip.isOpen()) {
			clip.close();
		}
		try {
			if (isPlaying) {
				clip.stop();
			}
			
			if (clip == null) {
				clip = AudioSystem.getClip();
			}
			
			File file = new File(filePath);
			audioStream = AudioSystem.getAudioInputStream(file);
			
			
			clip.open(audioStream);
			clip.start();
			isPlaying = true;
			
			clip.addLineListener(event -> {
				if (event.getType() == LineEvent.Type.STOP) {
					try {
						audioStream.close();
					} catch (IOException e) {
						System.out.println("Erro ao fechar arquivo: " + e.getMessage());
					}
					System.out.println("Música terminou de tocar!");
					isPlaying = false;
					currentPosition = 0;
					}
				});
			
			while (clip.isActive()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Formato não suportado");
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println("Recurso não disponível");
		}
	}
	
	public void pause() {
		if (clip != null && clip.isRunning()) {
			currentPosition = clip.getMicrosecondPosition();
			clip.stop();
			isPlaying = false;
			System.out.println("Playback paused.");
		}	
		
	}
	
	public void resume() {
		if (clip != null && !clip.isRunning()) {
			clip.setMicrosecondPosition(currentPosition);
			clip.start();
			isPlaying = true;
			System.out.println("Playback resumed.");
		}
	}
	
	public void stop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.setMicrosecondPosition(0);
			currentPosition = 0;
			isPlaying = false;
		}
	}
	
	public void playNext(List<String> playlist, int currentIndex) {
		if (currentIndex < playlist.size() - 1) {
			currentIndex++;
			play(playlist.get(currentIndex));
		} else {
			System.out.println("Você chegou ao final da playlist!");
		}
	}
	

}
