public class Customer implements Runnable {
  
    PizzaMaker pizzaMaker;
  
    public Customer(PizzaMaker pizzaMaker)
    {
        this.pizzaMaker = pizzaMaker;
    }
  
    public void run()
    {
        while (this.pizzaMaker.isInProgress) {
            System.out.println(
                Thread.currentThread().getName()
                + ":-Pizza order complete??");
            System.out.println("--Busy Spinning---");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
  
        System.out.println(
            "Received the ordered pizza:-"
            + Thread.currentThread().getName());
        System.out.println("Base of the pizza is : "
                           + pizzaMaker.pizza.getBase());
        System.out.println(
            "Topings are : "
            + pizzaMaker.pizza.getToppings());
    }
}