class PiMain
{
	public static void main(String[] args)
	{
		// Megethos provlimatos
		int size = 1000;
		
		// Pi
		double pi = 0.0;
		
		// Arxikopoiisi step
		double step = 1.0 / (double)size;

		// Dhmiourgia pinaka
		double[] a = new double[size];
		for(int i = 0; i < size; i++)
			a[i] = 0; 

		// Pairnoume ton arithmo twn pirinwn gia na kanoume tosa nimata 
		int cores = Runtime.getRuntime().availableProcessors();
		int numThreads = cores;
	       
		// Enarxi xronou
        long start = System.currentTimeMillis();

		// Dimiorgia nimatwn
		PiThrdCalc threads[] = new PiThrdCalc[numThreads];
		
		// Enarxi nimatwn   
		for(int i = 0; i < numThreads; i++) {
			threads[i] = new PiThrdCalc(i, numThreads, a, size, step);
			threads[i].start();
		}

		// Anamoni na teleiwsoun ola ta nimata            
		for(int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
           	} catch (InterruptedException e) {}
		}

		// Telikos ipologismos pi
		for(int i = 0; i < size; i++)
			pi += a[i] * step;

		// Telikos xronos
	    long endTime = System.currentTimeMillis();
	    
	    // Emfanisi apotelesmatwn
        System.out.printf("Steps: %d \n", size);
        System.out.printf("Calculated pi = %22.20f\n" ,pi);
        System.out.printf("Difference between calculated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("Time = %f seconds\n", (double) (endTime - start)/1000);

	}
}