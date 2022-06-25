/*
 * Team Name: Falcon and the Winter Soldier
 * Progammed by: Saravana Polisetti and Daiwik Swaminathan
 */
public class DisplayArray {

    private int array[]= {25,96,87,41};


    public static void main(String[] args) {

        DisplayArray da = new DisplayArray();

        da.displayArrayRecursively(0,da.array.length-1);

        System.out.println();

        da.displayArrayWithStack(0,da.array.length-1);
    }

    public void displayArrayRecursively(int start, int length) {
        if(start == length + 1)
            return;
        else {
            System.out.print(array[start] + " ");
            displayArrayRecursively(start+1, length);
        }
    }

    public void displayArrayWithStack(int start, int length) {
        LinkedStack<Integer> arr = new LinkedStack<Integer>();
        for(int i = length; i >= start; i--) {
            arr.push(array[i]);
        }

        for(int j = start; j <= length; j++) {
            System.out.print(arr.pop() + " ");
        }
        System.out.println();
    }

    private class Record {
        private int first, last;
        private Record(int firstIndex, int lastIndex) {
            first = firstIndex;
            last = lastIndex;
        } // end constructor
    } // end Record
}