import java.util.Scanner;

public class Ephrem_HugeIntegerTest
{
   public static void main( String args[] )
   {
       Scanner input = new Scanner( System.in );
       HugeInteger integer1 = new HugeInteger();
       HugeInteger integer2 = new HugeInteger();

       System.out.print( "Enter first HugeInteger: " );
       integer1.input( input.next() );

       System.out.print( "Enter second HugeInteger: " );
       integer2.input( input.next() );

       System.out.printf( "HugeInteger 1: %s\n", integer1.toString() );
       System.out.printf( "HugeInteger 2: %s\n", integer2.toString() );

       HugeInteger result;

       // add two HugeIntegers
       result = integer1.add( integer2 );
       System.out.printf( "Add result: %s\n", result.toString() );

       // subtract two HugeIntegers
       result = integer1.subtract( integer2 );
       System.out.printf( "Subtract result: %s\n", result.toString() );

       // compare two HugeIntegers
       System.out.printf("HugeInteger 1 is zero: %b\n", integer1.isZero() );
       System.out.printf("HugeInteger 2 is zero: %b\n", integer2.isZero() );
       System.out.printf("HugeInteger 1 is equal to HugeInteger 2: %b\n",integer1.isEqualTo( integer2 ) );
       System.out.printf("HugeInteger 1 is not equal to HugeInteger 2: %b\n",integer1.isNotEqualTo( integer2 ) );
       System.out.printf("HugeInteger 1 is greater than HugeInteger 2: %b\n",integer1.isGreaterThan( integer2 ) );
       System.out.printf("HugeInteger 1 is less than HugeInteger 2: %b\n",integer1.isLessThan( integer2 ) );
       System.out.printf("HugeInteger 1 is greater than or equal to HugeInteger 2: %b\n",integer1.isGreaterThanOrEqualTo( integer2 ) );
       System.out.printf("HugeInteger 1 is less than or equal to HugeInteger 2: %b\n",integer1.isLessThanOrEqualTo( integer2 ) );
   } // end main
} // end class HugeIntegerTest
