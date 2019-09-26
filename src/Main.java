import StringMath.*; // import StringMath.*; | import StringMath.StringMath; | import StringMath.StringNumber; | 

import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		// For setting/creating StringNumbers, Deletes leading/trailing zeros, out of place decimals and negatives and non-numbers;
		// Do not use static methods of StringMath with an instance of StringNumber. You may not get the desired result.
		System.out.println("Instantiate some StringNumbers: (new StringNumber())");
			StringNumber z = new StringNumber(); 
			System.out.println("\tx: [EMPTY]:\t\t\t"+z); // defaults to 0;
			System.out.println("\tx: (StringNumber)x:\t\t"+new StringNumber(z)); // sets to an existing StringNumber;
			System.out.println("\tx: (String)\"-6.99\":\t\t"+new StringNumber("-6.99")); // sets to the string you implement;
			System.out.println("\tx: (Short/Byte)45:\t\t"+new StringNumber((short)45)); // sets to a short value;
			System.out.println("\tx: (Int/Char)54:\t\t"+new StringNumber(54)); // sets to an integer/char value;
			System.out.println("\tx: (Decimal)66.4:\t\t"+new StringNumber(66.4)); // sets to a double value(no 'D' indicator);
			System.out.println("\tx: (Double)-43.68D:\t\t"+new StringNumber(-43.68D)); // sets to a double value;
			System.out.println("\tx: (Float)77.55F:\t\t"+new StringNumber(77.55F)); // sets to a floating point number;
			System.out.println("\tx: (Long)5009L:\t\t\t"+new StringNumber(5009L)); // sets to a long value;
			System.out.println("\tx: (BigInteger)\"123\":\t\t"+new StringNumber(new BigInteger("123"))); // sets to a BigInteger;
			System.out.println("\tx: (Boolean)true:\t\t"+new StringNumber(true)); // sets a boolean to either 1 or 0;
		System.out.println("Set some StringNumbers: (x.set()) | (The same rules for setting also apply to instantiating.)");
		z.set();					System.out.println("\t[EMPTY]:\t\t"+z.get()); // defaults to 0;
		z.set("");					System.out.println("\t\"\":\t\t\t"+z.get()); // defaults to 0; 
		z.set("0");					System.out.println("\t0:\t\t\t"+z.get()); // defaults to 0; 
		z.set(z);					System.out.println("\tx:\t\t\t"+z.get()); // sets to another StringNumber;
		z.set(".");					System.out.println("\t.:\t\t\t"+z.get()); // sets to 0;
		z.set("-");					System.out.println("\t-:\t\t\t"+z.get()); // sets to 0;
		z.set("-.");				System.out.println("\t-.:\t\t\t"+z.get()); // sets to 0;
		z.set(".-");				System.out.println("\t.-:\t\t\t"+z.get()); // sets to 0;
		z.set("0.");				System.out.println("\t0.:\t\t\t"+z.get()); // sets to 0;
		z.set("..");				System.out.println("\t..:\t\t\t"+z.get()); // sets to 0;
		z.set("--");				System.out.println("\t--:\t\t\t"+z.get()); // sets to 0;
		z.set("++");				System.out.println("\t++:\t\t\t"+z.get()); // sets to 0;
		z.set(".0");				System.out.println("\t.0:\t\t\t"+z.get()); // sets to 0;
		z.set("-0");				System.out.println("\t-0:\t\t\t"+z.get()); // sets to 0;
		z.set("+0");				System.out.println("\t+0:\t\t\t"+z.get()); // sets to 0;
		z.set("-0.");				System.out.println("\t-0.:\t\t\t"+z.get()); // sets to 0;
		z.set("-.0");				System.out.println("\t-.0:\t\t\t"+z.get()); // sets to 0;
		z.set("0.0");				System.out.println("\t0.0:\t\t\t"+z.get()); // sets to 0;
		z.set("-0.0");				System.out.println("\t-0.0:\t\t\t"+z.get()); // sets to 0;
		z.set("+0.0");				System.out.println("\t+0.0:\t\t\t"+z.get()); // sets to 0;
		z.set("0000");				System.out.println("\t0000:\t\t\t"+z.get()); // sets to 0.00000;
		z.set("00000.00000");		System.out.println("\t00000.00000:\t\t"+z.get()); // sets to 0.00000;
		z.set("008000");			System.out.println("\t008000:\t\t\t"+z.get()); // sets to 8000;
		z.set("0007000.086600");	System.out.println("\t0007000.086600:\t\t"+z.get()); // sets to 7000.0866;		
		z.set("0007.0000866000");	System.out.println("\t0007.0000866000:\t"+z.get()); // sets to 7.0000866;
		z.set("00000.00008");		System.out.println("\t00000.00008:\t\t"+z.get()); // sets to 0.00008;
		z.set("00008.80000");		System.out.println("\t00008.80000:\t\t"+z.get()); // sets to 8.8;
		z.set("00000.80008");		System.out.println("\t00000.80008:\t\t"+z.get()); // sets to 0.80008;	
		z.set("0007");				System.out.println("\t0007:\t\t\t"+z.get()); // sets to 7;
		z.set("-00.07");			System.out.println("\t-00.07:\t\t\t"+z.get()); // sets to -0.07;
		z.set("-.07");				System.out.println("\t-.07:\t\t\t"+z.get()); // sets to -0.07;		
		z.set("a.a-7-x.mld.89&");	System.out.println("\ta.a-7-x.mld.89&:\t"+z.get()); // sets to 0.789;
		z.set(".a-a-7-x.mld.89&");	System.out.println("\t.a-a-7-x.mld.89&:\t"+z.get()); // sets to 0.789;
		z.set("a-a-7-x.mld.89&");	System.out.println("\ta-a-7-x.mld.89&:\t"+z.get()); // sets to -7.89;
		z.set("a-.a-7-x.mld.89&");	System.out.println("\ta-.a-7-x.mld.89&:\t"+z.get()); // sets to -0.789;
		z.set("39.0");				System.out.println("\t39.0:\t\t\t"+z.get()); // sets to 39;
		z.set(z);					System.out.println("\tx:\t\t\t"+z.get()); // sets to x;
		z.set("45");				System.out.println("\t\"45\":\t\t\t"+z.get()); // sets to 45;
		z.set((short)54);			System.out.println("\t(short/byte)54:\t\t"+z.get()); // sets to (short)54;
		z.set(54);					System.out.println("\t(int/char value)54:\t"+z.get()); // sets to 54;
		z.set(33.8);				System.out.println("\t33.8:\t\t\t"+z.get()); // sets to 33.8;
		z.set(33.8D);				System.out.println("\t33.8D:\t\t\t"+z.get()); // sets to 33.8;
		z.set(37.6F);				System.out.println("\t37.6F:\t\t\t"+z.get()); // sets to 37.6;
		z.set(64L);					System.out.println("\t64L:\t\t\t"+z.get()); // sets to 64;
		z.set(new BigInteger("12"));System.out.println("\tnew BigInteger(\"12\"):\t"+z.get()); // sets to 12;
		z.set(true);				System.out.println("\ttrue:\t\t\t"+z.get()); // sets to 1;
		System.out.println("print, get and reset some StringNumbers:");
					System.out.println("\tPrint: x.print() ");z.print();
					System.out.println("\tGet( x.get(), x, x.toString() ):\t\t\t\t("+z.get()+", "+z+", "+z.toString()+")");
		z.reset();	System.out.println("\tReset to initial variable for this StringNumber( x.reset() ):\t("+z.get()+")");		
		System.out.println("Addition(+) on StringNumbers: x.add() | (z=25)"); z.set(25);
		z.add(new StringNumber("-25.2"));			System.out.println("\tz+-25.2:\t\t"+z.get()); // -0.2;
		z.add(z);									System.out.println("\tz+z:\t\t\t"+z.get()); // -0.4;
		System.out.println("Subtraction(-) on StringNumbers: x.sub() | (z=25)"); z.set(25);
		z.subtract(new StringNumber("-25.2"));		System.out.println("\tz--25.2:\t\t"+z.get()); // 50.2;
		z.subtract(z);								System.out.println("\tz-z:\t\t\t"+z.get()); // 0;
		System.out.println("Multiplication(*) on StringNumbers: x.mult() | (z=25)"); z.set(25);
		z.multiply(new StringNumber("-25.2"));		System.out.println("\tz*-25.2:\t\t"+z.get()); // -630;
		z.multiply(z);								System.out.println("\tz*z:\t\t\t"+z.get()); // 396900;
		System.out.println("Division(/) on StringNumbers: x.dividedBy(), x.divides() | (z=25 each case, and precision set to 9)"); z.set(25);
		z.dividedBy(new StringNumber("-25.2"), 9);	System.out.println("\tdividedBy():\tz divided by -25.2:\t"+z.get()); z.set(25);// -0.992063492;
		z.dividedBy(new StringNumber("12"), 9);		System.out.println("\tdividedBy():\tz divided by 12:\t"+z.get()); z.set(25);// 2.083333333;
		z.divides(new StringNumber("-25.2"), 9);	System.out.println("\tdivides():\t-25.2 divides z:\t"+z.get()); z.set(25);// -1.008;
		z.divides(new StringNumber("12"), 9);		System.out.println("\tdivides():\t12 divides z:\t\t"+z.get()); z.set(25); // 0.48;
		System.out.println("Division where divisor is zero, then dividend is zero, then both are zero:");
		z.dividedBy(new StringNumber("0"), 9);		System.out.println("\tdividedBy():\tz divided by 0:\t"+z.get()); z.set(0);// error;
		z.dividedBy(new StringNumber("25"), 9);		System.out.println("\tdividedBy():\t25 divided by z:"+z.get()); z.set(0);// 0;
		z.dividedBy(new StringNumber("0"), 9);		System.out.println("\tdividedBy():\t0 divided by 0:\t"+z.get()); z.set(25);// error;
		z.divides(new StringNumber("0"), 9);		System.out.println("\tdivides():\t0 divides z:\t"+z.get()); z.set(0);// 0;
		z.divides(new StringNumber("25"), 9);		System.out.println("\tdivides():\tz divides 25:\t"+z.get()); z.set(0);// error;
		z.divides(new StringNumber("0"), 9);		System.out.println("\tdivides():\t0 divides 0:\t"+z.get()); // error;
		System.out.println("Modulo(%) on StringNumbers: x.mod(), x.modFlip() | (z=25 each case except for some in the last 6 cases)"); z.set(25);
		z.mod(new StringNumber("12.3"));			System.out.println("\tmod():\t\tz % 12.3:\t"+z.get()); z.set(25); // 0.4;
		z.mod(new StringNumber("12"));				System.out.println("\tmod():\t\tz % 12:\t\t"+z.get()); z.set(25); // 1;
		z.modFlip(new StringNumber("12.3"));		System.out.println("\tmodFlip():\t12.3 % z:\t"+z.get()); z.set(25); // 12.3;
		z.modFlip(new StringNumber("-4.4"));		System.out.println("\tmodFlip():\t-4.4 % z:\t"+z.get()); z.set(25); // 20.6;
		z.modFlip(new StringNumber("33"));			System.out.println("\tmodFlip():\t33 % z:\t\t"+z.get()); z.set(25); // 8;
		z.mod(new StringNumber("0") );				System.out.println("\tmod():\t\tz % 0:\t\t"+z.get()); z.set(0); // error;
		z.mod(new StringNumber("25") );				System.out.println("\tmod():\t\tz % 25:\t\t"+z.get()); z.set(0); // 0;
		z.mod(new StringNumber("0") );				System.out.println("\tmod():\t\t0 % 0:\t\t"+z.get()); z.set(25); // error;
		z.modFlip(new StringNumber("0") );			System.out.println("\tmodFlip():\t0 % z:\t\t"+z.get()); z.set(0); // 0;
		z.modFlip(new StringNumber("25") );			System.out.println("\tmodFlip():\t25 % z:\t\t"+z.get()); z.set(0); // error;
		z.modFlip(new StringNumber("0") );			System.out.println("\tmodFlip():\t0 % 0:\t\t"+z.get());  z.set(25); // error;
		System.out.println("<, <=, >, >=, =, !=: lessThan(), lessThanOrEqualTo(), greaterThan(), greaterThanOrEqualTo(), equalTo(), notEqualTo()"); z.set(25.5); // |-,-|-,+|+,-|+,+|
		System.out.println("Less Than:");
									System.out.println("\t25.5 < 27:\t"+z.lessThan(new StringNumber("27"))); z.set(-25.5); // true; (less)
									System.out.println("\t-25.5 < 55.6:\t"+z.lessThan(new StringNumber("55.6"))); z.set(25.5); // true; (less)
									System.out.println("\t25.5 < -27:\t"+z.lessThan(new StringNumber("-27"))); z.set(-25.5); // false; (more)
									System.out.println("\t-25.5 < -27:\t"+z.lessThan(new StringNumber("-27")));  z.set(27); // false; (more)
									System.out.println("\t27 < 25.5:\t"+z.lessThan(new StringNumber("25.5"))); z.set(-55.6); // false; (more)
									System.out.println("\t-55.6 < 25.5:\t"+z.lessThan(new StringNumber("25.5"))); z.set(27); // true; (less)
									System.out.println("\t27 < -25.5:\t"+z.lessThan(new StringNumber("-25.5"))); z.set(-27); // false; (more)
									System.out.println("\t-27 < -25.5:\t"+z.lessThan(new StringNumber("-25.5")));  z.set(-10.2); // true; (less)
									System.out.println("\t-10.2 < -10.2:\t"+z.lessThan(new StringNumber("-10.2")));  z.set(10.2); // false; (equal)
									System.out.println("\t10.2 < 10.2:\t"+z.lessThan(new StringNumber("10.2")));  z.set(25.5); // false; (equal)
		System.out.println("Less Than Or Equal To:");
									System.out.println("\t25.5 < 27:\t"+z.lessThanOrEqualTo(new StringNumber("27"))); z.set(-25.5); // true; (less)
									System.out.println("\t-25.5 < 55.6:\t"+z.lessThanOrEqualTo(new StringNumber("55.6"))); z.set(25.5); // true; (less)
									System.out.println("\t25.5 < -27:\t"+z.lessThanOrEqualTo(new StringNumber("-27"))); z.set(-25.5); // false; (more)
									System.out.println("\t-25.5 < -27:\t"+z.lessThanOrEqualTo(new StringNumber("-27")));  z.set(27); // false; (more)
									System.out.println("\t27 < 25.5:\t"+z.lessThanOrEqualTo(new StringNumber("25.5"))); z.set(-55.6); // false; (more)
									System.out.println("\t-55.6 < 25.5:\t"+z.lessThanOrEqualTo(new StringNumber("25.5"))); z.set(27); // true; (less)
									System.out.println("\t27 < -25.5:\t"+z.lessThanOrEqualTo(new StringNumber("-25.5"))); z.set(-27); // false; (more)
									System.out.println("\t-27 < -25.5:\t"+z.lessThanOrEqualTo(new StringNumber("-25.5")));  z.set(-10.2); // true; (less)
									System.out.println("\t-10.2 < -10.2:\t"+z.lessThanOrEqualTo(new StringNumber("-10.2")));  z.set(10.2); // true; (equal)
									System.out.println("\t10.2 < 10.2:\t"+z.lessThanOrEqualTo(new StringNumber("10.2")));  z.set(25.5); // true; (equal)
		System.out.println("Greater Than:");
									System.out.println("\t25.5 > 27:\t"+z.greaterThan(new StringNumber("27"))); z.set(-25.5); // false; (less)
									System.out.println("\t-25.5 > 55.6:\t"+z.greaterThan(new StringNumber("55.6"))); z.set(25.5); // false; (less)
									System.out.println("\t25.5 > -27:\t"+z.greaterThan(new StringNumber("-27"))); z.set(-25.5); // true; (more)
									System.out.println("\t-25.5 > -27:\t"+z.greaterThan(new StringNumber("-27")));  z.set(27); // true; (more)
									System.out.println("\t27 > 25.5:\t"+z.greaterThan(new StringNumber("25.5"))); z.set(-55.6); // true; (more)
									System.out.println("\t-55.6 > 25.5:\t"+z.greaterThan(new StringNumber("25.5"))); z.set(27); // false; (less)
									System.out.println("\t27 > -25.5:\t"+z.greaterThan(new StringNumber("-25.5"))); z.set(-27); // true; (more)
									System.out.println("\t-27 > -25.5:\t"+z.greaterThan(new StringNumber("-25.5")));  z.set(-10.2); // false; (less)
									System.out.println("\t-10.2 > -10.2:\t"+z.greaterThan(new StringNumber("-10.2")));  z.set(10.2); // false; (equal)
									System.out.println("\t10.2 > 10.2:\t"+z.greaterThan(new StringNumber("10.2")));  z.set(25.5); // false; (equal)
		System.out.println("Greater Than Or Equal To:");
									System.out.println("\t25.5 > 27:\t"+z.greaterThanOrEqualTo(new StringNumber("27"))); z.set(-25.5); // false; (less)
									System.out.println("\t-25.5 > 55.6:\t"+z.greaterThanOrEqualTo(new StringNumber("55.6"))); z.set(25.5); // false; (less)
									System.out.println("\t25.5 > -27:\t"+z.greaterThanOrEqualTo(new StringNumber("-27"))); z.set(-25.5); // true; (more)
									System.out.println("\t-25.5 > -27:\t"+z.greaterThanOrEqualTo(new StringNumber("-27")));  z.set(27); // true; (more)
									System.out.println("\t27 > 25.5:\t"+z.greaterThanOrEqualTo(new StringNumber("25.5"))); z.set(-55.6); // true; (more)
									System.out.println("\t-55.6 > 25.5:\t"+z.greaterThanOrEqualTo(new StringNumber("25.5"))); z.set(27); // false; (less)
									System.out.println("\t27 > -25.5:\t"+z.greaterThanOrEqualTo(new StringNumber("-25.5"))); z.set(-27); // true; (more)
									System.out.println("\t-27 > -25.5:\t"+z.greaterThanOrEqualTo(new StringNumber("-25.5")));  z.set(-10.2); // false; (less)
									System.out.println("\t-10.2 > -10.2:\t"+z.greaterThanOrEqualTo(new StringNumber("-10.2")));  z.set(10.2); // true; (equal)
									System.out.println("\t10.2 > 10.2:\t"+z.greaterThanOrEqualTo(new StringNumber("10.2")));  z.set(-10.2); // true; (equal)
		System.out.println("Equal To:");
									System.out.println("\t-10.2 = -10.2:\t"+z.equalTo(new StringNumber("-10.2")));  z.set(10.2); // true; (equal)
									System.out.println("\t10.2 = 10.2:\t"+z.equalTo(new StringNumber("10.2")));  z.set(-10.2); // true; (equal)
									System.out.println("\t-10.2 = -5.6:\t"+z.equalTo(new StringNumber("-5.6")));  z.set(10.2); // false; (not equal)
									System.out.println("\t10.2 = 7.6:\t"+z.equalTo(new StringNumber("7.6")));  z.set(-10.2); // false; (not equal)
		System.out.println("Not Equal To:");
									System.out.println("\t-10.2 = -10.2:\t"+z.notEqualTo(new StringNumber("-10.2")));  z.set(10.2); // false; (equal)
									System.out.println("\t10.2 = 10.2:\t"+z.notEqualTo(new StringNumber("10.2")));  z.set(-10.2); // false; (equal)
									System.out.println("\t-10.2 = -5.6:\t"+z.notEqualTo(new StringNumber("-5.6")));  z.set(10.2); // true; (not equal)
									System.out.println("\t10.2 = 7.6:\t"+z.notEqualTo(new StringNumber("7.6")));  z.set(25); // true; (not equal)
		System.out.println("Set prior to the error state on StringNumbers: x.resetPriorToError() | (z=25 prior to error state)");
		z.dividedBy(new StringNumber("0"), 9);System.out.println("\tdividedBy():\t\tz divided by 0:\t"+z.get()); // error;
		z.resetPriorToError();System.out.println("\tsetPriorToError():\t"+z); // 25;
		z.dividedBy(new StringNumber("0"), 9);System.out.println("\tdividedBy():\t\tz divided by 0:\t"+z.get()); // error;
		z.dividedBy(new StringNumber("0"), 9);System.out.println("\tdividedBy():\t\tz divided by 0:\t"+z.get()); // error "parent";
		z.resetPriorToError();System.out.println("\tsetPriorToError():\t"+z); // 25;
		System.out.println("Static method: (StringMath.add())");
		System.out.println( "\t0 + 0 = " + StringMath.add(new StringNumber("0"),new StringNumber("0")) );
		System.out.println( "\t10 + 29 = " + StringMath.add(new StringNumber("10"),new StringNumber("29")) );
		System.out.println( "\t-10 + 29 = " + StringMath.add(new StringNumber("-10"),new StringNumber("29")) );
		System.out.println( "\t10 + -29 = " + StringMath.add(new StringNumber("10"),new StringNumber("-29")) );
		System.out.println( "\t-10 + -29 = " + StringMath.add(new StringNumber("-10"),new StringNumber("-29")) );
		System.out.println( "\t29 + 10 = " + StringMath.add(new StringNumber("29"),new StringNumber("10")) );
		System.out.println( "\t-29 + 10 = " + StringMath.add(new StringNumber("-29"),new StringNumber("10")) );
		System.out.println( "\t29 + -10 = " + StringMath.add(new StringNumber("29"),new StringNumber("-10")) );
		System.out.println( "\t-29 + -10 = " + StringMath.add(new StringNumber("-29"),new StringNumber("-10")) );
		System.out.println( "\t.9 + .1 = " + StringMath.add(new StringNumber(".9"),new StringNumber(".1")) );
		System.out.println( "\t-.9 + .1 = " + StringMath.add(new StringNumber("-.9"),new StringNumber(".1")) );
		System.out.println( "\t.1 + -.9 = " + StringMath.add(new StringNumber(".1"),new StringNumber("-.9")) );
		System.out.println( "\t.9 + -.1 = " + StringMath.add(new StringNumber(".9"),new StringNumber("-.1")) );
		System.out.println( "\t-.1 + .9 = " + StringMath.add(new StringNumber("-.1"),new StringNumber(".9")) );
		System.out.println( "\t5 + 101 = " + StringMath.add(new StringNumber("5"),new StringNumber("101")) );
		System.out.println( "\t101 + 5 = " + StringMath.add(new StringNumber("101"),new StringNumber("5")) );
		System.out.println( "\t9.989333433999 + 9.989333333999 = " + StringMath.add(new StringNumber("9.989333433999"),new StringNumber("9.989333333999")) );
		System.out.println( "\t9.988 + 9.989 = " + StringMath.add(new StringNumber("9.988"),new StringNumber("9.989")) );
		System.out.println( "\t489.635 + 4 = " + StringMath.add(new StringNumber("489.635"),new StringNumber("4")) );
		System.out.println( "\t-489.635 + 4 = " + StringMath.add(new StringNumber("-489.635"),new StringNumber("4")) );
		System.out.println( "\t18446744073709551615 + 18446744073709551615 = " + StringMath.add(new StringNumber("18446744073709551615"),new StringNumber("18446744073709551615")) );
		System.out.println("Static method: (StringMath.sub())");
		System.out.println( "\t0 - 0 = " + StringMath.subtract(new StringNumber("0"),new StringNumber("0")) );
		System.out.println( "\t10 - 29 = " + StringMath.subtract(new StringNumber("10"),new StringNumber("29")) );
		System.out.println( "\t-10 - 29 = " + StringMath.subtract(new StringNumber("-10"),new StringNumber("29")) );
		System.out.println( "\t10 - -29 = " + StringMath.subtract(new StringNumber("10"),new StringNumber("-29")) );
		System.out.println( "\t-10 - -29 = " + StringMath.subtract(new StringNumber("-10"),new StringNumber("-29")) );
		System.out.println( "\t29 - 10 = " + StringMath.subtract(new StringNumber("29"),new StringNumber("10")) );
		System.out.println( "\t-29 - 10 = " + StringMath.subtract(new StringNumber("-29"),new StringNumber("10")) );
		System.out.println( "\t29 - -10 = " + StringMath.subtract(new StringNumber("29"),new StringNumber("-10")) );
		System.out.println( "\t-29 - -10 = " + StringMath.subtract(new StringNumber("-29"),new StringNumber("-10")) );
		System.out.println( "\t-2.04 - -0.555 = " + StringMath.subtract(new StringNumber("-2.04"),new StringNumber("-0.555")) );
		System.out.println( "\t.9 - .1 = " + StringMath.subtract(new StringNumber(".9"),new StringNumber(".1")) );
		System.out.println( "\t-.9 - .1 = " + StringMath.subtract(new StringNumber("-.9"),new StringNumber(".1")) );
		System.out.println( "\t.1 - -.9 = " + StringMath.subtract(new StringNumber(".1"),new StringNumber("-.9")) );
		System.out.println( "\t.9 - -.1 = " + StringMath.subtract(new StringNumber(".9"),new StringNumber("-.1")) );
		System.out.println( "\t-.1 - .9 = " + StringMath.subtract(new StringNumber("-.1"),new StringNumber(".9")) );
		System.out.println( "\t555401.5552 - 555400.5552 = " + StringMath.subtract(new StringNumber("555401.5552"),new StringNumber("555400.5552")) );
		System.out.println( "\t90.989333433999 - 9.989333333999 = " + StringMath.subtract(new StringNumber("90.989333433999"),new StringNumber("9.989333333999")) );
		System.out.println( "\t9.989333433999 - 9.989333333999 = " + StringMath.subtract(new StringNumber("9.989333433999"),new StringNumber("9.989333333999")) );
		System.out.println( "\t4 - 6 = " + StringMath.subtract(new StringNumber("4"),new StringNumber("6")) );
		System.out.println( "\t99 - 108 = " + StringMath.subtract(new StringNumber("99"),new StringNumber("108")) );
		System.out.println( "\t0.3 - 0.7 = " + StringMath.subtract(new StringNumber("0.3"),new StringNumber("0.7")) );
		System.out.println( "\t5554.4555 - 5556.7555 = " + StringMath.subtract(new StringNumber("5554.4555"),new StringNumber("5556.7555")) );
		System.out.println( "\t5554.4555 - 5554.4555 = " + StringMath.subtract(new StringNumber("5554.4555"),new StringNumber("5554.4555")) );
		System.out.println("Static method: (StringMath.mult())");
		System.out.println( "\t0 * 0 = " + StringMath.multiply(new StringNumber("0"),new StringNumber("0")) );
		System.out.println( "\t9 * 9 = " + StringMath.multiply(new StringNumber("9"),new StringNumber("9")) );
		System.out.println( "\t9001 * 9001 = " + StringMath.multiply(new StringNumber("9001"),new StringNumber("9001")) );
		System.out.println( "\t99 * 888 = " + StringMath.multiply(new StringNumber("999"),new StringNumber("88")) );
		System.out.println( "\t0.3 * 2.13 = " + StringMath.multiply(new StringNumber("0.3"),new StringNumber("2.13")) );
		System.out.println( "\t2.13 * 0.3 = " + StringMath.multiply(new StringNumber("2.13"),new StringNumber("0.3")) );
		System.out.println( "\t0.00003 * 2.13 = " + StringMath.multiply(new StringNumber("0.00003"),new StringNumber("2.13")) );
		System.out.println( "\t0.000303 * 2.13 = " + StringMath.multiply(new StringNumber("0.000303"),new StringNumber("2.13")) );
		System.out.println( "\t213 * 303 = " + StringMath.multiply(new StringNumber("213"),new StringNumber("303")) );
		System.out.println( "\t0000.00003 * 2.13 = " + StringMath.multiply(new StringNumber("0000.00003"),new StringNumber("2.13")) );
		System.out.println( "\t-0.3 * 222.13 = " + StringMath.multiply(new StringNumber("-0.3"),new StringNumber("222.13")) );
		System.out.println( "\t999955 * 999955 = " + StringMath.multiply(new StringNumber("999955"),new StringNumber("999955")) );
		System.out.println( "\t9999.55 * -9999.55 = " + StringMath.multiply(new StringNumber("9999.55"),new StringNumber("-9999.55")) );
		System.out.println( "\t-.1 * -9 = " + StringMath.multiply(new StringNumber("-.1"),new StringNumber("-9")) );
		System.out.println( "\t18446744073709551615 * 2 = " + StringMath.multiply(new StringNumber("18446744073709551615"),new StringNumber("2")) );
		System.out.println( "\t18446744073709551615 * 18446744073709551615 = " + StringMath.multiply(new StringNumber("18446744073709551615"),new StringNumber("18446744073709551615")) );
		System.out.println( "\t340282366920938463426481119284349108225 * 340282366920938463426481119284349108225 = " + 
							StringMath.multiply(new StringNumber("340282366920938463426481119284349108225"),new StringNumber("340282366920938463426481119284349108225")) );
		System.out.println( "\t115792089237316195398462578067141184799968521174335529155754622898352762650625 * "
							+ "115792089237316195398462578067141184799968521174335529155754622898352762650625 = " + 
							StringMath.multiply(new StringNumber("115792089237316195398462578067141184799968521174335529155754622898352762650625"),
									new StringNumber("115792089237316195398462578067141184799968521174335529155754622898352762650625")) );
		System.out.println( "\t13407807929942597093759315203840991004188031530987402520718628407015669769757"
							+ "842313630909715223819254400837606388228716074377856895316039510175975812890625 * "
							+ "13407807929942597093759315203840991004188031530987402520718628407015669769757"
							+ "842313630909715223819254400837606388228716074377856895316039510175975812890625 = " +
							StringMath.multiply(new StringNumber("1340780792994259709375931520384099100418803153098740252071862840"
											+ "7015669769757842313630909715223819254400837606388228716074377856895316039510175975812890625"),
									new StringNumber("1340780792994259709375931520384099100418803153098740252071862840701566976975784231363090971522381925440083760"
											+ "6388228716074377856895316039510175975812890625")) );
		System.out.println( "\t1000 * 1000 = " + StringMath.multiply(new StringNumber("1000"),new StringNumber("1000")) );
		System.out.println("Static method: (StringMath.div()) (Each are rounded to 15 after the decimal, then converted to a valid StringNumber)");
		System.out.println( "\tStringMath.div( \"0\",\"0\" ) = " + StringMath.divide( new StringNumber("0"), new StringNumber("0"), 15 ));
		System.out.println( "\tStringMath.div( \"0\",\"1\" ) = " + StringMath.divide( new StringNumber("0"), new StringNumber("1"), 15 ));
		System.out.println( "\tStringMath.div( \"1\",\"0\" ) = " + StringMath.divide( new StringNumber("1"), new StringNumber("0"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"7.023\",\"7.023\" ) = " + StringMath.divide( new StringNumber("7.023"), new StringNumber("7.023"), 15 ));
		System.out.println( "\tStringMath.div( \"70.23\",\"7.023\" ) = " + StringMath.divide( new StringNumber("70.23"), new StringNumber("7.023"), 15 ));
		System.out.println( "\tStringMath.div( \"7.023\",\"70.23\" ) = " + StringMath.divide( new StringNumber("7.023"), new StringNumber("70.23"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"123456\",\"1.7\" ) = " + StringMath.divide( new StringNumber("123456"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \"1.7\",\"123456\" ) = " + StringMath.divide( new StringNumber("1.7"), new StringNumber("123456"), 15 ));
		System.out.println( "\tStringMath.div( \".123456\",\"17\" ) = " + StringMath.divide( new StringNumber(".123456"), new StringNumber("17"), 15 ));
		System.out.println( "\tStringMath.div( \"4\",\"16\" ) = " + StringMath.divide( new StringNumber("4"), new StringNumber("16"), 15 ));
		System.out.println( "\tStringMath.div( \"80\",\"40\" ) = " + StringMath.divide( new StringNumber("80"), new StringNumber("40"), 15 ));
		System.out.println( "\tStringMath.div( \"8\",\".4\" ) = " + StringMath.divide( new StringNumber("8"), new StringNumber(".4"), 15 ));
		System.out.println( "\tStringMath.div( \".4\",\"8\" ) = " + StringMath.divide( new StringNumber(".4"), new StringNumber("8"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"0.0066\",\".17\" ) = " + StringMath.divide( new StringNumber("0.0066"), new StringNumber(".17"), 15 ));
		System.out.println( "\tStringMath.div( \"0.0066\",\"1.7\" ) = " + StringMath.divide( new StringNumber("0.0066"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \"0.0066\",\"17\" ) = " + StringMath.divide( new StringNumber("0.0066"), new StringNumber("17"), 15 ));
		//
		System.out.println( "\tStringMath.div( \".125\",\".17\" ) = " + StringMath.divide( new StringNumber(".125"), new StringNumber(".17"), 15 ));
		System.out.println( "\tStringMath.div( \".125\",\"1.7\" ) = " + StringMath.divide( new StringNumber(".125"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \".125\",\"17\" ) = " + StringMath.divide( new StringNumber(".125"), new StringNumber("17"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"1.25\",\".17\" ) = " + StringMath.divide( new StringNumber("1.25"), new StringNumber(".17"), 15 ));
		System.out.println( "\tStringMath.div( \"1.25\",\"1.7\" ) = " + StringMath.divide( new StringNumber("1.25"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \"1.25\",\"17\" ) = " + StringMath.divide( new StringNumber("1.25"), new StringNumber("17"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"12.5\",\".17\" ) = " + StringMath.divide( new StringNumber("12.5"), new StringNumber(".17"), 15 ));
		System.out.println( "\tStringMath.div( \"12.5\",\"1.7\" ) = " + StringMath.divide( new StringNumber("12.5"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \"12.5\",\"17\" ) = " + StringMath.divide( new StringNumber("12.5"), new StringNumber("17"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"125\",\".17\" ) = " + StringMath.divide( new StringNumber("125"), new StringNumber(".17"), 15 ));
		System.out.println( "\tStringMath.div( \"125\",\"1.7\" ) = " + StringMath.divide( new StringNumber("125"), new StringNumber("1.7"), 15 ));
		System.out.println( "\tStringMath.div( \"125\",\"17\" ) = " + StringMath.divide( new StringNumber("125"), new StringNumber("17"), 15 ));
		//
		System.out.println( "\tStringMath.div( \".17\",\".125\" ) = " + StringMath.divide( new StringNumber(".17"), new StringNumber(".125"), 15 ));
		System.out.println( "\tStringMath.div( \"1.7\",\".125\" ) = " + StringMath.divide( new StringNumber("1.7"), new StringNumber(".125"), 15 ));
		System.out.println( "\tStringMath.div( \"17\",\".125\" ) = " + StringMath.divide( new StringNumber("17"), new StringNumber(".125"), 15 ));
		//
		System.out.println( "\tStringMath.div( \".17\",\"1.25\" ) = " + StringMath.divide( new StringNumber(".17"), new StringNumber("1.25"), 15 ));
		System.out.println( "\tStringMath.div( \"1.7\",\"1.25\" ) = " + StringMath.divide( new StringNumber("1.7"), new StringNumber("1.25"), 15 ));
		System.out.println( "\tStringMath.div( \"17\",\"1.25\" ) = " + StringMath.divide( new StringNumber("17"), new StringNumber("1.25"), 15 ));
		//
		System.out.println( "\tStringMath.div( \".17\",\"12.5\" ) = " + StringMath.divide( new StringNumber(".17"), new StringNumber("12.5"), 15 ));
		System.out.println( "\tStringMath.div( \"1.7\",\"12.5\" ) = " + StringMath.divide( new StringNumber("1.7"), new StringNumber("12.5"), 15 ));
		System.out.println( "\tStringMath.div( \"17\",\"12.5\" ) = " + StringMath.divide( new StringNumber("17"), new StringNumber("12.5"), 15 ));
		//
		System.out.println( "\tStringMath.div( \".17\",\"125\" ) = " + StringMath.divide( new StringNumber(".17"), new StringNumber("125"), 15 ));
		System.out.println( "\tStringMath.div( \"1.7\",\"125\" ) = " + StringMath.divide( new StringNumber("1.7"), new StringNumber("125"), 15 ));
		System.out.println( "\tStringMath.div( \"17\",\"125\" ) = " + StringMath.divide( new StringNumber("17"), new StringNumber("125"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"12\",\"25\" ) = " + StringMath.divide( new StringNumber("12"), new StringNumber("25"), 15 ));
		System.out.println( "\tStringMath.div( \"25\",\"12\" ) = " + StringMath.divide( new StringNumber("25"), new StringNumber("12"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"250001\",\"120.33\" ) = " + StringMath.divide( new StringNumber("250001"), new StringNumber("120.33"), 15 ));
		System.out.println( "\tStringMath.div( \"120.33\",\"250001\" ) = " + StringMath.divide( new StringNumber("120.33"), new StringNumber("250001"), 15 ));
		//
		System.out.println( "\tStringMath.div( \"570.0009\",\"0.05\" ) = " + StringMath.divide(new StringNumber("570.0009"),new StringNumber("0.05"),15));
		System.out.println( "\tStringMath.div( \"0.05\",\"570.0009\" ) = " + StringMath.divide(new StringNumber("0.05"),new StringNumber("570.0009"),15));
		System.out.println( "\tStringMath.div( \"500\",\"200\" ) = " + StringMath.divide(new StringNumber("500"),new StringNumber("200"),15));
		System.out.println( "\tStringMath.div( \"200\",\"500\" ) = " + StringMath.divide(new StringNumber("200"),new StringNumber("500"),15));
		System.out.println( "\tStringMath.div( \"200.20\",\"500\" ) = " + StringMath.divide(new StringNumber("200.20"),new StringNumber("500"),15));
		//
		System.out.println( "\tStringMath.div( \"-200.20\",\"500\" ) = " + StringMath.divide(new StringNumber("-200.20"),new StringNumber("500"),15));
		System.out.println( "\tStringMath.div( \"-500\",\"200.20\" ) = " + StringMath.divide(new StringNumber("-500"),new StringNumber("200.20"),15));
		System.out.println( "\tStringMath.div( \"200.20\",\"-500\" ) = " + StringMath.divide(new StringNumber("200.20"),new StringNumber("-500"),15));
		System.out.println( "\tStringMath.div( \"500\",\"-200.20\" ) = " + StringMath.divide(new StringNumber("500"),new StringNumber("-200.20"),15));
		System.out.println( "\tStringMath.div( \"-500\",\"-200.20\" ) = " + StringMath.divide(new StringNumber("-500"),new StringNumber("-200.20"),15));
		//
		System.out.println( "\tStringMath.div( \"0\",\"500\" ) = " + StringMath.divide(new StringNumber("0"),new StringNumber("500"),15));
		System.out.println( "\tStringMath.div( \"200.20\",\"0\" ) = " + StringMath.divide(new StringNumber("200.20"),new StringNumber("0"),15));
		System.out.println( "\tStringMath.div( \"0\",\"0\" ) = " + StringMath.divide(new StringNumber("0"),new StringNumber("0"),15));
		//
		System.out.println("Static method: (StringMath.mod())");
		System.out.println("\tStringMath.mod( \"570.0009\",\"0.092\" ) = " + StringMath.mod(new StringNumber("570.0009"),new StringNumber("0.092")));
		System.out.println("\tStringMath.mod( \"900.55\",\"500.15\" ) = " + StringMath.mod(new StringNumber("900.55"),new StringNumber("500.15")));
		System.out.println("\tStringMath.mod( \"900.15\",\"500.55\" ) = " + StringMath.mod(new StringNumber("900.15"),new StringNumber("500.55")));
		System.out.println("\tStringMath.mod( \"900\",\"500.00\" ) = " + StringMath.mod(new StringNumber("900"),new StringNumber("500.00")));
		System.out.println("\tStringMath.mod( \"79665.0912345\",\"3.0912345\" ) = " + StringMath.mod(new StringNumber("79665.0912345"),new StringNumber("3.0912345")));
		System.out.println("\tStringMath.mod( \"79665.0912345\",\"3.00912345\" ) = " + StringMath.mod(new StringNumber("79665.0912345"),new StringNumber("3.00912345")));
		System.out.println("\tStringMath.mod( \"79665.0912345\",\"0.0912345\" ) = " + StringMath.mod(new StringNumber("79665.0912345"),new StringNumber("0.0912345")));
		System.out.println("\tStringMath.mod( \"0.09\",\"0.05\" ) = " + StringMath.mod(new StringNumber("0.09"),new StringNumber("0.05")));
		System.out.println("\tStringMath.mod( \"570.0009\",\"0.05\" ) = " + StringMath.mod(new StringNumber("570.0009"),new StringNumber("0.05")));
		System.out.println("\tStringMath.mod( \"570.0009\",\"0.95\" ) = " + StringMath.mod(new StringNumber("570.0009"),new StringNumber("0.95")));
		System.out.println("\tStringMath.mod( \"570.0009\",\"0.000095\" ) = " + StringMath.mod(new StringNumber("570.0009"),new StringNumber("0.000095")));
		System.out.println("\tStringMath.mod( \"72\",\"7.2\" ) = " + StringMath.mod(new StringNumber("72"),new StringNumber("7.2")));
		System.out.println("\tStringMath.mod( \"2\",\"2\" ) = " + StringMath.mod(new StringNumber("2"),new StringNumber("2")));
		System.out.println("\tStringMath.mod( \"10\",\"2\" ) = " + StringMath.mod(new StringNumber("10"),new StringNumber("2")));
		System.out.println("\tStringMath.mod( \"900\",\"500\" ) = " + StringMath.mod(new StringNumber("900"),new StringNumber("500")));
		System.out.println("\tStringMath.mod( \"900\",\"51\" ) = " + StringMath.mod(new StringNumber("900"),new StringNumber("51")));
		System.out.println("\tStringMath.mod( \"900009\",\"501\" ) = " + StringMath.mod(new StringNumber("900009"),new StringNumber("501")));
		System.out.println("\tStringMath.mod( \"900\",\"40\" ) = " + StringMath.mod(new StringNumber("900"),new StringNumber("40")));
		System.out.println("\tStringMath.mod( \"99\",\"5\" ) = " + StringMath.mod(new StringNumber("99"),new StringNumber("5")));
		System.out.println("\tStringMath.mod( \"799\",\"72\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("72")));
		System.out.println("\tStringMath.mod( \"799\",\"68\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("68")));
		System.out.println("\tStringMath.mod( \"799\",\"69\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("69")));
		System.out.println("\tStringMath.mod( \"799\",\"79\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("79")));
		System.out.println("\tStringMath.mod( \".79\",\"799\" ) = " + StringMath.mod(new StringNumber(".79"),new StringNumber("799")));
		System.out.println("\tStringMath.mod( \"0.0079\",\".799\" ) = " + StringMath.mod(new StringNumber("0.0079"),new StringNumber(".799")));
		//
		System.out.println("\tStringMath.mod( \"10\",\"4\" ) = " + StringMath.mod(new StringNumber("10"),new StringNumber("4")));
		System.out.println("\tStringMath.mod( \"4\",\"10\" ) = " + StringMath.mod(new StringNumber("4"),new StringNumber("10")));
		System.out.println("\tStringMath.mod( \"-10\",\"-4\" ) = " + StringMath.mod(new StringNumber("-10"),new StringNumber("-4")));
		System.out.println("\tStringMath.mod( \"-4\",\"-10\" ) = " + StringMath.mod(new StringNumber("-4"),new StringNumber("-10")));
		System.out.println("\tStringMath.mod( \"-.79\",\"799\" ) = " + StringMath.mod(new StringNumber("-.79"),new StringNumber("799")));
		System.out.println("\tStringMath.mod( \".79\",\"-799\" ) = " + StringMath.mod(new StringNumber(".79"),new StringNumber("-799")));
		System.out.println("\tStringMath.mod( \"-799\",\".79\" ) = " + StringMath.mod(new StringNumber("-799"),new StringNumber(".79")));
		System.out.println("\tStringMath.mod( \"799\",\"-.79\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("-.79")));
		System.out.println("\tStringMath.mod( \"799\",\"0\" ) = " + StringMath.mod(new StringNumber("799"),new StringNumber("0")));
		System.out.println("\tStringMath.mod( \"0\",\"-.79\" ) = " + StringMath.mod(new StringNumber("0"),new StringNumber("-.79")));
		System.out.println("\tStringMath.mod( \"0\",\"0\" ) = " + StringMath.mod(new StringNumber("0"),new StringNumber("0")));
		//Setting a new StringNumber to an error causes it to be an error, then it can be set to zero with resetPriorToError() or reset():
		System.out.println("Setting a new StringNumber to an error causes it to be an error, then it can be set to zero with resetPriorToError() or reset()");
		StringNumber x = new StringNumber( StringMath.divide(new StringNumber("0"), new StringNumber("0"), 1 ));
		System.out.println("\tStringNumber x = new StringNumber( StringMath.divide(new StringNumber(\"0\"), new StringNumber(\"0\"), 1 )): "+x);
		x.resetPriorToError();System.out.println("\tx.resetPriorToError(): "+x);
		StringNumber y = new StringNumber( StringMath.divide(new StringNumber("0"), new StringNumber("0"), 1 ));
		System.out.println("\tStringNumber y = new StringNumber( StringMath.divide(new StringNumber(\"0\"), new StringNumber(\"0\"), 1 )): "+y);
		y.reset();System.out.println("\ty.reset(): "+y);

	}
}