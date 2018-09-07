package by.yaroshuk.post.command;

import by.yaroshuk.post.Message;
import by.yaroshuk.post.MessageBox;

public class ListCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox) {
        System.out.println("List of messsages: ");
        for (Message message : messageBox.list()){
            System.out.println(message);
        }
    }
}
