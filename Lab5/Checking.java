public class Checking {
    public static void main(String[] args) {
        VectorStack<Integer> lowervalues = new VectorStack<Integer>();
        VectorStack<Integer> uppervalues = new VectorStack<Integer>();
        int [] data = {3, 7, 0, 2, 4, 6, 5, 3, 1, 2, 8};
        int [] result = new int[data.length];

        for(int i = 0; i < data.length; i++) {

            if(lowervalues.isEmpty()) {
                lowervalues.push(data[i]);
            }

            while(data[i] < lowervalues.peek()) {
                int value = lowervalues.pop();
                uppervalues.push(value);

                if(lowervalues.isEmpty() || data[i] > lowervalues.peek()) {
                    lowervalues.push(data[i]);
                }
            }

            if(i == 1 && uppervalues.isEmpty()) {
                uppervalues.push(data[i]);
            }

            while(data[i] > lowervalues.peek() && data[i] > uppervalues.peek()) {
                int value2 = uppervalues.pop();
                    lowervalues.push(value2);

                if (uppervalues.isEmpty() || data[i] < uppervalues.peek()) {
                    uppervalues.push(data[i]);
                }
            }

            if(data[i] > lowervalues.peek() && data[i] < uppervalues.peek()) {
                uppervalues.push(data[i]);
            }

            if(i == data.length - 1) {
                int j = 0;
                int put;
                while(!lowervalues.isEmpty()) {
                    put = lowervalues.pop();
                    uppervalues.push(put);
                }

                while(!uppervalues.isEmpty()) {
                    result[j] = uppervalues.pop();
                    j++;
                }
            }
        }
//        lowervalues.push(-3);
//        lowervalues.push(6);
//        lowervalues.push(8);
//
//        uppervalues.push(14);
//        uppervalues.push(9);
//        uppervalues.push(8);
//
//        if(lowervalues.isEmpty()) {
//            lowervalues.push(val);
//        }
//
//        while(val < lowervalues.peek()) {
//            int value = lowervalues.pop();
//            uppervalues.push(value);
//
//            if(val > lowervalues.peek())
//                lowervalues.push(val);
//        }
//
//        if(uppervalues.isEmpty()) {
//            uppervalues.push(val);
//        }
//
//        while (val > lowervalues.peek() && val > uppervalues.peek()) {
//            int value2 = uppervalues.pop();
//            lowervalues.push(value2);
//
//            if (val < uppervalues.peek())
//                uppervalues.push(val);
//        }

        System.out.println(lowervalues);
        System.out.println(uppervalues);
    }
}