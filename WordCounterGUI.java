
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class WordCounterGUI extends JFrame {

    private JTextArea textArea;
    private JButton countButton;

    public WordCounterGUI() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addEventListeners();
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        countButton = new JButton("Count Words");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane)
                        .addComponent(countButton, GroupLayout.Alignment.CENTER)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addComponent(countButton)
        );
    }

    private void addEventListeners() {
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String inputText = textArea.getText();

        // Step 3: Split the string into an array of words using space or punctuation as delimiters
        String[] words = inputText.split("\\s+|\\p{Punct}");

        // Step 4: Initialize a counter variable
        int wordCount = 0;

        // Step 7: Ignore common words or stop words
        Set<String> stopWords = createStopWordsSet();

        // Step 5: Iterate through the array of words and increment the counter
        for (String word : words) {
            // Step 7: Ignore common words or stop words
            if (!stopWords.contains(word.toLowerCase())) {
                wordCount++;
            }
        }

        // Step 6: Display the total count of words to the user
        JOptionPane.showMessageDialog(this, "Total words: " + wordCount);

        
    }

    private Set<String> createStopWordsSet() {
        // Common English stop words for demonstration purposes
        String[] stopWordsArray = {"a", "an", "the", "and", "is", "in", "of", "to", "with"};

        Set<String> stopWordsSet = new HashSet<>();
        for (String stopWord : stopWordsArray) {
            stopWordsSet.add(stopWord);
        }
        return stopWordsSet;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterGUI().setVisible(true);
            }
        });
    }
}

    

