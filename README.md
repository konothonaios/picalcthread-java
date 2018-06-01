<h1>Pi Thread Calculation</h1>

The attached program calculates a approach of π using arithmetic integration. The integral is approximated as a sum of
sub-areas. The smaller the step, the better the approach, but more with a more costly calculation.

This is achieved using threads creating as many threads as the number of CPU cores. Every thread is assigned to a part of
the calculation.

Finally we sum up all the individual results.
