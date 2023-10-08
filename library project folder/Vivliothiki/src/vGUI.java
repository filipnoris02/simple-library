import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.util.Vector;

public class vGUI extends JFrame {
    public static void main(String[] args) {
        String file = "C:\\PROJECTS\\JAVA PROJECTS\\Vivliothiki\\src\\";
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("                                                                                   Welcome to la Biblioteca");
        frame.setSize(732, 575);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel me = new JLabel("by Filippos Vorgiatzidis");
        me.setBounds(580,520,132,15);
        panel.add(me).setVisible(true);

        JLabel userlb = new JLabel("Username:");
        userlb.setBounds(10,10,70,20);
        JTextField usertx = new JTextField(10);
        usertx.setBounds(75,10,90,20);
        JLabel passlb = new JLabel("Password:");
        passlb.setBounds(10,35,70,20);
        JPasswordField passtx = new JPasswordField(10);
        passtx.setBounds(75,35,90,20);

        //
        JLabel addlb = new JLabel("Address:");
        addlb.setBounds(10,60,70,20);
        JTextField addtx = new JTextField(10);
        addtx.setBounds(75,60,90,20);
        JLabel phonelb = new JLabel("Phone:");
        phonelb.setBounds(10,85,70,20);
        JTextField phonetx = new JTextField(10);
        phonetx.setBounds(75,85,90,20);


        JButton regbt = new JButton("Register");
        regbt.setBounds(10, 60, 82,25);
        JButton logbt = new JButton("Log in");
        logbt.setBounds(95, 60, 70,25);

        JButton backbt = new JButton("Back");
        backbt.setBounds(10, 110, 70,25);
        JButton subbt = new JButton("Submit");
        subbt.setBounds(90, 110, 75,25);


        JLabel currentuser = new JLabel();
        currentuser.setBounds(10,10,200,20);

        JButton logoutbt = new JButton("Log out");
        logoutbt.setBounds(10,35,80,25);

        //

        JTextField searchbox = new JTextField();
        searchbox.setBounds(600,10,90,20);
        panel.add(searchbox);

        JLabel searchlb = new JLabel("Press Enter to search:");
        searchlb.setBounds(470,10,200,20);
        panel.add(searchlb);

        //

        JButton savebt = new JButton("Save Changes");
        savebt.setBounds(10,410,115,25);

        JLabel savetip = new JLabel("(Double click cells to edit)");
        savetip.setBounds(10, 435,200,25);
        panel.add(savetip).setVisible(false);

        //
        JLabel bid = new JLabel("Book ID:");
        bid.setBounds(10, 105,200,25);
        panel.add(bid).setVisible(false);

        JTextField bidtx = new JTextField();
        bidtx.setBounds(10, 130,115,25);
        panel.add(bidtx).setVisible(false);

        JLabel btitle = new JLabel("Title:");
        btitle.setBounds(10, 155,200,25);
        panel.add(btitle).setVisible(false);

        JTextField btitletx = new JTextField();
        btitletx.setBounds(10, 180,115,25);
        panel.add(btitletx).setVisible(false);

        JLabel bauthor = new JLabel("Author:");
        bauthor.setBounds(10, 205,200,25);
        panel.add(bauthor).setVisible(false);

        JTextField bauthortx = new JTextField();
        bauthortx.setBounds(10, 230,115,25);
        panel.add(bauthortx).setVisible(false);

        JLabel bcopies = new JLabel("Copies:");
        bcopies.setBounds(10, 255,200,25);
        panel.add(bcopies).setVisible(false);

        JTextField bcopiestx = new JTextField();
        bcopiestx.setBounds(10, 280,115,25);
        panel.add(bcopiestx).setVisible(false);

        JButton addbook = new JButton("Add book");
        addbook.setBounds(10,305,115,25);
        panel.add(addbook).setVisible(false);

        JButton rembook = new JButton("Remove book");
        rembook.setBounds(10,350,115,25);
        panel.add(rembook).setVisible(false);

        JLabel rembooklb = new JLabel("(Select a book from the table)");
        rembooklb.setBounds(10,375,215,25);
        panel.add(rembooklb).setVisible(false);


        //

        JButton borrowbt = new JButton("Borrow selection");
        borrowbt.setBounds(10,65,150,25);
        panel.add(borrowbt).setVisible(false);

        JButton returnbt = new JButton("Return selection");
        returnbt.setBounds(10,95,150,25);
        panel.add(returnbt).setVisible(false);


        panel.add(userlb);
        panel.add(usertx);
        panel.add(passlb);
        panel.add(passtx);
        panel.add(logbt);
        panel.add(regbt);

        panel.add(addlb).setVisible(false);
        panel.add(addtx).setVisible(false);
        panel.add(phonelb).setVisible(false);
        panel.add(phonetx).setVisible(false);
        panel.add(backbt).setVisible(false);
        panel.add(subbt).setVisible(false);

        panel.add(currentuser).setVisible(false);
        panel.add(logoutbt).setVisible(false);

        panel.add(savebt).setVisible(false);


        DefaultTableModel bookmodel = new DefaultTableModel(new String[]{"Book ID", "Title", "Author", "Copies"}, 0);
        try {
            Scanner scanner = new Scanner(new File(file+"books.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                bookmodel.addRow(parts);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(bookmodel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setBounds(200,40,500,480);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200,40,500,480);
        panel.add(scrollPane);

        DefaultTableModel admodel = new DefaultTableModel(new String[]{"Username", "Password", "Address", "Phone"}, 0);
        try {
            Scanner scanner = new Scanner(new File(file+"USERDATA.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                admodel.addRow(parts);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JTable admintable = new JTable(admodel);
        admintable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        admintable.setBounds(200,20,500,250);
        JScrollPane scrollPane2 = new JScrollPane(admintable);
        scrollPane2.setBounds(200,260,500,250);
        panel.add(scrollPane2).setVisible(false);

        DefaultTableModel usmodel = new DefaultTableModel(new String[]{"Book ID", "Title", "Author"}, 0);
        try {
            Scanner scanner = new Scanner(new File(file+"borrowed.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                usmodel.addRow(parts);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JTable ustable = new JTable(usmodel);
        ustable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        ustable.setBounds(200,20,500,250);
        JScrollPane scrollPane3 = new JScrollPane(ustable);
        scrollPane3.setBounds(200,260,500,250);
        panel.add(scrollPane3).setVisible(false);



            frame.setVisible(true);




        borrowbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Vector<Object> rowData = new Vector<Object>();
                    for (int i = 0; i < bookmodel.getColumnCount(); i++) {
                        rowData.add(bookmodel.getValueAt(selectedRow, i));
                    }
                    usmodel.addRow(rowData);
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file+"borrowed.txt"));
                    for (int row = 0; row < usmodel.getRowCount(); row++) {
                        for (int col = 0; col < usmodel.getColumnCount(); col++) {
                            writer.write(usmodel.getValueAt(row, col) + ",");
                        }
                        writer.write("\n");
                    }
                    writer.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        returnbt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (ustable.getSelectedRow() != -1) {

                    usmodel.removeRow(ustable.getSelectedRow());
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file+"borrowed.txt"));
                    for (int row = 0; row < usmodel.getRowCount(); row++) {
                        for (int col = 0; col < usmodel.getColumnCount(); col++) {
                            writer.write(usmodel.getValueAt(row, col) + ",");
                        }
                        writer.write("\n");
                    }
                    writer.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        rembook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (table.getSelectedRow() != -1) {

                    bookmodel.removeRow(table.getSelectedRow());
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file+"books.txt"));
                    for (int row = 0; row < bookmodel.getRowCount(); row++) {
                        for (int col = 0; col < bookmodel.getColumnCount(); col++) {
                            writer.write(bookmodel.getValueAt(row, col) + ",");
                        }
                        writer.write("\n");
                    }
                    writer.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        logbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                currentuser.setText("You are logged in as: "+usertx.getText());

                String userNameInput = usertx.getText();
                String passwordInput = passtx.getText();

                if (userNameInput.equals("admin") && passwordInput.equals("admin"))
                {
                    JOptionPane.showMessageDialog(null,
                            "You are logged in as an administrator", "Admin log in",
                            JOptionPane.INFORMATION_MESSAGE);

                    logoutbt.setVisible(true);
                    currentuser.setVisible(true);
                    passlb.setVisible(false);
                    userlb.setVisible(false);
                    usertx.setVisible(false);
                    passtx.setVisible(false);
                    logbt.setVisible(false);
                    regbt.setVisible(false);
                    savebt.setVisible(true);
                    savetip.setVisible(true);
                    scrollPane.setBounds(200,40,500,220);
                    scrollPane2.setVisible(true);

                    bid.setVisible(true);
                    bidtx.setVisible(true);
                    btitle.setVisible(true);
                    btitletx.setVisible(true);
                    bauthor.setVisible(true);
                    bauthortx.setVisible(true);
                    bcopies.setVisible(true);
                    bcopiestx.setVisible(true);
                    addbook.setVisible(true);
                    rembook.setVisible(true);
                    rembooklb.setVisible(true);

                }
                else {
                    boolean logcheck = false;

                    try {
                        Scanner in = new Scanner(new File(file+"USERDATA.txt"));
                        while (in.hasNextLine()) {
                            String s = in.nextLine();
                            String[] sArray = s.split(",");

                            if (userNameInput.equals(sArray[0]) && passwordInput.equals(sArray[1])) {
                                JOptionPane.showMessageDialog(null,
                                        "Login Successful", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                logcheck = true;

                                logoutbt.setVisible(true);
                                currentuser.setVisible(true);
                                passlb.setVisible(false);
                                userlb.setVisible(false);
                                usertx.setVisible(false);
                                passtx.setVisible(false);
                                logbt.setVisible(false);
                                regbt.setVisible(false);
                                scrollPane.setBounds(200,40,500,220);
                                scrollPane3.setVisible(true);
                                borrowbt.setVisible(true);
                                returnbt.setVisible(true);
                            }

                        }
                        if (!logcheck) {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid Username / Password. Please register or check credentials.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        in.close();

                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null,
                                "User Database Not Found", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        regbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                backbt.setVisible(true);
                subbt.setVisible(true);
                backbt.setVisible(true);
                phonetx.setVisible(true);
                addtx.setVisible(true);
                phonelb.setVisible(true);
                addlb.setVisible(true);
                logbt.setVisible(false);
                regbt.setVisible(false);
            }
        });
        subbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (usertx.getText().isBlank() || passtx.getText().isBlank() || addtx.getText().isBlank() || phonetx.getText().isBlank()) {
                    JFrame regfailed = new JFrame();
                    JOptionPane.showMessageDialog(regfailed, "Please fill all fields.");
                }
                else {
                    try {
                        FileWriter fw = new FileWriter(file + "USERDATA.txt", true);
                        fw.write(usertx.getText() + "," + passtx.getText() + "," + addtx.getText() + "," + phonetx.getText() + "\n");
                        fw.close();
                        JFrame regcomplete = new JFrame();
                        JOptionPane.showMessageDialog(regcomplete, "Registration completed, you can now log in.");
                        addlb.setVisible(false);
                        addtx.setVisible(false);
                        phonelb.setVisible(false);
                        phonetx.setVisible(false);
                        backbt.setVisible(false);
                        subbt.setVisible(false);
                        logbt.setVisible(true);
                        regbt.setVisible(true);
                        phonetx.setText("");
                        addtx.setText("");

                        admodel.setRowCount(0);
                        try {
                            Scanner scanner = new Scanner(new File(file+"USERDATA.txt"));
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                String[] parts = line.split(",");
                                admodel.addRow(parts);
                            }
                            scanner.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    } catch (Exception e) {
                    }

                }
                admodel.fireTableDataChanged();
            }
        });

        backbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addlb.setVisible(false);
                addtx.setVisible(false);
                phonelb.setVisible(false);
                phonetx.setVisible(false);
                backbt.setVisible(false);
                subbt.setVisible(false);
                logbt.setVisible(true);
                regbt.setVisible(true);
                phonetx.setText("");
                addtx.setText("");
            }
        });
        logoutbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                passlb.setVisible(true);
                userlb.setVisible(true);
                usertx.setVisible(true);
                usertx.setText("");
                passtx.setVisible(true);
                passtx.setText("");
                logbt.setVisible(true);
                regbt.setVisible(true);
                currentuser.setVisible(false);
                savebt.setVisible(false);
                logoutbt.setVisible(false);
                savetip.setVisible(false);
                scrollPane.setBounds(200,40,500,480);
                scrollPane2.setVisible(false);
                scrollPane3.setVisible(false);
                borrowbt.setVisible(false);
                returnbt.setVisible(false);

                bid.setVisible(false);
                bidtx.setVisible(false);
                btitle.setVisible(false);
                btitletx.setVisible(false);
                bauthor.setVisible(false);
                bauthortx.setVisible(false);
                bcopies.setVisible(false);
                bcopiestx.setVisible(false);
                addbook.setVisible(false);
                rembook.setVisible(false);
                rembooklb.setVisible(false);



            }
        });

        savebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file+"books.txt"));
                for (int row = 0; row < bookmodel.getRowCount(); row++) {
                    for (int col = 0; col < bookmodel.getColumnCount(); col++) {
                        writer.write(bookmodel.getValueAt(row, col) + ",");
                    }
                    writer.write("\n");
                }
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        });

        addbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (bidtx.getText().isBlank() || btitletx.getText().isBlank() || bauthortx.getText().isBlank() || bcopiestx.getText().isBlank()) {
                    JFrame bsubfail = new JFrame();
                    JOptionPane.showMessageDialog(bsubfail, "Please fill all fields and try again.");
                }
                else {
                    try {
                        FileWriter fw = new FileWriter(file + "books.txt", true);
                        fw.write(bidtx.getText() + "," + btitletx.getText() + "," + bauthortx.getText() + "," + bcopiestx.getText() + "\n");
                        fw.close();
                        JFrame regcomplete = new JFrame();
                        JOptionPane.showMessageDialog(regcomplete, "Book added successfully.");
                        bidtx.setText("");
                        btitletx.setText("");
                        bauthortx.setText("");
                        bcopiestx.setText("");

                        bookmodel.setRowCount(0);
                        try {
                            Scanner scanner = new Scanner(new File(file+"books.txt"));
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                String[] parts = line.split(",");
                                bookmodel.addRow(parts);
                            }
                            scanner.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    } catch (Exception e) {
                    }

                }
                bookmodel.fireTableDataChanged();
            }
        });

        searchbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchbox.getText();
                TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
                if (searchText.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }
        });
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(bookmodel);
        table.setRowSorter(sorter);
    }

}