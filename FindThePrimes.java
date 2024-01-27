import java.util.ArrayList; 
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors


public class FindThePrimes {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //start the runtime clock ticking
        //range of numbers 1 - 100 000 000
        long begin = 1;
        long end = 100000000;
        ArrayList<Long> allPrimes = new ArrayList<>(); //return the list of primes from the section

        //split into 8 sections to run
        long threadValueSize = (end - begin + 1) / 8;
        ArrayList<Thread> threads = new ArrayList<>();

        for(int i=0; i<8; i++){
            long firstNumber = begin + i * threadValueSize; // 1 + i * size gets you to that start place
            long lastNumber = (begin + (i+1) * threadValueSize) -1;

            //System.out.println("thread: " + i + "  Begin: " + firstNumber + "  end: " + lastNumber);
            // define the 8 threads to run through the 8 sections
            Thread thread = new Thread(new PrimeSweep(firstNumber, lastNumber, allPrimes));
           //add each thread to the threads array
            threads.add(thread);
        }
    

    // Start 8 threads
    for (Thread thread: threads) {
        thread.start();
    }

    // Wait for 8 threads to complete
    for (Thread thread: threads) {
        try {
            thread.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        long totalNumberPrimes = allPrimes.size();

        //sum up the arraylist
        long sumOfPrimes = allPrimes.stream().mapToLong(Long::longValue).sum();
        long endTime = System.currentTimeMillis(); //stop the clock

        // Calculate execution time
        long runtime = endTime - startTime; //find runtime before printing
        //write to a file
        try {
            FileWriter output = new FileWriter("output.txt");
            output.write("Execution Time: "  + runtime + " milliseconds\n");
            output.write("Total Number of Primes: " + totalNumberPrimes + "\n");
            output.write("Sum of All Primes: " + sumOfPrimes + "\n");
            for (int i = Math.max((int)totalNumberPrimes - 10, 0); i < totalNumberPrimes; i++) {
                output.write("Top Ten Primes " + i + ": " + (allPrimes.get(i))+ "\n");
            }
            output.close();
          } 
          catch (IOException e) {
            e.printStackTrace();
          }
    }

    //PrimeSweep Operations
    static class PrimeSweep implements Runnable {
        long begin;
        long end;
        ArrayList<Long> foundPrimesTotal;
        //set the local variables based on input
        PrimeSweep(long begin, long end, ArrayList<Long> allPrimes) {
            this.foundPrimesTotal = allPrimes;
            this.begin = begin;
            this.end = end;
        }

        //run this
        @Override
        public void run() {
            //run the algorthimn to find the primes and add to the total arraylist of primes
            foundPrimesTotal.addAll(findPrimes(begin, end));
        }

        //function to execute the algoirthmn
        private ArrayList<Long> findPrimes(long begin, long end) {
            ArrayList<Long> foundPrimes = new ArrayList<>();
            
           
            //loop through the section, skip even numbers (optimized num*num)
            for(long num = begin; num <= end; num += 2){

                if(isPrime(num, end) == true){
                    foundPrimes.add(num);
                }
            }

            return foundPrimes;
        }
        public static boolean isPrime(long num, long end) {
            // Iterate only up to end
            if (num == 3) {
                return true;
            }
            if (num % 3 == 0 ) {
                return false;
            }
            //optimized with +6 rule
            for (long i = 5; i * i <= end; i += 6) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
