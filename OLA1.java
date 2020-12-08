import java.util.Scanner;
public class OLA1{
public static void main(String[] args) {
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Enter the filing status:\n 0-single filer, 1-married jointly,\n 2-married separately, 3-head of household");
       int filingstatus = keyboard.nextInt();
       System.out.println("Enter the taxable income:");
      double income = keyboard.nextDouble();
       double tax=00.00;
       if(filingstatus==0)
{
if (income <= 8350)
   tax = income * 0.10;
else if (income <= 33950)
   tax = 8350 * 0.10 + (income - 8350) * 0.15;
else if (income <= 82250)
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
else if (income <= 171550)
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
else if (income <= 372950)
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +(82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +(income - 171550) * 0.33;
else
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
}
else if(filingstatus==1)
{
if (income <= 16700)
   tax = income * 0.10;
else if (income <= 67900)
   tax = 16700 * 0.10 + (income - 16700) * 0.15;
else if (income <= 137050)
   tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
else if (income <= 208850)
   tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income -137050) * 0.28;
else if (income <= 372950)
   tax = 16700 * 0.10 + (67900 - 16700) * 0.15 +(137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 +(income - 171550) * 0.33;
else
   tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
}
else if (filingstatus == 2)
{
if (income <= 8350)
   tax = income * 0.10;
else if (income <= 33950)
   tax = 8350 * 0.10 + (income - 8350) * 0.15;
else if (income <=68525)
tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
else if (income <= 104425)
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
else if (income <= 186475)
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +(68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +(income - 171550) * 0.33;
else
   tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 171550) * 0.33 + (income - 372950) * 0.35;
}
else if (filingstatus==3)
{
if (income <= 11950)
   tax = income * 0.10;
else if (income <= 45500)
   tax = 11950 * 0.10 + (income - 11950) * 0.15;
else if (income <= 117450)
   tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
else if (income <= 171550)
   tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
else if (income <= 372950)
   tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +(117450 - 45500) * 0.25 + (171550 - 117450) * 0.28 +(income - 171550) * 0.33;
else
   tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450- 45500) * 0.25 + (171550 - 117450) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
}
else
{
System.out.println("Error");
}
System.out.println("Tax is " + (int)(tax * 100) / 100.0);
}
}
