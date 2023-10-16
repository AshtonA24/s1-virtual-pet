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


    //events

     public void goalChance(Integer i) {

        int random = (int) (Math.random() * 2);

        // i: left = 1 right = 0
        //random: miss = 0 goal = 1

        if (i == 0 && random == 1) {
            face.setMessage("Shooting...");
            takeABeat(500);
            face.setMessage("YOU SCORED!");
            ourScore++;
            face.setImage("leftGoal");
        } else if (i == 1 && random == 1) {
            face.setMessage("Shooting...");
            face.setImage("rightGoal");
            takeABeat(500);
            face.setMessage("YOU SCORED!");
            ourScore++;
            
        } else if(i==0) {
            face.setMessage("Shooting...");
            face.setImage("leftMiss");
            takeABeat(500);
            face.setMessage("You missed.");
            
        } else {
            face.setMessage("Shooting...");
            face.setImage("rightMiss");
            takeABeat(500);
            face.setMessage("You missed.");
            
        }

    }



    public boolean stepovers(String a) {
        Integer i = Integer.parseInt(a);
        if (i <= 4) {
            return true;
        }
        return false;
    }



    public boolean megFaint(Integer i){
        
        int random = (int) (Math.random() * 2);
        if (i == 1 && random == 1){
            return true;
        }else if( i == 0 && random == 0)  {
            return true;
        }

        return false;
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

        public void passedHim(boolean a) {
        face.setMessage("Attempting to pass defender...");
        takeABeat(1500);
        if (a) {
            face.setMessage("You got passed him!");
            face.setImage("joyful");
            takeABeat(1000);
            face.setImage("openGoal");
            takeABeat(1000);
            face.setMessage("You passed the defender and now have a shot at goal...");
            takeABeat(2000);
            goalChance(getAnswer3());
            takeABeat(2000);
            displayScore();

        } else {
            face.setMessage("You didnt get passed him.");
            takeABeat(1500);
            face.setMessage("You lose possesion and they score.");
            opScore ++;
            displayScore();
            face.setImage("cry");
        }
    }



     public void endGame(){
        face.setMessage("The final whistle blows*");
        takeABeat(2000);
        String s = "Final score: " + ourScore + "-" +  opScore+ ". ";
        if (ourScore > opScore)
            s += "You won!";
        else if (opScore > ourScore)
            s += "You lost...";
        else
            s += "You tied.";
        face.setMessage(s);
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

    //user input

     public String getAnswer(String a) {
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(), a, "Message", JOptionPane.PLAIN_MESSAGE);

        return s;
    }

     public Integer getAnswer2(String s) {
        Object[] options = { "Meg him", "Do a bodyfaint" };

        Integer n = JOptionPane.showOptionDialog(new JFrame(), s,

                "Choice",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        return n;
    }

    public Integer getAnswer3() {
        Object[] options = { "Shoot left", "Shoot right" };

        Integer n = JOptionPane.showOptionDialog(new JFrame(), "You have a shot opening",

                "Choice",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        return n;
    }




    

    



    
    //misc
   

    public int getOpScore(){
        return opScore;
    }

    public int getOurScore(){
        return ourScore;
    }


    public void takeABeat(int milliseconds) {
        try {
            Thread.sleep(milliseconds); 
        } catch (Exception e) {

        }

    }


   

    




   
} // end Virtual Pet
