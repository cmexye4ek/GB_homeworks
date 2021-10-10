package ru.geekbrains.lesson8_homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {

    public ChatWindow() {
        setTitle("BadChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 600);
        JPanel grayPanelNorth = new JPanel();
        JPanel grayPanelEast = new JPanel();
        JPanel grayPanelWest = new JPanel();
        add(grayPanelNorth, BorderLayout.NORTH);
        add(grayPanelEast, BorderLayout.EAST);
        add(grayPanelWest, BorderLayout.WEST);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);


        JTextField inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        JLabel inputTip = new JLabel("Enter your message text:");
        inputPanel.add(inputTip, BorderLayout.NORTH);

        JPanel chatHistoryPanel = new JPanel();
        chatHistoryPanel.setLayout(new BorderLayout());
        add(chatHistoryPanel, BorderLayout.CENTER);

        JTextArea chatHistoryText = new JTextArea();
        chatHistoryPanel.add(chatHistoryText, BorderLayout.CENTER);
        chatHistoryText.setEditable(false);

        JScrollPane chatHistoryScroll = new JScrollPane(chatHistoryText);
        chatHistoryPanel.add(chatHistoryScroll, BorderLayout.CENTER);

        JLabel chatHistoryTip = new JLabel("Chat history:");
        chatHistoryPanel.add(chatHistoryTip, BorderLayout.NORTH);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SS");


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String inputString = inputField.getText();
                if (!inputString.isEmpty()) {
                    chatHistoryText.setText(chatHistoryText.getText() + ZonedDateTime.now().format(dateTimeFormatter) + " You: " + inputString + '\n');
                    inputField.setText(null);
                }
            }
        });

        setVisible(true);
    }
}
