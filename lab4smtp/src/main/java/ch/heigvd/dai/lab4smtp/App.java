package ch.heigvd.dai.lab4smtp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        PrankGenerator prankGenerator = new PrankGenerator();
        prankGenerator.startPrank();
    }
}
