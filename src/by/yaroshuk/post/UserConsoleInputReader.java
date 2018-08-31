package by.yaroshuk.post;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserConsoleInputReader {
    private Scanner scanner;
    private MessageBox messageBox;
    public UserConsoleInputReader(MessageBox messageBox){
        this.messageBox = messageBox;
        scanner = new Scanner(System.in);

    }
    public void start (){
        while (true){
            String line = scanner.nextLine();

            parseAndExecutLine(line);
        }
    }
    private void parseAndExecutLine(String line) {
        Scanner s = new Scanner(line);
        //remove 2
        String token = s.next();
        if (token.equalsIgnoreCase("remove")){
            if (s.hasNextLong()){
                long l = s.nextLong();
                if (s.hasNext()){
                    System.out.println("Unknown format: " + line);
                }else {
                    remove (l);
                }
            }else if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else {
                System.out.println("Wrong format: remove $id - no $id: " + line);
            }
        }else if (token.equalsIgnoreCase("edit")){
            if (s.hasNextLong()){
                long l = s.nextLong();
                if (s.hasNext()){
                    System.out.println("Unknown format: " + line);
                }else {
                    edit (l);
                }
            }else if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else {
                System.out.println("Wrong format: edit $id - no $id: " + line);
            }

        }else if (token.equalsIgnoreCase("add")){
            if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else add ();
        }else if (token.equalsIgnoreCase("send")){
            if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else send ();
        }else if (token.equalsIgnoreCase("list")){
            if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else list ();
        }else if (token.equalsIgnoreCase("help")){
            if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else help ();
        }else if (token.equalsIgnoreCase("exit")){
            if (s.hasNext()){
                System.out.println("Unknown format: " + line);
            }else exit ();
        }else {
            processUnknownComand(line);
        }
    }

    private void help() {
        System.out.println("You can use following commands: ");
        System.out.println("add");
        System.out.println("send");
        System.out.println("list");
        System.out.println("edit <<id>>");
        System.out.println("remove <<id>>");
        System.out.println("help");
        System.out.println("exit");
        System.out.println("HELPING...");
    }

    private void list() {
        System.out.println("LISTING....");
        System.out.println("Messages in box: ");
        for (Message message : messageBox.list()){
            System.out.println(message);
        }
    }

    private void send() {
        System.out.println("SENDING....");
        List<Long> longs = messageBox.sendToMainOffice();
        System.out.println("Following messges were send:" + longs);

    }

    private void add() {
        System.out.println("ADDING...");
        System.out.println("Please, enter sender: ");
        String sender = scanner.nextLine();
        System.out.println("Please, enter reciever: ");
        String reciever = scanner.nextLine();
        System.out.println("Please, enter address: ");
        String address = scanner.nextLine();
        System.out.println("Please, enter category from " + Arrays.toString(Message.MassageCategory.values()));
        String category = scanner.nextLine().trim();
        Message.MassageCategory cat = parceCategory(category);
        messageBox.add(cat, sender, address, reciever);

    }

    private Message.MassageCategory parceCategory(String category) {
        Message.MassageCategory cat;
        switch (category){
            case "first_class" :
                cat = Message.MassageCategory.FIRST_CLASS;
                break;
            case "special" :
                cat = Message.MassageCategory.SPECIAL;
                break;
            case "regular" :
            default:
                cat = Message.MassageCategory.REGULAR;
                break;
        }
        return cat;
    }

    private void edit(long l) {
        System.out.println("EDITING " + l);

        Message message = messageBox.search(l);
        if (message == null){
            System.out.println("Message " + l + "was not found!");
        }else {
            System.out.print("Change sender (" + message.getSender() + ") if you want: ");
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()){
                message.setSender(line);
            }
            System.out.print("Change receiver (" + message.getReceiver() + ") if you want: ");
            line = scanner.nextLine().trim();
            if (!line.isEmpty()){
                message.setReceiver(line);
            }
            System.out.print("Change address (" + message.getAddress() + ") if you want: ");
            line = scanner.nextLine().trim();
            if (!line.isEmpty()){
                message.setAddress(line);
            }
            System.out.print("Change category (" + message.getCategory() + ") if you want: ");
            line = scanner.nextLine().trim();
            if (!line.isEmpty()){
                message.setCategory(parceCategory(line));
            }
        }

    }

    private void remove(long l) {
        System.out.println("REMOVING " + l);
        boolean delete = messageBox.delete(l);
        if (delete) {
            System.out.println("Message" + l + "was sucessfully remove!");
        }else {
            System.out.println("Message" + l + "was not found!");
        }
    }

    private void processUnknownComand(String line) {
        System.out.println("Unknown comand: " + line );
    }

    private void exit (){
        System.out.println("Exiting...");
        System.exit(0);
    }
}
