package by.yaroshuk.post.command;

import by.yaroshuk.post.Message;
import by.yaroshuk.post.MessageBox;

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

    @Override
    public void execute(MessageBox messageBox) {
        messageBox.add(category, sender, address, reciever);

    }
}
