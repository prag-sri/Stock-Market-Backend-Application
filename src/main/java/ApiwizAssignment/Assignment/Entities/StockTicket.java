package ApiwizAssignment.Assignment.Entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stockTickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class StockTicket {
    @Id
    private String id;
    private String stock_symbol;
    @Enumerated(EnumType.STRING)
    private NotiFreq notification_frequency;
    @Timestamp
    private String notify_time;
}
