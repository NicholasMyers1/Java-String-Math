package StringMath;
import java.math.BigInteger;

public class StringNumber extends StringMath {
	// Variables for specific instances of StringNumber;
	private String stringNumber;
	private String initialStringNumber;
	private String priorToErrorStringNumber;
	// ADDITION:  
	public void add(StringNumber x) {		setPreErrorState(); stringNumber = add(this, x); } 
	// SUBTRACTION:
	public void subtract(StringNumber x) {	setPreErrorState(); stringNumber = subtract(this, x); } 
	// MULTIPLICATION: 
	public void multiply(StringNumber x) {	setPreErrorState(); stringNumber = multiply(this, x);}
	// DIVISION:
	public void dividedBy(StringNumber divisor, int precision) {setPreErrorState(); stringNumber = StringMath.divide(this, divisor, precision);}
	public void divides(StringNumber dividend, int precision) {	setPreErrorState(); stringNumber = StringMath.divide(dividend, this, precision );}
	// LESS THAN, GREATER THAN, EQUAL TO, and the appropriate combinations:
	public boolean lessThan(StringNumber x) {				setPreErrorState(); return( lessThan(this, x) );}
	public boolean lessThanOrEqualTo(StringNumber x) {		setPreErrorState(); return( lessThan(this, x) || equalTo(this, x ) );}
	public boolean greaterThan(StringNumber x) {			setPreErrorState(); return( greaterThan(this, x) );}
	public boolean greaterThanOrEqualTo(StringNumber x) {	setPreErrorState(); return( greaterThan(this, x) || equalTo(this, x ) );}
	public boolean equalTo(StringNumber x) {				setPreErrorState(); return( equalTo(this, x) );}
	public boolean notEqualTo(StringNumber x) {				setPreErrorState(); return( notEqualTo(this, x) );}
	// MODULO:
	public void mod(StringNumber divisor) {			setPreErrorState(); stringNumber = StringMath.mod(this, divisor );}
	public void modFlip(StringNumber dividend) {	setPreErrorState(); stringNumber = StringMath.mod(dividend, this );}
	// Constructors: ( Converting a character to a StringNumber defaults to the integer constructor with the corresponding decimal ASCII value. )
	public StringNumber() {					set("0");					initialStringNumber = stringNumber; }
	public StringNumber( StringNumber x){	set(x.get());				initialStringNumber = stringNumber; }
	public StringNumber( String n ){		set(n);						initialStringNumber = stringNumber; }
	public StringNumber( short n ){			set(Short.toString(n));		initialStringNumber = stringNumber; }
	public StringNumber( int n ){			set(Integer.toString(n));	initialStringNumber = stringNumber; }
	public StringNumber( double n ){		set(Double.toString(n));	initialStringNumber = stringNumber; }
	public StringNumber( float n ){			set(Float.toString(n));		initialStringNumber = stringNumber; }
	public StringNumber( long n ){			set(Long.toString(n));		initialStringNumber = stringNumber; }
	public StringNumber( BigInteger n ){	set(n.toString());			initialStringNumber = stringNumber; }
	public StringNumber( boolean n ) {		set(n?"1":"0");				initialStringNumber = stringNumber; }
	// Get, Set, Reset, and Reset Prior To Error: 
	public String get() {				return stringNumber; }
	public void set() {					set("0"); }
	public void set( StringNumber x) {	x.get(); }
	public void set( String x) {		stringNumber = ( isError(x) ? x : toStringNumber(x) ); }
	public void set( short x) {			set(Short.toString(x)); }
	public void set( int n ){			set(Integer.toString(n)); }
	public void set( double n ){		set(Double.toString(n));}
	public void set( float n ){			set(Float.toString(n)); }
	public void set( long n ){			set(Long.toString(n)); }
	public void set( BigInteger n ){	set(n.toString()); }
	public void set( boolean n ){		set(n?"1":"0"); }
	public void reset() {				if( isError( initialStringNumber ) ) initialStringNumber = "0";
											stringNumber = initialStringNumber; }
	public void resetPriorToError() {	if( priorToErrorStringNumber == null || isError( priorToErrorStringNumber ) )
											priorToErrorStringNumber = "0";
										stringNumber = priorToErrorStringNumber; }
	private void setPreErrorState() { 	if( !isError( stringNumber ) ) priorToErrorStringNumber = stringNumber;}
	private boolean isError(String x) {	return( x.equals( DIVISION_OR_MODULO_ERROR ) || 
												x.equals( ERROR_ATTEMPTING_TO_CALCULATE ) );}
	// Override the toString method, so the hashString isn't returned;
	@Override public String toString(){	return stringNumber; }
	public void print() {				System.out.println(stringNumber); }
}