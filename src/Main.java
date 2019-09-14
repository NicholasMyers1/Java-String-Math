
import java.math.BigInteger;

import StringMath.*; // import StringMath.*; | import StringMath.StringMath; | import StringMath.StringNumber;

public class Main {
	public static void main(String args[]) {
		// For setting/creating StringNumbers, the appropriate 0-9 characters will be kept, and any out of place decimals and negatives will be parsed out;
		// Do not use static methods of StringMath with an instance of StringNumber. You may not get the desired result.
		System.out.println("Instantiate some StringNumbers: (new StringNumber())");
			StringNumber z = new StringNumber(); 
			System.out.println("\tx: [EMPTY]:\t\t\t"+z); // defaults to 0;
			System.out.println("\tx: x:\t\t\t\t"+new StringNumber(z)); // sets to an existing StringNumber;
			System.out.println("\tx: -6.99:\t\t\t"+new StringNumber("-6.99")); // sets to the string you implement;
			System.out.println("\tx: 54:\t\t\t\t"+new StringNumber(54)); // sets to an integer;
			System.out.println("\tx: 66.4:\t\t\t"+new StringNumber(66.4)); // sets to a double value(no 'D' indicator);
			System.out.println("\tx: -43.68D:\t\t\t"+new StringNumber(-43.68D)); // sets to a double value;
			System.out.println("\tx: 77.55F:\t\t\t"+new StringNumber(77.55F)); // sets to a floating point number;
			System.out.println("\tx: 5009L:\t\t\t"+new StringNumber(5009L)); // sets to a long value;
			System.out.println("\tx: new BigInteger(\"123\"):\t"+new StringNumber(new BigInteger("123"))); // sets to a BigInteger;
			System.out.println("\tx: true:\t\t\t"+new StringNumber(true)); // sets a boolean to either 1 or 0;
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
		z.set(54);					System.out.println("\t54:\t\t\t"+z.get()); // sets to 54;
		z.set(33.8);				System.out.println("\t33.8:\t\t\t"+z.get()); // sets to 33.8;
		z.set(33.8D);				System.out.println("\t33.8D:\t\t\t"+z.get()); // sets to 33.8;
		z.set(37.6F);				System.out.println("\t37.6F:\t\t\t"+z.get()); // sets to 37.6;
		z.set(64L);					System.out.println("\t64L:\t\t\t"+z.get()); // sets to 64;
		z.set(new BigInteger("12"));System.out.println("\tnew BigInteger(\"12\"):\t"+z.get()); // sets to 12;
		z.set(true);				System.out.println("\ttrue:\t\t\t"+z.get()); // sets to 1;
		System.out.println("Get and reset some StringNumbers:");
									System.out.println("\tGet( x.get(), x, x.toString() ):\t("+z.get()+", "+z+", "+z.toString()+")");
		z.reset();					System.out.println("\tReset( x.reset() ):\t\t\t("+z.get()+")");		
		System.out.println("Addition(+) on StringNumbers: x.add() | (z=25)"); z.set(25);
		z.add("-25.2");				System.out.println("\tz+-25.2:\t\t"+z.get()); // -0.2;
		z.add(z);					System.out.println("\tz+z:\t\t\t"+z.get()); // -0.4;
		System.out.println("Subtraction(+) on StringNumbers: x.sub() | (z=25)"); z.set(25);
		z.sub("-25.2");				System.out.println("\tz--25.2:\t\t"+z.get()); // 50.2;
		z.sub(z);					System.out.println("\tz-z:\t\t\t"+z.get()); // 0;
		System.out.println("Multiplication(+) on StringNumbers: x.mult() | (z=25)"); z.set(25);
		z.mult("-25.2");			System.out.println("\tz*-25.2:\t\t"+z.get()); // -630;
		z.mult(z);					System.out.println("\tz*z:\t\t\t"+z.get()); // 396900;
		System.out.println("Static method: (StringMath.add())");
		System.out.println( "\t0 + 0 = " + StringMath.add("0","0") );
		System.out.println( "\t10 + 29 = " + StringMath.add("10","29") );
		System.out.println( "\t-10 + 29 = " + StringMath.add("-10","29") );
		System.out.println( "\t10 + -29 = " + StringMath.add("10","-29") );
		System.out.println( "\t-10 + -29 = " + StringMath.add("-10","-29") );
		System.out.println( "\t29 + 10 = " + StringMath.add("29","10") );
		System.out.println( "\t-29 + 10 = " + StringMath.add("-29","10") );
		System.out.println( "\t29 + -10 = " + StringMath.add("29","-10") );
		System.out.println( "\t-29 + -10 = " + StringMath.add("-29","-10") );
		System.out.println( "\t.9 + .1 = " + StringMath.add(".9",".1") );
		System.out.println( "\t-.9 + .1 = " + StringMath.add("-.9",".1") );
		System.out.println( "\t.1 + -.9 = " + StringMath.add(".1","-.9") );
		System.out.println( "\t.9 + -.1 = " + StringMath.add(".9","-.1") );
		System.out.println( "\t-.1 + .9 = " + StringMath.add("-.1",".9") );
		System.out.println( "\t5 + 101 = " + StringMath.add("5","101") );
		System.out.println( "\t101 + 5 = " + StringMath.add("101","5") );
		System.out.println( "\t9.989333433999 + 9.989333333999 = " + StringMath.add("9.989333433999","9.989333333999") );
		System.out.println( "\t9.988 + 9.989 = " + StringMath.add("9.988","9.989") );
		System.out.println( "\t489.635 + 4 = " + StringMath.add("489.635","4") );
		System.out.println( "\t-489.635 + 4 = " + StringMath.add("-489.635","4") );
		System.out.println( "\t18446744073709551615 + 18446744073709551615 = " + StringMath.add("18446744073709551615","18446744073709551615") );
		System.out.println("Static method: (StringMath.sub())");
		System.out.println( "\t0 - 0 = " + StringMath.sub("0","0") );
		System.out.println( "\t10 - 29 = " + StringMath.sub("10","29") );
		System.out.println( "\t-10 - 29 = " + StringMath.sub("-10","29") );
		System.out.println( "\t10 - -29 = " + StringMath.sub("10","-29") );
		System.out.println( "\t-10 - -29 = " + StringMath.sub("-10","-29") );
		System.out.println( "\t29 - 10 = " + StringMath.sub("29","10") );
		System.out.println( "\t-29 - 10 = " + StringMath.sub("-29","10") );
		System.out.println( "\t29 - -10 = " + StringMath.sub("29","-10") );
		System.out.println( "\t-29 - -10 = " + StringMath.sub("-29","-10") );
		System.out.println( "\t-2.04 - -0.555 = " + StringMath.sub("-2.04","-0.555") );
		System.out.println( "\t.9 - .1 = " + StringMath.sub(".9",".1") );
		System.out.println( "\t-.9 - .1 = " + StringMath.sub("-.9",".1") );
		System.out.println( "\t.1 - -.9 = " + StringMath.sub(".1","-.9") );
		System.out.println( "\t.9 - -.1 = " + StringMath.sub(".9","-.1") );
		System.out.println( "\t-.1 - .9 = " + StringMath.sub("-.1",".9") );
		System.out.println( "\t555401.5552 - 555400.5552 = " + StringMath.sub("555401.5552","555400.5552") );
		System.out.println( "\t90.989333433999 - 9.989333333999 = " + StringMath.sub("90.989333433999","9.989333333999") );
		System.out.println( "\t9.989333433999 - 9.989333333999 = " + StringMath.sub("9.989333433999","9.989333333999") );
		System.out.println( "\t4 - 6 = " + StringMath.sub("4","6") );
		System.out.println( "\t99 - 108 = " + StringMath.sub("99","108") );
		System.out.println( "\t0.3 - 0.7 = " + StringMath.sub("0.3","0.7") );
		System.out.println( "\t5554.4555 - 5556.7555 = " + StringMath.sub("5554.4555","5556.7555") );
		System.out.println( "\t5554.4555 - 5554.4555 = " + StringMath.sub("5554.4555","5554.4555") );
		System.out.println("Static method: (StringMath.mult())");
		System.out.println( "\t0 * 0 = " + StringMath.mult("0","0") );
		System.out.println( "\t9 * 9 = " + StringMath.mult("9","9") );
		System.out.println( "\t9001 * 9001 = " + StringMath.mult("9001","9001") );
		System.out.println( "\t99 * 888 = " + StringMath.mult("999","88") );
		System.out.println( "\t0.3 * 2.13 = " + StringMath.mult("0.3","2.13") );
		System.out.println( "\t2.13 * 0.3 = " + StringMath.mult("2.13","0.3") );
		System.out.println( "\t0.00003 * 2.13 = " + StringMath.mult("0.00003","2.13") );
		System.out.println( "\t0.000303 * 2.13 = " + StringMath.mult("0.000303","2.13") );
		System.out.println( "\t213 * 303 = " + StringMath.mult("213","303") );
		System.out.println( "\t0000.00003 * 2.13 = " + StringMath.mult("0000.00003","2.13") );
		System.out.println( "\t-0.3 * 222.13 = " + StringMath.mult("-0.3","222.13") );
		System.out.println( "\t999955 * 999955 = " + StringMath.mult("999955","999955") );
		System.out.println( "\t9999.55 * -9999.55 = " + StringMath.mult("9999.55","-9999.55") );
		System.out.println( "\t-.1 * -9 = " + StringMath.mult("-.1","-9") );
		System.out.println( "\t18446744073709551615 * 2 = " + StringMath.mult("18446744073709551615","2") );
		System.out.println( "\t18446744073709551615 * 18446744073709551615 = " + StringMath.mult("18446744073709551615","18446744073709551615") );
		System.out.println( "\t340282366920938463426481119284349108225 * 340282366920938463426481119284349108225 = " + StringMath.mult("340282366920938463426481119284349108225","340282366920938463426481119284349108225") );
		System.out.println( "\t115792089237316195398462578067141184799968521174335529155754622898352762650625 * 115792089237316195398462578067141184799968521174335529155754622898352762650625 = " + StringMath.mult("115792089237316195398462578067141184799968521174335529155754622898352762650625","115792089237316195398462578067141184799968521174335529155754622898352762650625") );
		System.out.println( "\t13407807929942597093759315203840991004188031530987402520718628407015669769757842313630909715223819254400837606388228716074377856895316039510175975812890625 * 13407807929942597093759315203840991004188031530987402520718628407015669769757842313630909715223819254400837606388228716074377856895316039510175975812890625 = " + StringMath.mult("13407807929942597093759315203840991004188031530987402520718628407015669769757842313630909715223819254400837606388228716074377856895316039510175975812890625","13407807929942597093759315203840991004188031530987402520718628407015669769757842313630909715223819254400837606388228716074377856895316039510175975812890625") );
		System.out.println( "\t1000 * 1000 = " + StringMath.mult("1000","1000") );
		System.out.println("Static methods from StringMath:");
		System.out.println("Static method: (StringMath.div())");
//		System.out.println( "\tStringMath.div( \"0\",\"0\" ) = " + StringMath.div( "0", "0" ));
//		System.out.println( "\tStringMath.div( \"0\",\"1\" ) = " + StringMath.div( "0", "1" ));
//		System.out.println( "\tStringMath.div( \"1\",\"0\" ) = " + StringMath.div( "1", "0" ));
//		System.out.println( "\tStringMath.div( \"1\",\"1\" ) = " + StringMath.div( "1", "1" ));
//		System.out.println( "\tStringMath.div( \"1.7\",\"123456\" ) = " + StringMath.div( 10,  "1.7", "123456" ));
//		System.out.println( "\tStringMath.div( \".123456\",\"17\" ) = " + StringMath.div( 1, ".123456", "17" ));
		System.out.println( "\tStringMath.div( \"1.7\",\"123456\" ) = " + StringMath.div( "4", "16", 10 ));
		//
//		System.out.println( "\tStringMath.div( \"0.0066\",\".17\" ) = " + StringMath.div( "0.0066", ".17" ));
//		System.out.println( "\tStringMath.div( \"0.0066\",\"1.7\" ) = " + StringMath.div( "0.0066", "1.7" ));
//		System.out.println( "\tStringMath.div( \"0.0066\",\"17\" ) = " + StringMath.div( "0.0066", "17" ));

//		System.out.println( "\tStringMath.div( \".125\",\".17\" ) = " + StringMath.div( ".125", ".17" ));
//		System.out.println( "\tStringMath.div( \".125\",\"1.7\" ) = " + StringMath.div( ".125", "1.7" ));
//		System.out.println( "\tStringMath.div( \".125\",\"17\" ) = " + StringMath.div( ".125", "17" ));
//		//
//		System.out.println( "\tStringMath.div( \"1.25\",\".17\" ) = " + StringMath.div( "1.25", ".17" ));
//		System.out.println( "\tStringMath.div( \"1.25\",\"1.7\" ) = " + StringMath.div( "1.25", "1.7" ));
//		System.out.println( "\tStringMath.div( \"1.25\",\"17\" ) = " + StringMath.div( "1.25", "17" ));
//		//
//		System.out.println( "\tStringMath.div( \"12.5\",\".17\" ) = " + StringMath.div( "12.5", ".17" ));
//		System.out.println( "\tStringMath.div( \"12.5\",\"1.7\" ) = " + StringMath.div( "12.5", "1.7" ));
//		System.out.println( "\tStringMath.div( \"12.5\",\"17\" ) = " + StringMath.div( "12.5", "17" ));
//		//
//		System.out.println( "\tStringMath.div( \"125\",\".17\" ) = " + StringMath.div( "125", ".17" ));
//		System.out.println( "\tStringMath.div( \"125\",\"1.7\" ) = " + StringMath.div( "125", "1.7" ));
//		System.out.println( "\tStringMath.div( \"125\",\"17\" ) = " + StringMath.div( "125", "17" ));
	}
}