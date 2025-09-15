public class Defender extends GameCharacter {
// class 2

    Defender(int istr, int ihit, int iavo, int idef, int ihp, String iuserName){
        super(istr, ihit, iavo, idef, ihp, iuserName);
        // any buff stacks or whateverthe fuck
    }

    Defender(Stats stats, String iuserName){
        super(stats, iuserName);
    }

    public void showClassName(){
        System.out.println("Defender");
    }

    public static void showDescription(){
        System.out.println("Special moves which scale off of defensive stats");
    }

    public void special1(){

    }

    public void special2(){

    }

    public void special3(){

    }
}
