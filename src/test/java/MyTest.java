import com.zxc.pojo.Books;
import com.zxc.service.BookService;
import com.zxc.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookServiceImpl.class);
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }

    }
}
