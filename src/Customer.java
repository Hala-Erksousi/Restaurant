import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    public String name;
    Order order;

    public Customer(){}
    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, int id, List meals, double totalprice, String status) {
        this.name = name;
        order=new Order(id,meals,totalprice,status);

    }
    public static void SaveOrder(Customer customer) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream ofos = null;
        try {
            fos = new FileOutputStream("Restaurant's Order.ser");
            ofos = new ObjectOutputStream(fos);
            ofos.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ofos.close();
        }
    }

    public String toString() {
        return "Customer{" +
                "name=" + name  +","+
                order.toString()+
                '}' +"\n"+"\n";
    }
}
