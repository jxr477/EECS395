package Generator;
import java.util.*;
import DBConnect.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SearchTest {

    @Test
    public void searchTest() throws Exception {
        ArrayList<String> test1 = Search.search("Computer Engineering");
        ArrayList<String> test2 = Search.search("should have no result");


        Assert.assertEquals(test1.size(), Search.search("Computer Engineering").size());
        Assert.assertEquals(test2.size(), Search.search("should have no result").size());
    }

}
