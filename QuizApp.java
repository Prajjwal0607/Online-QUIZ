import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == (correctOptionIndex + 1);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of real questions you asked for
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Who is the Prime Minister of India?",
                Arrays.asList("Rahul Gandhi", "Narendra Modi", "Amit Shah", "Yogi Adityanath"),
                1
        ));
        questions.add(new Question(
                "What is our National Animal?",
                Arrays.asList("Elephant", "Peacock", "Tiger", "Lion"),
                2
        ));
        questions.add(new Question(
                "What is the Capital of India?",
                Arrays.asList("Mumbai", "Kolkata", "New Delhi", "Chennai"),
                2
        ));
        questions.add(new Question(
                "What is our National Sport?",
                Arrays.asList("Cricket", "Hockey", "Kabaddi", "Football"),
                1
        ));

        int score = 0;

        System.out.println("📚 Welcome to the Indian General Knowledge Quiz!");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.display();

            System.out.print("Your answer (1-4): ");
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Skipping question.");
                continue;
            }

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + (q.correctOptionIndex + 1));
            }
        }

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}
