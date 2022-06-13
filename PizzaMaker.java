public class PizzaMaker implements Runnable {
  
    Pizza pizza;
    boolean isInProgress;
    public PizzaMaker(Pizza pizza)
    {
        this.pizza = pizza;
        this.isInProgress = true;
    }
  
    public void run()
    {
        System.out.println("Pizza order in progress");
        pizza.make();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
            " Making of pizza  with base :"
            + this.pizza.getBase() + " and toppings as "
            + this.pizza.getToppings() + " is complete :- "
            + Thread.currentThread().getName());
        this.isInProgress = false;
    }
}