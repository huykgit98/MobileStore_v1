package model;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Order {

	private int id;
	private Customer customer;
	private List<Item> items;
	private Date date_order;
	private int status;
	
	public Order() {
		this.status = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Date getDate_order() {
		return date_order;
	}
	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTotal(){
		NumberFormat formatter = new DecimalFormat("###,###,###.##");
		long total = 0;
		for(Item item : items) {
			total += item.getPrice()*item.getQty();
		}
	    return formatter.format(total);
	}

	public void removeToCart(Long product) {
        boolean bln = items.contains(product);
        if (bln) {
        	items.remove(product);
        }
}
}