import com.bdqn.dao.BookDao;
import com.bdqn.service.BookService;
import com.bdqn.service.BookServiceImpl;
import com.bdqn.service.Cashier;
import com.bdqn.service.CashierImpl;
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
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        bookDao=(BookDao)ctx.getBean("bookDaoImpl");
        bookService= (BookService) ctx.getBean("bookServiceImpl");
        cashier= (Cashier) ctx.getBean("cashierImpl");
    }

    @Test
    public void testPropagation(){
        cashier.checkout("cc", Arrays.asList(1001,1002));
    }

    @Test
    public void testBookDao(){
//        bookDao.updateUserAccount("cy",1000);
        bookDao.updateBookStock(1002);
    }

    @Test
    public void testTransaction(){
        bookService.purchase("cy",1001);
    }
}
