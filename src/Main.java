import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String loading = """
                 Bank
                Bankımıza xoş gəlmisiniz
                """;
        System.out.println(loading);
        ArrayList<BankAccount> users = new ArrayList<BankAccount>();
        esasMenu(users);

        Scanner scanner = new Scanner(System.in);

        BankAccount bk1 = new BankAccount(AccountType.Savings, "Shola",
                " ", 90, "sol", "123", users);
        System.out.println(users.get(0));


    }

    public static void signUp(ArrayList<BankAccount> users) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Name yazin");
        String name = sr.nextLine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("shifrenizi daxil edin");
        String password = scanner.nextLine();
        System.out.println("adresinizi daxil edin");
        String address = scanner.nextLine();
        System.out.println(" emailinizi daxil edin");
        String email = scanner.nextLine();
        System.out.println("nomrenizi daxil edin");
        int phone = scanner.nextInt();


        BankAccount bk1 = new BankAccount(AccountType.Savings, name, address, phone, email, password, users);

        System.out.println(bk1);

    }

    public static void esasMenu(ArrayList<BankAccount> user) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ana ekran:");
        System.out.println("1.SignUp");
        System.out.println("2.Depozit");
        System.out.println("3.Show account");
        System.out.println("4.Withdraw ");
        System.out.println("5.Transfer");
        int secim = scanner.nextInt();
        switch (secim) {
            case 1:
                //     signUp();
                signUp(user);
                esasMenu(user);


            case 2:
                deposit(user);
                esasMenu(user);


            case 3:
                BankAccount r = null;
                Scanner sc = new Scanner(System.in);
                while (r == null) {
                    System.out.println("Account numberinizi daxil edin");
                    int accnumber = sc.nextInt();


                    for (BankAccount a : user) {

                        if (accnumber == a.getAccountNumber()) {
                            r = a;
                        }

                    }
                    try {
                        if (r==null){
                            throw new InvalidAccountException("Xeta bash verdi");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                System.out.println(r);
                esasMenu(user);
            case 4:
                withdraw(user);
   esasMenu(user);
            case 5:
         transfer(user);
         esasMenu(user);

            case 0:
                System.out.println("Proqramdan çıxılır...");
                scanner.close();
//     return;
            default:
                System.out.println("Seçim yanlışdır, doğru bir seçim edin.");
                break;
        }

    }


    //avtomatic
    public static void deposit(ArrayList<BankAccount> user) {
        BankAccount r = null;
        Scanner sc = new Scanner(System.in);
        while (r == null) {
            System.out.println("Account numberinizi daxil edin");
            int accnumber = sc.nextInt();


            for (BankAccount a : user) {

                if (accnumber == a.getAccountNumber()) {
                    r = a;
                }

            }
        }
        int daxilOlanMebleg;

        do {
            System.out.println("Balansiniza pulu daxil edin");
            daxilOlanMebleg = sc.nextInt();


        } while (daxilOlanMebleg < 0);
        r.setBalance(r.getBalance() + daxilOlanMebleg);
        System.out.println("Mebleg balansiniza daxil oldu");
    }

    public static void withdraw(ArrayList<BankAccount> user) {
        BankAccount r = null;
        Scanner sc = new Scanner(System.in);
        while (r == null) {
            System.out.println("Account numberinizi daxil edin");
            int accnumber = sc.nextInt();


            for (BankAccount a : user) {

                if (accnumber == a.getAccountNumber()) {
                    r = a;
                }

            }
        }
        int daxilOlanMebleg;

        do {
            System.out.println("Balansinizdan cixarmaq istediyiniz pulu daxil edin " + r.getBalance());
            daxilOlanMebleg = sc.nextInt();


        } while (daxilOlanMebleg < 0 || daxilOlanMebleg <= r.getBalance());
        r.setBalance(r.getBalance() - daxilOlanMebleg);
        System.out.println("Mebleg balansinizdan cixarildi " + r.getBalance());
    }

    public static void transfer(ArrayList<BankAccount> user) {
        BankAccount r = null;
        BankAccount newAccount = null;
        Scanner sc = new Scanner(System.in);
        while (r == null) {
            System.out.println(" Şəxsi account numberinizi daxil edin");
            int accnumber = sc.nextInt();


            for (BankAccount a : user) {

                if (accnumber == a.getAccountNumber()) {
                    r = a;
                }

            }
        }
        while (newAccount == null) {
            System.out.println(" Transfer edeceyiniz account numberinizi daxil edin");
            int accnumber = sc.nextInt();


            for (BankAccount a : user) {

                if (accnumber == a.getAccountNumber()) {
                    newAccount = a;
                }

            }
        }


        int daxilOlanMebleg;

        do {
            System.out.println("Balansinizdan transfer etmek istediyiniz pulu daxil edin " + r.getBalance());
            daxilOlanMebleg = sc.nextInt();


        } while (daxilOlanMebleg < 0 || daxilOlanMebleg <= r.getBalance());
        r.setBalance(r.getBalance() - daxilOlanMebleg);
        System.out.println("Mebleg balansinizdan cixarildi " + r.getBalance());

        newAccount.setBalance(newAccount.getBalance() + daxilOlanMebleg);


    }


}
