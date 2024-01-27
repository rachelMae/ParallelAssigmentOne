# ParallelAssigmentOne
To run this program, ensure you have installed a local Java developer environment.

On a Windows machine, use cd to move into the directory where you downloaded the file and dir to confirm the file is in that directory. On Mac, use cd and ls respectively. 
Once you are in the directory of the file type java FindThePrimes.java to run the program from the command line.

Once I got the 8 threads running well, the focus of this problem was the prime checker. I spent a lot of time trying to optimize the division.
I skipped the even numbers, excluded 0,1, and 2, and learned about the +6 rule with primes to cut down on speed.
Unfortunately, despite these attempts, my runtime was still 42 seconds when I wanted it to be under 30 seconds. 
Some research led me to the Sieve of Eratosthenes, which involves a different approach by marking numbers composite and assuming the rest are prime by taking each prime, multiplying it, and marking off the multiples.
I tried to implement this method but was not successful because of issues with managing the array of booleans and such led to a lot of out of bounds issues that I had not yet been able to solve by the duedate.

I wrote code that recorded runtime and used the size of the ArrayList to report how many primes there were. I could sum the contents of the ArrayList with the built-in sum function. 
To print the last 10 primes I used a loop to go through the last 10 in the ArrayList. I had to look up how to write to a file in Java but it was fairly simple to implement into my program. 
I used a geektogeek article to learn how to write to a file in Java.

