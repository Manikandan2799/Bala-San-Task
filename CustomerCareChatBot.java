//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Samples.JavaPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class CustomerCareChatBot {
    static Stack<SelectedOptions> backStack = new Stack();

    public CustomerCareChatBot() {
    }

    public static void main(String[] args) {
        backStack.push(new SelectedOptions(0, 0));
        print(0, 0);

        int choice;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter your option : ");
            choice = input.nextInt();
            if (choice == 9) {
                backStack.pop();
                if (backStack.isEmpty()) {
                    break;
                }
            } else if (choice == 22) {
                backStack.push(new SelectedOptions(1, 1));
            } else {
                backStack.push(new SelectedOptions(((SelectedOptions)backStack.peek()).level + 1, choice));
            }

            SelectedOptions top = (SelectedOptions)backStack.peek();
            print(top.level, top.choice);
        } while(choice != 0);

        System.out.println("Thank you for visiting our website...");
    }

    private static void print(int level, int choice) {
        Iterator var2 = getChoices(level, choice).iterator();

        while(var2.hasNext()) {
            String choiceString = (String)var2.next();
            System.out.println(choiceString);
        }

    }

    static ArrayList<String> getChoices(int level, int choice) {
        ArrayList<String> choiceList = new ArrayList();
        if (level == 0) {
            choiceList.add(CustomerCareChatBot.Level1.OPTION_1.toString());
            choiceList.add(CustomerCareChatBot.Level1.OPTION_2.toString());
            choiceList.add(CustomerCareChatBot.Level1.OPTION_3.toString());
            choiceList.add(CustomerCareChatBot.Level1.OPTION_4.toString());
        } else if (level == 1) {
            switch (choice) {
                case 1:
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_4.toString());
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_5.toString());
                    choiceList.add(CustomerCareChatBot.Level2.OPTION_6.toString());
                    break;
                case 2:
                    choiceList.add(CustomerCareChatBot.Level3.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.Level3.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.Level3.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.Level3.OPTION_4.toString());
            }
        } else if (level == 2) {
            switch (choice) {
                case 1:
                    choiceList.add(CustomerCareChatBot.Recharge.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.Recharge.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.Recharge.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.Recharge.OPTION_4.toString());
                    choiceList.add(CustomerCareChatBot.Recharge.OPTION_5.toString());
                    break;
                case 2:
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_4.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_5.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_6.toString());
                    choiceList.add(CustomerCareChatBot.Caller_Tune.OPTION_7.toString());
                    break;
                case 3:
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_4.toString());
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_5.toString());
                    choiceList.add(CustomerCareChatBot.DataPacks.OPTION_6.toString());
                    break;
                case 4:
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_1.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_2.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_3.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_4.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_5.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_6.toString());
                    choiceList.add(CustomerCareChatBot.NewOffers.OPTION_7.toString());
            }
        } else if (level == 3) {
            System.out.println("Set Successfully");
            System.out.println("9-Back");
            System.out.println("0-Exit");
            System.out.println("22-Main Menu");
        }

        return choiceList;
    }

    static class SelectedOptions {
        private int level;
        private int choice;

        SelectedOptions(int level, int choice) {
            this.level = level;
            this.choice = choice;
        }

        public int getLevel() {
            return this.level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getChoice() {
            return this.choice;
        }

        public void setChoice(int choice) {
            this.choice = choice;
        }
    }

    public static enum Level1 {
        OPTION_1("1.English"),
        OPTION_2("2.Tamil"),
        OPTION_3("3.Hindi"),
        OPTION_4("0-Exit");

        private final String text;

        private Level1(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum Level2 {
        OPTION_1("1.Recharge"),
        OPTION_2("2.Caller_Tune"),
        OPTION_3("3.Internet"),
        OPTION_4("4.New Offers"),
        OPTION_5("9-Back"),
        OPTION_6("0.Exit"),
        OPTION_7("22-Main Menu");

        private final String text;

        private Level2(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum Level3 {
        OPTION_1("1.ரீஜார்ச்"),
        OPTION_2("2.காலர் டியுன்"),
        OPTION_3("3.டிடிஎச்"),
        OPTION_4("4.புதிய ஆஃபர்");

        private final String text;

        private Level3(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum Recharge {
        OPTION_1("1.Recharge"),
        OPTION_2("2.Add ON Packs"),
        OPTION_3("9.Back"),
        OPTION_4("0.Exit"),
        OPTION_5("22-Main menu");

        private final String text;

        private Recharge(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum Caller_Tune {
        OPTION_1("1.Arabic Kuthu"),
        OPTION_2("2.Mudhal Nee Mudivum Nee"),
        OPTION_3("3.Vera Maari"),
        OPTION_4("4.Two Two Two"),
        OPTION_5("9.Back"),
        OPTION_6("0-Exit"),
        OPTION_7("22-Main Menu");

        private final String text;

        private Caller_Tune(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum DataPacks {
        OPTION_1("1.Rs.999 81 Days 2GB/Day 4G Data+Voice Unlimited"),
        OPTION_2("2.Rs.299 28 Days 1.5GB/Day 4G Data+Voice Unlimited"),
        OPTION_3("3.Rs.239 28 Days 1GB/Day 4G Data+Voice Unlimited"),
        OPTION_4("9.Back"),
        OPTION_5("0.Exit"),
        OPTION_6("22-Main menu");

        private final String text;

        private DataPacks(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }

    public static enum NewOffers {
        OPTION_1("1.265=UL call+1GB/D,28D"),
        OPTION_2("2.479=UL call+1.5GB/D,56D"),
        OPTION_3("3.299=UL call+1.5GB/D28D"),
        OPTION_4("4.549=UL call+25GB/D,56D"),
        OPTION_5("9.Back"),
        OPTION_6("0.Exit"),
        OPTION_7("22-Main menu");

        private final String text;

        private NewOffers(String text) {
            this.text = text;
        }

        public String toString() {
            return this.text;
        }
    }
}
