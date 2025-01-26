import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantApp {
    int b;
    static int id = 0;
    double PriceOrder;
    static int totalMeals=0;
    List<Meal> rmeal;
    static List<Customer> ListCoustmer=new ArrayList<>();
    private Restaurant restaurant;
    static ImageIcon originalImageIcon;
    static JLabel labelIcon;
    static JLabel PriceMeals=new JLabel();
    static double DailyReturns;
    String status;
    DefaultListModel tableModel = new DefaultListModel();
    JList listMenu = new JList(tableModel);
    JLabel TotalPrice=new JLabel();
    JLabel priceDelivery = new JLabel(" Price Delivery is 15$");
    JLabel TotalPriceOnSite = new JLabel();
    Font newFontName = new Font("Arial", Font.BOLD, 35);

    public RestaurantApp() {
        restaurant = new Restaurant();
        restaurant.addMeal((new Meal("Pizza Chocola", 50, "Chocola")));
        restaurant.addMeal(new Meal("Margreta", 60, "Cheese,Oriuano"));
        restaurant.addMeal(new Meal("HotDog", 70, "Cheese,hotdog,Cheeder Cheese"));
        restaurant.addMeal(new Meal("Peporony", 90, "Mozerlla,peporony"));
        restaurant.addMeal(new Meal("Checken", 80, "Mozeralla,checken"));
        restaurant.addMeal(new Meal("Four season", 65, "Tomato,olives,Cheese,"));
        restaurant.addMeal(new Meal("Corn pizza", 87, "corn,Mozeralla"));
        restaurant.addMeal(new Meal("mushroom Fresh", 90, "mushroom,cheese"));
        restaurant.addMeal(new Meal("sausage", 50, "sausage,cheese"));
        restaurant.addMeal(new Meal("salami", 70, "salami,sous petzaro,cheese"));

        createFrame();

    }

    public void createFrame() {

        JFrame restaurant = new JFrame("Restaurant Management System");
        restaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        restaurant.setBounds(400, 175, 1700, 1000);
        restaurant.setLayout(null);


        Font newfont = new Font("Arial", Font.BOLD, 50);
        Font newfont1 = new Font("serif", Font.BOLD, 33);
        Font newFont2 = new Font("Arial", Font.BOLD, 25);

        originalImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza.jpg");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(restaurant.getWidth(), restaurant.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        labelIcon = new JLabel(scaledImageIcon);
        labelIcon.setBounds(0, 0, restaurant.getWidth(), restaurant.getHeight());

        JLabel labelWelcome = new JLabel("Welcome To OhioPizza");
        labelWelcome.setFont(newfont);
        labelWelcome.setForeground(Color.WHITE);

        JLabel labelQuastion = new JLabel("Are You Employee Or Customer?");
        labelQuastion.setFont(newfont1);
        labelQuastion.setForeground(Color.WHITE);

        JRadioButton employee = new JRadioButton("Employee");
        JRadioButton customer = new JRadioButton("Customer");
        employee.setFont(newFont2);
        customer.setFont(newFont2);
        employee.setForeground(Color.WHITE);
        customer.setForeground(Color.WHITE);
        ButtonGroup group = new ButtonGroup();

        employee.setOpaque(false);
        customer.setOpaque(false);

        group.add(employee);
        group.add(customer);

        labelWelcome.setBounds(500, 175, 600, 41);
        labelQuastion.setBounds(300, 350, 500, 37);
        employee.setBounds(250, 450, 200, 30);
        customer.setBounds(250, 550, 200, 30);

        labelIcon.add(labelWelcome);
        labelIcon.add(labelQuastion);
        labelIcon.add(employee);
        labelIcon.add(customer);
        restaurant.add(labelIcon);

        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame employeeFrame = new JFrame("Employee Frame");
                employeeFrame.setBounds(400, 175, 1700, 1000);
                employeeFrame.setLayout(null);

                ImageIcon EmployeeImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza.jpg"); // استبدل بـ مسار الصورة
                Image EmployeeImage = EmployeeImageIcon.getImage();
                Image scaledemployeeImage = EmployeeImage.getScaledInstance(employeeFrame.getWidth(), employeeFrame.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledEmployeeImageIcon = new ImageIcon(scaledemployeeImage);

                labelIcon=new JLabel(scaledEmployeeImageIcon);
                labelIcon.setBounds(0,0,employeeFrame.getWidth(),employeeFrame.getHeight());

                JPanel panelEmployee = new JPanel(null);
                panelEmployee.setBorder(BorderFactory.createTitledBorder("Add user"));
                panelEmployee.setBounds(75, 40, 1500, 850);
                panelEmployee.setOpaque(false);

                JLabel labelName = new JLabel("Enter Your Name :");
                JLabel PasswordLabel=new JLabel("Password :");

                JButton buttonOk = new JButton("Login");
                JButton buttonBack=new JButton("Back");
                JTextField nameField = new JTextField();
                JPasswordField passwordField=new JPasswordField();

                labelName.setFont(newFontName);
                PasswordLabel.setFont(newFontName);
                buttonOk.setFont(newFontName);
                buttonBack.setFont(newFontName);

                labelName.setBounds(250, 250, 350, 36);
                nameField.setBounds(680, 260, 172, 22);
                PasswordLabel.setBounds(250,400,250,36);
                passwordField.setBounds(680,400,172,22);
                buttonOk.setBounds(750, 650, 150, 44);
                buttonBack.setBounds(550,650,150,44);

                labelName.setForeground(Color.WHITE);
                PasswordLabel.setForeground(Color.WHITE);
                buttonOk.setForeground(Color.black);
                buttonBack.setForeground(Color.black);

                panelEmployee.add(labelName);
                panelEmployee.add(nameField);
                panelEmployee.add(passwordField);
                panelEmployee.add(PasswordLabel);
                panelEmployee.add(buttonOk);
                panelEmployee.add(buttonBack);


                labelIcon.add(panelEmployee);
                employeeFrame.add(labelIcon);

                buttonBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        employeeFrame.dispose();
                    }
                });
                buttonOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String name=nameField.getText();
                        String orginal="pizza";
                        String p= new String(passwordField.getPassword());
                        try {
                            if ((Employee.compare(name,"employeeName.txt"))&&(p.equals(orginal)))
                                Employee.Report();
                            else {
                                JOptionPane.showMessageDialog(null, "Sorry,You are not allowed to enter",
                                        "Error Message", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                employeeFrame.setVisible(true);
            }
        });
        customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame customerFrame = new JFrame("Customer Frame");
                customerFrame.setBounds(400, 175, 1700, 1000);
                customerFrame.setLayout(null);


                originalImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza.jpg"); // استبدل بـ مسار الصورة
                Image customerImage = originalImageIcon.getImage();
                Image scaledCustomerImage = customerImage.getScaledInstance(customerFrame.getWidth(), customerFrame.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledCustomerImage);

                labelIcon=new JLabel(scaledImageIcon);
                labelIcon.setBounds(0,0,customerFrame.getWidth(),customerFrame.getHeight());

                JPanel panelCustomer = new JPanel(null);
                panelCustomer.setBorder(BorderFactory.createTitledBorder("Add user"));
                panelCustomer.setBounds(75, 40, 1500, 850);
                panelCustomer.setOpaque(false);



                JLabel labelName = new JLabel("Enter Your Name :");
                JTextField nameField = new JTextField();
                JButton buttonOk = new JButton("Login");
                JButton buttonBack=new JButton("Back");


                labelName.setFont(newFontName);
                buttonOk.setFont(newFontName);
                buttonBack.setFont(newFontName);

                labelName.setForeground(Color.WHITE);
                buttonOk.setForeground(Color.black);
                buttonBack.setForeground(Color.black);

                labelName.setBounds(250, 350, 350, 36);
                nameField.setBounds(680, 360, 172, 22);
                buttonOk.setBounds(750, 650, 150, 44);
                buttonBack.setBounds(550,650,150,44);

                panelCustomer.add(labelName);
                panelCustomer.add(nameField);
                panelCustomer.add(buttonOk);
                panelCustomer.add(buttonBack);
                labelIcon.add(panelCustomer);
                customerFrame.add(labelIcon);

                buttonBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        customerFrame.dispose();
                    }
                });
                for (Meal meal : Restaurant.menu) {
                    tableModel.addElement(meal);
                }
                buttonOk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        listMenu.clearSelection();
                        if(nameField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(customerFrame,"Please Enter your name","Error Message",JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            Customer customerOrder = new Customer(nameField.getText());
                            BufferedWriter writer=null;
                            FileWriter f=null;
                            try{
                                f=new FileWriter("Save Customer Name.txt", true);
                                writer = new BufferedWriter(f) ;
                                writer.write(customerOrder.name);
                                writer.newLine();
                                writer.flush();
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(customerFrame, "Failed save name Customer", "Error Message", JOptionPane.ERROR_MESSAGE);
                            }
                            JFrame selected = new JFrame("Menu");
                            selected.setBounds(400,125,1800,1200);
                            selected.setLayout(null);

                            JPanel menuPanel = new JPanel(null);
                            menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
                            menuPanel.setBounds(50, 25, 1350, 525);
                            menuPanel.setOpaque(false);

                            ImageIcon MenuImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza3.jpg"); // استبدل بـ مسار الصورة
                            Image MenuImage = MenuImageIcon.getImage();
                            Image scaledMenuImage = MenuImage.getScaledInstance(selected.getWidth(), selected.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon MenuImageIcons = new ImageIcon(scaledMenuImage);

                            labelIcon = new JLabel(MenuImageIcons);
                            labelIcon.setBounds(0, 0, selected.getWidth(), selected.getHeight());
                            labelIcon.add(menuPanel);


                            Font newFont3 = new Font("serif", Font.BOLD, 25);
                            Font selectLabelNameFont=new Font("serif",Font.BOLD,30);
                            listMenu.setFont(newFont3);
                            listMenu.setForeground(Color.black);
                            listMenu.setBackground(Color.gray);

                            JScrollPane scrollPane = new JScrollPane(listMenu);

                            scrollPane.setBounds(50, 100, 1000, 300);

                            JLabel label = new JLabel("To select Multiple Meal press Ctrl");
                            label.setBounds(50, 25, 644, 78);
                            label.setFont(selectLabelNameFont);
                            label.setForeground(Color.WHITE);

                            menuPanel.add(label);
                            menuPanel.add(scrollPane);
                            labelIcon.add(menuPanel);
                            selected.add(labelIcon);

                            listMenu.addListSelectionListener(new ListSelectionListener() {
                                @Override
                                public void valueChanged(ListSelectionEvent e) {
                                    rmeal = listMenu.getSelectedValuesList();
                                }
                            });

                            JRadioButton delivery = new JRadioButton("Delivery");
                            JRadioButton onSite = new JRadioButton("On Restaurant");

                            ButtonGroup buttonGroup = new ButtonGroup();
                            buttonGroup.add(delivery);
                            buttonGroup.add(onSite);

                            Font newFont4 = new Font("serif", Font.BOLD, 27);
                            delivery.setBounds(50, 600, 201, 78);
                            onSite.setBounds(50, 725, 250, 78);

                            delivery.setFont(newFont4);
                            onSite.setFont(newFont4);

                            delivery.setOpaque(false);
                            onSite.setOpaque(false);

                            delivery.setForeground(Color.WHITE);
                            onSite.setForeground(Color.WHITE);

                            labelIcon.add(delivery);
                            labelIcon.add(onSite);
                            selected.add(labelIcon);
                            Order objOrder = new Order();
                            Font deliveryFont = new Font("serif", Font.BOLD, 25);
                            delivery.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    if (rmeal == null) {
                                        JOptionPane.showMessageDialog(null,
                                                "Error,You did not choose any meals yet ",
                                                "Error Message", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        b = 1;
                                        PriceMeals.setBounds(300, 580, 1000, 100);
                                        priceDelivery.setBounds(550, 530, 1500, 200);
                                        TotalPrice.setBounds(800, 480, 2000, 300);

                                        PriceMeals.setFont(deliveryFont);
                                        priceDelivery.setFont(deliveryFont);
                                        TotalPrice.setFont(deliveryFont);

                                        PriceMeals.setForeground(Color.WHITE);
                                        priceDelivery.setForeground(Color.WHITE);
                                        TotalPrice.setForeground(Color.white);

                                        labelIcon.add(PriceMeals);
                                        labelIcon.add(priceDelivery);
                                        labelIcon.add(TotalPrice);

                                        PriceMeals.setVisible(true);
                                        priceDelivery.setVisible(true);
                                        TotalPrice.setVisible(true);


                                        PriceMeals.setText("price your meals  " + objOrder.calculateTotal(rmeal));
                                        PriceOrder = objOrder.calculateTotal(rmeal) + 15;
                                        TotalPrice.setText("Total Price is :" + PriceOrder);

                                        selected.add(labelIcon);
                                    }
                                }
                            });

                            onSite.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    if (rmeal == null) {
                                        JOptionPane.showMessageDialog(null,
                                                "Error,You did not choose any meals yet ",
                                                "Error Message", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        b = 0;

                                        TotalPriceOnSite.setForeground(Color.WHITE);
                                        TotalPriceOnSite.setFont(deliveryFont);
                                        PriceOrder = objOrder.calculateTotal(rmeal);
                                        labelIcon.add(TotalPriceOnSite);
                                        TotalPriceOnSite.setBounds(300, 715, 1000, 100);
                                        TotalPriceOnSite.setText("Total Price is :" + PriceOrder);
                                        selected.add(labelIcon);
                                    }
                                }
                            });
                            JButton AddOrder = new JButton("Add Order");
                            JButton CancelOrder = new JButton("Cancel Order");
                            JButton buttonBack = new JButton("Back");

                            AddOrder.setBounds(800, 1000, 275, 65);
                            CancelOrder.setBounds(400, 1000, 275, 65);
                            buttonBack.setBounds(1500, 1050, 200, 65);

                            AddOrder.setFont(newFontName);
                            CancelOrder.setFont(newFontName);
                            buttonBack.setFont(newFontName);

                            AddOrder.setForeground(Color.black);
                            AddOrder.setBackground(Color.gray);
                            CancelOrder.setForeground(Color.black);
                            CancelOrder.setBackground(Color.gray);
                            buttonBack.setForeground(Color.black);
                            buttonBack.setBackground(Color.gray);

                            labelIcon.add(AddOrder);
                            labelIcon.add(CancelOrder);
                            labelIcon.add(buttonBack);
                            selected.add(labelIcon);
                            buttonBack.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    selected.dispose();
                                }
                            });
                            AddOrder.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    CancelOrder.setEnabled(false);
                                    if (rmeal == null) {
                                        JOptionPane.showMessageDialog(null,
                                                "Error,You did not choose any meals yet ",
                                                "Error Message", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        if (delivery.isSelected() || onSite.isSelected()) {
                                            totalMeals += rmeal.size();
                                            id++;
                                            JOptionPane.showMessageDialog(null, "Your Order is Pending ", "Your Order", JOptionPane.INFORMATION_MESSAGE);
                                            try {
                                                Thread.sleep(3000);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                            if (b == 0) {
                                                status = "completed";
                                                JOptionPane.showMessageDialog(null, "Your Order is Completed", "Complete", JOptionPane.INFORMATION_MESSAGE);
                                            } else if (b == 1) {
                                                status = "Delivered";
                                                JOptionPane.showMessageDialog(null, "Your Order Under delivery and it will arrive within 15m",
                                                        "Delivering", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            Customer customernew = new Customer(nameField.getText(), id, rmeal, PriceOrder, status);
                                            ListCoustmer.add(customernew);
                                            DailyReturns += PriceOrder;
                                            try {
                                                Customer.SaveOrder(customernew);
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "Error,You did not choose the Type of Order ",
                                                    "Error Message", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            });
                            CancelOrder.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    if (rmeal == null) {
                                        JOptionPane.showMessageDialog(null,
                                                "Error,You did not choose any meals yet ",
                                                "Error Message", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        status = "Canceled";
                                        Customer customernew = new Customer(nameField.getText(), id, rmeal, PriceOrder, status);
                                        ListCoustmer.add(customernew);
                                        JOptionPane.showMessageDialog(null, "your order has been canceled",
                                                "Information Message", JOptionPane.INFORMATION_MESSAGE);
                                        listMenu.clearSelection();
                                        TotalPrice.setVisible(false);
                                        priceDelivery.setVisible(false);
                                        PriceMeals.setVisible(false);
                                        TotalPriceOnSite.setVisible(false);
                                    }
                                }
                            });
                            selected.setVisible(true);
                        }
                    }
                });
                customerFrame.setVisible(true);
            }
        });
        restaurant.setVisible(true);
    }
}
