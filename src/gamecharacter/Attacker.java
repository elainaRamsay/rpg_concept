package gamecharacter;
import stats.*;

public class Attacker extends GameCharacter {
    // class 1
    private int buffStack;
    protected Attacker(int istr, int ihit, int iavo, int idef, int ihp, String iuserName){
        super(istr, ihit, iavo, idef, ihp, iuserName);
        // any buff stacks or whateverthe fuck

        buffStack = 0;
    }

    protected Attacker(Stats stats, String iUsername){
        super(stats, iUsername);
    }

    @Override
    public void showClassName(){
        System.out.println("Attacker");
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
        // return int for move selected
        return 0;
    }

    @Override
    public void doMove(int selection){

    }

    public static void showDescription(){
        System.out.println("Special moves which scale off of offensive stats");
    }

    private void special1(){
        System.out.println("Attacker sp 1");
    }
    
    private void special2(){
        buffStack += 2;
        System.out.println("buffstack: " + buffStack);
    }

    private void special3(){

    }
}
