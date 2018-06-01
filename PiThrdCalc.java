class PiThrdCalc extends Thread {
	private int myId;
    private int numThreads;
    private double [] table;
    private int tableSize;
	private int myStart;
    private int myStop;
    private double myStep;

	// Constructor
	public PiThrdCalc(int id, int threads, double[] array, int size, double step) {
        myId = id;
        numThreads = threads;
		table = array;
        tableSize = size;
        myStep = step;
		myStart = myId * (tableSize / numThreads);
        myStop = myStart + (tableSize / numThreads);
        if (myId == (numThreads - 1))
        	myStop = tableSize;
	}

	public void run() {
		double x;
		for(int i= myStart; i < myStop; i++) {
			x = ((double)i+0.5)*myStep;
			table[i] = 4.0/(1.0+x*x);
		}
	}
}