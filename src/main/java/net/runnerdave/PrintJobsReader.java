package net.runnerdave;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by runnerdave on 14/01/17.
 */
public class PrintJobsReader {
    final static Logger logger = Logger.getLogger(PrintJobsReader.class);

    private String fileLocation;

    public PrintJobsReader(String inFileLocation) {
        this.fileLocation = inFileLocation;
        System.out.println("Reading jobs from: " + fileLocation);
    }

    public List<PrintJob> loadPrintJobs() {
        String line = "";
        List<PrintJob> jobs = new ArrayList<PrintJob>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.fileLocation));) {
            int i = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator and remove spaces
                String[] job = line.split("\\s*,\\s*");
                i++;
                if (validateLine(job)) {
                    PrintJob printJob = PrintJobFactory.createPrintJob(Integer.parseInt(job[0]), Integer.parseInt(job[1]), Boolean.parseBoolean(job[2]));
                    jobs.add(printJob);
                } else {
                    logger.info(new StringBuilder("Invalid job in line: ").append(i));
                }

            }
        } catch (FileNotFoundException e) {
            logger.error("File not found.");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return jobs;
    }

    /**
     * Total number has to be higher or equal to number of colour pages. Line
     * has to have 3 elements. First and second elements have to be integers.
     * Last element has to be parseable as boolean.
     *
     * @param line
     * @return boolean
     */
    private boolean validateLine(String[] line) {
        boolean isValid = false;

        if (line.length == 3 && isPositiveInteger(line[0]) && isPositiveInteger(line[1]) && isBoolean(line[2])
                && (Integer.parseInt(line[0]) >= Integer.parseInt(line[1]))) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * test if positive integer
     *
     * @param str
     * @return true if value is integer and positive
     */
    private boolean isPositiveInteger(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i >= 0) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * test if parseable as boolean.
     *
     * @param str
     * @return true is value is parseable as boolean.
     */
    private boolean isBoolean(String str) {
        try {
            Boolean.parseBoolean(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
