import javax.sound.sampled.*;
import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        Scanner sc = new Scanner(System.in);
        
        File file = new File("Revenge.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = "";

        while (!response.equals("Q")) {
            System.out.println("P = play, S = Stop , R = Reset, Q = Quit");
            System.out.println("Enter your choice: ");

            response = sc.next();
            response = response.toUpperCase();

            switch(response) {
                case ("P"):
                clip.start();
                break;
                case ("S"):
                clip.stop();
                break;
                case ("R"):
                clip.setMicrosecondPosition(0);
                clip.start();
                break;
                case ("Q"):
                clip.close();
                break;
                default: 
                System.out.println("Invalid Input");
            }
        } 
        System.out.println("Thank you for using SweatyMediaPlayer!");
    }
}
