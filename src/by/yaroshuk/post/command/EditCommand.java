package by.yaroshuk.post.command;

import by.yaroshuk.post.Message;
import by.yaroshuk.post.MessageBox;

public class EditCommand implements UserCommand {
    private long id;
    private String sender;
    private String reciever;
    private String address;
    private Message.MassageCategory  category;

    public EditCommand(long id) {
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String reciever) {
        this.reciever = reciever;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(Message.MassageCategory category) {
        this.category = category;
    }

    @Override
    public void execute(MessageBox messageBox) {
        Message message = messageBox.search(id);
        if (message == null){
            System.out.println("Couldn't find message " + id + "!");
            return;
        }
        message.setCategory(category);
        message.setSender(sender);
        message.setReceiver(reciever);
        message.setAddress(address);
    }
}
