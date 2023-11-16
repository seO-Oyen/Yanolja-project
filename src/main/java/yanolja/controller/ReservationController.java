package yanolja.controller;

import java.util.ArrayList;
import java.util.List;

import yanolja.dao.ReservationDao;
import yanolja.vo.ReservationInfo;

public class ReservationController {
	ReservationDao rDao = new ReservationDao();
	
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
		rlist = rDao.getReservationInfo(category, periodNum);
		
		for (ReservationInfo info : rlist) {
			System.out.println("예약번호 : " + info.getReservation());
			System.out.println("예약날짜 : " + info.getReservationDate());
			info.getProductInfo();
		}
		
		return rlist;
	}
	
	public ReservationInfo getReservation(int Num) {
		
		return rDao.getReservation(Num);
	}

}
