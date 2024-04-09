import java.util.Arrays;

public class Pizza {
    private int id;
    private String name;
    private int price;
    private String[] ingredients;

    public Pizza(int id, String name,  int price, String[] ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }
    public String getName(){
        return name;
    }

     public int getId(){
         return id;
     }

     public int getPrice(){
         return price;
     }

     public String[] getIngredients(){
         return ingredients;
     }

      public String toString() {
        return id + ". "+ name + ": " + Arrays.toString(ingredients)+ " - Kr. " + price;
      }
}




