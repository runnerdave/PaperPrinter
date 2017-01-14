

#Problem description
To reduce printing waste, a school is implementing a printing solution and will charge for printing as follows:

Paper size A4, job type single sided:
  * 15 cents per black and white page
  * 25 cents per colour page

Paper size A4, job type double sided:
  * 10 cents per black and white page
  * 20 cents per colour page

Support for other paper sizes will be added in the future.  

Write a program in Java that takes a list of A4 print jobs and calculates the cost of each job, given the total number of pages, number of colour pages and whether printing is double sided.  

The application should:
  * Read print jobs from a file (see attached file for an example.)
  * Output the job details and job cost for each job to the console
  * Output the total cost of all jobs
  
#Solution
  Implementation of Static Factory Method to print different types paper depending on prices for each kind.
  
  Does not allow to print a one page as double side, it defaults to single side.
  
  To extend the solution to other sizes add 
    
#Build
  With maven installed simply run: __mvn clean package__
  
#Run
  run the following command: __java -jar target/printing-strategy-jar-with-dependencies.jar__
  
