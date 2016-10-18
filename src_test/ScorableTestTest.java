import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Jubal Rife on 10/17/2016.
 */
public class ScorableTestTest {

    @Test (expected = ScorableTest.MismatchedAnswersAndKeyException.class)
    public void test_givenMismatchedAnswerAndKey_throwException() throws Exception {
        new ScorableTest().setAnswers("a;b;c").setKey("a;b").score();
    }

    @Test (expected = ScorableTest.NullInputException.class)
    public void test_givenNullAnswer_throwException() throws Exception {
        new ScorableTest().setAnswers(null).setKey("").score();
    }

    @Test (expected = ScorableTest.NullInputException.class)
    public void test_givenNullKey_throwException() throws Exception {
        new ScorableTest().setAnswers("").setKey(null).score();
    }

    @Test (expected = ScorableTest.NullInputException.class)
    public void test_givenNulls_throwException() throws Exception {
        new ScorableTest().setAnswers(null).setKey(null).score();
    }

    @Test
    public void test_givenNoAnswersAndNoKey_returnPerfectScore() throws Exception {
        int score = new ScorableTest().setAnswers("").setKey("").score();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenMultipleQuestionsWithNoAnswerOrKey_returnPerfectScore() throws Exception {
        int score = new ScorableTest().setAnswers("_;_").setKey("_;_").score();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenNoAnswersWithKey_returnZeroScore() throws Exception {
        int score = new ScorableTest().setAnswers("_").setKey("a").score();
        assertThat(score, is(0));
    }

    @Test
    public void test_givenSingleCorrectAnswer_expectPerfectScore() throws Exception {
        int score = new ScorableTest().setAnswers("a").setKey("a").score();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenOneCorrectAnswerAndOneAbsentAnswer_withKey_expectHalf() throws Exception {
        int score = new ScorableTest().setAnswers("a;_").setKey("a;b").score();
        assertThat(score, is(50));
    }

    @Test
    public void test_givenTwoOutOfThreeWrong_withKey_produceScore() throws Exception {
        int score = new ScorableTest()
                .setAnswers("a;c;a")
                .setKey("a;b;a")
                .score();
        assertThat(score, is(66));
    }
}