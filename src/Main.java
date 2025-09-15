import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        GameCharacter one = new GameCharacter(99,100,30,30,30,"mogus");



        //System.out.println(one.dodgeCalc(100));
        //System.out.println(one.basicAttack());

        UnitTests.runCharacterTests(one);
        //StatCreator stats1 = new StatCreator();
        //GameCharacter p1 = new GameCharacter();
        //p1.displayAllStats();
        // p1.displayAllStats();
        // System.out.println(p1.checkInputValid(p1.getUserInput()));
        // UnitTests.runStatCreatorTests(p1);
        /*
        stats1.statCreator(scanner, p1);
        if (stats1.getCharacterClass() == 1){
            p1 = stats1.makeAttacker();
        }
        else if (stats1.getCharacterClass() == 2){
            p1 = stats1.makeDefender();
        }
         * 
         */

        //p1.displayAllStats();
        // p1.special1(); // doesnt work

        scanner.close(); 
        
        /*
        // modulo behaviour testing
        // anything but doing maths
        System.out.println(8%10);
        System.out.println(88%10);
        System.out.println(888%10);
        System.out.println(-8%10);
        System.out.println(-88%10);
        System.out.println(-8%-10);
        System.out.println(-88%-10);
        System.out.println(80%10);   
        */
    }

}
