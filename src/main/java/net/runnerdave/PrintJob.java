package net.runnerdave;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by runnerdave on 14/01/17.
 */
public class PrintJob {
    private int totalPages;
    private int colourPages;
    private boolean isDoubleSided;
    private BigDecimal blackAndWhitePagesPrice;
    private BigDecimal colourPagesPrice;
    private PaperSize size;


    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Job details: ");

        details.append(" Size: ").append(size);
        details.append(isDoubleSided ? ", double sided" : ", single sided");
        details.append(", total number of pages: ").append(totalPages);
        details.append(", number of colour pages: ").append(colourPages);
        details.append(", number of black and white pages: ").append(totalPages - colourPages);
        details.append(", price: ").append(calculatePrice());

        return details.toString();
    }

    void setBlackAndWhitePagesPrice(BigDecimal blackAndWhitePagesPrice) {
        this.blackAndWhitePagesPrice = blackAndWhitePagesPrice;
    }

    void setColourPagesPrice(BigDecimal colourPagesPrice) {
        this.colourPagesPrice = colourPagesPrice;
    }

    PrintJob(int totalPages, int colourPages, boolean isDoubleSided, PaperSize size) {
        this.totalPages = totalPages;
        this.colourPages = colourPages;
        this.isDoubleSided = isDoubleSided;
        this.size = size;
    }

    BigDecimal calculatePrice() {
        BigDecimal blackAndWhiteTotal = blackAndWhitePagesPrice.multiply(new BigDecimal(totalPages - colourPages));
        BigDecimal colourTotal = colourPagesPrice.multiply(new BigDecimal(colourPages));
        return blackAndWhiteTotal.add(colourTotal).setScale(2, RoundingMode.HALF_UP);
    }
}
