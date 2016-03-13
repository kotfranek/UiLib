/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui;

import kret.ui.interfaces.ICommandListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author P. Podwapinski
 */
public class MenuAction extends AbstractAction 
{  
    public MenuAction( String text, String command, String desc, ICommandListener listener ) 
    {
        super( text );
        
        m_listenerCollection = new CommandListenerCollection();
        
        putValue( ACTION_COMMAND_KEY, command );
        putValue( SHORT_DESCRIPTION, desc );
               
        addCommandListener( listener );
    }
    
    
    public final void addCommandListener( ICommandListener listener )
    {
        m_listenerCollection.addListener( listener );
    }
    
    @Override public void actionPerformed( ActionEvent e ) 
    {   
        m_listenerCollection.onCommandExecuted( new Command( e ) );
    }
    
    private CommandListenerCollection m_listenerCollection;
}
