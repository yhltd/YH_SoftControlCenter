package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.PushNews;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@DS("notice")
public interface PushNewsMapper extends BaseMapper<PushNews> {
    @Select("select * from product_pushnews ")
    List<PushNews> getList();

    @Select("<script>" +
            "SELECT * FROM product_pushnews " +
            "<where>" +
            "   <if test='system != null and system != \"\"'>" +
            "       AND xtname = #{system}" +
            "   </if>" +
            "   <if test='company != null and company != \"\"'>" +
            "       AND gsname LIKE CONCAT('%', #{company}, '%')" +
            "   </if>" +
            "</where>" +
            "</script>")
    List<PushNews> getLittle(@Param("system") String system, @Param("company") String company);

    @Insert("INSERT INTO product_pushnews (" +
            "gsname, xtname, textbox, topgao, xuankuan, " +
            "tptop1, tptop2, tptop3, tptop4, tptop5, " +
            "tptop6, beizhu1, qidate, zhidate, date" +
            ") VALUES (" +
            "#{gsname}, #{xtname}, #{textbox}, #{topgao}, #{xuankuan}, " +
            "#{tptop1}, #{tptop2}, #{tptop3}, #{tptop4}, #{tptop5}, " +
            "#{tptop6}, #{beizhu1}," +
            "CASE WHEN #{qidate} IS NULL OR #{qidate} = '' THEN NULL ELSE CONVERT(datetime2, #{qidate}, 120) END, " +
            "CASE WHEN #{zhidate} IS NULL OR #{zhidate} = '' THEN NULL ELSE CONVERT(datetime2, #{zhidate}, 120) END, " +
            "GETDATE()" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPushNews(PushNews pushNews);

    @Update("UPDATE product_pushnews SET " +
            "gsname = #{gsname}, xtname = #{xtname}, textbox = #{textbox}, " +
            "topgao = #{topgao}, xuankuan = #{xuankuan},beizhu1 = #{beizhu1}, " +
            "tptop1 = #{tptop1}, tptop2 = #{tptop2}, tptop3 = #{tptop3}, " +
            "tptop4 = #{tptop4}, tptop5 = #{tptop5}, tptop6 = #{tptop6}, " +
            "qidate = CASE WHEN #{qidate} IS NULL OR #{qidate} = '' THEN NULL ELSE CONVERT(datetime2, #{qidate}, 120) END, " +
            "zhidate = CASE WHEN #{zhidate} IS NULL OR #{zhidate} = '' THEN NULL ELSE CONVERT(datetime2, #{zhidate}, 120) END " +
            "WHERE id = #{id}")
    int updatePushNews(PushNews pushNews);

    @Delete("DELETE FROM product_pushnews WHERE id = #{id}")
    int deleteById(Integer id);

}
