package Singleton;

class MobileClass {
    private static MobileClass instance;
    private String process;

    private MobileClass() {
        process = "Prototype.Mobile is off";
    }

    public static MobileClass getInstance() {
        if (instance == null) {
            instance = new MobileClass();
        }
        return instance;
    }

    public void playAudio() {
        process = "Prototype.Mobile is Playing Audio";
    }

    public void playGame() {
        process = "Prototype.Mobile is Playing Game";
    }

    public void playVideo() {
        process = "Prototype.Mobile is Playing Video";
    }

    public String getProcess() {
        return process;
    }
}
