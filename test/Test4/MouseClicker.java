 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MouseClicker extends JFrame {

    AudioClip click;

    public static void main(String[] args) {
        new MouseClicker();
    }

    public MouseClicker() {
        try {
            this.setSize(400, 400);
            this.setTitle("Mouse Clicker");
            this.addMouseListener(new Clicker());
            URL urlClick = (new File("E:\\Music\\English Songs\\44 - Luis Fonsi feat Daddy Yankee - Despacito(0).mp3")).toURL();
            click = Applet.newAudioClip(urlClick);
            this.setVisible(true);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MouseClicker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class Clicker extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            click.play();
        }
    }
}