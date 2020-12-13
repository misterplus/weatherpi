package plus.misterplus.weatherpi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@PropertySource("classpath:setting.properties")
@ConfigurationProperties(prefix = "setting")
public class Setting {
    private List<String> node, nodeName;
}
