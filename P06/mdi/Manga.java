package mdi;

public class Manga {
    public static void main(String[] args) {
        String storeName = (args.length > 0) ? args[0] : "Untitled";
        Controller controller = new Controller(storeName);
        controller.mdi();
    }
}
