package com.lvg.mapper;

import com.lvg.pojo.TbUgc;
import com.lvg.pojo.TbUgcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUgcMapper {
    int countByExample(TbUgcExample example);

    int deleteByExample(TbUgcExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUgc record);

    int insertSelective(TbUgc record);

    List<TbUgc> selectByExampleWithBLOBs(TbUgcExample example);

    List<TbUgc> selectByExample(TbUgcExample example);

    TbUgc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUgc record, @Param("example") TbUgcExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUgc record, @Param("example") TbUgcExample example);

    int updateByExample(@Param("record") TbUgc record, @Param("example") TbUgcExample example);

    int updateByPrimaryKeySelective(TbUgc record);

    int updateByPrimaryKeyWithBLOBs(TbUgc record);

    int updateByPrimaryKey(TbUgc record);
}