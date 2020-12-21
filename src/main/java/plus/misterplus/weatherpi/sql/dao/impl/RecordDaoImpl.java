package plus.misterplus.weatherpi.sql.dao.impl;

import plus.misterplus.weatherpi.bean.AvgRecord;
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
        String sql = "select * from record where created >= ? and created < ? order by created asc";
        Date date = DBUtils.convertSimpleDateString(day);
        Date endDate = DBUtils.nextDay(date);
        String start = DBUtils.convertComplexDate(date);
        String end = DBUtils.convertComplexDate(endDate);
        return selectMultiple(DBUtils.get(index).getConnection(), Record.class, sql, start, end);
    }

    @Override
    public List<AvgRecord> selectMonth(int index, String month) {
        String sql = "select created, avg(temp) as avgTemp, min(temp) as minTemp, max(temp) as maxTemp, avg(humidity) as avgHumidity, avg(pressure) as avgPressure from record group by cast(created as date) having created >= ? and created < ?";
        Date date = DBUtils.convertSimpleDateString(month);
        Date endDate = DBUtils.nextMonth(date);
        String start = DBUtils.convertComplexDate(date);
        String end = DBUtils.convertComplexDate(endDate);
        return selectMultiple(DBUtils.get(index).getConnection(), AvgRecord.class, sql, start, end);
    }
}
