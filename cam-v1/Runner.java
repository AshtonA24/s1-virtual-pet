import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner {

    public Runner() {
        VirtualPet p = new VirtualPet();

        takeABeat(1000);
        if(getAnswer("how are you?").equals("hungry")){
            p.feed();
        }
        
        
        

    }

    public void takeABeat(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // milliseconds
        } catch (Exception e) {

        }
    }

    

    public String getAnswer(String a){
        String s = (String)JOptionPane.showInputDialog(
        new JFrame(), a, "Message", JOptionPane.PLAIN_MESSAGE);
        return s;
}

    

    


    public static void main(String[] args) {
        new Runner();
    }
}
