package plus.misterplus.weatherpi.sql.dao.impl;

import plus.misterplus.weatherpi.bean.Node;
import plus.misterplus.weatherpi.sql.connection.MasterDB;
import plus.misterplus.weatherpi.sql.dao.NodeDao;

import java.util.List;

public class NodeDaoImpl extends BaseDao implements NodeDao {

    private static final NodeDaoImpl instance = new NodeDaoImpl();

    public static NodeDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Node> selectNameAll() {
        String sql = "select nodeName from node";
        return selectMultiple(MasterDB.getInstance().getConnection(), Node.class, sql);
    }

    @Override
    public Node select(int id) {
        String sql = "select * from node where id = ?";
        return select(MasterDB.getInstance().getConnection(), Node.class, sql, id);
    }

    @Override
    public int insert(Node node) {
        String sql = "insert into node(address, nodeName, username, pass) values(?,?,?,?)";
        return insert(MasterDB.getInstance().getConnection(), sql, node.getAddress(), node.getNodeName(), node.getUsername(), node.getPass());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from node where id = ?";
        int affected = update(MasterDB.getInstance().getConnection(), sql, id);
        if (affected != 0) {
            String cleanup = "update node set id = id - 1 where id > ?";
            return update(MasterDB.getInstance().getConnection(), cleanup, id);
        }
        else
            return affected;
    }

    @Override
    public int update(Node node) {
        String sql = "update node set address = ?, nodeName = ?, username = ?, pass = ? where id = ?";
        return update(MasterDB.getInstance().getConnection(), sql, node.getAddress(), node.getNodeName(), node.getUsername(), node.getPass(), node.getId());
    }


}
