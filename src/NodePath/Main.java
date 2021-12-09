package NodePath;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Main extends JFrame {

    private JPanel contentPane;
    private JTextField nameFromTextField;
    private JTextField nameToTextField;
    public static JTextArea resultTextArea;
    public JScrollPane scroll;

    /**
     * Launch the application.
     */
    static Graph graph = new Graph();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }// end of main method

    public static void findPath(String startName, String endName, PathFinding path) {
        graph.resetAllNodes();
        if (path.pathFind(startName, endName)) {
            resultTextArea.append("\nHAVE A PATH");
        } else {
            resultTextArea.append("\nNo path found.");
        }
    }

    public void init() throws IOException {
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Path path = Paths.get(file.getAbsolutePath());
            BufferedReader reader = Files.newBufferedReader(path);

            String line;
            while ((line = reader.readLine()) != null) {

                String[] col = line.split("[,;]");
                if (col[4].trim().equals("room") || col[4].trim().equals("transit")) {
                    graph.addNode(new Node(col[0].trim(), Integer.parseInt(col[1].trim()),
                            Integer.parseInt(col[2].trim()), Integer.parseInt(col[3].trim()), col[4].trim()));
                }
                if (col[4].trim().equals("yes") || col[4].trim().equals("no")) {
                    graph.addLink(col[0].trim(), col[1].trim(), col[2].trim(), Double.parseDouble(col[3].trim()),
                            (col[4].trim().equals("yes") ? true : false));
                    // System.out.println(col[4]);
                }
            }
            reader.close();
        }
    }

    /**
     * Create the frame.
     */
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 419, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nameFromTextField = new JTextField();
        nameFromTextField.setBounds(118, 50, 46, 20);
        contentPane.add(nameFromTextField);
        nameFromTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Room \u2116");
        lblNewLabel.setBounds(46, 50, 74, 14);
        contentPane.add(lblNewLabel);

        JLabel lblFrom = new JLabel("From");
        lblFrom.setBounds(118, 25, 46, 14);
        contentPane.add(lblFrom);

        JLabel lblTo = new JLabel("To");
        lblTo.setBounds(261, 25, 46, 14);
        contentPane.add(lblTo);

        JButton btnGo = new JButton("Go");
        btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                resultTextArea.resetKeyboardActions();
                resultTextArea.setText("Avoiding CLIMB\n");
                findPath(nameFromTextField.getText(), nameToTextField.getText(), new ConditionOne(graph));
            }
        });
        btnGo.setBounds(28, 102, 61, 23);
        contentPane.add(btnGo);

        nameToTextField = new JTextField();
        nameToTextField.setColumns(10);
        nameToTextField.setBounds(261, 50, 46, 20);
        contentPane.add(nameToTextField);

        JButton btnInsertFile = new JButton("Insert file");
        btnInsertFile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {
                    init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resultTextArea.setText("File inserted");
            }
        });
        btnInsertFile.setBounds(286, 102, 89, 23);
        contentPane.add(btnInsertFile);
        scroll = new JScrollPane();
        scroll.setSize(347, 179);
        scroll.setLocation(28, 136);
        scroll.setVisible(true);
        contentPane.add(scroll);

        resultTextArea = new JTextArea();
        scroll.setViewportView(resultTextArea);
        resultTextArea.setEditable(false);

        JButton btnGoTwo = new JButton("Go");
        btnGoTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultTextArea.resetKeyboardActions();
                resultTextArea.setText("Minimum steps acquired\n"
                        + "Sadly it doesn't work. :(\n");
                findPath(nameFromTextField.getText(), nameToTextField.getText(), new ConditionTwo(graph));
            }
        });
        btnGoTwo.setBounds(114, 102, 61, 23);
        contentPane.add(btnGoTwo);

        JButton btnGoThree = new JButton("Go");
        btnGoThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                resultTextArea.resetKeyboardActions();
                resultTextArea.setText("Finding a way to a room using LIFT.\n" +
                        "If there is no LIFT - use CLIMB,\n" + "but the steps will be doubled.\n");
                findPath(nameFromTextField.getText(), nameToTextField.getText(), new ConditionThree(graph));
            }
        });
        btnGoThree.setBounds(197, 102, 61, 23);
        contentPane.add(btnGoThree);

        JLabel lblNewLabel_1 = new JLabel("Cond. one");
        lblNewLabel_1.setBounds(28, 81, 75, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblConditionTwo = new JLabel("Cond. two");
        lblConditionTwo.setBounds(114, 81, 75, 14);
        contentPane.add(lblConditionTwo);

        JLabel lblConditionThree = new JLabel("Cond. three");
        lblConditionThree.setBounds(197, 81, 75, 14);
        contentPane.add(lblConditionThree);

    }
}
