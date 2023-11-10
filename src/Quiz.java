import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    private final String[] questions = {"What is the capital of France?", "What is the largest planet in our solar system?", "What is the smallest country in the world by land area?"};
    private final String[][] options = {{"Paris", "London", "Berlin", "Madrid"}, {"Saturn", "Jupiter", "Uranus", "Neptune"}, {"Monaco", "Nauru", "Tuvalu", "Vatican City"}};
    private final String[] answers = {"Paris", "Jupiter", "Vatican City"};
    private final int totalQuestions = questions.length;
    private int currentQuestion = 0;
    private int correctAnswers = 0;

    private final JLabel question = new JLabel();
    private final JButton buttonA = new JButton();
    private final JButton buttonB = new JButton();
    private final JButton buttonC = new JButton();
    private final JButton buttonD = new JButton();
    private final JButton submitButton = new JButton("Submit");
    private final JButton nextButton = new JButton("Next");

    Quiz() {

        question.setFont(new Font("Nunito", Font.PLAIN, 40));
        question.setVerticalAlignment(JLabel.CENTER);
        question.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelQuestion = new JPanel();
        panelQuestion.setLayout(new BorderLayout());
        panelQuestion.setBackground(new Color(214, 184, 219));
        panelQuestion.setPreferredSize(new Dimension(1920, 400));
        panelQuestion.add(question);

        buttonA.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        buttonB.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        buttonC.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        buttonD.setFont(new Font("Comic Sans MS", Font.BOLD, 35));

        JPanel panelAnswer = new JPanel();
        panelAnswer.setLayout(new GridLayout(2, 2));
        panelAnswer.setPreferredSize(new Dimension(500, 500));
        panelAnswer.setBackground(Color.blue);
        panelAnswer.add(buttonA);
        panelAnswer.add(buttonB);
        panelAnswer.add(buttonC);
        panelAnswer.add(buttonD);

        this.setLayout(new GridLayout(2, 2));
        this.getContentPane().setBackground(Color.GRAY);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelQuestion);
        this.add(panelAnswer);
        this.setVisible(true);

        submitButton.addActionListener(this);
        nextButton.addActionListener(this);
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);

        displayQuestion();
    }

    private void displayQuestion() {
        question.setText(questions[currentQuestion]);
        buttonA.setText(options[currentQuestion][0]);
        buttonB.setText(options[currentQuestion][1]);
        buttonC.setText(options[currentQuestion][2]);
        buttonD.setText(options[currentQuestion][3]);
    }

    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(answers[currentQuestion])) {
            correctAnswers++;
        }
    }

    private void displayScore() {
        ImageIcon icon0 = new ImageIcon("zero.jpg");
        ImageIcon icon1 = new ImageIcon("one.jpg");
        ImageIcon icon2 = new ImageIcon("two.jpg");
        ImageIcon icon3 = new ImageIcon("three.jpg");


        this.setVisible(false);
        JLabel label = new JLabel();
        label.setText("Your score is " + correctAnswers + " out of " + totalQuestions);
        label.setFont(new Font(" ", Font.BOLD, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);

        if (correctAnswers == 0) {
            label.setIcon(icon0);
        } else if (correctAnswers == 1) {
            label.setIcon(icon1);
        } else if (correctAnswers == 2) {
            label.setIcon(icon2);
        } else label.setIcon(icon3);

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setSize(800, 800);
        frame.setTitle("Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            displayScore();
            submitButton.setEnabled(false);
            nextButton.setEnabled(false);
        } else if (e.getSource() == buttonA) {

            checkAnswer(buttonA.getText());
            currentQuestion++;
            if (currentQuestion < totalQuestions) {
                displayQuestion();
            } else displayScore();
        } else if (e.getSource() == buttonB) {

            checkAnswer(buttonB.getText());
            currentQuestion++;
            if (currentQuestion < totalQuestions) {
                displayQuestion();
            } else displayScore();
        } else if (e.getSource() == buttonC) {

            checkAnswer(buttonC.getText());
            currentQuestion++;
            if (currentQuestion < totalQuestions) {
                displayQuestion();
            } else displayScore();
        } else if (e.getSource() == buttonD) {

            checkAnswer(buttonD.getText());
            currentQuestion++;
            if (currentQuestion < totalQuestions) {
                displayQuestion();
            } else displayScore();
        }

    }
}


