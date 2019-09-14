package StringMath;
import java.math.BigInteger;
import StringMath.Operation;

public abstract class StringMath {
	// public static methods:
	public static String toStringNumber() { return "0"; }
	public static String toStringNumber(StringNumber x) { return ( toStringNumber(x) ); }
	public static String toStringNumber(int x) { return ( toStringNumber(Integer.toString(x)) ); }
	public static String toStringNumber(double x) { return (toStringNumber(Double.toString(x))); }
	public static String toStringNumber(float x) { return (toStringNumber(Float.toString(x))); }
	public static String toStringNumber(long x) { return (toStringNumber(Long.toString(x))); }
	public static String toStringNumber(BigInteger n ){ return (toStringNumber(n.toString())); }
	public static String toStringNumber(boolean x) { return ( x ? "1" : "0" ); }
	public static String toStringNumber(String x) { // Deletes leading/trailing zeros, out of place decimals and negatives and non-numbers;
		String stringNumberTemp = "";
		boolean isNegative = false;
		boolean isDecimal = false;
		// Create a valid StringNumber;
		for(int n=0;n<x.length();n++) {
			if( x.charAt(n) == '-' && !isNegative && !isDecimal ) {
				isNegative = true;
			} else if( x.charAt(n) == '.' && !isDecimal ) {
				stringNumberTemp += "."; isDecimal = true;
			} else if( x.charAt(n) >= 48 && x.charAt(n) <= 57 ) 
				stringNumberTemp += x.charAt(n);
		} // Remove unnecessary zeros: then add in the appropriate zeros and negative sign if necessary;
		String r = stringNumberTemp;
		if( r.length() > 1 ) {
			for( int n = 0; !r.equals("0") && stringNumberTemp.charAt(n) == '0'; n++ ) 
				r = r.substring(1, r.length());
			for( int n = stringNumberTemp.length()-1; n >= 0 && stringNumberTemp.charAt(n) == '0' && isDecimal ; n-- )
				r = r.substring(0, r.length()-1);
			r = ( r.charAt(0) == '.' ? "0" + r : r ) + ( r.charAt(r.length()-1) == '.' ? "0" : "" );
		} if( isNegative && !r.equals("0") ) r = "-" + r;
		return( r.length() == 0 || r.equals(".") || r.equals("-") || r.equals("0.0") || r.equals("-0.0") || r.equals("-.") || r.equals("-0") ? "0" : 
				r.length() > 1 && r.charAt(r.length()-2) == '.' && r.charAt(r.length()-1) == '0' ? r.substring(0, r.length()-2) : r );
	} // ADDITION: 
	public static String add( String x, String y ) {
		return mathOperationParser( x, y, Operation.ADDITION );
	} // SUBTRACTION: 
	public static String sub( String x, String y ) {
		return mathOperationParser( x, y, Operation.SUBTRACTION );
	} // MULTIPLICATION: 
	public static String mult( String x, String y ) {
		return ( toStringNumber(x).equals("0") ? "0" : mathOperationParser( x, y, Operation.MULTIPLICATION ) );
	} // DIVISION: 
	public static String div( String x, String y, int precisionPosition ) {
		return ( toStringNumber(x).equals("0") ? "0" : mathOperationParser( x, y, Operation.DIVISION, precisionPosition ) );
	} // local methods: 
	private static String mathOperationParser(String a, String b, Operation operation, int...precisionPosition) {
		String n[] = { toStringNumber(a) , toStringNumber(b) };
		// set negative if necessary, then remove the negative signs;
		boolean isNegative[] = { n[0].charAt(0) == '-', n[1].charAt(0) == '-' };
		// get the decimal positions if any exist and insert if necessary;
		int decimalPosition[] = { -1, -1 };
		for(int c=0;c<n.length;c++) {
			if ( isNegative[c] ) n[c] = n[c].substring(1, n[c].length());
			for(int d=0;d<n[c].length();d++) 
				if( n[c].charAt(d) == '.' ) { decimalPosition[c] = d; break; }
			if( decimalPosition[c] == -1 ) { decimalPosition[c] = n[c].length(); n[c] += "."; }
		}		
		int lengthLeft[] = { decimalPosition[1]-1, decimalPosition[0]-1 };
		int lengthRight[] = { n[1].length()-1-decimalPosition[1], n[0].length()-1-decimalPosition[0] };
		// add in correct number of zeros to each number before and after the decimal point:
		boolean isSwapped = false;
		if( operation != Operation.DIVISION ) { // swap so the largest number is on top:
			for(int c = 0; c < n.length; c++) {
				for(int d=0; d<lengthLeft[c] && lengthLeft[0]!=lengthLeft[1]; d++)
					{ n[c] = "0" + n[c]; decimalPosition[c]+=1; }
				for(int d=0; d<lengthRight[c] && lengthRight[0]!=lengthRight[1]; d++)
					n[c] += "0";
			} 
			for(int c=0;c<n[0].length();c++) {
				if( n[0].charAt(c) < n[1].charAt(c) ) { 
					String s = n[0]; n[0] = n[1]; n[1] = s; 
					boolean neg = isNegative[0]; isNegative[0] = isNegative[1]; isNegative[1] = neg; 
					isSwapped = true; break;
				} else if( n[0].charAt(c) > n[1].charAt(c) ) break;
			}
		} 
	if ( n[0].length() == 0 && n[1].length() == 0 ) return "0"; // return 0 if necessary:
		String result = "";
		switch( operation ) { // perform the appropriate function: 
			case ADDITION: {
				result = ( isNegative[0] && isNegative[1] || !isNegative[0] && !isNegative[1] ? addFunction( n[0], n[1] ) : subtractFunction( n[0], n[1] ) );
				return toStringNumber( isNegative[0] && !isNegative[1] || isNegative[1] && isNegative[0] ? "-" + result : result );
			} case SUBTRACTION: {
				result = ( isNegative[0] && isNegative[1] || !isNegative[0] && !isNegative[1] ? subtractFunction( n[0], n[1] ) : addFunction( n[0], n[1] ) );
				return toStringNumber( isSwapped && !isNegative[0] && !isNegative[1] || isSwapped && !isNegative[0] && isNegative[1] || 
						!isSwapped && isNegative[0] && isNegative[1] || !isSwapped && isNegative[0] && !isNegative[1] ? "-" + result : result );
			} case MULTIPLICATION: {
				result = multiplyFunction( n[0].replace(".", ""), n[1].replace(".", "") ); // take out decimals;
				int decimalPositionForMultiplication = ( n[0].length()-decimalPosition[0]-1 ) + ( n[1].length()-decimalPosition[1]-1 ) ;
				if( decimalPositionForMultiplication >= 0 ) 
					result =	result.substring( 0,result.length()-decimalPositionForMultiplication ) + "." +
								result.substring( result.length()-decimalPositionForMultiplication,result.length() );
				return toStringNumber( isNegative[0] && !isNegative[1] || !isNegative[0] && isNegative[1] ? "-" + result : result );
			} case DIVISION: { // divisor = n[1], dividend = n[0];
				for(int x=0;x<n.length;x++) { if( n[x].charAt(0) == '0' )
					n[x] = n[x].substring(1); }
				boolean isDivisorADecimal = ( n[1].indexOf('.') == -1 || n[1].indexOf('.') == n[1].length()-1 ? false : true );
				int lengthToMoveDecimalOver = ( !isDivisorADecimal ? 0 : n[1].length() - 1 - n[1].indexOf('.') );
				if(n[0].charAt(0)=='.' && !isDivisorADecimal)
					n[0] = '0' + n[0];
				String divisor = toStringNumber( n[1].replace( ".", "" ) );
				String dividend = n[0].replace( ".", "" );
				int finalDecimalPosition = ( n[0].indexOf('.') == -1 ? 0 : n[0].indexOf('.') ) + lengthToMoveDecimalOver;
				if( precisionPosition[0] < 0) precisionPosition[0] = 0;
				result = divideFunction( divisor, dividend, precisionPosition[0]+finalDecimalPosition );
				boolean isCorrectLength = result.length() == ( precisionPosition[0]+finalDecimalPosition );
				result = result.substring( 0, finalDecimalPosition ) + "." + result.substring( finalDecimalPosition );
				if( isNegative[0] && !isNegative[1] || !isNegative[0] && isNegative[1] ) result = "-" + result;
				return ( isCorrectLength ? result : toStringNumber( result ) );
			} default: return "";
		}
	}
	private static String addFunction(String a, String b) { // perform the add function: 
		String result = "";
		boolean carry = false;
		for( int x= a.length()-1; x >= 0; x-- ) {
			if( a.charAt(x) == '.' ) { result = '.' + result; continue; }
			int r = ( Character.getNumericValue( a.charAt(x) ) + Character.getNumericValue( b.charAt(x) ) ) + ( carry ? 1 : 0 );
			carry = ( r > 9 ? true : false );
			result = String.valueOf( ( r > 9 ? r-10 : r ) ) + result;
		} return ( carry ? "1" + result : result);
	}
	private static String subtractFunction(String a, String b) { // perform the subtract function:
		String result = "";
		boolean borrow = false;
		for( int x= a.length()-1; x >= 0; x-- ) {
			if( a.charAt(x) == '.' ) { result = "." + result; continue; }
			int top = Character.getNumericValue( a.charAt(x) ) + ( borrow ? -1 : 0 );
			int bottom = Character.getNumericValue( b.charAt(x) );
			if( top < bottom ) { top += 10 ; borrow = true; }
			else borrow = false;
			result = String.valueOf( ( top-bottom > 9 ? top-bottom-10 : top-bottom ) ) + result;
		} return result;
	}
	private static String multiplyFunction(String a, String b) { // perform the multiplication function: 
		String result = "";
		String zerosToAddPerIteration = ""; // zeros must be added to the end of the number after each iteration because of multiplication;
		for( int x=a.length()-1; x >= 0; x-- ) {
			String iterationResult = "";
			String carry = "0";
			for( int y=a.length()-1; y >= 0; y-- ) {
				String innerResult = "0";
				for( int z=0;z < ( a.charAt(y)>b.charAt(x) ? Character.getNumericValue(b.charAt(x)) : Character.getNumericValue(a.charAt(y)) );z++ ){
					String tempA = Character.toString( ( a.charAt(y) > b.charAt(x) ? a.charAt(y) : b.charAt(x) ) );
					innerResult = addFunction( innerResult, ( tempA.length()<innerResult.length()) ? "0"+tempA : tempA );
				}
				innerResult = addFunction( innerResult, ( carry.length()<innerResult.length() ? "0"+carry : carry ) );
				carry = ( innerResult.length() > 1 ? Character.toString( innerResult.charAt(0) ) : "0" );
				iterationResult = innerResult.charAt( innerResult.length()-1 ) + iterationResult;
			}
			iterationResult = carry + iterationResult + zerosToAddPerIteration;
			zerosToAddPerIteration += "0";
			result = (x==a.length()-1 ? iterationResult : addFunction( iterationResult, ( result.length() < iterationResult.length() ? "0" + result : result ) ));
		} return result;
	}
	private static String divideFunction(String divisor, String dividend, int precisionPosition) {
		if( divisor.equals("0") ) return "ERROR: Division by zero..";
		if( divisor.equals(dividend) ) return "1";
		if( dividend.equals("0") ) return "0";
		String result = "";
		int tempDivInsertAt = 1;
		String tempDividend = dividend.substring(0, tempDivInsertAt);
		while( result.length() < precisionPosition ) {
			String tempDivisor = divisor;
			int count = 0;
			if(tempDivisor.length()>tempDividend.length())tempDivisor=tempDivisor.substring(1);
			String addDivisor = tempDivisor;
			String beforeLastAdd = tempDivisor;
			while( isLessThan( tempDivisor, tempDividend ) ) { // ( maximum of 9 while loop iterations per digit );
				beforeLastAdd = tempDivisor;
				tempDivisor = addFunction( tempDivisor, (addDivisor.length() < tempDivisor.length() ? addDivisor = "0" + addDivisor : addDivisor));
				count += 1;
			}
			if( !tempDivisor.equals(tempDividend) ) tempDivisor = ( beforeLastAdd.length() < tempDividend.length() ? "0" : "" ) + beforeLastAdd;
			else count += 1;
			String remainder = tempDividend;
			if( !isLessThan( tempDividend, tempDivisor ) ) {
				remainder = subtractFunction( tempDividend, tempDivisor );
				while( remainder.length() > 1 && remainder.charAt(0) == '0' ) remainder = remainder.substring(1);
			} if( remainder.equals("0") && tempDivInsertAt >= dividend.length() || remainder.length() == 0 && tempDivInsertAt >= dividend.length() ) 
				return ( result + count );
			tempDividend = ( remainder.equals("0") ? "" : remainder );
			if( tempDivInsertAt < dividend.length() ) {
				tempDividend += ( dividend.charAt( tempDivInsertAt ) );
				tempDivInsertAt += 1;
			} else tempDividend += "0";
			result += count;
		} return result;
	}

	private static boolean isLessThan(String x, String y) { // decimals and negatives must be parsed out and the lengths must be set equal;
		if( x.equals(y) || x.length() > y.length() ) return false;
		if( x.length() < y.length() ) return true;
		for(int n=0;n<x.length();n++) {
			if( x.charAt(n) < y.charAt(n) ) return true;
			else if( x.charAt(n) > y.charAt(n) ) return false;
		} return false;
	}

	private static boolean isMoreThan(String x, String y) { // decimals and negatives must be parsed out and the lengths must be set equal;
		if( x.equals(y) || x.length() < y.length() ) return false;
		if( x.length() > y.length() ) return true;
		for(int n=0;n<x.length();n++) {
			if( x.charAt(n) > y.charAt(n) ) return true;
			else if( x.charAt(n) < y.charAt(n) ) return false;
		} return false;
	}
	
	private static boolean isEqualTo(String x, String y) { // decimals and negatives must be parsed out and the lengths must be set equal;
		return ( x.equals(y) );
	}
}