import java.util.Scanner;
import java.util.ArrayList;

public class DeAnza_FoodCourt {
    private final double[] prices;
    ArrayList<Integer> options = new ArrayList<>();
    ArrayList<Integer> amount = new ArrayList<>();
    private final double tax = 0.09;


    public DeAnza_FoodCourt() {
        prices = new double[5];
        prices[0] = 5.25;
        prices[1] = 5.75;
        prices[2] = 5.95;
        prices[3] = 5.95;
        prices[4] = 5.95;
    }

    public static void main(String[] args) {
        DeAnza_FoodCourt obj = new DeAnza_FoodCourt();
        obj.displayMenu();
        obj.getInputs();
        obj.calculate();
    }

    public void displayMenu(){
        String title = "Menu Items";
        String DAB = "De Anza Burger";
        String Bac = "Bacon Cheese";
        String Mush = "Mushroom Swiss";
        String West = "Western Burger";
        String Don = "Don Cali Burger";

        System.out.printf("%68s \n", title);
        int i = 0;
        while(i <= 125) {
            System.out.print("-");
            i++;
        }

        System.out.printf("\n(1)%-21s (2)%-22s (3)%-22s (4)%-23s (5)%-25s",DAB, Bac, Mush, West, Don);
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","Charbroiled Beef Patty", "Charbroiled Beef Patty",
                "Beef Patty", "Charbroiled Beef Patty", "Charbroiled Beef Patty");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","Green Leaf", "Smoked Bacon", "Mushrooms & Swiss Cheese",
                "Beer Battered Onion Rings", "Spring Mix Lettuce");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","Tomato", "Caramelized Onion", "Garlic & Mayo",
                "Sriracha BBQ Sauce", "Tomato & Red Onion");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","Red Onion", "American Cheese", "Green Leaf Lettuce",
                "American Cheese", "Avocado");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","White Cheddar", "Toasted Bun", "Tomato",
                "Toasted Bun", "Smoked Gouda & Bacon");
        System.out.printf("\n%-25s %-25s %-25s %-25s %-25s","Toasted Bun", "", "Toasted Bun",
                "", "Toasted Bun");
        System.out.printf("\n$%-25.2f $%-23.2f $%-24.2f $%-24.2f $%-25.2f", prices[0], prices[1], prices[2], prices[3], prices[4]);
        System.out.println("\n");
    }

    public void getInputs() {
        Scanner input = new Scanner(System.in);
        String yN = " ";
        int opt = -1;
        int amnt = -1;
        boolean prompt = true;

        while(prompt) {
            while(opt <= 0 || opt > 5) {
                System.out.print("\nWhat would you like to order today (Options: 1, 2, 3, 4, 5)? ");
                opt = input.nextInt();
                if (opt > 0 && opt <= 5)
                    options.add(opt);
                System.out.println();
            }

            while(amnt < 0) {
                System.out.print("How many of option " + opt + " would you like? ");
                amnt = input.nextInt();
                if (amnt > 0)
                    amount.add(amnt);
                System.out.println();
            }

            System.out.print("Would you like anything else? (Y/N) ");
            yN = input.next();

            prompt = yN.equals("Y") || yN.equals("y");

        }

        System.out.println("This is your order: ");
        System.out.println(options);
        System.out.println(amount);

        calculate();
        printBill();
    }

//    public void calculate() {
//        double total
//        for(int i = 0; i < options.size(); i++) {
//
//            switch (options.get(i)) {
//                case 1:
//
//                case 2:
//                case 3:
//                case 4:
//                default:
//
//            }
//            if(options.get(i) == 1)
//                System.out.println();
//            else if(options.get(i) == )
//        }
//    }

    public void printBill () {

    }
}