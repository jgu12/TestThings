//simple builder pattern, try this type of method chaining in selenium test
//        Pizza p2 = new Pizza.PizzaBuilder(200).
//                customer("jane").
//                bacon(true).
//                cheese(true).build();
// ------->
// home = new homePgae()
// home.dothis()
//  .dothat()
//  .verifythis()

public class Pizza{
    private int size;
    private boolean cheese;
    private String customer;
    private boolean bacon;

    private Pizza(PizzaBuilder builder){
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.customer = builder.customer;
        this.bacon = builder.bacon;
    }

    public int getSize(){
        return this.size;
    }

    public static class PizzaBuilder{
        private int size; //required
        private boolean cheese;
        private String customer;
        private boolean bacon;

        public PizzaBuilder(int size){
            this.size = size;
        }

        public Pizza build(){
            return new Pizza(this);
        }

        public PizzaBuilder cheese(boolean addCheese){
            this.cheese = addCheese;
            return this;
        }

        public PizzaBuilder bacon(boolean addBacon){
            this.bacon = addBacon;
            return this;
        }

        public PizzaBuilder customer(String customerName){
            this.customer = customerName;
            return this;
        }
    }
}
