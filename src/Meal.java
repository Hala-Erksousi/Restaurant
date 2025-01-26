import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Meal implements Serializable {
    public  String name;
    private double price;
    private String ingredients;
    public static JLabel labelIcon;
    public static Font AtrialFont=new Font("Arial",Font.BOLD,28);
    static JButton buttonBack=new JButton("Back");

    public Meal(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;

    }
    @Override
    public String toString() {
        return   "name= " + name+
                ", price=" + price+
                ", ingredients=" + ingredients
                ;
    }

    public static void  EditMenu() {
        JFrame editMenuFrame = new JFrame("Edit Menu");

        editMenuFrame.setBounds(300, 100, 2000, 1200);

        ImageIcon EditMenuImageIcon = new ImageIcon("C:\\Users\\erkso\\IdeaProjects\\Restaurant Test1\\Pizza2.jpg");
        Image MenuImage = EditMenuImageIcon.getImage();
        Image scaledMenuImage = MenuImage.getScaledInstance(editMenuFrame.getWidth(), editMenuFrame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon MenuImageIconsEdit = new ImageIcon(scaledMenuImage);

        labelIcon=new JLabel(MenuImageIconsEdit);
        labelIcon.setBounds(0,0,editMenuFrame.getWidth(),editMenuFrame.getHeight());


        JButton AddButton = new JButton("Add Meal");
        JButton RemoveButton=new JButton("Remove Meal");

        AddButton.setBounds(150, 300, 250, 50);
        RemoveButton.setBounds(150,800,250,50);
        buttonBack.setBounds(1700,1000,200,50);

        AddButton.setBackground(Color.gray);
        RemoveButton.setBackground(Color.gray);
        buttonBack.setBackground(Color.gray);

        AddButton.setFont(AtrialFont);
        RemoveButton.setFont(AtrialFont);
        buttonBack.setFont(AtrialFont);

        JPanel AddPanel=new JPanel(null);
        AddPanel.setBorder(BorderFactory.createTitledBorder("Meal Info"));
        AddPanel.setBounds(600,150,800,425);
        AddPanel.setOpaque(false);

        AddPanel.setFont(AtrialFont);

        JLabel nameMeal=new JLabel("Name Meal");
        JLabel PriceMeal=new JLabel("Price Meal");
        JLabel IngredientMeal=new JLabel("Ingredients Meal");

        JTextField nameField=new JTextField();
        JTextField PriceField=new JTextField();
        JTextField IngredientField=new JTextField();

        nameMeal.setBounds(50,80,200,90);
        PriceMeal.setBounds(50,155,250,90);
        IngredientMeal.setBounds(50,230,300,90);

        nameField.setBounds(325,100,150,35);
        PriceField.setBounds(325,180,150,35);
        IngredientField.setBounds(325,260,150,35);

        nameMeal.setForeground(Color.white);
        PriceMeal.setForeground(Color.white);
        IngredientMeal.setForeground(Color.white);

        nameMeal.setFont(AtrialFont);
        PriceMeal.setFont(AtrialFont);
        IngredientMeal.setFont(AtrialFont);

        AddPanel.add(nameMeal);
        AddPanel.add(PriceMeal);
        AddPanel.add(IngredientMeal);
        AddPanel.add(nameField);
        AddPanel.add(PriceField);
        AddPanel.add(IngredientField);

        labelIcon.add(AddPanel);
        editMenuFrame.setVisible(true);


        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String name = nameField.getText();
                double price = Double.parseDouble(PriceField.getText());
                String Ingredients = IngredientField.getText();

                Meal newMeal = new Meal(name, price, Ingredients);
                Restaurant.addMeal(newMeal);
            }
        });
        JPanel RemovePanel=new JPanel(null);
        RemovePanel.setBounds(600,650,850,400);
        RemovePanel.setOpaque(false);

        JLabel RemoveLabel=new JLabel("To Delete meal selected it : ");
        RemoveLabel.setBounds(25,15,400,50);
        RemoveLabel.setForeground(Color.white);
        RemoveLabel.setFont(AtrialFont);

        DefaultListModel tableModel = new DefaultListModel();
        JList listMenu = new JList(tableModel);
        for (Meal meal : Restaurant.menu) {
            tableModel.addElement(meal);
        }
        Font serifFont=new Font("serif",Font.BOLD,25);
        listMenu.setFont(serifFont);

        listMenu.setForeground(Color.BLACK);
        listMenu.setBackground(Color.gray);
        JScrollPane scrollPane = new JScrollPane(listMenu);
        scrollPane.setBounds(25, 75, 750, 250);

        RemovePanel.add(RemoveLabel);
        RemovePanel.add(scrollPane);

        labelIcon.add(RemovePanel);


        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Restaurant.menu.removeAll(listMenu.getSelectedValuesList());
            }
        });
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editMenuFrame.dispose();
            }
        });
        labelIcon.add(AddButton);
        labelIcon.add(RemoveButton);
        labelIcon.add(buttonBack);
        editMenuFrame.add(labelIcon);
        editMenuFrame.setLayout(null);
        editMenuFrame.setVisible(true);
    }

    public double getPrice() {
        return price;
    }

}
