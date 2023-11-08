package tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("отличный")) {
            return "happy";
        } else if (message.contains("ужасный")) {
            return "unhappy";
        }
        return "so so";
    }

}
