package TestCodeInterview;

import CodeInterview.ModerateMasterMind;
import CodeInterview.Recursion;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class TestModerateMasterMind extends TestCase {
    public void test_TakeAGuess_should_throw_Exception_if_the_guess_has_not_the_right_form() throws Exception {
        try {
            ModerateMasterMind moderateMasterMind = new ModerateMasterMind(Arrays.asList(
                    Recursion.Color.Black,
                    Recursion.Color.Yellow,
                    Recursion.Color.Blue,
                    Recursion.Color.Green));
            List<Recursion.Color> myGuess = Arrays.asList(
                    Recursion.Color.Yellow,
                    Recursion.Color.Black,
                    Recursion.Color.Blue,
                    Recursion.Color.Green,
                    Recursion.Color.Green);
            moderateMasterMind.takeAGuess(myGuess);
            fail("Should have thrown Exception, guess has not the right form");
        } catch (IllegalStateException e) {
            Assertions.assertThat(e).hasMessage("Your guess has the right number of item");
        }
    }

}