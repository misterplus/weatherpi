package plus.misterplus.weatherpi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @JsonFormat(pattern = "HH:mm")
    private Date created;
    private int temp, humidity, pressure;
}
