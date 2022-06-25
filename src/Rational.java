/*
 * The rational class implements various functions that add, subtract, multiply, divide,
 * and get the reciprocal of a rational number.
 *
 * Team Name: Falcon and the Winter Soldier
 * @authors: Saravana Polisetti, Daiwik Swaminathan
 * @version 4.0
 */
/**
 * A class that represents a rational number.
 *
 * @author Charles Hoot
 * @version 4.0
 */

public class Rational
{
    private int n, d = -1;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational() {
        n = 1;
        d = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    public Rational(int n, int d) {
        if(d == 0)
            throw new ZeroDenominatorException("The denominator can't be zero.");
        else {
            this.n = n;
            this.d = d;
        }

        normalize();
    }

    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator() {
        return n;
    }

    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator() {
        return d;
    }


    /**
     * Negate a rational number r
     *
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate() {
        Rational temp = new Rational(this.n, this.d);
        temp.n = temp.n * -1;
        return temp;
    }


    /**
     * Invert a rational number r
     *
     * @return a new rational number that is 1/r.
     */
    public Rational invert()
    {
        Rational temp = new Rational(this.n, this.d);
        int tempNum = -1;

        if(temp.n < 0) {
            tempNum = -1 * temp.n;
            temp.n = -1 * this.d;
            temp.d = tempNum;
        }

        else {
            tempNum = temp.n;
            temp.n = this.d;
            temp.d = tempNum;
        }

        if(temp.d == 0)
            throw new ZeroDenominatorException("Denominator can't be zero.");

        return temp;
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */
    public Rational add(Rational other) {
        Rational sum = new Rational(this.n, this.d);
        sum.n = (sum.n*other.d + sum.d*other.n);
        sum.d = (sum.d * other.d);

        sum.normalize();

        return sum;
    }

    /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other) {

        Rational sub = new Rational(this.n, this.d);
        sub.n = (sub.n*other.d - sub.d*other.n);
        sub.d = (sub.d * other.d);

        sub.normalize();

        return sub;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */
    public Rational multiply(Rational other) {
        Rational mul = new Rational(this.n, this.d);
        mul.n = (mul.n * other.n);
        mul.d = (mul.d * other.d);

        mul.normalize();

        return mul;
    }


    /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other) {
        Rational div = new Rational(this.n, this.d);
        div.n = (div.n * other.d);
        div.d = (div.d * other.n);

        if(div.d == 0)
            throw new ZeroDenominatorException("Denominator can't be zero.");

        div.normalize();

        return div;
    }



    /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize() {
        if(d < 0) {
            n = n * -1;
            d = d * -1;

            int div = gcd(Math.abs(n), d);

            n = n / div;
            d = d / div;
        }

        else {
            int div = gcd(Math.abs(n), d);

            n = n / div;
            d = d / div;
        }
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
}
