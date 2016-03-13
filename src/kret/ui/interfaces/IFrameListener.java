/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui.interfaces;

/**
 * FrameListener interface
 * @author P. Podwapinski
 */
public interface IFrameListener {
    
    /**
     * Called when the frame gets closed
     */
    public void onFrameClosed();
    
    /**
     * Called when the frame is being opened
     */
    public void onFrameOpened();
    
    /**
     * Called when frame is being activated
     */
    public void onFrameActivated();
}
