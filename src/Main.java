public class Main {

    public static void main(String[] args) {
        FrameFighterPlane frameFighterPlane = new FrameFighterPlane();
        MyPanel myPanel = new MyPanel();
        frameFighterPlane.addMyPanel(myPanel);
    }
}