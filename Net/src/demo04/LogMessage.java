package demo04;

public class LogMessage {
    public static void main(String[] args) {
        String msg1 = "a";
        String msg2 = "a";
        String msg3 = "a";

        showLog(1,()->{
            return msg1 + msg2 + msg3;
        });
    }
    public static void showLog(int level,MessageBuilder messageBuilder){
        if (level == 1){
            System.out.println("===============");
            System.out.println(messageBuilder.builderMessage());
        }
    }
}
