package model;
import java.io.Serializable;


public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}

	private long id;
	private Category cate;
	private String name;
	private int qty;
	private int price;
	private String manufacturer;
	private String image; 
	private String description; 
	private String condition;
	
	public Product(long id, Category cate, String name, int qty, int price, String manufacturer, String image,
			String description, String condition) {
		super();
		this.id = id;
		this.cate = cate;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.manufacturer = manufacturer;
		this.image = image;
		this.description = description;
		this.condition = condition;
	}
	public Product(String name, int qty, int price, String manufacturer, String image,
			String description,Category category, String condition) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.manufacturer = manufacturer;
		this.image = image;
		this.description = description;
		this.cate = category;
		this.condition = condition;
	}
	
	public Product(long id, Category cate, String name, int qty, int price, String manufacturer, String image,
			String description) {
		super();
		this.id = id;
		this.cate = cate;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.manufacturer = manufacturer;
		this.image = image;
		this.description = description;
	}
	public Product(String name, int qty, int price, String manufacturer, String image,
			String description,Category category) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.manufacturer = manufacturer;
		this.image = image;
		this.description = description;
		this.cate = category;
	}
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}