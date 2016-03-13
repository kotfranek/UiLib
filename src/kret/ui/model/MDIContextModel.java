/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui.model;

import java.util.ArrayList;
import javax.swing.JDesktopPane;
import kret.ui.AbstractInternalFrameContext;

/**
 * Multiple-Document Interface (MDI) class to ease use of JInternalFrames and corresponding contexts
 * @author P. Podwapinski
 */
public class MDIContextModel {
    public MDIContextModel( JDesktopPane dekstopPane )
    {
        m_desktopPane = dekstopPane;
        m_frameContexts = new ArrayList<>();
    }
    
    void addFrameContext( AbstractInternalFrameContext context )
    {
        m_frameContexts.add( context );
        //m_desktopPane.add( m_desktopPane );
    }
    
    
    
    AbstractInternalFrameContext getActiveFrameContext()
    {
        return null;
    }
    
    private JDesktopPane m_desktopPane;
    ArrayList< AbstractInternalFrameContext > m_frameContexts;
}
