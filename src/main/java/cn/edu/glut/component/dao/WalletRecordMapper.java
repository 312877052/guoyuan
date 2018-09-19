package cn.edu.glut.component.dao;

import cn.edu.glut.model.WalletRecord;
import cn.edu.glut.model.WalletRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletRecordMapper {
    int countByExample(WalletRecordExample example);

    int deleteByExample(WalletRecordExample example);

    int deleteByPrimaryKey(Integer walletRecordId);

    int insert(WalletRecord record);

    int insertSelective(WalletRecord record);

    List<WalletRecord> selectByExample(WalletRecordExample example);

    WalletRecord selectByPrimaryKey(Integer walletRecordId);

    int updateByExampleSelective(@Param("record") WalletRecord record, @Param("example") WalletRecordExample example);

    int updateByExample(@Param("record") WalletRecord record, @Param("example") WalletRecordExample example);

    int updateByPrimaryKeySelective(WalletRecord record);

    int updateByPrimaryKey(WalletRecord record);
}