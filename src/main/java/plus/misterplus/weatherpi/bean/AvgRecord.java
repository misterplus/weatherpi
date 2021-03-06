package plus.misterplus.weatherpi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvgRecord {
    @JsonFormat(pattern = "MM-dd")
    private Date created;
    private int avgTemp, minTemp, maxTemp, avgHumidity, avgPressure;
}
