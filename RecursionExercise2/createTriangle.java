/*
 * Team Name: Falcon and the Winter Soldier
 * Progammed by: Saravana Polisetti and Daiwik Swaminathan
 */

public class createTriangle {

    public static void main(String[] args) {
        createTriangle('*', 10);
    }

    public static void createTriangle(char symbol, int length) {
        if(length == 0)
            return;
        else {
            createTriangle(symbol, length-1);
            for (int i = 1; i <= length; i++)
                System.out.print(symbol);
            System.out.println();
        }
        System.out.println();
    }
}