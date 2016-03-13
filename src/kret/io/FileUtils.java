/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author prpo4526
 */
public class FileUtils 
{
    public static String resourceToString( String resourcePath, String resourceEncoding )
    {
        String result = null;
        
        if ( null != resourcePath && null != resourceEncoding )
        {
            InputStream inputStream = getInputStreamForResource( resourcePath );           
            
            if ( null != inputStream )
            {
                result = inputStreamToString( inputStream, resourceEncoding );
            }
        }
        System.out.print( result.length() );  
        return result;
    }
    
    
    public static InputStream getInputStreamForResource( String resourcePath )
    {
        InputStream result = null;
        
        try
        {
            result = ClassLoader.getSystemClassLoader().getResourceAsStream( resourcePath ); 
        }
        catch( NullPointerException e )
        {

        }        
        
        return result;
    }
    
    
    public static String inputStreamToString( InputStream inputStream, String resourceEncoding )
    {
        String result = null;
        InputStreamReader streamReader = null;
        
        try 
        {
            streamReader = new InputStreamReader( inputStream, resourceEncoding );                    
        }
        catch( UnsupportedEncodingException e )
        {
                    
        }
        
        if ( null != streamReader )
        {
            char[] auxiliaryBuffer = new char[ 1024 ];
            BufferedReader bufferedReader = new BufferedReader( streamReader );
            StringWriter stringWriter = new StringWriter();
            
            try
            {
                int bytesRead = bufferedReader.read( auxiliaryBuffer );
                int writerOffset = 0;
                
                while ( -1 != bytesRead )
                {
                    stringWriter.write( auxiliaryBuffer, writerOffset, bytesRead );
                    writerOffset += bytesRead;                    
                    bytesRead = bufferedReader.read( auxiliaryBuffer );
                }
                
                result = stringWriter.toString();
            }
            catch( IOException e )
            {
                
            }            
        }
        
        return result;
    }
    
}
