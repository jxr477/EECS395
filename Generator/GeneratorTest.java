package Generator;
import java.util.*;
import DBConnect.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class GeneratorTest {

        @Test
        public void generateTest() throws Exception {
            Student student1 = new Student("9999", 4.0, 170, 170, 6.0, 120, true, 10, "China");
            Student student2 = new Student("0001", 3.42, 157, 168, 3.0, 100, false, 0, "China");
            ArrayList<School> test1 = Generator.generate(student1);
            ArrayList<School> test2 = Generator.generate(student2);


            Assert.assertEquals(test1.size(), Generator.generate(student1).size());
            Assert.assertEquals(test2.size(), Generator.generate(student2).size());
        }

        @Test
        public void GetAverageGPATest() {
            Assert.assertEquals(3.87, Generator.getAverageGPA("'0001'"), 0.01);
        }

        @Test
        public void GetAverageGRE_VTest() {
            Assert.assertEquals(158.33, Generator.getAverageGRE_V("'0001'"), 0.01);
        }

    @Test
    public void GetAverageGRE_QTest() {
        Assert.assertEquals(169.33, Generator.getAverageGRE_Q("'0001'"), 0.01);
    }

    @Test
    public void GetAverageGRE_WTest() {
        Assert.assertEquals(3.83, Generator.getAverageGRE_W("'0001'"), 0.01);
    }

    @Test
    public void GetAverageWorkingTimeTest() {
        Assert.assertEquals(0.0, Generator.getAverageWorkingTime("'0001'"), 0.01);
    }

    @Test
    public void GetAverageToeflTest() {
        Assert.assertEquals(107.67, Generator.getAverageToefl("'0001'"), 0.01);
    }

    @Test
    public void GetAveragePublicationTest() {
        Assert.assertEquals(true, Generator.getAveragePublication("'0001'"));
    }

    @Test
    public void GraduateFromUSTest() {
        Assert.assertEquals(true, Generator.GraduateFromUS("0001"));
    }

    @Test
    public void AdjustPublicationTest() {
        Assert.assertEquals(true, Generator.AdjustPublication(true, true));
        Assert.assertEquals(true, Generator.AdjustPublication(false, false));
        Assert.assertEquals(true, Generator.AdjustPublication(true, false));
        Assert.assertEquals(true, Generator.AdjustPublication(false, true));
    }



}
