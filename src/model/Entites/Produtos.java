
package model.Entites;


public class Produtos {
    private String name;
    private Double price;
    private Integer quantity;
    
    public Produtos(){
        
    }

    public Produtos(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public double total(){
       return price * quantity;
    }
    
}
