package gamecharacter;
import stats.*;

public class DefenderFactory extends GameCharacterFactory {
    public GameCharacter GameCharacterMaker(Stats stats, String iuserName){
        return new Defender(stats, iuserName); 
    }
}