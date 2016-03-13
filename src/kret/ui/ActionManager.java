package kret.ui;

import java.util.ArrayList;
import javax.swing.Action;
import kret.ui.interfaces.ICommandListener;

/**
 *
 * @author P. Podwapinski
 */
public class ActionManager 
{
    public ActionManager()
    {
        m_actions = new ArrayList<>();
    }
    
    public void addAction( final String label, final String name, final String description )
    {
        addAction( new MenuAction( label, name, description, null ) );
    }
            
    public void addAction( MenuAction action )
    {
        m_actions.add( action );
    }
       
    public boolean setListenerToCommand( final String command, ICommandListener listener )
    {
        boolean result = false;
        MenuAction menuAction = getMenuActionByCommand( command );
        
        if ( null != menuAction )
        {
            menuAction.addCommandListener( listener );
            result = true;
        }
        
        return result;
    }
    
    public MenuAction getMenuActionByCommand( final String command )
    {
        MenuAction result = null;
        
        for( MenuAction action : m_actions )
        {
            if ( null != action )
            {
                if ( command.equals( action.getValue( Action.ACTION_COMMAND_KEY ) ) )
                {
                    result = action;
                    break;
                }
            }
        }
        
        return result;        
    }
    
    public Action getActionByCommand( final String command )
    {       
        return getMenuActionByCommand( command );
    }
    
    private ArrayList<MenuAction> m_actions;
}
