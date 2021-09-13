package de.gothaer;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public class Main extends Frame  {



    public Main() throws HeadlessException {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               dispose();
            }
        });
        setSize(300,300);
    }


}
