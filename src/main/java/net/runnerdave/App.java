package net.runnerdave;

import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by runnerdave on 14/01/17.
 */
public class App {
    private final static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");

    public static void main(String[] args) {

        System.out.println(myResources.getString("app.initial.message"));

        PrintJobsReader reader = new PrintJobsReader(myResources.getString("print.jobs.file.name"));

        System.out.println(myResources.getString("app.log.information.message"));

        List<PrintJob> jobs = reader.loadPrintJobs();

        System.out.println();
        System.out.printf("Total number of jobs: %s\n", jobs.size());
        System.out.println("Jobs:");

        BigDecimal totalCost = new BigDecimal(0);
        for (PrintJob job: jobs
             ) {
            System.out.println(job);
            totalCost = totalCost.add(job.calculatePrice());
        }
        System.out.println("Total cost:" + totalCost);

    }
}
