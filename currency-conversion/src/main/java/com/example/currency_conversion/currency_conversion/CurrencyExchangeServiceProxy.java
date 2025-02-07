package com.example.currency_conversion.currency_conversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//http://:8000/currency-exchange/from/{from}/to/{to}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from,@PathVariable String to);
		

}
