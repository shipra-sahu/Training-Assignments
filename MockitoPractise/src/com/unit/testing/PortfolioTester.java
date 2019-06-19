package com.unit.testing;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.source.main.Portfolio;
import com.source.main.Stock;
import com.source.main.StockService;

import static org.mockito.Mockito.*;

public class PortfolioTester {
	
	private static Portfolio portfolio;	
	private static StockService stockService;
	   
 
   @BeforeClass
	public static  void setUp() throws Exception{
	   portfolio = new Portfolio();		
	   
	      //Create the mock object of stock service
	      stockService = mock(StockService.class);		
	  
	      //set the stockService to the portfolio
	      portfolio.setStockService(stockService);
	}

   @AfterClass
	public static void tearDown() throws Exception {
		System.gc();
	}
   
   @Test
   public void testMarketValue(){
    	   
      //Creates a list of stocks to be added to the portfolio
      List<Stock> stocks = new ArrayList<Stock>();
      Stock googleStock = new Stock("1","Google", 100);
      Stock microsoftStock = new Stock("2","Microsoft",100);	
 
      stocks.add(googleStock);
      stocks.add(microsoftStock);

      //add stocks to the portfolio
      portfolio.setStocks(stocks);

      //mock the behavior of stock service to return the value of various stocks
      when(stockService.getPrice(googleStock)).thenReturn(50.00);
      when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);		

//      double marketValue = portfolio.getMarketValue();		
//      return marketValue == 105000.0;
      Assert.assertEquals(105000, portfolio.getMarketValue(), 0);
   }
}
