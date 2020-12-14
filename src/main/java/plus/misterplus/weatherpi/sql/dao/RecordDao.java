package plus.misterplus.weatherpi.sql.dao;

import plus.misterplus.weatherpi.bean.Record;

import java.util.List;

public interface RecordDao {
    List<Record> selectDay(int index, String day);
    List<Record> selectMonth(int index, String month);
}
