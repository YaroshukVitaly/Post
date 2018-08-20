package by.yaroshuk.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageBox {
    private MainOffice mainOffice;
    private List<Message> messages;
    private static long nextIndex = 0;

    public MessageBox(){
        this (100) ;
    }
    public MessageBox(int count) {
        messages = new ArrayList<Message>(count);
        mainOffice = new MainOffice();
        }

    public long add(Message.MassageCategory category, String sender, String address, String receiver){
        Message message = new Message(category, sender, address, receiver);
        message.setId(nextIndex++);
        messages.add(message);
                return message.getId();
    }
// Метод для исправления!
    public  Message search(long id){
        for (Message message : messages) {
            if (message.getId() == id){
                return message;
            }
        }
        return null;
    }
//Метод для удаления!
    public boolean delete(long id){
        Message message = search(id);
        return messages.remove(message);


    }
//Метод для отметки отпраки пиcем
    public List<Long> sendToMainOffice () {
        List<Message> toRemove = new ArrayList<Message>();
        for (Message message  : messages) {
            boolean accepted = mainOffice.queue(message);
            if (accepted) {
                toRemove.add(message);

            }
        }
        List<Long> ids = new ArrayList<Long>();
        for (Message message : toRemove) {
            ids.add(message.getId());
            messages.remove(message);

        }
        return ids;
    }
//Метод отображения текущего списка элементов
    public List<Message> list (){
        return new ArrayList<Message>(messages);
    }
    @Override
    public String toString() {
        return "MessageBox{" +
                "messages=" + messages +
                '}';
    }
}
