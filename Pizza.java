// Importing List class from java.util package
import java.util.List;

public class Pizza {
    private String base;
    public String getBase() { return base; }
  
    public void setBase(String base) { this.base = base; }
  
    public List<String> getToppings() { return toppings; }
  
    public void setToppings(List<String> toppings)
    {
        this.toppings = toppings;
    }
  
    private List<String> toppings;
  
    public Pizza(String base, List<String> toppings)
    {
        super();
        this.base = base;
        this.toppings = toppings;
    }
  
    public void make()
    {
        System.out.println("Making pizza");
    }
}