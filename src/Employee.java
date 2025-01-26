import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class Employee {
    static JFrame ReportFrame = new JFrame("Management");
    static JButton editMenu = new JButton("To Edit Menu");
    static JButton ToKnowTheNumberOrders = new JButton("To Know The Number Orders");
    static JButton ToKnowTheMostRequestedMeal = new JButton("To Know The Most Requested Meal");
    static JButton ToKnowThePermanentCustomer = new JButton("To Know The Permanent Customer");
    static JButton ToCalculateDailyReturns = new JButton("To Calculate Daily Returns");
    static JButton ToShowOrder = new JButton("To View Current Order");
    static Font ArialFont = new Font("Arial", Font.BOLD, 25);
    static JLabel labelTotalMeals = new JLabel("Total meals is :");
    static  JLabel labelRequestMeal = new JLabel();
    static JLabel labelMostFrequentName = new JLabel();
    static JLabel labelPriceOrder  =new JLabel();
    static JButton buttonBack=new JButton("Back");

    public static boolean compare(String name, String filePath) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = "";
            while (((line = br.readLine()) != null)) {
                if (line.trim().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
        return false;
    }

    public static void Report() {
        ReportFrame.setBounds(325, 100, 1900, 1200);
        ReportFrame.setLayout(null);
        editMenu.setBounds(50, 50, 500, 55);
        ToKnowTheNumberOrders.setBounds(50, 250, 500, 55);
        ToCalculateDailyReturns.setBounds(50, 450, 500, 55);
        ToKnowThePermanentCustomer.setBounds(50, 650, 500, 55);
        ToKnowTheMostRequestedMeal.setBounds(50, 850, 500, 55);
        ToShowOrder.setBounds(50,1050,500,55);
        buttonBack.setBounds(1600,1050,200,55);

        ImageIcon ReportImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza2.jpg");
        Image ReportImage = ReportImageIcon.getImage();
        Image scaledReportImage = ReportImage.getScaledInstance(ReportFrame.getWidth(),ReportFrame.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ReportscaledImageIcon = new ImageIcon(scaledReportImage);

        JLabel labelIcon=new JLabel(ReportscaledImageIcon);
        labelIcon.setBounds(0,0,ReportFrame.getWidth(),ReportFrame.getHeight());


        Font fontButton = new Font("Arial", Font.BOLD, 25);
        editMenu.setFont(fontButton);
        ToKnowTheNumberOrders.setFont(fontButton);
        ToKnowTheMostRequestedMeal.setFont(fontButton);
        ToKnowThePermanentCustomer.setFont(fontButton);
        ToCalculateDailyReturns.setFont(fontButton);
        ToShowOrder.setFont(fontButton);
        buttonBack.setFont(fontButton);


        editMenu.setForeground(Color.black);
        ToKnowTheNumberOrders.setForeground(Color.black);
        ToKnowTheMostRequestedMeal.setForeground(Color.black);
        ToKnowThePermanentCustomer.setForeground(Color.black);
        ToCalculateDailyReturns.setForeground(Color.black);
        ToShowOrder.setForeground(Color.black);
        buttonBack.setForeground(Color.black);

        editMenu.setBackground(Color.gray);
        ToKnowTheNumberOrders.setBackground(Color.gray);
        ToKnowTheMostRequestedMeal.setBackground(Color.gray);
        ToKnowThePermanentCustomer.setBackground(Color.gray);
        ToKnowThePermanentCustomer.setBackground(Color.gray);
        ToCalculateDailyReturns.setBackground(Color.gray);
        ToShowOrder.setBackground(Color.gray);
        buttonBack.setBackground(Color.gray);

        labelIcon.add(editMenu);
        labelIcon.add(ToKnowTheNumberOrders);
        labelIcon.add(ToKnowTheMostRequestedMeal);
        labelIcon.add(ToKnowThePermanentCustomer);
        labelIcon.add(ToCalculateDailyReturns);
        labelIcon.add(ToShowOrder);
        labelIcon.add(buttonBack);

        ReportFrame.add(labelIcon);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ReportFrame.dispose();
                labelTotalMeals.setVisible(false);
                labelRequestMeal.setVisible(false);
                labelMostFrequentName.setVisible(false);
                labelPriceOrder.setVisible(false);
            }
        });
        editMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Meal.EditMenu();
            }
        });
        ToKnowTheNumberOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelTotalMeals = new JLabel();
                labelTotalMeals.setBounds(600, 250, 250, 39);

                labelTotalMeals.setFont(ArialFont);
                labelTotalMeals.setForeground(Color.WHITE);

                labelIcon.add(labelTotalMeals);

                labelTotalMeals.setText("Total Orders is  : " +RestaurantApp.id);
            }
        });

        ToKnowTheMostRequestedMeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Customer customer = new Customer();
                customer = null;
                Meal RequestMeal = null;
                ObjectInputStream ois = null;
                try (FileInputStream fis = new FileInputStream("Restaurant's Order.ser")) {
                    ois = new ObjectInputStream(fis);
                    customer = (Customer) ois.readObject();
                    List<Meal> meals = customer.order.meals;
                    RequestMeal = Restaurant.hashMap(meals);
                } catch (IOException | ClassNotFoundException a) {
                    //a.printStackTrace();
                    JOptionPane.showMessageDialog(null, "You Do Not have Meal yet ", "Warning Message", JOptionPane.WARNING_MESSAGE);

                }
                labelRequestMeal.setBounds(50, 650, 1100, 600);
                labelRequestMeal.setForeground(Color.WHITE);
                labelRequestMeal.setFont(ArialFont);
                labelIcon.add(labelRequestMeal);
                labelRequestMeal.setText("Requested Meal:" + RequestMeal);
            }

        });
        ToKnowThePermanentCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Restaurant.HashSet()==true) {
                    String mostFrequentName = "";
                    try (BufferedReader br = new BufferedReader(new FileReader("Save Customer Name.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] names = (line.split("\\s+"));
                            mostFrequentName = Restaurant.hashMap(names);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    labelMostFrequentName.setBounds(550, 650, 400, 60);
                    labelMostFrequentName.setForeground(Color.WHITE);
                    labelMostFrequentName.setFont(ArialFont);
                    labelIcon.add(labelMostFrequentName);
                    labelMostFrequentName.setText("The Permanent Customer : " + mostFrequentName);
                    ReportFrame.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "You Do Not have permanent customer", "Warning Message", JOptionPane.WARNING_MESSAGE);
            }
        });
        ToCalculateDailyReturns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelPriceOrder.setBounds(600,450,400,60);
                labelPriceOrder.setForeground(Color.white);
                labelPriceOrder.setFont(ArialFont);
                labelIcon.add(labelPriceOrder);
                labelPriceOrder.setText("Daily Returns: "+RestaurantApp.DailyReturns);
            }
        });
        ToShowOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame show=new JFrame("View Current Order");
                show.setBounds(325, 100, 1900, 1200);

                ImageIcon ReportImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza2.jpg");
                Image ReportImage = ReportImageIcon.getImage();
                Image scaledReportImage = ReportImage.getScaledInstance(show.getWidth(),show.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon ReportscaledImageIcon = new ImageIcon(scaledReportImage);

                JLabel labelIcon=new JLabel(ReportscaledImageIcon);
                labelIcon.setBounds(0,0,show.getWidth(),show.getHeight());


                JTextArea AreaShow=new JTextArea();
                JScrollPane AreaScroll=new JScrollPane(AreaShow);
                JButton buttonBack=new JButton("Back");

                AreaShow.setLineWrap(true);
                AreaShow.setWrapStyleWord(true);
                AreaShow.setEditable(false);

                AreaShow.setBackground(Color.gray);
                AreaShow.setForeground(Color.black);

                buttonBack.setBackground(Color.gray);
                buttonBack.setForeground(Color.black);

                AreaScroll.setBounds(225,200,1300,600);
                buttonBack.setBounds(1600,1050,200,50);



                AreaShow.setFont(AreaShow.getFont().deriveFont(25f));
                buttonBack.setFont(new Font("Arial",Font.BOLD,25));

                labelIcon.add(AreaScroll);
                labelIcon.add(buttonBack);
                AreaShow.setText(RestaurantApp.ListCoustmer.toString());
                buttonBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        show.dispose();
                    }
                });
                show.add(labelIcon);
                show.setVisible(true);
            }
        });
        ReportFrame.add(labelIcon);
        ReportFrame.setVisible(true);
    }
}












 /* ReportFrame.revalidate();
        ReportFrame.repaint();*/