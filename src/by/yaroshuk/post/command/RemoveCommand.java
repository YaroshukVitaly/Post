package by.yaroshuk.post.command;

import by.yaroshuk.post.MessageBox;

public class RemoveCommand implements UserCommand {
    private long id;

    public RemoveCommand(long id) {
        this.id = id;
    }

    @Override
    public void execute(MessageBox messageBox) {
        boolean delete = messageBox.delete(id);
        if (delete) {
            System.out.println("Message" + id + "was sucessfully remove!");
        }else {
            System.out.println("Message" + id + "was not found!");
        }
    }
}
