package battle;
import gamecharacter.GameCharacter;

public class Battle {
    
    
    public void fight(GameCharacter p1, GameCharacter p2){
        p1.doMove(p1.moveSelect());
    }
}