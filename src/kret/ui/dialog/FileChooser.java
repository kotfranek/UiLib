/*
 * Copyright (c) 2016, kret
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package kret.ui.dialog;

/**
 *
 * @author kret
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import kret.ui.AbstractWindowContext;


/**
 *
 * @author kret
 */
public class FileChooser 
{
    public FileChooser( AbstractWindowContext windowContext, FileNameExtensionFilter filter )
    {
        m_fileChooser = new JFileChooser();
        m_fileChooser.setFileFilter( filter );
        m_windowContext = windowContext;
    }
    
    public Boolean open()
    {
        Boolean result = false;

        int fcResult = m_fileChooser.showOpenDialog( m_windowContext.getWindow() );
        
        if ( fcResult == JFileChooser.APPROVE_OPTION )
        {
            final String filePath = m_fileChooser.getSelectedFile().getAbsolutePath();
            {
                m_windowContext.showErrorMessage( "Error" , "File " + filePath + " can't be written!");
            }
        }
        
        return result;
    }
    
    private JFileChooser m_fileChooser;
    private AbstractWindowContext m_windowContext;
}
