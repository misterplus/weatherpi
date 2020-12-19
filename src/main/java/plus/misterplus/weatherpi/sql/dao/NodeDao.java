package plus.misterplus.weatherpi.sql.dao;

import plus.misterplus.weatherpi.bean.Node;

import java.util.List;

public interface NodeDao {
    List<Node> selectNameAll();
    //todo id does not sort itself when deleted
    Node select(int id);
    int insert(Node node);
}
