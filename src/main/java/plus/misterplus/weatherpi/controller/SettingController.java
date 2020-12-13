package plus.misterplus.weatherpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plus.misterplus.weatherpi.bean.Node;
import plus.misterplus.weatherpi.bean.Setting;

@RestController
@EnableConfigurationProperties(Setting.class)
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private Setting setting;

    @RequestMapping("/select")
    public Node select(@RequestParam(value = "index", defaultValue = "0") int index) {
        return new Node(setting.getNode().get(index), setting.getNodeName().get(index));
    }

    @RequestMapping("/all")
    public String all() {
        return "";
    }
}
