// Define Markov Chain Class
public class MarkovChain {
	// Set instance variables
	private Vector stateVector;
	private Matrix transitionMatrix;
	
	// Create constructor
	public MarkovChain(Vector sVector, Matrix tMatrix) {
		// Initialize with input values
		stateVector = sVector;
		transitionMatrix = tMatrix;
	}
	
	// Method that checks if matrix is valid
	public boolean isValid() {
		// Check if the transition matrix is a square (same columns and rows)
		if (transitionMatrix.getNumRows()==transitionMatrix.getNumCols()) {
			// Check if transition matrix has same rows and columsn in state vector
			if (transitionMatrix.getNumRows()==stateVector.getNumCols()) {
				// Create variables to sum totals
				double totalStateVector = 0;
				double totalMatrix = 0;
				// For every number in the state vector
				for (double i : stateVector.getData()[0]){
					// Add the number to the total
					totalStateVector += i;
				
			}	
				// If total isn't in range, then it's not valid
				if ((0.99>= totalStateVector) || (totalStateVector>=1.01)) {
					return false;
			}	
				
				// Check matrix sum
				for (int i=0;i < transitionMatrix.getNumRows();i++) {
					totalMatrix = 0;
					// for every row have a diff total
					for (int j=0; j<transitionMatrix.getNumCols();j++) {
						// for every column in the row, add to the total
						totalMatrix += transitionMatrix.getData()[i][j];
					}
					// Check for each row the final total
					if ((0.99>= totalMatrix) || (totalMatrix>=1.01)) {
						return false;
					}
				}
			// If it runs through both loops and doesn't return false, return true
			return true;
			}
		}
		// If the ifrst or second if one doesn't run
		return false;
	}
	
	// Method to multiple matrix by itself
	public Matrix computeProbabilityMatrix(int numSteps) {
		// Create a temporary object equal to the matrix
		Matrix newMatrix = transitionMatrix;
		// Check if it is valid 
		if (!this.isValid()) {
			// if not return null
			return null;
		}else {
			// For numSteps-1 times
			for (int i=0; i< numSteps-1;i++) {
				// Multiply the matrix by itself 
				newMatrix = newMatrix.multiply(transitionMatrix); 
			}
			// Multiply statevector by newmatrix
			return stateVector.multiply(newMatrix);
		}
	}
}
