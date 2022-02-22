package com.lvg.mapper;

import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupMapper {
    int countByExample(TbGroupExample example);

    int deleteByExample(TbGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGroup record);

    int insertSelective(TbGroup record);

    List<TbGroup> selectByExample(TbGroupExample example);

    TbGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGroup record, @Param("example") TbGroupExample example);

    int updateByExample(@Param("record") TbGroup record, @Param("example") TbGroupExample example);

    int updateByPrimaryKeySelective(TbGroup record);

    int updateByPrimaryKey(TbGroup record);
}