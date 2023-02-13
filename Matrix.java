// Define Matrix Class
public class Matrix {
	// Define instance variables
	private int numRows;
	private int numCols; 
	private double[][] data;
	
	// Constructor
	public Matrix(int r,int c) {
		// initialize variables with parameter input
		numRows = r;
		numCols = c;
		data = new double[r][c];
	}
	
	// Constructor #2 that overrides
	public Matrix(int r, int c, double[] linArr) {
		// Call original constructor
		this(r,c);
		// using for loop, map out the array into the 2-d list  
		int count = 0;
		for (int j = 0; j < r; j++) {
			for (int i = 0; i < c; i++) {
				data[j][i] = linArr[count++];
				}
			}
	}
	
	// Getter method for rows
	public int getNumRows() {
		return numRows;
	}
	
	// Getter method for columns
	public int getNumCols() {
		return numCols;
	}
	
	// Getter method for data array
	public double[][] getData(){
		return data;
	}
	
	// Getter method for a element in the matrix
	public double getElement(int r,int c) {
		return data[r][c];
	}
	
	// Setter method for setting an element value in matrix
	public void setElement(int r,int c,double value) {
		data[r][c] = value;
	}
	
	// Transpose method 
	public void transpose() {
		// Create new double 2-d array
		double[][]transposeMatrix = new double[numCols][numRows];

		// Nested for loop to access every value in matrx
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// Change the row and column values
				transposeMatrix[j][i] = data[i][j];
			}
		}
		
		// set numRows and numCols instance variables of new object
		int tempRows = numRows;
		this.numRows = numCols;
		this.numCols = tempRows;
		// Set new object data variable to transposeMatrix
	    this.data = transposeMatrix; 
	}

	// Scalar Multiply Method
	public Matrix multiply(double scalar) {
		// Create a new matrix object
		Matrix newMatrix = new Matrix(numRows,numCols);
		// Use a nested for loop for every item in the matrix
		for (int i = 0; i< numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// multiply each element by scalar
				newMatrix.setElement(i,j, scalar*data[i][j]);
			}
		}
		// return newMatrix object
		return newMatrix;
	}
	
	// Matrix Multiply Method
	public Matrix multiply(Matrix other) {
		// If rows of other matrix and columns of matrix aren't the same, return null
		if (other.getNumRows()!= this.numCols) {
			return null;
			
		}else {
			// create new matrix object
			Matrix newMatrix = new Matrix(this.numRows,this.numCols);
			// For every row of the original matrix..
			for (int i =0; i < this.numRows;i++) {
				// for every column of the original matrix
				for (int j=0;j<this.numCols;j++) {
					for (int k=0; k< this.numCols;k++) {
						// for the number of columns there are, I need to add that
						newMatrix.setElement(i, j, newMatrix.getElement(i,j) + this.data[i][k]* other.data[k][j]);
					}
				}
			}
			return newMatrix;
		}
	}
	
	// String output Method
	public String toString() {
		// If the matrix is empty
		if (data.length == 0) {
			return "Empty matrix";
		}else {
			// Use for loop to add data to string
			String output="";
			for (int i =0; i < numRows; i++) {
				for (int j=0;j<numCols;j++) {
					// Format output and add to string output
					output = output+ String.format("%8.3f", data[i][j]);
				}
				// Add Next line
				output = output + "\n";
			}
			return output;
		}
	}
	
}
