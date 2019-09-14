package StringMath;
import java.math.BigInteger;

public class StringNumber extends StringMath{ 
	// Used for specific instances of StringNumber;
	private String stringNumber;
	private String initialStringNumber;
	// ADDITION: 
	public void add(StringNumber x) { stringNumber = add(stringNumber, x.get()); } 
	public void add(String x) { stringNumber = add(stringNumber, x); } 
	// SUBTRACTION:
	public void sub(StringNumber x) { stringNumber = sub(stringNumber, x.get()); } 
	public void sub(String x) { stringNumber = sub(stringNumber, x); }
	// MULTIPLICATION: 
	public void mult(StringNumber x) { stringNumber = mult(stringNumber, x.get());}
	public void mult(String x) { stringNumber = mult(stringNumber, x);}
	// DIVISION:
	public void divOut(StringNumber x, int pos) { stringNumber = StringMath.div(stringNumber, x.get(), pos);}	// this StringNumber divided by another StringNumber;
	public void divOut(String x, int pos) { stringNumber = StringMath.div(stringNumber, x, pos);}				// this String divided by another String;
	public void divIn(StringNumber x, int pos) { stringNumber = StringMath.div(x.get(), stringNumber, pos );}	// another StringNumber divided by this StringNumber;
	public void divIn(String x, int pos) { stringNumber = StringMath.div(x, stringNumber, pos);}				// Another String divided by this String;
	// Constructors: 
	public StringNumber() { stringNumber = "0"; initialStringNumber = stringNumber; }
	public StringNumber( StringNumber x ) { stringNumber = x.get(); initialStringNumber = stringNumber; }
	public StringNumber( String n ){ set(n); initialStringNumber = stringNumber; }
	public StringNumber( int n ){ set(Integer.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( double n ){ set(Double.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( float n ){ set(Float.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( long n ){ set(Long.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( BigInteger n ){ set(n.toString()); initialStringNumber = stringNumber; }
	public StringNumber( boolean n ){ stringNumber = (n ? "1" : "0"); initialStringNumber = stringNumber; }
	// Get, Set, and Reset: 
	public String get() { return stringNumber; }
	public void reset() { stringNumber = initialStringNumber; }
	public void set() { stringNumber = "0"; }
	public void set(StringNumber x) { stringNumber = x.get(); }
	public void set(String x) { stringNumber = toStringNumber(x); }
	public void set( int n ){ set(Integer.toString(n)); }
	public void set( double n ){ set(Double.toString(n)); }
	public void set( float n ){ set(Float.toString(n)); }
	public void set( long n ){ set(Long.toString(n)); }
	public void set( BigInteger n ){ set(n.toString()); }
	public void set( boolean n ){ stringNumber = (n ? "1" : "0" ); }
	// Override the toString method, so the hashString isn't returned;
	@Override public String toString(){ return stringNumber; }
}