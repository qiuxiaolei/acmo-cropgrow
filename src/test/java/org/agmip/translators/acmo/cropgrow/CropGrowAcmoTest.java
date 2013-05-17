package org.agmip.translators.acmo.cropgrow;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.agmip.acmo.translators.cropgrow.CropGrowAcmo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
/**
 *
 * @author Meng Zhang
 */
public class CropGrowAcmoTest {

    CropGrowAcmo runner;
    URL resource;

    @Before
    public void setUp() throws Exception {
        runner = new CropGrowAcmo();
        resource = this.getClass().getClassLoader().getResource("ACMO_meta.dat");
    }

    @Test
    public void test() throws IOException, Exception {
        File file = runner.execute(resource.getPath(), "");
        if (file != null) {
            assertTrue(file.exists());
            assertTrue(file.getName().matches("ACMO_CropGrow( \\(\\d\\))*.csv"));
            assertTrue(file.delete());
        }
    }
}