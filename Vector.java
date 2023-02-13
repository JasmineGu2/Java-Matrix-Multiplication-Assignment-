// Define Vector Class inherited from matrix
public class Vector extends Matrix{
	// Constructor
	public Vector(int c) {
		// Call matrix constructor
		super(1,c);
	}
	// Second constructor that overrides 
	public Vector(int c,double[]linArr) {
		// Call matrix constructor
		super(1,c,linArr);
		
	}
	
	// Method to get element
	public double getElement(int c) {
		// call matrix class method getdata
		return getData()[0][c];
	}
}
