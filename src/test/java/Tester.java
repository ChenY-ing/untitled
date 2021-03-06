import com.bdqn.test.Grade;
import com.bdqn.test.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate=null;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    @Test
    public void test(){

    }

    @Test
    public void testNonQuery(){
        DataSource ds= (DataSource) ctx.getBean("dataSource");
        String sql="insert grade value(null,?)";
        int r=jdbcTemplate.update(sql,"Y4");
        //测试
        System.out.println(r>0?"插入成功":"插入失败");
    }

    //批量更新
    @Test
    public void testBatchUpdate(){
        String sql="insert grade value(null,?)";
        List<Object[]> list=new ArrayList<Object[]>();
        list.add(new Object[]{"A1"});
        list.add(new Object[]{"A2"});
        list.add(new Object[]{"A3"});
        int [] result = jdbcTemplate.batchUpdate(sql, list);
        for (int i :result) {
            System.out.println(i>0?"插入成功":"插入失败");
        }
    }

    @Test
    public void testQueryObject(){
        String sql="select * from myschool.student where StudentNo=?";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, "S1101001");
        System.out.println(student);
    }

    @Test
    public void testQueryforList(){
        String sql="select * from myschool.student";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> student = jdbcTemplate.query(sql, rowMapper);
        System.out.println(student.size());
    }

    @Test
    public void testQueryforSingle(){
        String sql="select address from myschool.student where studentNo=?";
        String s=jdbcTemplate.queryForObject(sql,String.class,"S1101001");
        System.out.println(s);
    }

    @Test
    public void testNamedParameter(){
        String sql="insert grade values(null,:gradeName)";
        Grade g=new Grade();
        g.setGradeName("B1");

        SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(g);
        int update = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(update>0?"插入成功":"插入失败");
    }
}
