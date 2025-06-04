package in.sp.main.Model;

public class StockInfo {
	
	   
		private String datetime;
	    private String open;
	    private String close;
	    private double percentChange;
		public String getDatetime() {
			return datetime;
		}
		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}
		public String getOpen() {
			return open;
		}
		public void setOpen(String open) {
			this.open = open;
		}
		
		public String getClose() {
			return close;
		}
		public void setClose(String close) {
			this.close = close;
		}
		public double getPercentChange() {
			return percentChange;
		}
		public void setPercentChange(double percentChange) {
			this.percentChange = percentChange;
		}
		
		public StockInfo(String datetime, String open, String close, double percentChange) {
			this.datetime = datetime;
			this.open = open;
			this.close = close;
			this.percentChange = percentChange;
			
		}
	
	
	    
}
