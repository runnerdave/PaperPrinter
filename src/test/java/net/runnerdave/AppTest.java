package net.runnerdave;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testCalculatePriceOnePageOfEachDoubleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,1, true);
        assertEquals(new BigDecimal(0.30).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }

    @Test
    public void testCalculatePriceNoColourDoubleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,0, true);
        assertEquals(new BigDecimal(0.20).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }

    @Test
    public void testCalculatePriceTwoColourDoubleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,2, true);
        assertEquals(new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }

    @Test
    public void testCalculatePriceOnePageOfEachSingleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,1, false);
        assertEquals(new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }

    @Test
    public void testCalculatePriceNoColourSingleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,0, false);
        assertEquals(new BigDecimal(0.30).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }

    @Test
    public void testCalculatePriceTwoColourSingleSided() {
        PrintJob printJob = PrintJobFactory.createPrintJob(2,2, false);
        assertEquals(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP), printJob.calculatePrice());
    }
}
