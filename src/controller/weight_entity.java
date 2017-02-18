/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;

/**
 *
 * @author Win7
 */
public class weight_entity {
    
     private File fileBobot;
    
    public void open(String fileName)
    {
        fileBobot = new File(fileName);
    }
    
    public File getFile()
    {
        return fileBobot;
    }
    
}
