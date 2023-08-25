package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import com.example.demo.entity.FinanceUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:09
 */
@Mapper
@Repository
@DS("finance")
public interface FinanceUserMapper extends BaseMapper<FinanceUser> {
    @Select("select * from account where company like '%'+#{company}+'%' and name like '%'+#{username}+'%' ")
    List<FinanceUser> getList(String company, String username);

    @Select("select company from account group by company ")
    List<FinanceUser> getCompany();

    @Delete("delete from Account where company=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from Accounting where company=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from AccountingPeizhi where company=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from Department where company=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from FinancingExpenditure where company=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from FinancingIncome where company=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from InvestmentExpenditure where company=#{company} ")
    boolean deleteCompany7(String company);

    @Delete("delete from InvestmentIncome where company=#{company} ")
    boolean deleteCompany8(String company);

    @Delete("delete from Invoice where company=#{company} ")
    boolean deleteCompany9(String company);

    @Delete("delete from InvoicePeizhi where company=#{company} ")
    boolean deleteCompany10(String company);

    @Delete("delete from KehuPeizhi where company=#{company} ")
    boolean deleteCompany11(String company);

    @Delete("delete from ManagementExpenditure where company=#{company} ")
    boolean deleteCompany12(String company);

    @Delete("delete from ManagementIncome where company=#{company} ")
    boolean deleteCompany13(String company);

    @Delete("delete from SimpleAccounting where company=#{company} ")
    boolean deleteCompany14(String company);

    @Delete("delete from SimpleData where company=#{company} ")
    boolean deleteCompany15(String company);

    @Delete("delete from VoucherSummary where company=#{company} ")
    boolean deleteCompany16(String company);

    @Delete("delete from VoucherWord where company=#{company} ")
    boolean deleteCompany17(String company);
}
