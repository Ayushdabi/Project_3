package in.co.rays.project_3.dto;

import java.util.Date;

public class ShopingDTO extends BaseDTO {

	private String productName;
	private String shopeName;
	private Date purchaseDate;
	private String category;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShopeName() {
		return shopeName;
	}

	public void setShopeName(String shopeName) {
		this.shopeName = shopeName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return category;
	}

}
