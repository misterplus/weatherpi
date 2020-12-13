package plus.misterplus.weatherpi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@PropertySource(value = "classpath:setting.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "setting")
public class Setting {
    private List<String> node, nodeName;

    @Autowired
    ResourceLoader resourceLoader;

    public void save() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < node.size(); i++) {
            builder.append(String.format("setting.node[%d]=%s\nsetting.nodeName[%d]=%s\n", i, node.get(i), i, nodeName.get(i)));
        }
        Resource resource = resourceLoader.getResource("classpath:setting.properties");
        PrintStream stream = null;
        try {
            File file = resource.getFile();
            stream = new PrintStream(file);
            stream.print(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
