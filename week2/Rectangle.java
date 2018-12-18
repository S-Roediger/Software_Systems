package ss.week2;

public class Rectangle {
	
	/**
	 * @invariant length > 0
	 */
	//@private invariant length > 0;
    private int length;	
    /**
     * @invariant width > 0
     */
    //@private invariant width > 0;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@requires length > 0 && width > 0;
    public Rectangle(int length, int width) {
    	assert length > 0 && width > 0 : "Length or width is negative, but should be positive";
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ensures \result > 0;
    public int length() {
    	assert length > 0 : "Length should be positive";
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ensures \result > 0;
    public int width() {
    	assert width > 0 : "Width should be positive";
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
   //@ensures \result == length()*width();
    //@ensures \result > 0;
    public int area() {
    	assert length > 0 && width > 0 : "Length or width is negative, but should be positive";
    	return (length * width);
    } 

    /**
     * The perimeter of this Rectangle.
     */
    
    //@ensures \result > 0;
    //@ensures \result == 2*width() + 2*length();
    public int perimeter() {
    	assert length > 0 && width > 0 : "Length or width is negative, but should be positive";
    	return ((2 * length) + (2 * width));
    }
    
    public static void main(String[] args) {
    	//Rectangle rec = new Rectangle(2,2); 
    	Rectangle recError = new Rectangle(-2, 2);
    	//System.out.println(rec.area());
    	System.out.println(recError.area());
    }
}
