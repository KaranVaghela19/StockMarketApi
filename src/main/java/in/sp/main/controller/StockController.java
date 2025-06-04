package in.sp.main.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.sp.main.Model.TimeSeries;
import in.sp.main.StockService.StockService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
	
	@Autowired
    private StockService stockService;

	@Operation(tags = "Stock Data", summary = "Get stock summary by symbol", description = "Fetches the stock summary for a given symbol. Returns the latest stock data including open,"
	+ " close, and percent change.")
    @GetMapping("/{symbol}")
    public ResponseEntity<TimeSeries> getStock(@PathVariable String symbol) {
        TimeSeries data = stockService.getStockSummary(symbol);
        return ResponseEntity.ok(data);
    }
    
	
	@Operation(tags = "Stock Data", summary = "Get stock summaries for multiple symbols", description = "Fetches stock summaries for multiple symbols")
   @GetMapping
    public Map<String, TimeSeries> getMultipleStocks(@RequestParam String symbols) {
        List<String> symbolList = Arrays.stream(symbols.split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());

        Map<String, TimeSeries> results = new HashMap<>();
        for (String symbol : symbolList) {
            TimeSeries response = stockService.getStockSummary(symbol);
            results.put(symbol, response);
        }

        return results;
    } 

}
