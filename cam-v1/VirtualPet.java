/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {

    VirtualPetFace face;

    private int opScore = 0;
    private int ourScore = 0;

    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Whistle blows*");
    }

    public boolean stepovers(String a) {
        Integer i = Integer.parseInt(a);
        if (i <= 4) {
            return true;
        }
        return false;
    }

    public void defender(String a) {
        if (a.equals("Ramos")) {
            face.setMessage("Oh no! Ramos.");
            face.setImage("ramos");
        }

        if (a.equals("Maguire")) {
            face.setMessage("Phew, its just Maguire!");
            face.setImage("maguire");
        }

    }

    public void goalChance() {

        int value = (int) (Math.random() * 2);
        if (value == 0) {
            if (getAnswer("You have a shot at goal, shoot left or right?").equals("left")) {
                face.setMessage("Shooting...");
                takeABeat(500);
                face.setMessage("YOU SCORED!");
                ourScore++;
                face.setImage("ecstatic");
            } else {
                face.setMessage("Shooting...");
                takeABeat(500);
                face.setMessage("You missed.");
                face.setImage("verysad");
            }
        } else {
            if (getAnswer("You have a shot at goal, shoot left or right?").equals("right")) {
                face.setMessage("Shooting...");
                takeABeat(500);
                face.setMessage("YOU SCORED");
                ourScore++;
                face.setImage("ecstatic");
            } else {
                face.setMessage("Shooting...");
                takeABeat(1000);
                face.setMessage("You missed.");
                face.setImage("verysad");
            }
        }

    }

    public void passedHim(boolean a) {
        face.setMessage("Attempting to pass defender...");
        takeABeat(1500);
        if (a) {
            face.setMessage("You got passed him!");
            face.setImage("joyful");
            takeABeat(2000);
            face.setMessage("You passed the defender and now have a shot at goal...");
            takeABeat(2000);
            goalChance();
            takeABeat(2000);
            displayScore();

        } else {
            face.setMessage("Too many stepovers.");
            takeABeat(1500);
            face.setMessage("You lose possesion and they score.");
            takeABeat(1000);
            opScore ++;
            displayScore();
            face.setImage("cry");
        }
    }

    public void displayScore() {
        String a = "The score is " + ourScore + "-" + opScore + ", ";

        if (ourScore > opScore)
            a += "You're winning!";
        else if (opScore > ourScore)
            a += "You're losing...";
        else
            a += "Its tied.";

        face.setMessage(a);
    }

    public void endGame(){
        face.setMessage("The final whistle blows*");
        takeABeat(2000);
        String s = "Final score: " + ourScore + "-"+  opScore+ ". ";
        if (ourScore > opScore)
            s += "You won!";
        else if (opScore > ourScore)
            s += "You lost...";
        else
            s += "You tied.";
        face.setMessage(s);
    }

    public int getOpScore(){
        return opScore;
    }

    public int getOurScore(){
        return ourScore;
    }

    

    public String getAnswer(String a) {
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(), a, "Message", JOptionPane.PLAIN_MESSAGE);
        return s;
    }

    public void takeABeat(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // milliseconds
        } catch (Exception e) {

        }

    }

} // end Virtual Pet
