package yanolja.vo;

public class Review {
	
	private int reviewNum;
	private int prodectInfo;
	private int star;
	private String text;
	
	public Review(int reviewNum, int prodectInfo, int star, String text) {
		this.reviewNum = reviewNum;
		this.prodectInfo = prodectInfo;
		this.star = star;
		this.text = text;
	}
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public int getProdectInfo() {
		return prodectInfo;
	}
	public void setProdectInfo(int prodectInfo) {
		this.prodectInfo = prodectInfo;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
