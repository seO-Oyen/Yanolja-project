package yanolja.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yanolja.dao.ReservationDao;
import yanolja.dao.ReviewDao;
import yanolja.vo.ProductInfo;
import yanolja.vo.ReservationInfo;
import yanolja.vo.Review;

public class ReservationController {
	ReservationDao rDao = new ReservationDao();
	ReviewDao reviewDao = new ReviewDao();
	
	public List<ReservationInfo> getReservationList(String category, String period) {
		int periodNum;
		
		System.out.println(category);
		System.out.println(period);
		
		if (category == null) {
			category = "all";
			period = "six";
		}
		
		if (period.equals("three")) {
			periodNum = 3;
		} else if(period.equals("one")) {
			periodNum = 12;
		} else if(period.equals("two")) {
			periodNum = 24;
		} else {
			periodNum = 6;
		}
		
		List<ReservationInfo> rlist = new ArrayList<ReservationInfo>();
		// 테스트
		/*rlist.add(new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, false), 0));
		rlist.add(new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, true), 0));*/
		rlist = rDao.getReservationInfo(category, periodNum);
		
		for (ReservationInfo info : rlist) {
			System.out.println("예약번호 : " + info.getReservation());
			System.out.println("예약날짜 : " + info.getReservationDate());
			info.getProductInfo();
		}
		
		return rlist;
	}
	
	public ReservationInfo getReservation(int num) {
		/*return new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, false), 0);*/
		return rDao.getReservation(num);
	}
	
	public void createReview(String infoNum, String star, String text) {
		
		if (star.equals("undefined")) {
			System.out.println("등록 실패");
		} else {
			ReservationInfo reservation = null;
			int num = Integer.parseInt(infoNum);
			reservation = getReservation(num);
			rDao.setReview(num);
			reviewDao.setReview(num, Integer.parseInt(star), text);
			System.out.println(reservation.getProductInfo().getName());
			System.out.println("별점 : " + star);
			System.out.println("리뷰 : " + text);
		}
	}
	
	public Review getReview(int infoNum) {
		Review review = reviewDao.getReview(infoNum);
		System.out.println(review.getStar());
		System.out.println(review.getText());
		
		return review;
	}

}
