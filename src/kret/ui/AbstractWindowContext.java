/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kret.ui;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;
import kret.ui.interfaces.ICommandListener;
import kret.ui.interfaces.IFrame;
import kret.ui.interfaces.IFrameListener;

/**
 * JFrame Context Abstract class
 * @author prpo4526
 */
public abstract class AbstractWindowContext extends WindowAdapter implements ICommandListener, IFrameListener, IFrame
{       
    public AbstractWindowContext( ActionManager actionManager )
    {
        m_commandAdapter = new CommandAdapter( actionManager, this );
        m_childContexts = new HashMap<>();        
    }
    
    
    protected void setDefaultLocation()
    {
        getWindow().setLocationRelativeTo( null );
    }

    
    public void showErrorMessage( final String title, final String message )
    {
        JOptionPane.showMessageDialog( getWindow(), message, title, JOptionPane.ERROR_MESSAGE );
    }
      
    
    /**
     * Add a context as a child context and relate it with a name
     * @param name given Context name
     * @param context context reference
     */
    public void addChildContext( String name, AbstractWindowContext context )
    {      
        if ( null != name && null != context )
        {
            m_childContexts.put( name, context );
        }
    }
    
    
    /**
     * Will display a previously registered context with a given name
     * @param name context's name
     * @return true if context with given name was found
     */
    public boolean showChildContext( String name )
    {
        boolean result = false;
        
        AbstractWindowContext foundContext = m_childContexts.get( name );
        
        if ( null != foundContext )
        {
            foundContext.showFrame();
            result = true;
        }
        
        return result;
    }
                
       
    protected void registerLiseners()
    {
        addListenerToWindow( getWindow() );
    }
    
    /**
     * Make the current window visible
     */
    @ Override public void showFrame()
    {
        getWindow().setVisible( true );     
    }
   
    /**
     * Closes the current window
     */
    @ Override public void closeFrame()
    {
        getWindow().setVisible( false );
        getWindow().dispose();
    }
    
        
    @Override public void windowOpened( WindowEvent e ) 
    {
        onFrameOpened();
    }
    
    @Override public void windowClosed( WindowEvent e )
    {
        onFrameClosed();
    }
    
    @Override public void windowActivated( WindowEvent e )
    {
        onFrameActivated();
    }
       
    
    /**
     * Sets this context as an Event Listener for the registered Window (Frame)
     * @param frame Given frame
     */
    private void addListenerToWindow( Window frame )
    {
        if ( null != frame )
        {
            frame.addWindowListener( this );
            frame.addWindowStateListener( this );
            frame.addWindowFocusListener( this );            
        }
    }
    
    /**
     * Override this one to provide the window reference from eg. JFrame or JDialog
     * @return Window class reference
     */
    abstract public Window getWindow();
    

    @Override abstract public void setTitle( final String title );
    
    protected CommandAdapter getCommandAdapter()
    {
        return m_commandAdapter;
    }
    
    /**
     * Internal Command Adapter
     */
    final CommandAdapter m_commandAdapter;
    
    
    /**
     * Map representing child contexts and their names
     */
    final HashMap<String, AbstractWindowContext> m_childContexts;
}

