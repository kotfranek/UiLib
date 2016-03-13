package kret.ui;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import kret.ui.interfaces.ICommandListener;
import kret.ui.interfaces.IFrame;
import kret.ui.interfaces.IFrameListener;

/**
 * Abstract Command Framework Context class to be used with JInternalFrame windows
 * @see ICommandListener
 * @author P. Podwapinski
 */
public abstract class AbstractInternalFrameContext extends InternalFrameAdapter implements ICommandListener, IFrameListener, IFrame
{
    /**
     * Protected constructor to be used only by inheriting class
     * @param frame JInternalFrame reference
     * @param actionManager external ActionManager reference
     * @see ActionManager
     * @see CommandAdapter
     */
    protected AbstractInternalFrameContext( ActionManager actionManager, JInternalFrame frame )
    {
        m_frame = frame;
        m_commandAdapter = new CommandAdapter( actionManager, this );
    }
    

    @Override public void setTitle( String title )
    {
        if ( null != m_frame )
        {
            m_frame.setTitle( title );
        }
    }
    
    
    @Override public void showFrame()
    {
        if ( null != m_frame )
        {
            m_frame.setVisible( true );
        }
    }
    
    
    @Override public void closeFrame()
    {
        if ( null != m_frame )
        {
            m_frame.setVisible( false );
        }
        
    }
    
    /**
     * Returns the CommandAdapter reference
     * @return CommandAdapter reference
     */
    protected CommandAdapter getCommandAdapter()
    {
        return m_commandAdapter;
    }
    
    @Override public void internalFrameActivated( InternalFrameEvent e )
    {
        onFrameActivated();
    }
    
    @Override public void internalFrameOpened( InternalFrameEvent e )
    {
        onFrameOpened();
    }
    
    @Override public void internalFrameClosed( InternalFrameEvent e )
    {
        onFrameClosed();
    }
     
    /**
     * JInternalFrame instance reference
     */
    private JInternalFrame m_frame;
    
    /**
     * CommandAdapter instance for accessing the Command Framework
     */
    private CommandAdapter m_commandAdapter;
}
