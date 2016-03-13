package kret.ui;

import javax.swing.UIManager;
import kret.ui.interfaces.IFrame;

/**
 *
 * @author P. Podwapinski
 */
public abstract class AbstractUiBuilder implements Runnable {

    public AbstractUiBuilder( final String uiLookAndFeelName ) 
    {
        m_lafName = uiLookAndFeelName;
        m_actionManager = new ActionManager();
        m_mainFrame = null;
    }


    protected void setRootFrame( IFrame frame )
    {
        m_mainFrame = frame;
    }
    
    public void start()
    {
        java.awt.EventQueue.invokeLater( this );
    }
    
    
    public ActionManager getActionManager()
    {
        return m_actionManager;
    }
    
    @Override
    public void run() 
    {        
        applyLookAndFeel( m_lafName );
        createUi();
        showUi();
    }
    
    
    abstract protected void createUi();
    
    private void showUi()
    {
        if ( null != m_mainFrame )
        {
            m_mainFrame.showFrame();
        }
    }

    private void applyLookAndFeel( final String lookAndFeelName ) 
    {
        UIManager.LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
        String lookAndFeelClassName = null;

        for (int i = 0; i < looks.length; i++) 
        {
            System.out.println( looks[i].getName() );
            if (lookAndFeelName.equals( looks[i].getName() ) ) 
            {
                lookAndFeelClassName = looks[i].getClassName();
                break;
            }
        }

        try {
            UIManager.setLookAndFeel(lookAndFeelClassName);
            //SwingUtilities.updateComponentTreeUI(m_frameMain);

        } 
        catch (Exception e) 
        {
            /* JOptionPane.showMessageDialog(m_frameMain, "Can't change look and feel:"
                    + lookAndFeelClassName, "Invalid PLAF",
                    JOptionPane.ERROR_MESSAGE);*/
        }
    }
    
    private String m_lafName;    
    private ActionManager m_actionManager;
    private IFrame m_mainFrame;
}


