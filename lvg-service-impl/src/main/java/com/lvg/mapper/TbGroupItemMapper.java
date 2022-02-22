package com.lvg.mapper;

import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbGroupItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGroupItemMapper {
    int countByExample(TbGroupItemExample example);

    int deleteByExample(TbGroupItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGroupItem record);

    int insertSelective(TbGroupItem record);

    List<TbGroupItem> selectByExample(TbGroupItemExample example);

    TbGroupItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGroupItem record, @Param("example") TbGroupItemExample example);

    int updateByExample(@Param("record") TbGroupItem record, @Param("example") TbGroupItemExample example);

    int updateByPrimaryKeySelective(TbGroupItem record);

    int updateByPrimaryKey(TbGroupItem record);
}