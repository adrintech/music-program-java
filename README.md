## 🎵 MusicBox - A Simple Java Music Player  

**MusicBox** is a command-line music player developed in Java. It allows users to play WAV audio files with functionalities such as play, pause, resume, and stop, alongside playlist navigation and playback progress tracking. This project demonstrates the integration of basic and intermediate Java concepts with audio processing libraries.  

---

### 🛠 Features  

1. **Audio Playback**  
   - Play WAV files directly from a specified directory.  
   - Support for loading new files during runtime.  

2. **Playback Controls**  
   - **Play**: Start playing an audio file.  
   - **Pause**: Pause playback and save the current position.  
   - **Resume**: Resume playback from the last paused position.  
   - **Stop**: Stop playback and reset the position to the beginning.  

3. **Playlists**  
   - Automatically play the next track in a playlist.  
   - Display a message when the playlist ends.  

4. **Real-Time Feedback**  
   - Console messages to indicate actions such as *"Music finished playing!"* or *"Playback paused."*  

---

### 🚀 How to Run  

#### Requirements  
- **Java Development Kit (JDK)** 8 or later.  
- A terminal or command-line environment.  

#### Steps  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/your-username/musicbox.git  
   cd musicbox  
   ```  

2. Compile the code:  
   ```bash  
   javac -d bin src/entities/MusicPlayer.java src/Main.java  
   ```  

3. Run the program:  
   ```bash  
   java -cp bin Main  
   ```  

4. Follow the prompts to interact with the music player:  
   - Enter the file path of a WAV file.  
   - Use the commands `play`, `pause`, `resume`, and `stop` as instructed.  

---

### 🔧 Project Structure  

```
MusicBox  
├── src  
│   ├── entities  
│   │   └── MusicPlayer.java    # Core logic of the music player.  
│   ├── Main.java               # Command-line interaction logic.  
├── resources                   # Sample WAV files.  
├── README.md                   # This document.  
└── LICENSE                     # Project license.  
```  

---

### 📋 Technologies Used  
- **javax.sound.sampled**: For audio file processing.  
- **Java Collections**: For playlist management.  
- **Command-Line Input**: For user interaction.  

---

### 📖 What You’ll Learn  
- File and audio handling in Java.  
- Building interactive command-line programs.  
- Using event listeners for managing audio streams.  
- Structuring modular Java projects.  

---

### 📜 License  
This project is licensed under the MIT License. See the `LICENSE` file for details.  

---

### 🤝 Contributing  
Contributions are welcome! To contribute:  
1. Fork the repository.  
2. Create a new branch for your feature (`git checkout -b feature/new-feature`).  
3. Commit your changes (`git commit -m 'Add new feature'`).  
4. Push to the branch (`git push origin feature/new-feature`).  
5. Open a Pull Request.  

---

### ✨ Acknowledgments  
Thanks for exploring this project! If you found it helpful, give it a ⭐ and share it with fellow Java enthusiasts. 🎉
