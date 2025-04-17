package OOP.OurMenu;

public class MenuItem {private String name;
    private double price;
    private String description;
    private int id;
    private int time;
    public MenuItem() {
        this.id=id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setTime(int time){
        this.time = time;
    }
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    public int getTime(){
        return time;
    }
}


