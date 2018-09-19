package cn.edu.glut.component.dao;

import cn.edu.glut.model.Wallet;
import cn.edu.glut.model.WalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletMapper {
    int countByExample(WalletExample example);

    int deleteByExample(WalletExample example);

    int deleteByPrimaryKey(String walletId);

    int insert(Wallet record);

    int insertSelective(Wallet record);

    List<Wallet> selectByExample(WalletExample example);

    Wallet selectByPrimaryKey(String walletId);

    int updateByExampleSelective(@Param("record") Wallet record, @Param("example") WalletExample example);

    int updateByExample(@Param("record") Wallet record, @Param("example") WalletExample example);

    int updateByPrimaryKeySelective(Wallet record);

    int updateByPrimaryKey(Wallet record);
}