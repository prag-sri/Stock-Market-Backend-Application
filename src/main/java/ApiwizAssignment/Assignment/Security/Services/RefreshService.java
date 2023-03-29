package ApiwizAssignment.Assignment.Security.Services;

import ApiwizAssignment.Assignment.Entities.StockWrapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class RefreshService {

    private final Map<StockWrapper,Boolean> stocksToRefresh;
    public static final ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(1);

    private static final Duration refreshPeriod= Duration.ofSeconds(15);
    public RefreshService(){
        stocksToRefresh= new HashMap<>();
    }

    public boolean shouldRefresh(final StockWrapper stock)
    {
        if(!stocksToRefresh.containsKey(stock))
        {
            stocksToRefresh.put(stock,false);
            return true;
        }
        return stocksToRefresh.get(stock);
    }

    public void shouldRefreshEvery15Minutes(){
        scheduler.scheduleAtFixedRate(()->
                        stocksToRefresh.forEach((stock,value)-> {
                            if (stock.getLastAccessed().isBefore((LocalDateTime.now().minus(refreshPeriod))))
                            {
                                System.out.println("Setting should refresh " + stock.getStock().getSymbol());
                                stocksToRefresh.remove(stock);
                                stocksToRefresh.put(stock.withLastAccessed(LocalDateTime.now()),true);
                            }
    }),0,15,SECONDS);
    }
}
