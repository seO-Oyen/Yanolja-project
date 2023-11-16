package yanolja.vo;

import java.util.Date;

public class ReservationInfo {
	private String reservation;
	private Date reservationDate;
	private ProductInfo productInfo;
	private int personInfo;
	
	public ReservationInfo() {
		
	}

	public ReservationInfo(String reservation, Date reservationDate, ProductInfo productInfo, int personInfo) {
		this.reservation = reservation;
		this.reservationDate = reservationDate;
		this.productInfo = productInfo;
		this.personInfo = personInfo;
	}

	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	public int getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(int personInfo) {
		this.personInfo = personInfo;
	}

}
