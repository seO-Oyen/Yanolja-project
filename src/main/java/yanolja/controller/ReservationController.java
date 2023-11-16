package yanolja.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import yanolja.dao.ReservationDao;
import yanolja.vo.ProductInfo;
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
		// 테스트
		rlist.add(new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, false), 0));
		rlist.add(new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, true), 0));
		/*rlist = rDao.getReservationInfo(category, periodNum);
		
		for (ReservationInfo info : rlist) {
			System.out.println("예약번호 : " + info.getReservation());
			System.out.println("예약날짜 : " + info.getReservationDate());
			info.getProductInfo();
		}*/
		
		return rlist;
	}
	
	public ReservationInfo getReservation(int Num) {
		return new ReservationInfo("Y20231106ABCDE", new Date(2023, 11, 15),
				new ProductInfo(1, false, "지옥펜션", "프리미엄", new Date(2023, 11, 18),
						new Date(2023, 11, 20), false, 16, 12, 75000, false), 0);
		// return rDao.getReservation(Num);
	}

}
