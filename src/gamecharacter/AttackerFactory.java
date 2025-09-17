package gamecharacter;
import stats.*;

public class AttackerFactory extends GameCharacterFactory {
    public GameCharacter GameCharacterMaker(Stats stats, String iuserName){
        return new Attacker(stats, iuserName); 
    }
}