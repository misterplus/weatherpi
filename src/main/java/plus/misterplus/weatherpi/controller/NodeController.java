package plus.misterplus.weatherpi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.misterplus.weatherpi.bean.Node;
import plus.misterplus.weatherpi.sql.dao.impl.NodeDaoImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {
    @RequestMapping("/names")
    public List<String> names() {
        List<Node> nodes = NodeDaoImpl.getInstance().selectNameAll();
        List<String> names = new ArrayList<>();
        for (Node node : nodes) {
            names.add(node.getNodeName());
        }
        return names;
    }
}
