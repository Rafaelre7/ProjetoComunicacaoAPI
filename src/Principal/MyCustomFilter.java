/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Rafael
 */
public class MyCustomFilter extends FileFilter{

@Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
        }
        @Override
        public String getDescription() {
            return "Text documents (*.txt)";
        }
    } 