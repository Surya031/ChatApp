//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;


import static javax.swing.JOptionPane.*;

public abstract class Main implements Runnable  {

    public static void main(String[] args) {
            //code for login and chat frame
            JFrame frame1 = new JFrame("CHAT APP");
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setSize(500, 700);
            ImageIcon i1 = new ImageIcon("login.png");
            JLabel label1 = new JLabel(i1);
            label1.setBounds(200, 150, 100, 100);
            JLabel label2 = new JLabel("Username");
            label2.setBounds(150, 270, 100, 40);
            JLabel label3 = new JLabel("Password");
            label3.setBounds(150, 310, 100, 40);
            final JTextField textField1 = new JTextField();
            textField1.setBounds(260, 270, 150, 25);
            final JPasswordField textField2 = new JPasswordField();
            textField2.setBounds(260, 315, 150, 25);
            JButton Login = new JButton("Login");
            Login.setBounds(150, 400, 100, 50);
            JButton button2 = new JButton("Signup");
            button2.setBounds(260, 400, 100, 50);
            JButton button3 = new JButton("Forget Password");
            button3.setBounds(155, 470, 200, 50);
            frame1.add(label1);
            frame1.add(label2);
            frame1.add(label3);
            frame1.add(textField1);
            frame1.add(textField2);
            frame1.add(Login);
            frame1.add(button2);
            frame1.add(button3);
            frame1.setLayout((LayoutManager) null);
            frame1.setVisible(true);
            //end for login frame

            //code for chats frame
            JFrame frame2 = new JFrame("Chats");
            frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame2.setSize(500, 700);
            frame2.setLayout(null);
            JButton button21 = new JButton("Chats");
            button21.setBackground(Color.blue);
            button21.setBounds(0, 0, 166, 50);
            JButton button22 = new JButton("Contacts");
            button22.setBounds(166, 0, 166, 50);
            button22.setBackground(Color.blue);
            JButton button23 = new JButton("Help");
            button23.setBounds(332, 0, 168, 50);
            button23.setBackground(Color.blue);
            JTextArea newMessages = new JTextArea();
            newMessages.setBounds(0, 50, 500, 580);
            JTextField textField21 = new JTextField();
            textField21.setBounds(0, 620, 400, 50);
            JButton button24 = new JButton("Send");
            button24.setBounds(400, 620, 100, 50);
            frame2.add(button21);
            frame2.add(button22);
            frame2.add(button23);
            frame2.add(newMessages);
            frame2.add(textField21);
            frame2.add(button24);
            //end of chat frame

            //Code for Singup frame
            JFrame frame3 = new JFrame("Singup");
            frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame3.setSize(500, 700);
            frame3.setLayout(null);
            final JTextField nameTextField = new JTextField();
            nameTextField.setBounds(250, 50, 150, 30);
            final JTextField ageTextField = new JTextField();
            ageTextField.setBounds(250, 100, 50, 30);
            final JTextField usernameTextField = new JTextField();
            usernameTextField.setBounds(250, 150, 150, 30);
            final JTextField phoneTextField = new JTextField();
            phoneTextField.setBounds(250, 200, 150, 30);
            JTextField emailTextField =new JTextField();
            emailTextField.setBounds(250,250,150,30);
            JPasswordField newpasswordTextField=new JPasswordField();
            newpasswordTextField.setBounds(250,300,150,30);
            String[] spinnerstr1 = new String[2];
            spinnerstr1[0] = "What's your Neighbour pet name";
            spinnerstr1[1] = "What's your favourite book's Name";
            SpinnerModel value1 = new SpinnerListModel(spinnerstr1);
            JSpinner spinner1 = new JSpinner(value1);
            spinner1.setEditor(new JSpinner.DefaultEditor(spinner1));
            spinner1.setBounds(20,400,300,30);
            JTextField spinneranswer=new JTextField();
            spinneranswer.setBounds(20,450,300,30);
            JLabel name = new JLabel("Name:");
            name.setBounds(20, 50, 100, 30);
            JLabel age = new JLabel("Age:");
            age.setBounds(20, 100, 100, 30);
            JLabel username = new JLabel("Username(Unique):");
            username.setBounds(20, 150, 200, 30);
            JLabel PhoneNo = new JLabel("Mobile Number :");
            PhoneNo.setBounds(20, 200, 200, 30);
            JLabel email=new JLabel("Email");
            email.setBounds(20,250,100,30);
            JLabel newPasswordLabel=new JLabel("New Password");
            newPasswordLabel.setBounds(20,300,100,30);
            JLabel spinnerMessage=new JLabel("Security Question(for recovering password)");
            spinnerMessage.setBounds(20,350,300,30);
            JButton submit = new JButton("Submit");
            submit.setBounds(200, 500, 100, 30);
            frame3.add(name);
            frame3.add(nameTextField);
            frame3.add(age);
            frame3.add(ageTextField);
            frame3.add(PhoneNo);
            frame3.add(phoneTextField);
            frame3.add(email);
            frame3.add(emailTextField);
            frame3.add(usernameTextField);
            frame3.add(username);
            frame3.add(spinner1);
            frame3.add(spinneranswer);
            frame3.add(spinnerMessage);
            frame3.add(submit);
            frame3.add(newpasswordTextField);
            frame3.add(newPasswordLabel);
            //Closing of singnup frame

        //connecting to databse
        Connection con;
        con = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/Students?user=root&password=password");
            /*Statement statement=con.createStatement();
            String query="Alter table studentsInfo add mobile "+"int(10)";
            System.out.println("Connected to mysql");
            statement.executeUpdate(query);
            System.out.println("query done!");*/


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //close of database connection

        //socket Connection
        Socket socket=null;
        PrintWriter out=null;
        Scanner in=null;
        try {
            socket=new Socket("localhost", 59898);


        }
        catch(Exception e){
            newMessages.setText("No person is ONLINE.........");
        }

        //end socket connection

            //multithreading
        Socket finalSocket1 = socket;
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        messageFromServer(newMessages, finalSocket1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();
        //multithreading




        //send button implementatio
        Socket finalSocket = socket;

        button24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String str=textField21.getText();
                    newMessages.append("You:"+str+"\n");
                    messageToServer(textField21, finalSocket);


                }
                catch (Exception e){
                    newMessages.setText("Something went wrong");
                }
            }
        });
            //send button implementation close

            //code for Forget Password frame
            JFrame frame4 = new JFrame("RECOVER PASSWORD");
            frame4.setSize(500, 700);
            frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame4.setLayout(null);
            JTextField textField41 = new JTextField("Enter Your Answer");
            String[] spinnerstr = new String[2];
            spinnerstr[0] = "What's your Neighbour pet name";
            spinnerstr[1] = "What's your favourite book's Name";
            SpinnerModel value = new SpinnerListModel(spinnerstr);
            JSpinner spinner = new JSpinner(value);
            spinner.setEditor(new JSpinner.DefaultEditor(spinner));
            JLabel label41 = new JLabel("Choose the question to answer for:");
            JButton button41 = new JButton("Submit");
            button41.setBounds(200,150,100,50);
            label41.setBounds(50, 30, 400, 30);
            spinner.setBounds(50, 80, 400, 30);
            textField41.setBounds(50, 120, 400, 30);
            frame4.add(label41);
            frame4.add(spinner);
            frame4.add(textField41);
            frame4.add(button41);
            frame4.setLayout(null);
            //RECOVER PASSWORD frame end

            //Create new Password Frame
            JFrame frame5=new JFrame("Create New Password");
            frame5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame5.setSize(500,700);
            JLabel label51=new JLabel("New password");
            label51.setBounds(20,50,100,50);
            JTextField textField51=new JTextField();
            textField51.setBounds(20,120,350,50);
            JLabel label52=new JLabel("Retype new password");
            label52.setBounds(20,190,200,50);
            JTextField textField52=new JTextField();
            textField52.setBounds(20,260,350,50);
            JButton button51=new JButton("Submit");
            button51.setBounds(200,400,100,50);
            frame5.add(label51);
            frame5.add(textField51);
            frame5.add(label52);
            frame5.add(textField52);
            frame5.add(button51);
            frame5.setLayout(null);
            //end of create new Password frame

        Connection finalCon1 = con;
        Login.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        String text1 = textField1.getText();
                        String text2 = String.valueOf(textField2.getPassword());
                        Statement st = finalCon1.createStatement();
                        String query="Select Password from PersonDetails Where Username=" + "'"
                                + text1 + "'";
                        ResultSet resultSet = st.executeQuery(query);
                        String result=null;
                        while (resultSet.next()) {
                            result=resultSet.getString("Password");;
                        }
                        System.out.println(result);
                        if (text2.equals(result)) {
                            frame1.setVisible(false);
                            frame2.setVisible(true);

                        }
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(frame1, e.getMessage());
                    }
                }
            });

            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    frame1.setVisible(false);
                    frame3.setVisible(true);
                }
            });
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    frame1.setVisible(false);
                    frame4.setVisible(true);
                }
            });

            //working of submit button in recover password frame
            button41.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    frame4.setVisible(false);
                    frame5.setVisible(true);

                }
            });
            //close of submit button

        //working of submit button in sigup frame
        Connection finalCon = con;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Statement statement= finalCon.createStatement();
                    String query="INSERT INTO PersonDetails " +"values("+
                            "'"+nameTextField.getText().toString()+"'"+","+
                            "'"+ageTextField.getText().toString()+"'"+","+
                            "'"+usernameTextField.getText().toString()+"'"+","+
                            "'"+phoneTextField.getText().toString()+"'"+","+
                            "'"+emailTextField.getText().toString()+"'"+","+
                            "'"+newpasswordTextField.getText().toString()+"'"+","+
                            "'"+spinneranswer.getText().toString()+"'"+")";
                            System.out.println(query);
                            statement.executeUpdate(query);
                            finalCon.close();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(frame3,e.getMessage());
                }
                finally {
                    //JOptionPane.showMessageDialog(frame3, "Signnup sucessful \n Retuning to login page...");
                    frame3.setVisible(false);
                    frame1.setVisible(true);
                }
            }
        });
        //close working of submit button
    }

    private static void messageFromServer(JTextArea newMessages, Socket socket) throws IOException {
        Scanner in;
        in=new Scanner(socket.getInputStream());
        String str1 = in.nextLine();
        newMessages.append("Person: " + str1 + "\n");
    }

    private static void messageToServer(JTextField textField21, Socket socket) throws IOException {
        PrintWriter out;
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(textField21.getText());
        textField21.setText("");
    }

}
