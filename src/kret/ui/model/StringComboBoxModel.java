/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kret.ui.model;

import java.util.*;
import javax.swing.ComboBoxModel;
import javax.swing.event.*;

/**
 *
 * @author wro00113
 */
public class StringComboBoxModel implements ComboBoxModel {
    
    public StringComboBoxModel()
    {
        m_items = new ArrayList<>();
        m_dataListeners = new ArrayList<>();
        
        m_selectedItem = null;
    }
    
    public void setData( String[] dataSet )
    {
        m_items.clear();
        
        int i = dataSet.length;
        while ( i != 0 )
        {            
            i--;
            m_items.add( dataSet[ i ] );
        }
        
        notifyAllDataListeners();
    }
    
    @Override public String getSelectedItem()
    {
        return m_selectedItem;
    }
    
    @Override public void setSelectedItem( Object anItem )
    {
        m_selectedItem = ( String ) anItem;
        notifyAllDataListeners();
    }
    
    @Override public void addListDataListener( ListDataListener l )
    {
        m_dataListeners.add( l );
    }
    
    @Override public void removeListDataListener( ListDataListener l )
    {
        m_dataListeners.remove( l );
    }
    
    @Override public String getElementAt( int index )
    {
        return m_items.get( index );
    }
    
    @Override public int getSize()
    {
        return m_items.size();
    }
    
    private void notifyAllDataListeners()
    {
        for ( ListDataListener listener : m_dataListeners )
        {
            listener.contentsChanged( new ListDataEvent( this, ListDataEvent.CONTENTS_CHANGED, 0, 0 ) );
        }
    }
    
    private ArrayList<String> m_items;
    private ArrayList<ListDataListener> m_dataListeners;
    private String m_selectedItem;
}
