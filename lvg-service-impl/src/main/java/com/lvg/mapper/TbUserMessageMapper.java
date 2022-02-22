package com.lvg.mapper;

import com.lvg.pojo.TbUserMessage;
import com.lvg.pojo.TbUserMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMessageMapper {
    int countByExample(TbUserMessageExample example);

    int deleteByExample(TbUserMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUserMessage record);

    int insertSelective(TbUserMessage record);

    List<TbUserMessage> selectByExampleWithBLOBs(TbUserMessageExample example);

    List<TbUserMessage> selectByExample(TbUserMessageExample example);

    TbUserMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUserMessage record, @Param("example") TbUserMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUserMessage record, @Param("example") TbUserMessageExample example);

    int updateByExample(@Param("record") TbUserMessage record, @Param("example") TbUserMessageExample example);

    int updateByPrimaryKeySelective(TbUserMessage record);

    int updateByPrimaryKeyWithBLOBs(TbUserMessage record);

    int updateByPrimaryKey(TbUserMessage record);
}