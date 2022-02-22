package com.lvg.mapper;

import com.lvg.pojo.TbAdvert;
import com.lvg.pojo.TbAdvertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdvertMapper {
    int countByExample(TbAdvertExample example);

    int deleteByExample(TbAdvertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdvert record);

    int insertSelective(TbAdvert record);

    List<TbAdvert> selectByExample(TbAdvertExample example);

    TbAdvert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdvert record, @Param("example") TbAdvertExample example);

    int updateByExample(@Param("record") TbAdvert record, @Param("example") TbAdvertExample example);

    int updateByPrimaryKeySelective(TbAdvert record);

    int updateByPrimaryKey(TbAdvert record);
}