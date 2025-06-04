package in.sp.main.Model;

import java.util.List;

public class TimeSeries {
	 private MetaData metaData;
	    private List<StockInfo> values;
	    private String status;

	    public MetaData getMeta() { return metaData; }
	    public void setMeta(MetaData meta) { this.metaData = meta; }

	    public List<StockInfo> getValues() { return values; }
	    public void setValues(List<StockInfo> values) { this.values = values; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status;
}
}