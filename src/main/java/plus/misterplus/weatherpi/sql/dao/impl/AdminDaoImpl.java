package plus.misterplus.weatherpi.sql.dao.impl;

import cn.hutool.crypto.SecureUtil;
import plus.misterplus.weatherpi.bean.Admin;
import plus.misterplus.weatherpi.sql.connection.MasterDB;
import plus.misterplus.weatherpi.sql.dao.AdminDao;

public class AdminDaoImpl extends BaseDao implements AdminDao {

    private static final AdminDaoImpl instance = new AdminDaoImpl();

    public static AdminDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Admin select(Admin admin) {
        String sql = "select * from admin where username = ? and password = ?";
        return select(MasterDB.getInstance().getConnection(), Admin.class, sql, admin.getUsername(), SecureUtil.md5(admin.getPassword()));
    }
}
