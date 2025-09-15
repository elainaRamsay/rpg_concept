public class UnitTests {

    public static void runCharacterTests(GameCharacter testSubject){
        dodgeTest(testSubject);
        takeDamageTest(testSubject);
    }

    public static void runStatCreatorTests(StatCreator testSubject){
        isAllocationCorrectTest(testSubject);
    }

    private static void dodgeTest(GameCharacter thing){
        boolean weDodged = false;

        while (!weDodged) {
            System.out.println(thing.getAvo());
            if (thing.dodgeCalc(100)){
                weDodged = true;
                System.out.println("we did it");
            }
        }
    }

    private static void takeDamageTest(GameCharacter thing){
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.takeDamage(30);
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
        thing.takeDamage(50);
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
        thing.takeDamage(10);
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
    }
    
    private static void isAllocationCorrectTest(StatCreator testSubject){
        
        testSubject.setStr(0);
        testSubject.setHit(80);
        testSubject.setAvo(0);
        testSubject.setDef(0);
        testSubject.setHpMax(14);
        testSubject.setSkillPoints(50);
        // System.out.println(testSubject.isStatDistributionCorrect()); // true

        testSubject.setStr(20);
        testSubject.setHit(100);
        testSubject.setAvo(20);
        testSubject.setDef(20);
        testSubject.setHpMax(34);
        testSubject.setSkillPoints(0);
        
        // System.out.println(testSubject.isStatDistributionCorrect()); //true
    }
}
