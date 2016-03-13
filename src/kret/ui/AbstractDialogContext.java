/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kret.ui;

import java.awt.Window;
import javax.swing.JDialog;

/**
 * JDialog Context Abstract class
 * @author prpo4526
 */
public abstract class AbstractDialogContext extends AbstractWindowContext
{       
    public AbstractDialogContext( ActionManager actionManager, JDialog frame )
    {
        super( actionManager );
        m_dialog = frame;
        
        setDefaultLocation();
    }

       
    
    @Override public void setTitle( String title )
    {
        m_dialog.setTitle( title );
    }
    
           
    @Override public Window getWindow()
    {
        return m_dialog;
    }
    
    private JDialog m_dialog;
}

