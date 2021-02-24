public class myTrig {
    final static int PRECISION = 50;
    final static double PI = 3.14159265358979323846;

    //This function computes the factorial of a given number using recursion. The base case is when
    //n = 1 in which 1 is returned, after which the stack is multiplied by one another
    public static double Fact(double n) {
        if (n <= 1)
            return 1;
        else
            return n * Fact(n - 1);
    }

    //This function return x to the power of y using recursion. Since we are not permitted to use any of the
    //function in the Math library, we had to code this ourselves
    public static double pow(double x , double y) {
        if(y == 1)
            return x;
        if( y == 0 )
            return 1;
        return x * pow(x , y-1);
    }

    //This function outputs the sin value of a given radians value
    public double Sin(double x){
        //This line of code is extremely important as it takes each value and scales it to a value between 0 and 2PI.
        //This is important in computing the sin value for large values that are greater than the range of a double
        //variable
        x = x % (2 * PI); // setting x to be less than 2PI
        return TaylorSeries(x,0,0,1,1);
    }

    //This function outputs the cos value of a given radians value
    public double Cos(double x){
        x = x % (2 * PI); // setting x to be less than 2PI
        return TaylorSeries(x,1, 1 , 2 , -1);
    }

    //This function finds the result of the Taylor Series for a specific x value. The variable result stores
    //the result of the calculation, the variable i will be used for the loop iterations, j is for the exponent
    //value, and k for the multiplication of the term
    private static double TaylorSeries(double x ,double result, int i , int j , int k) {
        //Precision is the amount of terms that will be computed
        while(i < PRECISION) {
            result = result + ((pow(x, j) / Fact (j)) * k); //i-th term of taylor series.
            i++;j+=2;k*=-1;
        }
        return result;
    }

    //This is the tan function that computes the tan value by calling the sin and cos functions and dividing their
    //results based on the tan formula
    public double Tan(double x){
        return Sin(x) / Cos(x);
    }

    public double D2R(double deg) {
        return deg*(PI/180);
    }
}
