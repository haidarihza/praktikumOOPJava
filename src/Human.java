class Human extends Animal{
    public Human() {
        super(2);  
    }
    public void eat(String food) {
        if (food.equals("teman")) {
            //do nothing
        }
        else{
            this.hungry = false;
        }
    }
 
    public void run() {
        System.out.println("Human is running");
    }
}
