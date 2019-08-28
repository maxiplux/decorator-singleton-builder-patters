package bank.service;

public class EmailSender {

    private static   EmailSender instance ;

    private EmailSender()
    {
        // private constructor
    }
    synchronized  public static EmailSender getInstance(){
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new EmailSender();
        }
        return instance;
    }
    public void sendEmail(String to)
    {
        System.out.println("Simulated smtp server to "+to);
        System.out.println("Email From MidWestBank : Dear client your account has changengs");
    }

}
