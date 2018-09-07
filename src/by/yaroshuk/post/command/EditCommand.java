package by.yaroshuk.post.command;

import by.yaroshuk.post.Message;

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

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getAddress() {
        return address;
    }

    public Message.MassageCategory getCategory() {
        return category;
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
}
