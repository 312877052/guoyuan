package cn.edu.glut.component.dao;

import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.ReceiverAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiverAddressMapper {
    int countByExample(ReceiverAddressExample example);

    int deleteByExample(ReceiverAddressExample example);

    int deleteByPrimaryKey(Integer receiverAddressId);

    int insert(ReceiverAddress record);

    int insertSelective(ReceiverAddress record);

    List<ReceiverAddress> selectByExample(ReceiverAddressExample example);

    ReceiverAddress selectByPrimaryKey(Integer receiverAddressId);

    int updateByExampleSelective(@Param("record") ReceiverAddress record, @Param("example") ReceiverAddressExample example);

    int updateByExample(@Param("record") ReceiverAddress record, @Param("example") ReceiverAddressExample example);

    int updateByPrimaryKeySelective(ReceiverAddress record);

    int updateByPrimaryKey(ReceiverAddress record);
}