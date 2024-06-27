/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test3;




import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    public class Main {

        public static void audio() {
            try {
                File file = new File("C:\\Users\\nuwan\\Music\\English Songs\\44 - Luis Fonsi feat Daddy Yankee - Despacito(0).mp3");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
            }
        }


        private static String arg;

        public static void main(String[] args){


        arg = "background.gif";
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(arg);    
        f.setSize(480, 360);
        f.setVisible(true);
        l.setIcon(icon);
        p.add(l);
        f.getContentPane().add(p);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        audio();

            }
        }