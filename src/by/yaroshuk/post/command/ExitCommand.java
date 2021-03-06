package by.yaroshuk.post.command;

import by.yaroshuk.post.MessageBox;

public class ExitCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox) {
        System.out.println("Exiting....");
        System.exit(0   );
    }
}
