package plus.misterplus.weatherpi.sql.dao;

import plus.misterplus.weatherpi.bean.Node;

import java.util.List;

public interface NodeDao {
    List<Node> selectNameAll();
    Node select(int id);
}
