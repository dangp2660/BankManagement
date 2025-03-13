
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();
        int opt = -1;
        Account temp = null;
        do {
            System.out.println("1. Add a VIP account");
            System.out.println("2. Add a business account");
            System.out.println("3. Display all");
            System.out.println("4. Display business account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Exit");
            System.out.println("Option:");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    temp = new VIPaccount(true, "123","Nguyen Van A",500);
                    b.add(temp);
                    temp = new VIPaccount(true, "456","Nguyen Van B",400); 
                    b.add(temp);
                    break;
                case 2:
                    temp = new BussinessAccount(6.3, "789", "Hoang Thi C", 600);
                    b.add(temp);
                    temp = new BussinessAccount(6.3, "100", "Hoang Van D", 700);
                    b.add(temp);
                    break;
                case 3:
                    b.displayAccount();
                    break;
                case 4:
                    b.sortByRate();
                    for (Account a : new ArrayList<>(b.getAccount())) {
                        if(a instanceof BussinessAccount)
                            a.output();
                    }
                    break;
                case 5:
                    sc = new Scanner(System.in);
                    System.out.println("Code account:");
                    String send = sc.nextLine();
                    System.out.println("Money: ");
                    double money = sc.nextDouble();
                    b.deposit(send, (int) money);
                    break;
                case 6:
                    sc = new Scanner(System.in);
                    System.out.println("Code account:");
                    String sent = sc.nextLine();         
                    System.out.println("Money:");
                    int money2 = sc.nextInt();
                    b.withdraw(sent, money2);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }while(opt != 7);
    }
}
