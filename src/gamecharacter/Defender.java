package gamecharacter;
import stats.*;

public class Defender extends GameCharacter {
// class 2

    protected Defender(int istr, int ihit, int iavo, int idef, int ihp, String iuserName){
        super(istr, ihit, iavo, idef, ihp, iuserName);
        // any buff stacks or whateverthe fuck
    }

    protected Defender(Stats stats, String iuserName){
        super(stats, iuserName);
    }
    
    @Override
    public void showClassName(){
        System.out.println("Defender");
    }

   @Override
    public void displayAllStats(){
        this.universalStats();
        displayUniqueStats();
    }

    @Override
    public void displayUniqueStats(){
        // print custom stats i.e buffs
    }
    
    @Override
    public int moveSelect(){
        return 0;
    }

    @Override
    public void doMove(int selection){

    }

    public static void showDescription(){
        System.out.println("Special moves which scale off of defensive stats");
    }

    private void special1(){
        System.out.println("Defender sp 1");
    }

    private void special2(){

    }

    private void special3(){

    }
}
