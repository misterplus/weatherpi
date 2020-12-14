package plus.misterplus.weatherpi.sql.dao;

import plus.misterplus.weatherpi.bean.AvgRecord;
import plus.misterplus.weatherpi.bean.Record;

import java.util.List;

public interface RecordDao {
    List<Record> selectDay(int index, String day);
    List<AvgRecord> selectMonth(int index, String month);
}
