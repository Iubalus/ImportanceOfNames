import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Iubalus on 10/17/2016.
 */
public class _0Test {

    @Test(expected = _0._1.class)
    public void test_givenMismatchedAnswerAndKey_throwException() throws Exception {
        new _0()._0("a;b;c")._1("a;b")._2();
    }

    @Test (expected = _0._2.class)
    public void test_givenNullAnswer_throwException() throws Exception {
        new _0()._0(null)._1("")._2();
    }

    @Test (expected = _0._2.class)
    public void test_givenNullKey_throwException() throws Exception {
        new _0()._0("")._1(null)._2();
    }

    @Test (expected = _0._2.class)
    public void test_givenNulls_throwException() throws Exception {
        new _0()._0(null)._1(null)._2();
    }

    @Test
    public void test_givenNoAnswersAndNoKey_returnPerfectScore() throws Exception {
        int score = new _0()._0("")._1("")._2();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenMultipleQuestionsWithNoAnswerOrKey_returnPerfectScore() throws Exception {
        int score = new _0()._0("_;_")._1("_;_")._2();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenNoAnswersWithKey_returnZeroScore() throws Exception {
        int score = new _0()._0("_")._1("a")._2();
        assertThat(score, is(0));
    }

    @Test
    public void test_givenSingleCorrectAnswer_expectPerfectScore() throws Exception {
        int score = new _0()._0("a")._1("a")._2();
        assertThat(score, is(100));
    }

    @Test
    public void test_givenOneCorrectAnswerAndOneAbsentAnswer_withKey_expectHalf() throws Exception {
        int score = new _0()._0("a;_")._1("a;b")._2();
        assertThat(score, is(50));
    }

    @Test
    public void test_givenTwoOutOfThreeWrong_withKey_produceScore() throws Exception {
        int score = new _0()._0("a;c;a")._1("a;b;a")._2();
        assertThat(score, is(66));
    }

}