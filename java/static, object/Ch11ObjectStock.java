
class Ch11ObjectStock {
	String stockCode;
	int stockNum;
	Ch11ObjectStock(String stockCode, int stockNum) {
		this.stockCode = stockCode;
		this.stockNum = stockNum;
	}
	public String toString() {
		String str = "상품코드: " + stockCode + "재고수량: " + stockNum;
		return str;
	}
	
	
}
