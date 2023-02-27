package com.jwan.daos;

import com.jwan.domain.Fruit;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class FruitDynamicSQLProvider {
    public String select(Fruit indexFruit){
        return new SQL(){
            {
                SELECT("*");
                FROM("fruit");

                if(indexFruit.getfName() != null)
                    WHERE("f_name like '%${fName}%'");
                if (indexFruit.getfPrice() != null)
                    WHERE("f_price = #{fPrice}");
                if (indexFruit.getfCount() != null)
                    WHERE("f_count = #{fCount}");
                if (indexFruit.getfRemark() != null)
                   WHERE("f_remark like '%${fRemark}%'");


//                StringBuilder whereClause = new StringBuilder();
//                whereClause.append("1=1");
//                if(map.get("fName") != null)
//                    whereClause.append(" and f_name like '%").append(map.get("fName")).append("%'");
//                if (map.get("fPrice") != null)
//                    whereClause.append(" and f_price = ").append(map.get("fPrice"));
//                if (map.get("fCount") != null)
//                    whereClause.append(" and f_count = ").append(map.get("fCount"));
//                if (map.get("fRemark") != null)
//                    whereClause.append(" and f_remark like '%").append(map.get("fRemark")).append("%'");
//                WHERE(whereClause.toString());
            }
        }.toString();
    }

    public String insert(Fruit indexFruit){
        return new SQL(){
            {
                INSERT_INTO("fruit");
                //因为fName不能为null，所以一定要插入
                VALUES("f_name","#{fName}");
                if (indexFruit.getfPrice() != null)
                    VALUES("f_price","#{fPrice}");
                if (indexFruit.getfCount() != null)
                    VALUES("f_price","#{fPrice}");
                if (indexFruit.getfRemark() != null)
                    VALUES("f_remark","#{fRemark}");
            }
        }.toString();
    }
}
