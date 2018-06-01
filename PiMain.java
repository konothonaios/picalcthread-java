class PiMain {
	public static void main(String[] args) {
		// Problem Size
		int size = 1000;
		
		// Pi
		double pi = 0.0;
		
		// Step
		double step = 1.0 / (double)size;

		// Create table
		double[] a = new double[size];
		for(int i = 0; i < size; i++)
			a[i] = 0; 

		// Cores
		int cores = Runtime.getRuntime().availableProcessors();
		int numThreads = cores;
	       
		// Start Time
        	long start = System.currentTimeMillis();

		// Create threads
		PiThrdCalc threads[] = new PiThrdCalc[numThreads];
		
		// Start threads   
		for(int i = 0; i < numThreads; i++) {
			threads[i] = new PiThrdCalc(i, numThreads, a, size, step);
			threads[i].start();
		}

		// Wait for all threads to finish
		for(int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
           	} catch (InterruptedException e) {}
		}

		// Final calculation of Pi
		for(int i = 0; i < size; i++)
			pi += a[i] * step;

		// End time
		long endTime = System.currentTimeMillis();
	    
	   	// Printing
        	System.out.printf("Steps: %d \n", size);
        	System.out.printf("Calculated pi = %22.20f\n" ,pi);
        	System.out.printf("Difference between calculated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        	System.out.printf("Time = %f seconds\n", (double) (endTime - start)/1000);

	}
}
