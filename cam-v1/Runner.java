import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner {

    

    public Runner() {
        VirtualPet p = new VirtualPet();

        
       
        

        p.takeABeat(1000);
        p.face.setMessage("You get the ball...");
        p.takeABeat(1000);
        p.defender("Ramos");
        boolean a = p.stepovers(p.getAnswer("You come accross Ramos, how many stepovers are you doing?"));
        p.passedHim(a);

        p.takeABeat(3000);

        if(p.getOpScore() != p.getOurScore()){
        p.face.setMessage("Kickoff commences");
        p.takeABeat(2000);
        }
        
        p.face.setMessage("You get the ball again...");
        p.takeABeat(1000);
        p.defender("Maguire");
        a = p.megFaint(p.getAnswer2("You come accross Maguire, do you meg him or body faint?"));
        p.passedHim(a);

        p.endGame();

        
        
        

    }

    public static void main(String[] args) {
        new Runner();
    }
}
