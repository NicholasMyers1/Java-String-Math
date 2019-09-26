package StringMath;
import StringMath.Operation;

public abstract class StringMath{
	// final private static variables
	final private static String TRUE = "TRUE";
	final private static String FALSE = "FALSE";
	final protected static String DIVISION_OR_MODULO_ERROR = "ERROR_UNDEFINED: Division by zero..";
	final protected static String ERROR_ATTEMPTING_TO_CALCULATE = "ERROR_CALCULATING: Attempting to calculate an erroneous number..";
	// default static method: 
	static String toStringNumber(String x) { // Deletes leading/trailing zeros, out of place decimals and negatives and non-numbers;
		String stringNumberTemp = "";
		boolean isNegative = false;
		boolean isDecimal = false;
		for( int n=0;n<x.length();n++ ) { // Remove unnecessary decimals, negatives and non-numbers 
			if( x.charAt(n) == '-' && !isNegative && !isDecimal ) {
				isNegative = true;
			} else if( x.charAt(n) == '.' && !isDecimal ) {
				stringNumberTemp += "."; isDecimal = true;
			} else if( x.charAt(n) >= 48 && x.charAt(n) <= 57 ) 
				stringNumberTemp += x.charAt(n);
		} String r = stringNumberTemp;
		if( r.length() > 1 ) { // Remove unnecessary zeros: then add in the appropriate zeros and negative sign if necessary;
			for( int n = 0; !r.equals("0") && stringNumberTemp.charAt(n) == '0'; n++ ) 
				r = r.substring(1, r.length());
			for( int n = stringNumberTemp.length()-1; n >= 0 && stringNumberTemp.charAt(n) == '0' && isDecimal ; n-- )
				r = r.substring(0, r.length()-1);
			r = ( r.charAt(0) == '.' ? "0" + r : r ) + ( r.charAt(r.length()-1) == '.' ? "0" : "" );
		} if( isNegative && !r.equals("0") ) r = "-" + r;
		return( r.length() == 0 || r.equals(".") || r.equals("-") || r.equals("0.0") || r.equals("-0.0") || r.equals("-.") || r.equals("-0") ? "0" : 
				r.length() > 1 && r.charAt(r.length()-2) == '.' && r.charAt(r.length()-1) == '0' ? r.substring(0, r.length()-2) : r );
	} //public static methods: // ADDITION: 
	public static String add( StringNumber x, StringNumber y ) {
		return mathOperationParser( x.get(), y.get(), Operation.ADDITION );
	} // SUBTRACTION: 
	public static String subtract( StringNumber x, StringNumber y ) {
		return mathOperationParser( x.get(), y.get(), Operation.SUBTRACTION );
	} // MULTIPLICATION: 
	public static String multiply( StringNumber x, StringNumber y ) {
		return ( x.get().equals( "0" ) ? "0" : mathOperationParser( x.get(), y.get(), Operation.MULTIPLICATION ) );
	} // DIVISION WITH PRECISION: 
	public static String divide( StringNumber dividend, StringNumber divisor, int precisionPosition ) {
		return ( mathOperationParser( dividend.get(), divisor.get(), Operation.DIVISION, precisionPosition < 0 ? 0 : precisionPosition ) );
	} // LESS THAN:
	public static boolean lessThan( StringNumber x, StringNumber y) {
		return mathOperationParser( x.get(), y.get(), Operation.LESS_THAN ).equals(TRUE);
	} // LESS THAN OR EQUAL TO:
	public static boolean lessThanOrEqualTo( StringNumber x, StringNumber y) {
		return( mathOperationParser( x.get(), y.get(), Operation.EQUAL_TO ).equals(TRUE) || 
				mathOperationParser( x.get(), y.get(), Operation.LESS_THAN ).equals(TRUE) );
	} // GREATER THAN:
	public static boolean greaterThan( StringNumber x, StringNumber y) {
		return mathOperationParser( x.get(), y.get(), Operation.GREATER_THAN ).equals(TRUE);
	} // GREATER THAN OR EQUAL TO:
	public static boolean greaterThanOrEqualTo( StringNumber x, StringNumber y) {
		return( mathOperationParser( x.get(), y.get(), Operation.EQUAL_TO ).equals(TRUE) || 
				mathOperationParser( x.get(), y.get(), Operation.GREATER_THAN ).equals(TRUE) );
	} // EQUAL TO:
	public static boolean equalTo( StringNumber x, StringNumber y) {
		return mathOperationParser( x.get(), y.get(), Operation.EQUAL_TO ).equals(TRUE);
	} // NOT EQUAL TO:
	public static boolean notEqualTo( StringNumber x, StringNumber y) {
		return mathOperationParser( x.get(), y.get(), Operation.EQUAL_TO ).equals(FALSE);
	} // MODULO:
	public static String mod( StringNumber dividend, StringNumber divisor ) {
		boolean isNegative[] = { dividend.get().charAt(0) == '-', divisor.get().charAt(0) == '-' };
		if( !dividend.get().equals("0") && !divisor.get().equals("0") && equalTo( dividend, divisor ) ) return "0";
		else if( divisor.get().equals("0") || dividend.get().equals("0") && divisor.get().equals("0") ) return DIVISION_OR_MODULO_ERROR;
		else if( dividend.get().equals("0") ) return "0";
		else if( !isNegative[0] && !isNegative[1] ) {
			return ( lessThan( dividend, divisor ) ? dividend.get() : mathOperationParser( dividend.get(), divisor.get(), Operation.MODULO, 0 ) );
		} else if( isNegative[0] && isNegative[1] ) {
			return ( greaterThan( dividend, divisor ) ? dividend.get() : "-" + mathOperationParser( dividend.get(), divisor.get(), Operation.MODULO, 0 ) );
		} else if( !isNegative[0] && isNegative[1] ) {
			return ( lessThan( new StringNumber( dividend.get().substring(1) ), new StringNumber( divisor.get().substring(1) ) ) ? 
				add( divisor, dividend ) : 
				add( divisor, new StringNumber( mathOperationParser( dividend.get(), divisor.get(), Operation.MODULO, 0 ) ) ) );
		} else {
			return ( lessThan( new StringNumber( dividend.get().substring(1) ), new StringNumber( divisor.get().substring(1) ) ) ? 
				add( divisor, dividend ) : 
				subtract( divisor, new StringNumber( mathOperationParser( dividend.get(), divisor.get(), Operation.MODULO, 0 ) ) ) ); }
	} // Local Methods: 
	private static String mathOperationParser(String a, String b, Operation operation, int...precisionPosition) {
		String n[] = { a, b };
		for(int x=0;x<n.length;x++) 
			if( n[x].equals(DIVISION_OR_MODULO_ERROR) || n[x].equals(ERROR_ATTEMPTING_TO_CALCULATE) ) return ERROR_ATTEMPTING_TO_CALCULATE;
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
		int lengthLeftDecimal[] = { decimalPosition[1]-1, decimalPosition[0]-1 };
		int lengthRightDecimal[] = { n[1].length()-1-decimalPosition[1], n[0].length()-1-decimalPosition[0] };
		boolean isSwapped = false;
		if( operation != Operation.DIVISION && operation != Operation.MODULO ) {
			for(int c = 0; c < n.length; c++) { // add in correct number of zeros to each number before and after the decimal point:
				for(int d=0; d<lengthLeftDecimal[c] && lengthLeftDecimal[0]!=lengthLeftDecimal[1]; d++)
					{ n[c] = "0" + n[c]; decimalPosition[c]+=1; }
				for(int d=0; d<lengthRightDecimal[c] && lengthRightDecimal[0]!=lengthRightDecimal[1]; d++)
					n[c] += "0";
			}
			for(int c=0;c<n[0].length();c++) { // swap so the largest number is on top:
				if( n[0].charAt(c) < n[1].charAt(c) ) { 
					String s = n[0]; n[0] = n[1]; n[1] = s; 
					boolean neg = isNegative[0]; isNegative[0] = isNegative[1]; isNegative[1] = neg; 
					isSwapped = true; break;
				} else if( n[0].charAt(c) > n[1].charAt(c) ) break;
			}
		} if ( n[0].length() == 0 && n[1].length() == 0 ) return "0"; // return 0 if necessary:
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
			} case DIVISION: case MODULO: {
				int decimalIndex[] = { n[0].indexOf('.'), n[1].indexOf('.') };
				int lengthtoMoveDecimalOver = ( decimalIndex[1] == -1 ? 0 : n[1].length() - 1 - decimalIndex[1] );
				String divisor = toStringNumber ( n[1].replace( ".", "" ) ), dividend = n[0].replace( ".", "" );
				for( int x = 0; x < lengthtoMoveDecimalOver - (n[0].replace( ".", "" ).length() - decimalIndex[0]); x++ ) dividend += "0";
				int finalDecimalPosition = decimalIndex[0] + lengthtoMoveDecimalOver;
				result = divideFunction( divisor, dividend, precisionPosition[0] + finalDecimalPosition, ( operation == Operation.MODULO ) );
				if( result.equals("1") || result.equals("0") || result.equals( DIVISION_OR_MODULO_ERROR ) ) return result;
				if( operation == Operation.MODULO ) {
					if( lengthtoMoveDecimalOver != 0 ) { // divisor is a decimal;
						for( int x = result.length(); x < dividend.length(); x++ ) result = "0" + result;
						finalDecimalPosition = decimalIndex[0];
					} else { // divisor is a whole number;
						finalDecimalPosition = result.length();
						for( int x = result.length(); x < finalDecimalPosition; x++ ) result += "0";
					} return toStringNumber( result.substring( 0, finalDecimalPosition ) + "." + result.substring( finalDecimalPosition ) );
				} result = result.substring( 0, finalDecimalPosition ) + "." + result.substring( finalDecimalPosition );
				return toStringNumber( ( isNegative[0] && !isNegative[1] || !isNegative[0] && isNegative[1] ? "-"+result : result ) );
			} case LESS_THAN: case GREATER_THAN: case EQUAL_TO: {
				n[0] = ( isNegative[0] ? "-"+n[0] : "+"+n[0] ); n[1] = ( isNegative[1] ? "-"+n[1] : "+"+n[1] );
				if( operation == Operation.EQUAL_TO ) return ( n[0].equals( n[1] ) ? TRUE : FALSE );
				boolean neg[] = { isNegative[0], isNegative[1] }, isLessthan = ( operation == Operation.LESS_THAN );
				if( n[0].equals( n[1] ) || isLessthan && isSwapped && neg[0] && !neg[1] || isLessthan && !isSwapped && !neg[0] && neg[1] ||
					!isLessthan && isSwapped && !neg[0] && neg[1] || !isLessthan && !isSwapped && neg[0] && !neg[1] ) return FALSE;
				if(	isLessthan && isSwapped && !neg[0] && neg[1] || isLessthan && !isSwapped && neg[0] && !neg[1] ||
					!isLessthan && isSwapped && neg[0] && !neg[1] || !isLessthan && !isSwapped && !neg[0] && neg[1] ) return TRUE;
				if( isLessthan && !neg[0] && !neg[1] || !isLessthan && neg[0] && neg[1] ) 
					return ( isThan( isSwapped ? n[1] : n[0], isSwapped ? n[0] : n[1], Operation.LESS_THAN ) ? TRUE : FALSE );
				else return ( isThan( isSwapped ? n[1] : n[0], isSwapped ? n[0] : n[1], Operation.GREATER_THAN ) ? TRUE : FALSE );
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
	} private static String subtractFunction(String a, String b) { // perform the subtract function:
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
	} private static String multiplyFunction(String a, String b) { // perform the multiplication function: 
		String result = "";
		String zerosToAddPerIteration = ""; // zeros must be added to the end of the number after each iteration because of multiplication;
		for( int x=a.length()-1; x >= 0; x-- ) {
			String iterationResult = "";
			String carry = "0";
			for( int y=a.length()-1; y >= 0; y-- ) {
				String innerResult = "0";
				for( int z=0;z < (a.charAt(y)>b.charAt(x) ? Character.getNumericValue(b.charAt(x)) : Character.getNumericValue(a.charAt(y)) );z++ ){
					String tempAddValue = Character.toString( ( a.charAt(y) > b.charAt(x) ? a.charAt(y) : b.charAt(x) ) );
					innerResult = addFunction( innerResult, ( tempAddValue.length()<innerResult.length()) ? "0"+tempAddValue : tempAddValue );
				}
				innerResult = addFunction( innerResult, ( carry.length()<innerResult.length() ? "0"+carry : carry ) );
				carry = ( innerResult.length() > 1 ? Character.toString( innerResult.charAt(0) ) : "0" );
				iterationResult = innerResult.charAt( innerResult.length()-1 ) + iterationResult;
			}
			iterationResult = carry + iterationResult + zerosToAddPerIteration;
			zerosToAddPerIteration += "0";
			result = (x==a.length()-1 ? 
					iterationResult : addFunction( iterationResult, ( result.length() < iterationResult.length() ? "0" + result : result ) ));
		} return result;
	} private static String divideFunction(String divisor, String dividend, int precisionPosition, boolean isMod) {
		if( divisor.equals("0") || divisor.equals("0") && dividend.equals("0") ) return DIVISION_OR_MODULO_ERROR;
		else if( dividend.equals("0") ) return "0";
		else if( divisor.equals("1") ) return dividend;
		else if( divisor.equals(dividend) && isMod) return "0";
		String result = "";
		int dividendPosition = 1;
		int precisionLength = precisionPosition;
		String tempDividend = dividend.substring(0, dividendPosition);
		while( result.length() < precisionPosition ) { // loops until precisionPosition is met;
			String tempDivisor = divisor, addValue = tempDivisor, previousAddValue = addValue;
			int count = 0; // the below loop loops a maximum of 9 times each iteration and loops for each digit;
			while( isThan( tempDivisor, tempDividend, Operation.LESS_THAN ) && divisor.length() <= tempDividend.length() ) {
				previousAddValue = tempDivisor;
				tempDivisor = addFunction( tempDivisor, (addValue.length() < tempDivisor.length() ? addValue = "0" + addValue : addValue ) );
				count += 1;
			} if( !tempDivisor.equals(tempDividend) && tempDivisor.length() >= tempDividend.length() ) 
				tempDivisor = ( previousAddValue.length() < tempDividend.length() ? "0" : "" ) + previousAddValue;
			else count += 1;
			if( !isThan( tempDividend, tempDivisor, Operation.LESS_THAN ) ) {
				tempDividend = subtractFunction( tempDividend, tempDivisor );
				while( tempDividend.length() > 1 && tempDividend.charAt(0) == '0' )
					tempDividend = tempDividend.substring(1);
			} tempDividend = ( tempDividend.equals("0") ? "" : tempDividend );
			if( dividendPosition < dividend.length() ) {
				tempDividend += ( dividend.charAt( dividendPosition ) );
				dividendPosition += 1;
			} else if ( !isMod || isMod && precisionPosition > 1 ) tempDividend += "0";
			if( isMod && precisionPosition > 1 )		precisionPosition -= 1;
			else if( isMod && precisionPosition == 1 )	return ( !tempDividend.equals("0") ? tempDividend : dividend.substring( precisionLength ) );
			else										result += count;
		} return result;
	} private static boolean isThan(String x, String y, Operation lessThan) { // lengths are equal with decimals and negatives if from parser;
		boolean less = ( lessThan == Operation.LESS_THAN );
		if( lessThan != Operation.LESS_THAN && lessThan != Operation.GREATER_THAN ) return false;
		if( x.equals(y) || x.length() > y.length() && less || !less && x.length() < y.length() ) return false;
		if( x.length() < y.length() && less || !less && x.length() > y.length() ) return true;
		for( int n = 0; n < x.length(); n++ ) {
			if( x.charAt(n) < y.charAt(n) && less || !less && x.charAt(n) > y.charAt(n) ) return true;
			else if( x.charAt(n) > y.charAt(n) && less || !less && x.charAt(n) < y.charAt(n) ) return false;
		} return false;
	}
}