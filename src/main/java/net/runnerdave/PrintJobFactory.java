package net.runnerdave;

import java.math.BigDecimal;
import java.util.ResourceBundle;

/**
 * Created by runnerdave on 15/01/17.
 */
public class PrintJobFactory {
    private static final ResourceBundle myResources =
            ResourceBundle.getBundle("ResourceBundle");

    private static final BigDecimal A4_SINGLE_SIDE_COLOUR_PAGE_PRICE =
                    new BigDecimal(Double.valueOf(myResources.getString("a4.single.sided.colour.page.price")));
    private static final BigDecimal A4_SINGLE_SIDE_BLACK_AND_WHITE_PAGE_PRICE =
            new BigDecimal(Double.valueOf(myResources.getString("a4.single.sided.black.and.white.page.price")));
    private static final BigDecimal A4_DOUBLE_SIDE_COLOUR_PAGE_PRICE =
            new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.colour.page.price")));
    private static final BigDecimal A4_DOUBLE_SIDE_BLACK_AND_WHITE_PAGE_PRICE =
            new BigDecimal(Double.valueOf(myResources.getString("a4.double.sided.black.and.white.page.price")));

    /**
     * Creates a PrintJob and assigns the proper prices depending on the input.
     * Default size is A4, to include more sizes add a PaperSize enum parameter and adjust the PrintJobsReader
     * accordingly.
     * @param totalPages
     * @param colourPages
     * @param isDoubleSided
     * @return PrintJob with the prices set from the config file.
     */
    public static PrintJob createPrintJob(int totalPages, int colourPages, boolean isDoubleSided) {
        PrintJob printJob = new PrintJob(totalPages, colourPages, isDoubleSided, PaperSize.A4);
        if (isDoubleSided) {
            printJob.setBlackAndWhitePagesPrice(A4_DOUBLE_SIDE_BLACK_AND_WHITE_PAGE_PRICE);
            printJob.setColourPagesPrice(A4_DOUBLE_SIDE_COLOUR_PAGE_PRICE);
        } else {
            printJob.setBlackAndWhitePagesPrice(A4_SINGLE_SIDE_BLACK_AND_WHITE_PAGE_PRICE);
            printJob.setColourPagesPrice(A4_SINGLE_SIDE_COLOUR_PAGE_PRICE);
        }
        return printJob;
    }
}
