package com.lvg.mapper;

import com.lvg.pojo.TbOrderEval;
import com.lvg.pojo.TbOrderEvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderEvalMapper {
    int countByExample(TbOrderEvalExample example);

    int deleteByExample(TbOrderEvalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbOrderEval record);

    int insertSelective(TbOrderEval record);

    List<TbOrderEval> selectByExample(TbOrderEvalExample example);

    TbOrderEval selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbOrderEval record, @Param("example") TbOrderEvalExample example);

    int updateByExample(@Param("record") TbOrderEval record, @Param("example") TbOrderEvalExample example);

    int updateByPrimaryKeySelective(TbOrderEval record);

    int updateByPrimaryKey(TbOrderEval record);
}