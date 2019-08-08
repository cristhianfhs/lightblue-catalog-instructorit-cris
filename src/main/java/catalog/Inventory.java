
//Now we need to create inventory.java.
package catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="items")
public class Inventory {
  // Use generated ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // Item name
  @NotNull
  private String name;

  // Item description
  @NotNull 
  private String description;

  //Item price
  @NotNull
  private int price;

  //Item img_alt
  private String img_alt;

  //Item img
  @NotNull
  private String img;

  //Item stock
  @NotNull
  private int stock;

  //The constructors

  public Inventory() { }
  public Inventory(long id) {
    this.id = id;
    }
  
  public Inventory(String name, String description,
  int price, String img_alt, String img, int stock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.img = img;
    this.img_alt = img_alt;
    this.stock = stock;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append(String.format("\t\"id\": %s,\n",this.id));
    sb.append(String.format("\t\"name\": \"%s\",\n",this.name));
    sb.append(String.format("\t\"description\": \"%s\",\n",this.description));
    sb.append(String.format("\t\"price\": %s,\n",this.price));
    sb.append(String.format("\t\"imgAlt\": \"%s\",\n",this.img_alt));
    sb.append(String.format("\t\"img\": \"%s\",\n",this.img));
    sb.append(String.format("\t\"stock\": %s,\n",this.stock));
    sb.append("}");
   }
 }
 