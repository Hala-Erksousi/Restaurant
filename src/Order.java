import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    public int id;
    public List<Meal> meals=new ArrayList<>();
    private String status;
    private double tip;
    public double AllPrice;
    static int counter=0;

    public Order() {
    }

    public Order(int id, List meals, double AllPrice,String status) {
        counter++;
        this.id = counter;
        this.meals =  meals;
        this.status = status;
        this.AllPrice=AllPrice;
        this.tip = 15;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public  double calculateTotal(List<Meal> meals) {
        double total=0;
        for(int i=0;i<meals.size();i++) {
            total += meals.get(i).getPrice();
        }
        return total ;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", meals=" + meals +
                        ", status=" + status  +
                        ", AllPrice=" + AllPrice
                ;
    }
}
