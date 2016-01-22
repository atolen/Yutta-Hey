import java.io.*;
import java.util.*;

public class Game {

    //Instance Vars

    //change these constants to choose which topics to focus on
    public final static int kinQs = 2; // Kinematics
    public final static int moQs = 2; // Motion
    public final static int proQs = 2; // Projectiles
    public final static int forQs = 2; // Force
    public final static int momQs = 2; // Momentum
    public final static int enQs = 2; // Energy
    public final static int cirQs = 2; // Circular

    private boolean gameOver; // hp at 0? answer all questions?

    private InputStreamReader isr;
    private BufferedReader in;

    public Game() {
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }

    //====================================================

    public static void newGame() {

	String prt = "";
	String name = "";
	//==============INTRODUCTION=====================
	prt = "\n";
	System.out.print( prt );

	pause(1000);

	prt = "\t\tA long time ago in a galaxy far,\n\t\tfar away...\n\n";
	System.out.print( prt );

	pause(3000);

	prt =
"\n                    8888888888  888    88888" +
"\n                   88     88   88 88   88  88" +
"\n                    8888  88  88   88  88888" +
"\n                       88 88 888888888 88   88" +
"\n                88888888  88 88     88 88    888888" +
"\n " +
"\n                88  88  88   888    88888    888888" +
"\n                88  88  88  88 88   88  88  88" +
"\n                88 8888 88 88   88  88888    8888" +
"\n                 888  888 888888888 88   88     88" +
"\n                  88  88  88     88 88    8888888";
	prt += "\n\n\n";

    System.out.print( prt );

    pause(1000);

    prt =
"                          A NEW HOPE" +
"\n\n";
    System.out.print(prt);
    pause(2000);
    prt = 
"                  It is a period of civil war" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"                 Rebel   spaceships,  striking" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"               from  a  hidden  base,  have   won" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"              their    first    victory    against" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"             the      evil      Galactic      Empire.";
	System.out.print(prt);
	System.out.print("\n\n");
	pause(2000);

prt =
"            During     the        battle,      Rebel" +
"\n";
    System.out.print(prt);
    pause(500);
    prt =
"           spies     managed     to    steal    secret" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"          plans         to         the         Empire's" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"         ultimate        weapon,        the        DEATH" +
"\n";
    System.out.print(prt);
    pause(500);
    prt = 
"        STAR  ,        an          armored          space" +
"\n";
    System.out.print(prt);
    pause(500);
	//================END OF INTRO================
    }//end of newGame()
    //====================================================

    public static void pause(int time) {
	try {
	    Thread.sleep(time);//1000 milliseconds
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }//end of pause()

    public void kinSec() { //calls Kinematics questions
	while(kinQs > 0) {
	    Kinematics Questions = new Kinematics();
	}
    }//enf of kinSec

    public static void main(String[] args){
	newGame();
    }//end of main

}//end of Driver