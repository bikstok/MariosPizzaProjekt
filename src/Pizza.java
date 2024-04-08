 public class Pizza {
    private String name;
    private int id;
    private int price;
    private String[] ingredients;

    public Pizza(String name, int price, String[] ingredients) {
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

      //public String[] toString() {
       // return name; " - Kr" + price + "Indgridents" + Arrays.toString(ingredients);
}




