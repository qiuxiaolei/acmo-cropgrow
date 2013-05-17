/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor
 */
package org.agmip.acmo.translators.cropgrow;
import java.io.File;
import java.util.List;
import org.agmip.acmo.translators.AcmoTranslator;
import org.agmip.acmo.translators.cropgrow.core.AcmoCropGrowCsvOutput;
import org.agmip.acmo.translators.cropgrow.core.AcmoCropGrowOutputFileInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ACMO CSV translator for WheatGrow output data
 *
 * @version 1.0.0
 */
public class CropGrowAcmo implements AcmoTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(CropGrowAcmo.class);
    /**
     * Output ACMO csv File with WheatGrow output data
     *
     * @param sourceFolder
     * @param destFolder
     * @return The output file
     */
    @Override
    public File execute(String sourceFolder, String destFolder) {
        try {
            // Read WheatGrow and RiceGrow output data
            AcmoCropGrowOutputFileInput cropgrowReader = new AcmoCropGrowOutputFileInput();
            //HashMap about acmometa and outputsummary
            List metaList = cropgrowReader.readMeta(sourceFolder);
            List summaryList = cropgrowReader.readSummary(sourceFolder);
            // Output CSV File
            AcmoCropGrowCsvOutput csvWriter = new AcmoCropGrowCsvOutput();
            csvWriter.writeFile(destFolder, metaList,summaryList);
            return csvWriter.getOutputFile();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}