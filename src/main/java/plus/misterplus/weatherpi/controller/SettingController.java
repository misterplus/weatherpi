package plus.misterplus.weatherpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.misterplus.weatherpi.bean.Node;
import plus.misterplus.weatherpi.bean.Setting;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableConfigurationProperties(Setting.class)
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private Setting setting;

    @RequestMapping("/nodes")
    public List<Node> nodes() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < setting.getNode().size(); i++) {
            nodes.add(new Node(setting.getNode().get(i), setting.getNodeName().get(i)));
        }
        return nodes;
    }

    @RequestMapping("/save")
    public String save() {
        setting.getNode().add("3.3.3.3");
        setting.getNodeName().add("测试");
        setting.save();
        return "";
    }
}
