/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui;

import java.awt.event.ActionEvent;

/**
 *
 * @author kret
 */
public class Command 
{
    public Command( ActionEvent e )
    {
        m_source = e.getSource();
        m_command = e.getActionCommand();
    }
    
    
    public String getAction()
    {
        return m_command;
    }
    
    public boolean isSource( Object source )
    {
        return m_source == source;
    }
    
    /* Action Source */
    private Object m_source;
    
    /* Command type */
    private String m_command;
}
