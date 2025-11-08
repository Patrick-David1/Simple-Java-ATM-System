import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Welcome to CCST ATM ==="); //wow amazing! TANGINA ANG ANGAS!!!

        boolean flag = true; //FLAG PARA SA LOGIN

        //for login ito
        while (flag) {
            System.out.print("Enter PIN: ");
            String pin1 = input.nextLine();
                //check neto if "1221" yung input ng user
            if (pin1.equals("1221")) {
                flag = false; //if tama ooff nya yung flag na nag loloop sa login
                System.out.println("Access Granted!");
            } else { //pag hindi "1221" eto yung mag rurun, which is a print, and then mag loloop sya ulit sa log in
                System.out.println("Invalid, Access not granted.");
            }
        }

        System.out.println("");

       //dito na dinedeclare yung balance
        int balance = 0;
        boolean run = true;

        //loop nanaman to for the whole thing
        while (run) {
            //menu
            System.out.println("[1] Check Balance");
            System.out.println("[2] Deposit");
            System.out.println("[3] Withdraw");
            System.out.println("[4] Exit");
            System.out.print("Choose option: ");
            String option = input.nextLine();
            System.out.println("");
            //if 1 yung input ni user, print nya yung balance
            if (option.equals("1")) {
                System.out.println("Balance: ₱" + balance);
            }

            //if 2, deposit, etong else if yung magrurun
            else if (option.equals("2")) {
                System.out.print("Enter amount to deposit: ₱");

                //since magdedeposit ka ng pera, input needs to be a number, so !input.hasNextInt() yung mag checheck if number sya
                while (!input.hasNextInt()) {
                    System.out.println("Invalid amount. Please enter numbers only."); 
                    System.out.print("Enter amount to deposit: ₱");
                    input.nextLine(); //clears out yung mga invalid input
                }
                //if "input" is an integer, it runs thise code na
                int dep = input.nextInt();
                input.nextLine(); //since may other possible transactions pa, "input" will be reused, so dapat cineclear din sya

                //dito, it checks if yung deposit is above 0, kasi if negative input nilagay dito, magiging parang Withdraw lang din
                if (dep > 0) {
                    balance += dep;
                    System.out.println("Deposited successfully. New balance: ₱" + balance);
                } else {
                    System.out.println("Amount must be greater than ₱0.");
                }
            }

            //if "3", withdraw, eto mag rurun
            else if (option.equals("3")) {
                System.out.print("Enter amount to withdraw: ₱");

                //same thing, if hindi number, loop again
                while (!input.hasNextInt()) {
                    System.out.println("Invalid amount. Please enter numbers only.");
                    System.out.print("Enter amount to withdraw: ₱");
                    input.nextLine(); //clearing invalid input
                }
                //decrales "wd" as amount ng wiwithdraw mo
                int wd = input.nextInt();
                input.nextLine(); //clearing again
                //if mas mataas sa balance ang withdraw amount, eto yung mag checheck doon
                if (wd > 0) {
                    if (wd <= balance) {
                        balance -= wd;
                        System.out.println("Withdrawn successfully. New balance: ₱" + balance);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                } else {
                    System.out.println("Amount must be greater than ₱0.");
                } //if hindi valid ang withdraw amount, punta agad sa y/n transaction menu
            }
              //if "4", end transaction, tapos na yey
            else if (option.equals("4")) {
                System.out.println("Transaction ended.");
                break; //this ends the whole program
            }

            else {
                System.out.println("Invalid option. Try again.");
                System.out.println("");
                continue; //this skips the code below, kasama kasi din sila sa loob ng "run" loop, which is the whole ATM system
            }

            //this section handles yung y/n inputs, after transactions
            boolean watchuwantbro = true; //so dito, si "watchuwantbro" is declared as a boolean, and set to true
            // so after every transaction, ts run, remember java runs top to bottom
            while (watchuwantbro) {
                System.out.print("Do you want another transaction? (y/n): ");
                String again = input.nextLine().toLowerCase(); //yung .toLowerCase(); is para sa pagconvert ng anyinput into lowercase, since yung system natin for y/n is only accepting lowercase "y" and "n"

                if (again.equals("y")) { //if "y", turns "watchuwantbro" into false
                    watchuwantbro = false;
                }
                else if (again.equals("n")) { //if "n", turns "watchuwantbro" and "run" to false, and then prints "transaction ended"
                    watchuwantbro = false;
                    run = false;
                    System.out.println("Transaction ended.");
                }
                else {
                    System.out.println("Invalid input. Please enter only y or n."); //if wala sa y/n, this prints out and continues the loop
                }
            }

            System.out.println("");
        }
    }
}
