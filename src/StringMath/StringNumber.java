package StringMath;
import java.math.BigInteger;

public class StringNumber extends StringMath {
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
	public void divBy(StringNumber x, int pos) { stringNumber = StringMath.div(stringNumber, x.get(), pos);}// this divided by x (StringNumber);
	public void divBy(String x, int pos) { stringNumber = StringMath.div(stringNumber, x, pos);}			// this divided by x (String);
	public void div(StringNumber x, int pos) { stringNumber = StringMath.div(x.get(), stringNumber, pos );}	// x divided by this (StringNumber);
	public void div(String x, int pos) { stringNumber = StringMath.div(x, stringNumber, pos);}				// x divided by this (String);
	// LESS THAN, GREATER THAN, AND EQUAL TO:
	public boolean lessThan(StringNumber x) { return( lessThan(stringNumber, x.get()) );}
	public boolean lessThan(String x) { return( lessThan(stringNumber, x) );}
	public boolean greaterThan(StringNumber x) { return( greaterThan(stringNumber, x.get()) );}
	public boolean greaterThan(String x) { return( greaterThan(stringNumber, x) );}
	public boolean equalTo(StringNumber x) { return( equalTo(stringNumber, x.get()) );}
	public boolean equalTo(String x) { return( equalTo(stringNumber, x) );}
	// Constructors: 
	public StringNumber() { stringNumber = "0"; initialStringNumber = stringNumber; }
	public StringNumber( StringNumber x ) { stringNumber = x.get(); initialStringNumber = stringNumber; }
	public StringNumber( String n ){ set(n); initialStringNumber = stringNumber; }
	public StringNumber( short n ){ set(Short.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( int n ){ set(Integer.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( double n ){ set(Double.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( float n ){ set(Float.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( long n ){ set(Long.toString(n)); initialStringNumber = stringNumber; }
	public StringNumber( BigInteger n ){ set(n.toString()); initialStringNumber = stringNumber; }
	public StringNumber( boolean n ){ stringNumber = (n ? "1" : "0"); initialStringNumber = stringNumber; }
	// Get, Reset, and Set: 
	public String get() { return stringNumber; }
	public void reset() { stringNumber = initialStringNumber; }
	public void set() { stringNumber = "0"; }
	public void set( StringNumber x) { stringNumber = x.get(); }
	public void set( String x) { stringNumber = toStringNumber(x); }
	public void set( short x) { set(Short.toString(x)); }
	public void set( int n ){ set(Integer.toString(n)); }
	public void set( double n ){ set(Double.toString(n));}
	public void set( float n ){ set(Float.toString(n)); }
	public void set( long n ){ set(Long.toString(n)); }
	public void set( BigInteger n ){ set(n.toString()); }
	public void set( boolean n ){ stringNumber = (n ? "1" : "0" ); }
	// Override the toString method, so the hashString isn't returned;
	@Override public String toString(){ return stringNumber; }
}