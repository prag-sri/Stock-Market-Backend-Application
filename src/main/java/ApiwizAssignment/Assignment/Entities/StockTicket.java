package ApiwizAssignment.Assignment.Entities;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocktickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockTicket {

    private int id;
    private String stock_symbol;
    private NotiFreq notification_frequency;
    private Time notify_time;
}
