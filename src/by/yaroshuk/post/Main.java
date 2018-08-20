package by.yaroshuk.post;

public class Main {
    public static void main (String[] args){
        MessageBox messageBox = new MessageBox(3);
        messageBox.add(Message.MassageCategory.REGULAR, "Иванов И.", "В г. Москва", "Петров П.П.");

        System.out.println(messageBox);
    }
}
