package com.ahd.api.items;
import javax.persistence.*;



@Entity
@Table(name = "delegates")
public class ItemsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "trade_name")
    private String tradeName;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_class")
    private String itemClass;

    @Column(name = "price")
    private String price;

    @Column(name = "daynamic_price")
    private String daynamicPrice;


    public ItemsModel() {
    }

    public ItemsModel(String scientificName, String tradeName, String itemCode, String itemClass, String price, String daynamicPrice) {
        this.scientificName = scientificName;
        this.tradeName = tradeName;
        this.itemCode = itemCode;
        this.itemClass = itemClass;
        this.price = price;
        this.daynamicPrice = daynamicPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDaynamicPrice() {
        return daynamicPrice;
    }

    public void setDaynamicPrice(String daynamicPrice) {
        this.daynamicPrice = daynamicPrice;
    }

}