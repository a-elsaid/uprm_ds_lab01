//import static org.junit.Assert.assertTrue;
package lab01;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoreFrequentThanTester {

	private MoreFrequentThan.Bag<String> B = null;

    @Before
    public void setUp() throws Exception {
        B = new MoreFrequentThan.ArrayBag<String>(10);
        B.add("Joe");
        B.add("Kim");
        B.add("Ned");
        B.add("Ned");
        B.add("Joe");
        B.add("Joe");
        B.add("Li");
        // B = {Joe, Kim, Ned, Ned, Joe, Joe, Li}
        // B getFrequencyOf: Joe = 3, Kim = 1, Ned = 2, Li = 1
    }

    @Test
    public void TestCase1(){
        this.B.clear();
        assertTrue("moreFrequent()-> Fails to return empty bag when bag B is empty.",
                this.B.moreFrequentThan("Joe").isEmpty());
    }

    @Test
    public void TestCase2(){
        MoreFrequentThan.Bag<String> B2 = this.B.moreFrequentThan("Ned");
        boolean condition = B2.size()== 1 && B2.getFrequencyOf("Joe") == 1 && this.B.size() == 7;
        assertTrue("moreFrequent()-> Fails to return bag B2 = {Joe} when calling " +
                        "B.moreFrequentThan(Ned) on B = {Joe, Kim, Ned, Ned, Joe, Joe, Li}",
                condition);

    }
    @Test
    public void TestCase3(){
        MoreFrequentThan.Bag<String> B2 = this.B.moreFrequentThan("Kim");
        boolean condition = B2.size()== 2 && B2.getFrequencyOf("Joe") == 1 &&
                B2.getFrequencyOf("Ned") == 1 && this.B.size() == 7;
        assertTrue("moreFrequent()-> Fails to return bag B2 = {Joe, Ned} when calling " +
                        "B.moreFrequentThan(Kim) on B = {Joe, Kim, Ned, Ned, Joe, Joe, Li}",
                condition);

    }

    @Test
    public void TestCase4(){
        MoreFrequentThan.Bag<String> B2 = this.B.moreFrequentThan("Joe");
        boolean condition = B2.size()== 0 && this.B.size() == 7;

        assertTrue("moreFrequent()-> Fails to return bag B2 = {} when calling " +
                        "B.moreFrequentThan(Joe) on B = {Joe, Kim, Ned, Ned, Joe, Joe, Li}",
                condition);

    }
    @Test
    public void TestCase5(){
        MoreFrequentThan.Bag<String> B2 = this.B.moreFrequentThan("Apu");
        boolean condition = B2.size()== 4
                && B2.getFrequencyOf("Joe") == 1 &&
                B2.getFrequencyOf("Ned") == 1
                && B2.getFrequencyOf("Kim") == 1
                && B2.getFrequencyOf("Li") == 1
                && this.B.size() == 7;

        assertTrue("moreFrequent()-> Fails to return bag B2 = {Joe, Kim, Ned, Li} when calling " +
                        "B.moreFrequentThan(Apu) on B = {Joe, Kim, Ned, Ned, Joe, Joe, Li}",
                condition);

    }
}
