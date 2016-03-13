/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui;

import java.awt.Window;
import javax.swing.JFrame;

/**
 * JFrame Context Abstract class
 * @author prpo4526
 */
public abstract class AbstractFrameContext extends AbstractWindowContext
{       
    public AbstractFrameContext( ActionManager actionManager, JFrame frame )
    {
        super( actionManager );
        m_frame = frame;
    }

       
    
    @Override public void setTitle( String title )
    {
        m_frame.setTitle( title );
    }
    
           
    @Override public Window getWindow()
    {
        return m_frame;
    }
    
    private JFrame m_frame;
}
