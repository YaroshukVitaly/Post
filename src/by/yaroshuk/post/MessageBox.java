package by.yaroshuk.post;

import java.util.Arrays;

public class MessageBox {

    private Message[] messages;
    private int current;
    private static long nextIndex = 0;

    public MessageBox(int count) {
        messages = new Message[count];
        current = 0;
    }

    public long add(Message.MassageCategory category, String sender, String address, String receiver){
        Message message = new Message(category, sender, address, receiver);
        message.setId(nextIndex++);
        messages [current] = message;
        current++;
        return message.getId();
    }

    @Override
    public String toString() {
        return "MessageBox{" +
                "messages=" + Arrays.toString(messages) +
                '}';
    }
}
