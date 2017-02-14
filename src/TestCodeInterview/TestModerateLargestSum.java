package TestCodeInterview;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import static CodeInterview.ModerateLargestSum.findLargestSum;

/**
 * Created by pierre on 15/02/17.
 */
public class TestModerateLargestSum extends TestCase {

    public void testFindLargestSum() throws Exception {
        int[] myArray = {2, -8, 3, -2, 4, -10};
        Assertions.assertThat(findLargestSum(myArray)).isEqualTo(5);
    }
}