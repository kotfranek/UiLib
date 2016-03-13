/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.io.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author kret
 */
public class Configuration 
{
    public Configuration( String fileName )
    {
        m_file = new File( fileName );
        m_properties = new ArrayList<>();
    }
    
    
    /**
     * Add the property
     * @param property 
     */
    public void addProperty( Property property )
    {
        m_properties.add( property );
    }


    public boolean load()
    {
        boolean result = true;
        
        Properties props = new Properties();
        
        try 
        {
            InputStream is = new FileInputStream( m_file );
            props.load( is );
        }
        catch ( Exception e ) 
        {
            result = false;
        }              
        
        for( Property property : m_properties )   
        {
            property.load( props );
        }
        
        return result;
    }
    
    
    public boolean store()
    {
        boolean result = true;
        
        Properties props = new Properties();
        
        try 
        {
            OutputStream os = new FileOutputStream( m_file );
            props.store( os, "");
        }
        catch ( Exception e ) 
        {
            result = false;
        }              
        
        for( Property property : m_properties )   
        {
            property.store( props );
        }
        
        return result;
    }
    
    /* Configuration file */
    private File m_file;
    
    /* Properties */
    private final ArrayList<Property> m_properties;
}
