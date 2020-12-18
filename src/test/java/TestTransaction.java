import com.bdqn1.dao.BookDao;
import com.bdqn1.service.BookService;
import com.bdqn1.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestTransaction {
    private ApplicationContext ctx=null;
    private BookDao bookDao=null;
    private BookService bookService=null;
    private Cashier cashier=null;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc1.xml");
        bookDao=(BookDao)ctx.getBean("bookDao");
        bookService= (BookService) ctx.getBean("bookService");
        cashier= (Cashier) ctx.getBean("cashier");
    }

    @Test
    public void testPropagation(){
        cashier.checkout("cy", Arrays.asList(1001,1002));
    }

    @Test
    public void testBookDao(){
//        bookDao.updateUserAccount("cy",1000);
        bookDao.updateBookStock(1002);
    }

    @Test
    public void testTransaction(){
        bookService.purchase("cc",1001);
    }
}
