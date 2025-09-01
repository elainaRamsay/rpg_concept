import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        //Character one = new Character(99,100,30,30,30,"mogus");

        //System.out.println(one.dodgeCalc(100));
        //System.out.println(one.basicAttack());

        //UnitTests.runCharacterTests(one);
         StatCreator p1 = new StatCreator();
        // p1.displayAllStats();
        // System.out.println(p1.checkInputValid(p1.getUserInput()));
        // UnitTests.runStatCreatorTests(p1);
        p1.changeStats(scanner);
        
        scanner.close();
    }

}
