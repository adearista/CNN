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
public class image_entity {
    
    private File fileImage;
    
    public void open(String fileName)
    {
        fileImage = new File(fileName);
    }
    
    public File getFile()
    {
        return fileImage;
    }
    
}
