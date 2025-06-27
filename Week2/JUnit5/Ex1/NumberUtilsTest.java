import org.junit.Test;
import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void testFindMaxNormalArray() {
        int[] nums = {4, 7, 1, 9, 3};
        assertEquals(9, NumberUtils.findMax(nums));
    }

    @Test
    public void testFindMaxWithNegativeNumbers() {
        int[] nums = {-10, -3, -50, -1};
        assertEquals(-1, NumberUtils.findMax(nums));
    }

    @Test
    public void testFindMaxWithSingleElement() {
        int[] nums = {42};
        assertEquals(42, NumberUtils.findMax(nums));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMaxWithEmptyArray() {
        int[] nums = {};
        NumberUtils.findMax(nums);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMaxWithNullArray() {
        NumberUtils.findMax(null);
    }
}
