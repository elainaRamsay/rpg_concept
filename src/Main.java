import java.util.Scanner;
import gamecharacter.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        GameCharacterFactory AtkFactory = new AttackerFactory();
        GameCharacterFactory DefFactory = new DefenderFactory();

        GameCharacter initP1 = null; 

        //System.out.println(one.dodgeCalc(100));
        //System.out.println(one.basicAttack());

        //UnitTests.runCharacterTests();
        
        StatCreator stats1 = new StatCreator();
        // UnitTests.runStatCreatorTests(stats1);
         
        // GameCharacter p1 = new GameCharacter();
        //p1.displayAllStats();
        // System.out.println(p1.checkInputValid(p1.getUserInput()));
        // UnitTests.runStatCreatorTests(stats1);
        
        stats1.statCreator(scanner);
        if (stats1.getCharacterClass() == 1){
            initP1 = AtkFactory.GameCharacterMaker(stats1.getStats(), stats1.getSetUserName());
        }
        else if (stats1.getCharacterClass() == 2){
            initP1 = DefFactory.GameCharacterMaker(stats1.getStats(), stats1.getSetUserName());
        }
        
        System.out.println("p1 stats");
        initP1.showClassName();
        initP1.displayAllStats();
        
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
