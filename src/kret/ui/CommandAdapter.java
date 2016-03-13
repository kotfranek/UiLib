/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui;

import javax.swing.Action;
import kret.ui.interfaces.ICommandListener;

/**
 * Provides basic Window listener method implementation (WindowAdapter) and
 * Command handling routines like binding or enabling.
 * Shall be inherited by all FrameContexts.
 * @see AbstractFrameContext
 * @see AbstractInternalFrameContext
 * @author P. Podwapinski
 */
public class CommandAdapter
{
    /**
     * Constructor, to be instantiated only with inheriting class
     * @param actionManager External ActionManager instance
     * @param commandListener listener to be used for commands in bind and listen
     */
    public CommandAdapter( ActionManager actionManager, ICommandListener commandListener )
    {
        m_actionManager = actionManager;
        m_commandListener = commandListener;
    }
    
    /**
     * Binds the given trigger (button) to a command and sets self as a listener
     * @param trigger Which component is a trigger to given command
     * @param command Given command
     */
    public final void bindToCommand( javax.swing.AbstractButton trigger, final String command )
    {
        MenuAction menuAction = m_actionManager.getMenuActionByCommand( command );
        
        if ( null != menuAction )
        {
            menuAction.addCommandListener( m_commandListener );
            trigger.setAction( menuAction );
        }
    }
    
    /**
     * Makes this context a listener to a command which was not binded.
     * This means the command is not triggered by any action related to current context.
     * @param command Given command to listen to
     */
    public final void listenToCommand( final String command )
    {
        MenuAction menuAction = m_actionManager.getMenuActionByCommand( command );
        
        if ( null != menuAction )
        {
            menuAction.addCommandListener( m_commandListener );
        }        
    }
    
    /**
     * Enables or disables the command
     * @param command String with desired command name
     * @param enabled desired state
     */
    public final void setActionEnabledByCommand( final String command, boolean enabled )
    {
        Action toEnable = getActionByCommand( command );
        
        if ( null != toEnable )
        {
            toEnable.setEnabled( enabled );
        }
    }
    
    /**
     * Searches for Action object related to given command name
     * @param command String with desired command name
     * @return Action object if command found or null otherwise
     */
    private Action getActionByCommand( final String command )
    {
        Action result = null;
        
        if ( null != m_actionManager )
        {
            result = m_actionManager.getActionByCommand( command );
        }        
        return result;
    }
    
    /**
     * ActionManager instance reference.
     * Set in constructor.
     * @see ActionManager
     */
    private ActionManager m_actionManager; 
    
    /**
     * Command Listener instance reference used to bind and listen to commands
     */
    private ICommandListener m_commandListener;
}
