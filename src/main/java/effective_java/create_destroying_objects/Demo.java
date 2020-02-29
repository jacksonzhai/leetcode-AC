package effective_java.create_destroying_objects;

public class Demo {
    public static void main(String[] args) {
        NyPizza pizza =
                new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
    }
}
