package by.yaroshuk.post.command;

import by.yaroshuk.post.MessageBox;

import java.util.List;

public class SendCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox) {
        List<Long> longs = messageBox.sendToMainOffice();
        System.out.println("Following message were sent: " + longs);
    }
}
