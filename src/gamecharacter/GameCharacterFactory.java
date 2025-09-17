package gamecharacter;
import stats.*;

public abstract class GameCharacterFactory {
    public abstract GameCharacter GameCharacterMaker(Stats stats, String iuserName);
}
