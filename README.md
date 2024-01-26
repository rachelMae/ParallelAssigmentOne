# ParallelAssigmentOne
To run this program, ensure you have installed a local Java developer environment.

On a Windows machine, use cd to move into the directory where you downloaded the file and dir to confirm the file is in that directory. On Mac, use cd and ls respectively. 
Once you are in the directory of the file type java FindThePrimes.java to run the program from the command line.

Once I got the 8 threads running well, the focus of this problem was the prime checker. I spent a lot of time trying to optimize the division.
I skipped the even numbers, excluded 0,1, and 2, and learned about the +6 rule with primes to cut down on speed.
Unfortunately, despite these attempts, my runtime was still 45 secs when I wanted it to be under 30sec. 
Some research led me to the Sieve of Eratosthenes, which involves a different approach by marking numbers composite and assuming the rest are prime by taking each prime, multiplying it, and marking off the multiples.

It was easy to find code that recorded runtime and used the size of the ArrayList to report how many primes there were. 
