public class Testing <T> {

    public static void main(String[] args) {
        new Testing();
        Testing word = new Testing(10, "0");
        checkAge(300);
        int n = -3;
        int d = -4;
        System.out.println("came here " + n/(double)d);
    }

    public Testing() {
        System.out.println("First");
    }

    public Testing(int num, T alpha) {
        System.out.println("Second " + alpha);
    }

//    public Testing(int num, String word) {
//        System.out.println("Third " + word);
//    }

    public static void checkAge(int age) {
        assert(age > 60 && age < 110): "Incorrect Age";

        if(age > 60)
            System.out.println("You are eligible for benefits");
        else
            System.out.println("You are eligible for the vaccine");
    }
}
