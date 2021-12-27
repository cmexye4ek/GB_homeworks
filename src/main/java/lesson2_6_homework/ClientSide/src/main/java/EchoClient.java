import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient extends JFrame {
    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8189;

    private JTextField msgInputField;
    private JTextArea chatArea;

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public EchoClient() {
        prepareGUI();
        try {
            openConnection();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server connection error");
            msgInputField.setEditable(false);
            msgInputField.setText("You cant send message, connection is lost");

        }

    }

    public void openConnection() throws Exception {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                chatArea.append("Connection established ");
                chatArea.append("\n");
                while (true) {
                    String strFromServer = dis.readUTF();
                    if (strFromServer.contains("Server shutdown")) {
                        chatArea.append("\n" + strFromServer + "\n" + " You disconnected from server ");
                        msgInputField.setEditable(false);
                        msgInputField.setText("You cant send message, connection is lost");
                        break;
                    }
                    chatArea.append("Server send you: " + strFromServer);
                    chatArea.append("\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

    public void closeConnection() {
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                dos.writeUTF(msgInputField.getText());
                chatArea.append("You send: " + msgInputField.getText());
                chatArea.append("\n");
                msgInputField.setText("");
                msgInputField.grabFocus();

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Message send error, server connection is lost");
                msgInputField.setEditable(false);
                msgInputField.setText("You cant send message, connection is lost");

            }
        }
    }

    public void prepareGUI() {


        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Send");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                if (!(dos == null) && !(dis == null)) {
                    try {

                        dos.writeUTF("/finish");
                        closeConnection();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }

        });

        setVisible(true);


    }
}

