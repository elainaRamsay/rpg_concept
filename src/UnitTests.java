public class UnitTests {

    public static void runCharacterTests(Character testSubject){
        dodgeTest(testSubject);
        takeDamageTest(testSubject);
    }

    public static void runStatCreatorTests(StatCreator testSubject){
        isAllocationCorrectTest(testSubject);
    }

    private static void dodgeTest(Character thing){
        boolean weDodged = false;

        while (!weDodged) {
            System.out.println(thing.getAvo());
            if (thing.dodgeCalc(100)){
                weDodged = true;
                System.out.println("we did it");
            }
        }
    }

    private static void takeDamageTest(Character thing){
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.takeDamage(30);
        System.out.println("Current hp: " + thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
        thing.takeDamage(50);
        System.out.println(thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
        thing.takeDamage(10);
        System.out.println(thing.getHpCurrent());
        thing.setHpCurrent(thing.getHpMax());
    }
    
    private static void isAllocationCorrectTest(StatCreator testSubject){
        testSubject.setSetStr(0);
        testSubject.setSetHit(80);
        testSubject.setSetAvo(0);
        testSubject.setSetDef(0);
        testSubject.setSetHp(14);
        testSubject.setSkillPoints(50);
        //System.out.println(testSubject.isAllocationCorrect());

        testSubject.setSetStr(20);
        testSubject.setSetHit(100);
        testSubject.setSetAvo(20);
        testSubject.setSetDef(20);
        testSubject.setSetHp(34);
        testSubject.setSkillPoints(0);
        //System.out.println(testSubject.isAllocationCorrect());
    }
}
