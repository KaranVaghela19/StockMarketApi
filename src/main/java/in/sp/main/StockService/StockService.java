package in.sp.main.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import in.sp.main.Model.StockInfo;
import in.sp.main.Model.TimeSeries;

@Service
public class StockService {
	
	@Autowired
    private RestTemplate restTemplate;

	private final String API_KEY = "cd418138f34443dbae0a4d882669193c";

	@Cacheable(value = "stockCache", key = "#symbol")
    public TimeSeries getStockSummary(String symbol) {
    	 String url = "https://api.twelvedata.com/time_series?apikey=" + API_KEY +
                 "&interval=1min&symbol=" + symbol;

    	 try {
    ResponseEntity<TimeSeries> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<TimeSeries>() {}
    );

    TimeSeries timeSeries = response.getBody();

   
    if (timeSeries != null && timeSeries.getValues() != null) {
        for (StockInfo stock : timeSeries.getValues()) {
            try {
                double open = Double.parseDouble(stock.getOpen());
                double close = Double.parseDouble(stock.getClose());

                double percentChange = ((close - open) / open) * 100;
                stock.setPercentChange(Math.round(percentChange * 100.0) / 100.0); 
            } catch (NumberFormatException e) {
                stock.setPercentChange(0.0); 
            }
        }
    }

    return timeSeries;
    	 } catch (HttpClientErrorException.BadRequest e) {
             throw new RuntimeException("Enter valid stock name.");
         } catch (HttpServerErrorException e) {
             throw new RuntimeException("Server error from API: " + e.getStatusCode());
         } catch (ResourceAccessException e) {
             throw new RuntimeException("Network error: Unable to reach API.");
         } catch (Exception e) {
             throw new RuntimeException("Unexpected error: " + e.getMessage());
             
         }
}
    }

