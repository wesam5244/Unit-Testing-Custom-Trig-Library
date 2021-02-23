import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class myTrigTest {
    
    myTrig mytrig;

    @BeforeEach
    void setUp(){
        mytrig = new myTrig();
    }

    @Test
    /*
    For all the test cases, we included tests with degrees under each one to show that the function also works
    with degrees as well. However, in order to do so, the D2R function must be called to convert the degrees to radians
    and then using the ouput as a parameter for the function
    */
    void Sin() {
        /*
        Test cases in which sinx = 0. The reason why we added the precision for these cases is because the Math.sin()
        function does not return exactly 0 in this case, but rather it returns a very small number.
         */
        assertEquals(mytrig.Sin(0), Math.sin(0), 0.000000001);
        assertEquals(mytrig.Sin(Math.PI), Math.sin(Math.PI), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(180)), Math.sin(Math.PI), 0.000000001);

        assertEquals(mytrig.Sin(2*Math.PI), Math.sin(2*Math.PI), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(360)), Math.sin(2*Math.PI), 0.000000001);

        /*
        Test case in which sinx = 1. The reason why we added the precision for these cases is because the Math.sin()
        function does not return exactly 1 in this case, but rather it returns a very small number right above 1
         */
        assertEquals(mytrig.Sin(Math.PI/2), Math.sin(Math.PI/2), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(90)), Math.sin(Math.PI/2), 0.000000001);

        /*
        Test case in which sinx = -1. The reason why we added the precision for these cases is because the Math.sin()
        function does not return exactly -1 in this case, but rather it returns a very small number right below -1
         */
        assertEquals(mytrig.Sin((3*Math.PI)/2), Math.sin((3*Math.PI)/2), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(270)), Math.sin((3*Math.PI)/2), 0.000000001);

        /*
        Test similar values in each quadrant to test the sign differences. Each similar value should have the same
        absolute value in each quadrant, but there will be sign differences which are tested here.
         */
        assertEquals(mytrig.Sin((Math.PI)/3), Math.sin((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(60)), Math.sin((Math.PI)/3), 0.000000001);

        assertEquals(mytrig.Sin((2*(Math.PI))/3), mytrig.Sin((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(120)), Math.sin((Math.PI)/3), 0.000000001);

        assertEquals(mytrig.Sin((4*(Math.PI))/3), -1*mytrig.Sin((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(240)),-1*mytrig.Sin((Math.PI)/3), 0.000000001);

        assertEquals(mytrig.Sin((5*(Math.PI))/3), -1*mytrig.Sin((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(300)), -1*mytrig.Sin((Math.PI)/3), 0.000000001);

        /*
        The way the sine graph works is that the same values in the negative side of the graph output values that are
        negative to those of the positive values, and is essentially reflected. These test cases check to see if each
        quadrant is reflexive about the y-axis. In this case, we use assertTrue() instead of assertEquals() to show that
        they are indeed negatives of one another
         */
        assertTrue(-1*mytrig.Sin((Math.PI)/2) == mytrig.Sin((-1*Math.PI)/2));
        assertTrue(-1*mytrig.Sin(mytrig.D2R(90)) == mytrig.Sin(mytrig.D2R(-90)));

        assertTrue(-1*mytrig.Sin((Math.PI)) == mytrig.Sin((-1*Math.PI)));
        assertTrue(-1*mytrig.Sin(mytrig.D2R(180)) == mytrig.Sin(mytrig.D2R(-180)));

        assertTrue(-1*mytrig.Sin((Math.PI)/4) == mytrig.Sin((-1*Math.PI)/4));
        assertTrue(-1*mytrig.Sin(mytrig.D2R(45)) == mytrig.Sin(mytrig.D2R(-45)));

        assertTrue(-1*mytrig.Sin((3*Math.PI)/4) == mytrig.Sin((-3*Math.PI)/4));
        assertTrue(-1*mytrig.Sin(mytrig.D2R(135)) == mytrig.Sin(mytrig.D2R(-135)));

        assertTrue(-1*mytrig.Sin((3*Math.PI)/2) == mytrig.Sin((-3*Math.PI)/2));
        assertTrue(-1*mytrig.Sin(mytrig.D2R(270)) == mytrig.Sin(mytrig.D2R(-270)));

        /*
        The sine graphs are supposed to be cyclical in cycles of 2 pi. These test cases check to see if the four quadrants are indeed cyclical
        */
        assertEquals(mytrig.Sin((Math.PI)/6), mytrig.Sin((Math.PI)/6));
        assertEquals(mytrig.Sin(mytrig.D2R(30)), Math.sin((Math.PI)/6), 0.000000001);

        assertEquals(mytrig.Sin((Math.PI)/6), mytrig.Sin((25*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(30)), mytrig.Sin(mytrig.D2R(750)), 0.000000001);

        assertEquals(mytrig.Sin((5*Math.PI)/6), mytrig.Sin((29*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(150)), mytrig.Sin(mytrig.D2R(870)), 0.000000001);

        assertEquals(mytrig.Sin((7*Math.PI)/6), mytrig.Sin((31*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(210)), mytrig.Sin(mytrig.D2R(930)), 0.000000001);

        assertEquals(mytrig.Sin((11*Math.PI)/6), mytrig.Sin((35*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(330)), mytrig.Sin(mytrig.D2R(1050)), 0.000000001);

        /*
        The range of the sine function is between 1 and -1. In these test cases, through boundary analysis, we check to see if the
        sine function returns a value greater than 1 or less than -1 by checking the values immediately surrounding the points at which
        the graph return 1 and -1
        */
        assertTrue(mytrig.Sin((Math.PI/2) + ((double)1/100)) < 1);
        assertTrue(mytrig.Sin(mytrig.D2R(180+ (double)1/100)) < 1);

        assertTrue(mytrig.Sin(((3*Math.PI)/2) + ((double)1/100)) > -1);
        assertTrue(mytrig.Sin(mytrig.D2R(270 + (double)1/100)) > -1);

        /*
        The sine graph is infinite on both the positive and negative axis, so we check to see if it is infinite by inputting
        high values in either direction
        */
        assertEquals(mytrig.Sin(100*(Math.PI)), Math.sin(100*(Math.PI)), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(18000)), Math.sin(mytrig.D2R(18000)), 0.000000001);

        assertEquals(mytrig.Sin(-100*(Math.PI)), Math.sin(-100*(Math.PI)), 0.000000001);
        assertEquals(mytrig.Sin(mytrig.D2R(-18000)), Math.sin(mytrig.D2R(-18000)), 0.000000001);
    }

    @Test
    void Cos() {
        /*
        Test cases in which cosx = 0. The reason why we added the precision for these cases is because the Math.cos()
        function does not return exactly 1 in this case, but rather it returns a very small number.
         */
        assertEquals(mytrig.Cos(Math.PI/2), Math.cos(Math.PI/2), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(90)), Math.cos(Math.PI/2), 0.000000001);

        assertEquals(mytrig.Cos((3*Math.PI)/2), Math.cos((3*Math.PI)/2), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(270)), Math.cos(3*Math.PI/2), 0.000000001);

        /*
        Test case in which cosx = 1. The reason why we added the precision for these cases is because the Math.cos()
        function does not return exactly 1 in this case, but rather it returns a very small number right above 1
         */
        assertEquals(mytrig.Cos(0), Math.cos(0), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(0)), Math.cos(0), 0.000000001);

        /*
        Test case in which cosx = -1. The reason why we added the precision for these cases is because the Math.cos()
        function does not return exactly -1 in this case, but rather it returns a very small number right below -1
         */
        assertEquals(mytrig.Cos(Math.PI), Math.cos(Math.PI), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(180)), Math.cos(Math.PI), 0.000000001);

        /*
        Test similar values in each quadrant to test the sign differences. Each similar value should have the same
        absolute value in each quadrant, but there will be sign differences which are tested here.
         */
        assertEquals(mytrig.Cos((Math.PI)/3), Math.cos((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(60)), Math.cos(Math.PI/3), 0.000000001);

        assertEquals(mytrig.Cos((2*(Math.PI))/3), -1*mytrig.Cos((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(120)), -1*mytrig.Cos((Math.PI)/3), 0.000000001);

        assertEquals(mytrig.Cos((4*(Math.PI))/3), -1*mytrig.Cos((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(240)), -1*mytrig.Cos((Math.PI)/3), 0.000000001);

        assertEquals(mytrig.Cos((5*(Math.PI))/3), mytrig.Cos((Math.PI)/3), 0.000000001);
        assertEquals(mytrig.Cos(mytrig.D2R(300)), mytrig.Cos(Math.PI/3), 0.000000001);

        /*
        The cos graphs are supposed to be cyclical in cycles of 2 pi. These test cases check to see if the four quadrants are indeed cyclical
        */
        assertEquals(mytrig.Cos((Math.PI)/6), mytrig.Cos((Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Cos((Math.PI)/6), mytrig.Cos((25*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Cos((5*Math.PI)/6), mytrig.Cos((29*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Cos((7*Math.PI)/6), mytrig.Cos((31*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Cos((11*Math.PI)/6), mytrig.Cos((35*Math.PI)/6), 0.000000001);

        /*
        The way the cos graph works is that the same values in the negative side of the graph output values that are
        negative to those of the positive values, and is essentially reflected. These test cases check to see if each
        quadrant is reflexive about the y-axis. In this case, we use assertTrue() instead of assertEquals() to show that
        they are indeed negatives of one another
         */
        assertEquals(mytrig.Cos((Math.PI)/2), mytrig.Cos((-1*Math.PI)/2));
        assertEquals(mytrig.Cos(mytrig.D2R(90)), mytrig.Cos((-1*Math.PI)/2));

        assertEquals(mytrig.Cos((Math.PI)), mytrig.Cos((-1*Math.PI)));
        assertEquals(mytrig.Cos(mytrig.D2R(180)), mytrig.Cos((-1*Math.PI)));

        assertEquals(mytrig.Cos((Math.PI)/4), mytrig.Cos((-1*Math.PI)/4));
        assertEquals(mytrig.Cos(mytrig.D2R(45)), mytrig.Cos((-1*Math.PI)/4));

        assertEquals(mytrig.Cos((3*Math.PI)/4), mytrig.Cos((-3*Math.PI)/4));
        assertEquals(mytrig.Cos(mytrig.D2R(135)), mytrig.Cos((-3*Math.PI)/4));

        assertEquals(mytrig.Cos((3*Math.PI)/2), mytrig.Cos((-3*Math.PI)/2));
        assertEquals(mytrig.Cos(mytrig.D2R(270)), mytrig.Cos((-3*Math.PI)/2));

        /*
        The range of the cos function is between 1 and -1. In these test cases, through boundary analysis, we check to see if the
        cos function returns a value greater than 1 or less than -1 by checking the values immediately surrounding the points at which
        the graph return 1 and -1
        */
        assertTrue(mytrig.Cos((double)1/100) < 1);
        assertTrue(mytrig.Cos((Math.PI)) + ((double)1/100) > -1);

        /*
        The cos graph is infinite on both the positive and negative axis, so we check to see if it is infinite by inputting high values in either direction
        */
        assertEquals(mytrig.Cos((100*(Math.PI))/6), Math.cos((100*(Math.PI))/6), 0.000000001);
        assertEquals(mytrig.Cos((-100*(Math.PI))/6), Math.cos((-100*(Math.PI))/6), 0.000000001);
    }

    
    @Test
    void Tan(){
        /*
        Test case in which tanx = 0. Interestingly, the Math.tan() function does not return 0 at these points, so
        that is why we have the precision.
         */
        assertEquals(mytrig.Tan(0), Math.tan(0), 0.000000001);
        assertEquals(mytrig.Tan((Math.PI)), Math.tan(Math.PI), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(180)), Math.tan(Math.PI), 0.000000001);
        assertEquals(mytrig.Tan((2*Math.PI)), Math.tan(2*Math.PI), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(360)), Math.tan(2*Math.PI), 0.000000001);

        /*
        Test case in which tanx = 1. Interestingly, the Math.tan() function does not return 0 at these points, so
        that is why we have the precision.
         */
        assertEquals(mytrig.Tan((Math.PI)/4), Math.tan((Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(45)), Math.tan((Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan((5*Math.PI)/4), Math.tan((5*Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(225)), Math.tan((5*Math.PI)/4), 0.000000001);

        /*
        Test case in which tanx = -1. Interestingly, the Math.tan() function does not return 0 at these points, so
        that is why we have the precision.
         */
        assertEquals(mytrig.Tan((3*Math.PI)/4), Math.tan((3*Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(135)), Math.tan((3*Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan((7*Math.PI)/4), Math.tan((7*Math.PI)/4), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(315)), Math.tan((7*Math.PI)/4), 0.000000001);


        /*
        The tan graphs are supposed to be cyclical in cycles of 2 pi. These test cases check to see if the four quadrants are indeed cyclical
        */
        assertEquals(mytrig.Tan((Math.PI)/6), mytrig.Tan((Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(30)), Math.tan((Math.PI)/6), 0.000000001);

        assertEquals(mytrig.Tan((Math.PI)/6), mytrig.Tan((25*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(30)), mytrig.Tan(mytrig.D2R(750)), 0.000000001);

        assertEquals(mytrig.Tan((5*Math.PI)/6), mytrig.Tan((29*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(150)), mytrig.Tan(mytrig.D2R(870)), 0.000000001);

        assertEquals(mytrig.Tan((7*Math.PI)/6), mytrig.Tan((31*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(210)), mytrig.Tan(mytrig.D2R(930)), 0.000000001);

        assertEquals(mytrig.Tan((11*Math.PI)/6), mytrig.Tan((35*Math.PI)/6), 0.000000001);
        assertEquals(mytrig.Tan(mytrig.D2R(330)), mytrig.Tan(mytrig.D2R(1050)), 0.000000001);

        //Test to see if negative values are negative of positive values (and if 0 remains 0)
        assertEquals(-1*mytrig.Tan((Math.PI)/2), mytrig.Tan((-1*Math.PI)/2)); //UNDIFINED
        assertEquals(-1*mytrig.Tan(mytrig.D2R(90)), mytrig.Tan((-1*Math.PI)/2)); //UNDIFINED

        assertEquals(-1*mytrig.Tan((Math.PI)), mytrig.Tan((-1*Math.PI)));
        assertEquals(-1*mytrig.Tan(mytrig.D2R(180)), mytrig.Tan((-1*Math.PI)));

        assertEquals(-1*mytrig.Tan((Math.PI)/4), mytrig.Tan((-1*Math.PI)/4));
        assertEquals(-1*mytrig.Tan(mytrig.D2R(45)), mytrig.Tan((-1*Math.PI)/4));

        assertEquals(-1*mytrig.Tan((3*Math.PI)/4), mytrig.Tan((-3*Math.PI)/4));
        assertEquals(-1*mytrig.Tan(mytrig.D2R(135)), mytrig.Tan((-3*Math.PI)/4));

        assertEquals(-1*mytrig.Tan((3*Math.PI)/2), mytrig.Tan((-3*Math.PI)/2)); //UNDIFINED
        assertEquals(-1*mytrig.Tan(mytrig.D2R(270)), mytrig.Tan((-3*Math.PI)/2)); //UNDIFINED

        /*
        The tan graph is infinite on both the positive and negative axis, so we check to see if it is infinite by inputting high values in either direction
        */
        assertEquals(mytrig.Tan((100*(Math.PI))/6), Math.tan((100*(Math.PI))/6), 0.000000001);
        assertEquals(mytrig.Tan((-100*(Math.PI))/6), Math.tan((-100*(Math.PI))/6), 0.000000001);

        /*
        In the tan graph at every Pi the value will be negative before pi and positive after pi, so we must check
        the values before and after Pi to see if it returns a negative and positive value
        */
        assertTrue(mytrig.Tan(Math.PI - ((double)(1))/100) < 0);
        assertTrue(mytrig.Tan(mytrig.D2R(180) - ((double)(1))/100) < 0);

        assertTrue(mytrig.Tan(Math.PI + ((double)(1))/100) > 0);
        assertTrue(mytrig.Tan(mytrig.D2R(180) + ((double)(1))/100) > 0);
    }
}