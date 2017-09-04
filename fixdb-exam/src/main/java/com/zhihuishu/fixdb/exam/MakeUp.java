package com.zhihuishu.fixdb.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/beans.xml"})
public class MakeUp {

    @Resource
    private JdbcTemplate jdbcTemplate_mk;

    @Test
    public void test() {
        List<Map<String, Object>> queryForList = jdbcTemplate_mk.queryForList("SELECT * FROM MAKE_UP_2017_06_13_ERROR_TEMP_FINAL T");
        for (Map<String, Object> queryMap : queryForList) {
            String[] ids1 = ((String) queryMap.get("IDS")).split(",");
            HashSet<String> hashSet1 = new HashSet<String>(Arrays.asList(ids1));
            String[] ids2 = ((String) queryMap.get("GROUP_UID")).split(",");
            HashSet<String> hashSet2 = new HashSet<String>(Arrays.asList(ids2));
            Set<String> sets = new HashSet<String>();
            for (String s : hashSet1) {
                if (hashSet2.contains(s)) {

                } else {
                    sets.add(s);
                }
            }
            for (String s : hashSet2) {
                if (hashSet1.contains(s)) {

                } else {
                    sets.add(s);
                }
            }
            queryMap.put("IDS", StringUtils.collectionToCommaDelimitedString(sets));
            System.out.println(queryMap);
            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO MAKE_UP_2017_06_13_ERROR_TEMP_FINAL_ VALUES (?,?,?,?,?,?)");
            List<Object> params = new ArrayList<Object>();
            params.add(queryMap.get("RECRUIT_ID"));
            params.add(queryMap.get("CLASS_ID"));
            params.add(queryMap.get("COUNT"));
            params.add(queryMap.get("IDS"));
            params.add(queryMap.get("CLASS_COUNT"));
            params.add(null);
            jdbcTemplate_mk.update(sql.toString(), params.toArray());
        }
    }

}
