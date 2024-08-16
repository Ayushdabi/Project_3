package in.co.rays.project_3.dto;

import java.util.Date;

public class OrderDTO extends BaseDTO {
	private String orderName ;
	private Date orderDate ;
	private String Category ;
	private String address;
	private String price;
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return Category;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Category;
	}
	

}
