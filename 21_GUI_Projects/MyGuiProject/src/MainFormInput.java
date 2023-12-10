import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static java.lang.Thread.sleep;

public class MainFormInput {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel buttonsPanel;
    private JButton collapseButton;
    private JButton clearButton;
    private JTextField textField_FirstName;
    private JTextField textField_SecondName;
    private JTextField textField_LastName;
    private JLabel fNameField;
    private JLabel sNameField;
    private JLabel lNameField;
    private JLabel fioField;
    private JTextField textField_FIO;
    private JProgressBar progressBar1;
    private JLabel progressText;

    public MainFormInput() {
        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (collapseButton.getText() == "Collapse") {
                    String field_FirstName = textField_FirstName.getText().trim();
                    if (field_FirstName.isEmpty()) {
                        //textField_FirstName.setText("Enter First Name");
                        System.out.println("Please Enter First Name");
                    }

                    String field_SecondName = textField_SecondName.getText().trim();
                    if (field_SecondName.isEmpty()) {
                        //textField_SecondName.setText("Enter Second Name");
                        System.out.println("Please Enter Second Name");
                    } else {

                    }

                    String field_SurnameName = textField_LastName.getText().trim();
                    if (field_SurnameName.isEmpty()) {
                        System.out.println("Please Enter Surname Name");
                        // textField_LastName.setText("Enter Surname");
                        return;
                    }

                    if (!field_SurnameName.isEmpty() && !field_SecondName.isEmpty() && !field_SurnameName.isEmpty()) {

                        textField_FIO.setText(field_FirstName + " " + field_SecondName + " " + field_SurnameName);

                        setVisibilityElm(false);

                        textField_FirstName.setText("");
                        textField_SecondName.setText("");
                        textField_LastName.setText("");
                    }

                }

                if (!textField_FIO.getText().isEmpty()) {
                    if (collapseButton.getText() == "Expand") {

                        String currentText = textField_FIO.getText();

                        if (!currentText.isEmpty()) {

                            textField_FirstName.setText(currentText.trim().split(" ")[0]);
                            textField_SecondName.setText(currentText.trim().split(" ")[1]);

                            collapseButton.setText("Collapse");
                            setVisibilityElm(true);

                            innnitializeProgress();

                            return;

                        }
                    }
                }

                collapseButton.setText("Expand");

            }

        });
        topPanel.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    sleep(100);
                    topPanel.setBackground(Color.white);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                /// topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField_FirstName.setText("");
                textField_SecondName.setText("");
                textField_LastName.setText("");

                innnitializeProgress();

            }
        });
        textField_FirstName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!textField_FirstName.getText().isEmpty()) {
                    setProgressBar1(30);
                } else {
                    setProgressBar1(0);
                }

            }
        });

        textField_SecondName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!textField_SecondName.getText().isEmpty()) {
                    // setProgressBar1(70);
                    innnitializeProgress();
                }

            }
        });

        textField_LastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!textField_LastName.getText().isEmpty()) {
                    innnitializeProgress();
                }

            }
        });

        textField_FirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!textField_FirstName.getText().isEmpty()) {
                    // setProgressBar1(30);
                    innnitializeProgress();
                }
            }
        });

        textField_SecondName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!textField_SecondName.getText().isEmpty()) {
                    //setProgressBar1(70);
                    innnitializeProgress();
                }
            }
        });

        textField_LastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!textField_LastName.getText().isEmpty()) {
                    // setProgressBar1(100);
                    innnitializeProgress();
                }
            }
        });

        textField_LastName.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                innnitializeProgress();
            }
        });

        textField_FirstName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                innnitializeProgress();
            }
        });

        textField_SecondName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                innnitializeProgress();
            }
        });

        textField_LastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                innnitializeProgress();
            }
        });

        textField_LastName.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentRemoved(ContainerEvent e) {
                super.componentRemoved(e);
                innnitializeProgress();
            }
        });
        textField_FirstName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                innnitializeProgress();
            }
        });
        textField_SecondName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                innnitializeProgress();
            }
        });
        textField_LastName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                innnitializeProgress();
            }
        });
        textField_LastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                innnitializeProgress();
            }
        });
        textField_SecondName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                innnitializeProgress();
            }
        });
        textField_FirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                innnitializeProgress();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setVisibilityElm(boolean sst) {

        textField_FirstName.setVisible(sst);
        textField_SecondName.setVisible(sst);
        textField_LastName.setVisible(sst);
        fNameField.setVisible(sst);
        sNameField.setVisible(sst);
        lNameField.setVisible(sst);
        textField_FIO.setVisible(!sst);
        fioField.setVisible(!sst);

    }

    public void innnitializeProgress() {

        if ((textField_FirstName.getText().isEmpty()) && (textField_SecondName.getText().isEmpty()) && (textField_LastName.getText().isEmpty())) {
            setProgressBar1(0);
        }

        if ((!textField_FirstName.getText().isEmpty()) && (textField_SecondName.getText().isEmpty()) && (textField_LastName.getText().isEmpty())) {
            setProgressBar1(30);
        }

        if ((!textField_FirstName.getText().isEmpty()) && (!textField_SecondName.getText().isEmpty()) && (textField_LastName.getText().isEmpty())) {
            setProgressBar1(70);
        }

        if ((textField_FirstName.getText().isEmpty()) && (!textField_SecondName.getText().isEmpty()) && (textField_LastName.getText().isEmpty())) {
            setProgressBar1(30);
        }

        if ((textField_FirstName.getText().isEmpty()) && (textField_SecondName.getText().isEmpty()) && (!textField_LastName.getText().isEmpty())) {
            setProgressBar1(30);
        }

        if ((!textField_FirstName.getText().isEmpty()) && (!textField_SecondName.getText().isEmpty()) && (textField_LastName.getText().isEmpty())) {
            setProgressBar1(70);
        }

        if ((textField_FirstName.getText().isEmpty()) && (!textField_SecondName.getText().isEmpty()) && (!textField_LastName.getText().isEmpty())) {
            setProgressBar1(70);
        }

        if ((!textField_FirstName.getText().isEmpty()) && (textField_SecondName.getText().isEmpty()) && (!textField_LastName.getText().isEmpty())) {
            setProgressBar1(70);
        }

        if ((!textField_FirstName.getText().isEmpty()) && (!textField_SecondName.getText().isEmpty()) && (!textField_LastName.getText().isEmpty())) {
            setProgressBar1(100);
        }
    }

    public void setProgressBar1(int value) {

        progressBar1.setStringPainted(true);
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(100);
        progressBar1.setValue(value);

    }
}
