public class Runner {

    public Runner() {
        VirtualPet p = new VirtualPet();

        p.exercise();
        takeABeat(1000);
        p.feed();

    }

    public void takeABeat(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // milliseconds
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Runner();
    }
}
