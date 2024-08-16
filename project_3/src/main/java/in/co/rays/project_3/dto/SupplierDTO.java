package in.co.rays.project_3.dto;

import java.util.Date;

public class SupplierDTO  extends BaseDTO{
	
	private String name;
	private Date dob;
	private String category;
	private Long payment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
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
