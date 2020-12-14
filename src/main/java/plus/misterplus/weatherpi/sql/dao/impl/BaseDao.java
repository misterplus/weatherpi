package plus.misterplus.weatherpi.sql.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import plus.misterplus.weatherpi.util.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    public int procedure(Connection db, String sql, Object... params) {
        try {
            return queryRunner.execute(db, sql, params);
        } catch (SQLException e) { 
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return -1;
    }

    public int insert(Connection db, String sql, Object... params) {
        try {
            return queryRunner.update(db, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return -1;
    }

    public <T> T select(Connection db, Class<T> type, String sql) {
        try {
            return queryRunner.query(db, sql, new BeanHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return null;
    }

    public <T> T select(Connection db, Class<T> type, String sql, Object... params) {
        try {
            return queryRunner.query(db, sql, params, new BeanHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return null;
    }

    public <T> List<T> selectMultiple(Connection db, Class<T> type, String sql) {
        try {
            return queryRunner.query(db, sql, new BeanListHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return null;
    }

    public <T> List<T> selectMultiple(Connection db, Class<T> type, String sql, Object... params) {
        try {
            return queryRunner.query(db, sql, params, new BeanListHandler<>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return null;
    }

    public int update(Connection db, String sql, Object... params) {
        try {
            return queryRunner.update(db, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(db);
        }
        return 0;
    }
}
