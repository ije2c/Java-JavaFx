public class HugeInteger
{
   private final int DIGITS = 40;
   private int[] integer; // array containing the integer
   private boolean positive; // whether the integer is positive

   public HugeInteger()
   {
       integer = new int[ DIGITS ];
       positive = true;
   } 

   // convert a String to HugeInteger
   public void input( String inputString )
   {
       char[] int_char = inputString.toCharArray();

       if ( int_char[ 0 ] == '-' )
           positive = false;
       if ( positive )
           integer[ DIGITS - int_char.length ] =
           int_char[ 0 ] - '0';

       for ( int i = 1; i < int_char.length; i++ )
           integer[ DIGITS - int_char.length + i ] =
           int_char[ i ] - '0';
   }
   // add two HugeIntegers
   public HugeInteger add( HugeInteger addValue )
   {
       HugeInteger val = new HugeInteger();

       if ( positive == addValue.positive )
           val = addPositives( addValue );

       else if ( positive && ( !addValue.positive ) )
       {
           addValue.positive = true;
           if ( isGreaterThan( addValue ) )
               val = subtractPositives( addValue );
           else
           {
               val = addValue.subtractPositives( this );
               val.positive = false;
           }
           addValue.positive = false;
       }

       else if ( !positive && addValue.positive )
       {
           addValue.positive = false;
           if ( isGreaterThan( addValue ) )
               val = addValue.subtractPositives( this );
           else
           {
               val = subtractPositives( addValue );
               val.positive = false;
           }
           addValue.positive = true;
       }
       return val;
   }

   public HugeInteger addPositives( HugeInteger addValue )
   {
       HugeInteger val = new HugeInteger();
       int shift = 0;

       for ( int i = 39; i >= 0; i-- )
       {
           val.integer[ i ] =
                   integer[ i ] + addValue.integer[ i ] + shift;

           if ( val.integer[ i ] > 9 )
           {
               val.integer[ i ] %= 10;
               shift = 1;
           }
           else
               shift = 0;
       }

       if ( !positive )
           val.positive = false;
       return val;
   }

   public HugeInteger subtract( HugeInteger subtractValue )
   {
       HugeInteger val = new HugeInteger();

       if ( positive && ( !subtractValue.positive ) )
           val = addPositives( subtractValue );

       else if ( !positive && subtractValue.positive )
           val = addPositives( subtractValue );

       else
       {
           boolean isPositive = positive;
           boolean resultPositive = positive;

           positive = true;
           subtractValue.positive = true;
           if ( this.isGreaterThan( subtractValue ) )
               val = this.subtractPositives( subtractValue );
           else
           {
               val = subtractValue.subtractPositives( this );
               resultPositive = !isPositive;
           }
           positive = isPositive;
           subtractValue.positive = isPositive;
           val.positive = resultPositive;
       }
       return val;
   }
   // subtract two positive HugeIntegers
   public HugeInteger subtractPositives( HugeInteger subtractValue )
   {
       HugeInteger val = new HugeInteger();

       for ( int i = 39; i >= 0; i-- )
       {

           if ( integer[i] < subtractValue.integer[i] )
           {
               integer[ i ] += 10;
               subtractValue.integer[ i - 1 ]--;
           }
           val.integer[ i ] = integer[ i ] - subtractValue.integer[ i ];
       }
       return val;
   }

   public int findFirstNonZeroPosition()
   {
       int location = 39;

       for ( int i = 0; i < DIGITS; i++ )
       {
           if ( integer[ i ] > 0 )
               return i;
       }
       return 39;
   }
   // get string representation of HugeInteger
   public String toString()
   {
       String hugeint_output = "";
       if ( !positive )
           hugeint_output = "-";

       for ( int i = findFirstNonZeroPosition(); i < DIGITS; i++ )
           hugeint_output += integer[ i ];
       return hugeint_output;
   }
   // test if two HugeIntegers are equal
   public boolean isEqualTo( HugeInteger compareValue )
   {

       if ( positive != compareValue.positive )
           return false;

       for ( int i = 0; i < DIGITS; i++ )
       {
           if ( integer[ i ] != compareValue.integer[ i ] )
               return false;
       }
       return true;
   }
   // test if two HugeIntegers are not equal
   public boolean isNotEqualTo( HugeInteger compareValue )
   {
       return !isEqualTo( compareValue );
   }
   // test if one HugeInteger is greater than another
   public boolean isGreaterThan( HugeInteger compareValue )
   {

       if ( positive && ( !compareValue.positive ) )
           return true;
       else if ( !positive && compareValue.positive )
           return false;

       else
       {

           if ( findFirstNonZeroPosition() >
           compareValue.findFirstNonZeroPosition() )
           {
               return !positive;
           }

           else if ( findFirstNonZeroPosition() <
                   compareValue.findFirstNonZeroPosition() )
           {
               return positive;
           }

           else
           {
               for ( int i = 0; i < DIGITS; i++ )
               {
                   if ( integer[ i ] > compareValue.integer[ i ] )
                       return positive;
                   else if ( integer[ i ] < compareValue.integer[ i ] )
                       return !positive;
               }
           }
       }
       return false;
   }
   // test if one HugeInteger is less than another
   public boolean isLessThan( HugeInteger compareValue )
   {
       return !( isGreaterThan( compareValue ) ||
               isEqualTo( compareValue ) );
   }
   // test if one HugeInteger is great than or equal to another
   public boolean isGreaterThanOrEqualTo( HugeInteger compareValue )
   {
       return !isLessThan( compareValue );
   }
   // test if one HugeInteger is less than or equal to another
   public boolean isLessThanOrEqualTo( HugeInteger compareValue )
   {
       return !isGreaterThan( compareValue );
   }
   // test if one HugeInteger is zero
   public boolean isZero()
   {

       for ( int i = 0; i < DIGITS; i++ )
       {
           if ( integer[ i ] != 0 )
               return false;
       }
       return true;
   }
}
