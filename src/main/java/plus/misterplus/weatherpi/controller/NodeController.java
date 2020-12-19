package plus.misterplus.weatherpi.controller;

import org.springframework.web.bind.annotation.*;
import plus.misterplus.weatherpi.bean.AvgRecord;
import plus.misterplus.weatherpi.bean.Node;
import plus.misterplus.weatherpi.bean.Record;
import plus.misterplus.weatherpi.bean.Status;
import plus.misterplus.weatherpi.sql.dao.impl.NodeDaoImpl;
import plus.misterplus.weatherpi.sql.dao.impl.RecordDaoImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {
    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public List<String> names() {
        List<Node> nodes = NodeDaoImpl.getInstance().selectNameAll();
        List<String> names = new ArrayList<>();
        for (Node node : nodes) {
            names.add(node.getNodeName());
        }
        return names;
    }

    @RequestMapping(value = "/{year}/{month}/{day}", method = RequestMethod.GET)
    public List<Record> fetch(@PathVariable String year, @PathVariable String month, @PathVariable String day, @RequestParam(defaultValue = "0") int index) {
        String date = String.format("%s-%s-%s", year, month, day);
        return RecordDaoImpl.getInstance().selectDay(index, date);
    }

    @RequestMapping(value = "/{year}/{month}", method = RequestMethod.GET)
    public List<AvgRecord> fetch(@PathVariable String year, @PathVariable String month, @RequestParam(defaultValue = "0") int index){
        String date = String.format("%s-%s-01", year, month);
        return RecordDaoImpl.getInstance().selectMonth(index, date);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Status newNode(@RequestBody Node node) {
        int affected = NodeDaoImpl.getInstance().insert(node);
        if (affected != 0) {
            Status status = new Status();
            status.setStatus("success");
            return status;
        }
        else {
            Status status = new Status();
            status.setStatus("error");
            return status;
        }
    }
}
