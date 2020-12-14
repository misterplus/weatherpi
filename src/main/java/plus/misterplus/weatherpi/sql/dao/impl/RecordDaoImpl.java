package plus.misterplus.weatherpi.sql.dao.impl;

import plus.misterplus.weatherpi.bean.Record;
import plus.misterplus.weatherpi.sql.dao.RecordDao;
import plus.misterplus.weatherpi.util.DBUtils;

import java.util.Date;
import java.util.List;

public class RecordDaoImpl extends BaseDao implements RecordDao {

    private static final RecordDaoImpl instance = new RecordDaoImpl();

    public static RecordDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Record> selectDay(int index, String day) {
        String sql = "select * from record where created >= ? and created < ?";
        Date date = DBUtils.convertSimpleDateString(day);
        Date endDate = new Date(date.getTime() + 24 * 60 * 60 * 1000);
        String start = DBUtils.convertComplexDate(date);
        String end = DBUtils.convertComplexDate(endDate);
        return selectMultiple(DBUtils.get(index).getConnection(), Record.class, sql, start, end);
    }

    @Override
    public List<Record> selectMonth(int index, String month) {
        return null;
    }
}
