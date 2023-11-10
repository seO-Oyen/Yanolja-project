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
	public void getProductInfo() {
		System.out.println(productInfo.isUsed() ? "이용완료" : "이용전");
		System.out.println(productInfo.getName());
		System.out.println(productInfo.getProduct());
		System.out.print(productInfo.getStartDate() + " ~ ");
		System.out.println(productInfo.getEndDate());
		System.out.println(productInfo.isBus() ? "자동차" : "도보");
		System.out.println("체크인 : " + productInfo.getCheckIn());
		System.out.println("체크아웃 : " + productInfo.getCheckOut());
		System.out.println(productInfo.isReview() ? "후기 작성 완료" : "후기 작성 전");
		
		
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
