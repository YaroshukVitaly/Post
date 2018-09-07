package by.yaroshuk.post.command;

import by.yaroshuk.post.Message;

public class AddCommand implements UserCommand {
    private String sender;
    private String reciever;
    private String address;
    private Message.MassageCategory  category;

    public AddCommand(String sender, String reciever, String address, Message.MassageCategory category) {
        this.sender = sender;
        this.reciever = reciever;
        this.address = address;
        this.category = category;
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
}
