/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agmip.acmo.translators.cropgrownau.core;
import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author qiuxiaolei
 */
public class AcmoCropGrowNAUOutputFileInput {
    
    private static final Logger log = LoggerFactory.getLogger(AcmoCropGrowNAUOutputFileInput.class);
    /**
     * 
     * @param sourceFolder
     * @return ACMO_Meta CSV String Array
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List readMeta(String sourceFolder) throws FileNotFoundException, IOException{
        String fileName = sourceFolder + "/ACMO_meta.dat";
        if(!new File(fileName).exists()){
            boolean isFileExits = false;
            File f = new File(sourceFolder);
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().toUpperCase().equals("ACMO_META.DAT")){
                        fileName = files[i].getName();
                        isFileExits = true;
                    }
                }
            }
            if(!isFileExits){
                log.error("Error File Path:"+ sourceFolder);
                return null;
            }
        }
        CSVReader reader = new CSVReader(new FileReader(fileName),',','"');
        List myEntries = reader.readAll();
        reader.close();
        return myEntries;
    }
    /**
     * 
     * @param sourceFolder
     * @return OUTPUTSUMMARY CSV String Array
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List readSummary(String sourceFolder) throws FileNotFoundException, IOException{
        String fileName = sourceFolder + "/OUTPUTSUMMARY.csv";
        if(!new File(fileName).exists()){
            boolean isFileExits = false;
            File f = new File(sourceFolder);
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().toUpperCase().equals("OUTPUTSUMMARY.CSV")){
                        fileName = files[i].getName();
                        isFileExits = true;
                    }
                }
            }
            if(!isFileExits){
                log.error("Error File Path:"+ sourceFolder);
                return null;
            }
        }
        CSVReader reader = new CSVReader(new FileReader(fileName),',');
        List myEntries = reader.readAll();
        reader.close();
        return myEntries;
    }
}
