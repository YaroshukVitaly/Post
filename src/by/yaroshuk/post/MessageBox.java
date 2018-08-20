package by.yaroshuk.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageBox {

    private List<Message> messages;
    private static long nextIndex = 0;

    public MessageBox(){
        this (100) ;
    }
    public MessageBox(int count) {
        messages = new ArrayList<Message>(count);
        }

    public long add(Message.MassageCategory category, String sender, String address, String receiver){
        Message message = new Message(category, sender, address, receiver);
        message.setId(nextIndex++);
        messages.add(message);
                return message.getId();
    }

    public  Message search(long id){
        for (Message message : messages) {
            if (message.getId() == id){
                return message;
            }
        }
        return null;
    }

    public boolean delete(long id){
        Message message = search(id);
        return messages.remove(message);


    }
    @Override
    public String toString() {
        return "MessageBox{" +
                "messages=" + messages +
                '}';
    }
}
