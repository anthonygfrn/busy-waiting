import java.util.ArrayList;
import java.util.List;

class GFG {
  
    // Main driver method
    public static void main(String[] args)
    {
  
        //
        String base = "thick crust base";
  
        // Creating a List of String type
        List<String> toppings = new ArrayList<>();
  
        // Adding elements to the object
        toppings.add("tomato");
        toppings.add("corn");
        toppings.add("cheese");
        toppings.add("olive");
  
        Pizza pizza = new Pizza(base, toppings);
  
        PizzaMaker pizzaMaker = new PizzaMaker(pizza);
        Customer customer = new Customer(pizzaMaker);
        Thread pizzaMakerThread
            = new Thread(pizzaMaker, "pizzaMakerThread");
        Thread customerThread
            = new Thread(customer, "customerThread");
  
        pizzaMakerThread.start();
        customerThread.start();
    }
}