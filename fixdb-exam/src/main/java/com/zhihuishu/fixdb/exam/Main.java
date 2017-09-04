package com.zhihuishu.fixdb.exam;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/beans.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private JdbcTemplate jdbcTemplateMyCat;

    private final int courseId = 2009120;
    private final int parentExamId = 77234;
    private final int oldExamId = 45424;
    private final int newExamId = 77235;

    private final int examId = 45179;

    private final int recruitId = 4167;
    private final long userId = 162030747;

    @Test
    public void main() {
//        Integer recruit = findRecruit(courseId);
//        List<Integer> ids = findStudentExam(recruit, oldExamId);
//        boolean is = isFromParentExam(newExamId, parentExamId);
//        if (!is) {
//            System.out.println("error");
//            return;
//        }
//        System.out.println(ids.size());
//        System.out.println(buildUpdateSql(newExamId, ids));
//        System.out.println(buildTableSql(recruit, newExamId));
        /*String userString = getAnswerUser(recruitId, examId);
        System.out.print(userString);*/
        List<Integer> list2 = getDubbo2StuExamUser(recruitId, userId);
        System.out.println(list2.size()+"************");
        List<Integer> list = getDubboStuExamUser(recruitId, userId);
        System.out.println(list.size()+"************");
        //System.out.println(list.toArray());
        String listString = listToString(list);
        System.out.println("SELECT S.* FROM STUDENT_EXAM S WHERE S.ID IN("+listString+")");
        System.out.println();
        System.out.println("SELECT S.ID FROM STUDENT_EXAM S WHERE S.RECRUIT_ID ="+recruitId+" AND S.USER_ID= "+userId);

    }

    public static String listToString(List strings) {
        StringBuffer buffer = new StringBuffer();
        if (strings != null) {
            for (int i = 0; i < strings.size(); i++) {
                buffer.append(strings.get(i) + ",");
            }
            return buffer.toString().substring(0, buffer.toString().length() - 1);
        }
        return buffer.append(" ").toString();
    }

    public List<Integer> getDubbo2StuExamUser(Integer recruitId, Long userId){
        String sql = "SELECT S.ID FROM STUDENT_EXAM S WHERE S.RECRUIT_ID = ? AND S.USER_ID = ?  AND S.IS_DELETE = 0 ";
        List<Object> params = new ArrayList<Object>();
        params.add(recruitId);
        params.add(userId);
        return jdbcTemplate.queryForList(sql, params.toArray(), Integer.class);
    }
    public List<Integer> getDubboStuExamUser(Integer recruitId, Long userId){
        String sql = "SELECT S.ID FROM STUDENT_EXAM S WHERE S.RECRUIT_ID = ? AND S.USER_ID = ? AND S.IS_DELETE = 0 GROUP BY S.RECRUIT_ID, S.EXAM_ID, S.USER_ID";
        List<Object> params = new ArrayList<Object>();
        params.add(recruitId);
        params.add(userId);
        return jdbcTemplate.queryForList(sql, params.toArray(), Integer.class);
    }

    public String getAnswerUser(Integer recruitId, Integer examId) {
        String sql = "SELECT GROUP_CONCAT(Z.ANSWER_USER_ID) FROM Z_ANSWER Z WHERE Z.RECRUIT_ID = ? AND Z.EXAM_ID = ? AND Z.SCORE ='null'";
        List<Object> params = new ArrayList<Object>();
        params.add(recruitId);
        params.add(examId);
        return jdbcTemplateMyCat.queryForObject(sql, params.toArray(), String.class);

    }


    public Integer findRecruit(int courseId) {
        String sql = "SELECT ID FROM V2_RECRUIT REC WHERE REC.COURSE_ID = ? AND REC.IS_DELETE = 0 ";
        List<Object> params = new ArrayList<Object>(1);
        params.add(courseId);
        return jdbcTemplate.queryForObject(sql, params.toArray(), Integer.class);
    }

    public List<Integer> findStudentExam(int recruitId, int oldExamId) {
        String sql = "SELECT ID FROM STUDENT_EXAM SE WHERE SE.RECRUIT_ID = ? AND SE.EXAM_ID = ? AND SE.IS_DELETE = 0 ";
        List<Object> params = new ArrayList<Object>(2);
        params.add(recruitId);
        params.add(oldExamId);
        return jdbcTemplate.queryForList(sql, params.toArray(), Integer.class);
    }

    public boolean isFromParentExam(int newExamId, int parentExamId) {
        String sql = "SELECT IF(RANDOM_PARENT_ID=?, 1, 0) FROM EXAM WHERE EXAM_ID = ? ";
        List<Object> params = new ArrayList<Object>(2);
        params.add(parentExamId);
        params.add(newExamId);
        return jdbcTemplate.queryForObject(sql, params.toArray(), Boolean.class);
    }

    public String buildUpdateSql(Integer newExamId, List<Integer> ids) {
        String sql = "UPDATE STUDENT_EXAM SET EXAM_ID = ? WHERE ID IN (?) ";
        sql = sql.replaceFirst("\\?", newExamId.toString());
        sql = sql.replaceFirst("\\?", StringUtils.collectionToCommaDelimitedString(ids));
        return sql;
    }

    public String buildTableSql(int recruitId, int newExamId) {
        StringBuilder sBuilder = new StringBuilder("\n");
        sBuilder.append("DROP TABLE IF EXISTS test.2016_XZW_STU_EXAM_ERROR_").append(recruitId).append(";").append('\n');
        sBuilder.append("CREATE TABLE test.2016_XZW_STU_EXAM_ERROR_").append(recruitId).append('\n');
        sBuilder.append("SELECT S.ID,S.RECRUIT_ID,S.EXAM_ID,S.USER_ID").append('\n');
        sBuilder.append("FROM STUDENT_EXAM S WHERE ").append('\n');
        sBuilder.append("S.RECRUIT_ID  in (").append(recruitId).append(") AND S.EXAM_ID = ")
                .append(newExamId).append(" AND S.IS_DELETE = 0;").append('\n');
        return sBuilder.toString();
    }

}
