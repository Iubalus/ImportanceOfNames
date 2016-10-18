/**
 * Created by Jubal Rife on 10/17/2016.
 */
public class ScorableTest {
    private String answers;
    private String key;

    public ScorableTest setAnswers(String answers) {
        this.answers = answers;
        return this;
    }

    public ScorableTest setKey(String key) {
        this.key = key;
        return this;
    }

    public int score() {
        checkKeyAndAnswersExist();
        checkKeyAndAnswersMatch();
        if (key.isEmpty()) {
            return 100;
        } else if (answers.isEmpty()) {
            return 0;
        }
        String[] suppliedAnswers = answers.split(";");
        String[] expectedAnswers = key.split(";");
        double incorrect = 0;
        for (int i = 0; i < expectedAnswers.length; i++) {
            if (!suppliedAnswers[i].equals(expectedAnswers[i])) {
                incorrect++;
            }
        }
        double total = expectedAnswers.length;
        return (int) (100.0 - ((incorrect / total) * 100.0));
    }

    private void checkKeyAndAnswersExist() {
        if (key == null || answers == null) {
            throw new NullInputException();
        }
    }

    private void checkKeyAndAnswersMatch() {
        if (answers.length() != key.length()) {
            throw new MismatchedAnswersAndKeyException();
        }
    }

    public static class MismatchedAnswersAndKeyException extends RuntimeException {

    }

    public static class NullInputException extends RuntimeException {

    }
}
