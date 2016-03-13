/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui.interfaces;

/**
 *
 * @author P. Podwapinski
 */
public interface IFrame {
    /**
     * Sets the window title.
     * Overridden version for JFrame or JDialog
     * @param title new title
     */
    public void setTitle( final String title );
    
    /**
     * Display the frame
     */
    public void showFrame();
    
    /**
     * Close the displayed frame
     */
    public void closeFrame();
}
