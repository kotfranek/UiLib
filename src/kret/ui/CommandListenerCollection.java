/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui;

import java.util.ArrayList;
import java.util.Iterator;
import kret.ui.interfaces.ICommandListener;

/**
 *
 * @author prpo4526
 */
public class CommandListenerCollection implements ICommandListener 
{
    public CommandListenerCollection() 
    {
        m_listeners = new ArrayList<>();
    }
    
    public void addListener( ICommandListener listener )
    {
        m_listeners.add( listener );
    }
    
    @Override public void onCommandExecuted( final Command command)
    {
        for ( Iterator<ICommandListener> iter = m_listeners.iterator(); iter.hasNext();  ) 
        {
            ICommandListener listener = iter.next();
            if ( null != listener )
            {
                listener.onCommandExecuted( command );
            }
        }        
    }
    
    ArrayList<ICommandListener> m_listeners;
}
