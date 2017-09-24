/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubycon.rms.generic;

import com.rubycon.rms.generic.Login;

import javax.swing.JFrame;

/**
 *
 * @author P.Sreeja
 */
public class RestaurantSystem extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Login im = new Login();
        im.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        im.setVisible(true);
        
    }
    
}
