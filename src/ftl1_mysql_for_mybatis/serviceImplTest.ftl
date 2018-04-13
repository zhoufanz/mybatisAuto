
import com.yung.couponconfig.domain.Strategy;
import com.yung.couponconfig.service.StrategyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ${entity}ServiceImplTest {

    @Autowired
    private ${entity}Service ${lowerentity}Service;

    @Test
    public void insertSelective() {

    }

    @Test
    public void selectByPrimaryKey() {
        Integer id = 1;
        ${entity} ${lowerentity} = this.${lowerentity}Service.selectByPrimaryKey(id);
        System.out.println("*************");
        System.out.println(${lowerentity}.getId());
    }

    @Test
    public void updateByPrimaryKeySelective() {

    }
}
