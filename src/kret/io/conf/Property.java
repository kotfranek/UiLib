/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.io.conf;

import java.util.Properties;
import javax.swing.text.JTextComponent;

/**
 *
 * @author kret
 */
public class Property 
{
    public Property( String name, String defaultValue, JTextComponent textComponent )
    {
        m_name = name;
        m_default = defaultValue;
        m_value = defaultValue;
        m_component = textComponent;
    }
    
    
    /**
     * Load from the Properties
     * @param conf 
     */
    public void load( Properties conf )
    {
        m_value = conf.getProperty( m_name, m_default );
        if ( null != m_component )
        {
            m_component.setText( m_value );
        }
    }
    
    
    /**
     * Store to the Properties
     * @param conf 
     */
    public void store( Properties conf )
    {
        if ( null != m_component )
        {
            m_value = m_component.getText();
        }        
        conf.setProperty( m_name, m_value );
    }
    
    /**
     * Get the property name
     * @return 
     */
    public String getName()
    {
        return m_name;
    }
        
    
    /**
     * Set the property value
     * @param value 
     */
    public void setValue( String value )
    {
        m_value = value;
    }
    
    /**
     * Set the property value
     * @param value 
     */
    public void setValue( int value )
    {
        m_value = Integer.toString( value );
    }
    
    /**
     * Get as String
     * @return 
     */
    public String getAsString()
    {
        return m_value;
    }
    
    /**
     * Get as integer
     * @return 
     */
    public int getAsInt()
    {
        return Integer.parseInt(m_value);
    }
    
    /* Property name */
    private final String m_name;
    
    /* Default value */
    private final String m_default;
    
    /* Actual value */
    private String m_value;
    
    /* Optional Text component */
    private final JTextComponent m_component;
    
}
