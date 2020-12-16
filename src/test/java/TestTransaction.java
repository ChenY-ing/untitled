import com.bdqn.dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {
    private ApplicationContext ctx=null;
    private BookDao bookDao=null;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        bookDao=(BookDao)ctx.getBean("bookDaoImpl");
    }

    @Test
    public void testBookDao(){
        bookDao.updateUserAccount("cy",1000);
    }
}
