package yanolja.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductInfo {
	private int productInfo;
	private boolean isUsed;
	private String name;
	private String product;
	private Date startDate;
	private Date endDate;
	private boolean isBus;
	private int checkIn;
	private int checkOut;
	private int price;
	private boolean review;
	
	public ProductInfo() {
		
	}
	
	public ProductInfo(int productInfo, boolean isUsed, String name, String product, Date startDate, Date endDate, boolean isBus,
			int checkIn, int checkOut, int price, boolean review) {
		this.productInfo = productInfo;
		this.isUsed = isUsed;
		this.name = name;
		this.product = product;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isBus = isBus;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
		this.review = review;
	}
	
	public int getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(int productInfo) {
		this.productInfo = productInfo;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isBus() {
		return isBus;
	}
	public void setBus(boolean isBus) {
		this.isBus = isBus;
	}
	public int getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}
	public int getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isReview() {
		return review;
	}
	public void setReview(boolean review) {
		this.review = review;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	/*public boolean getUsed() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);	
		int compare;
		try {
			compare = endDate.compareTo(format.parse(date));
			if (compare >= 0) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}*/
	

}
