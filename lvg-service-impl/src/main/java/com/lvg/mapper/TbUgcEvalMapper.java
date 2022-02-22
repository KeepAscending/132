package com.lvg.mapper;

import com.lvg.pojo.TbUgcEval;
import com.lvg.pojo.TbUgcEvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUgcEvalMapper {
    int countByExample(TbUgcEvalExample example);

    int deleteByExample(TbUgcEvalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUgcEval record);

    int insertSelective(TbUgcEval record);

    List<TbUgcEval> selectByExample(TbUgcEvalExample example);

    TbUgcEval selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUgcEval record, @Param("example") TbUgcEvalExample example);

    int updateByExample(@Param("record") TbUgcEval record, @Param("example") TbUgcEvalExample example);

    int updateByPrimaryKeySelective(TbUgcEval record);

    int updateByPrimaryKey(TbUgcEval record);
}