package serviceTest;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */


public class DaoTest extends BaseTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void testMenuDaoQueryAll() {
        List<Menu> menuList = menuDao.queryAll();
        System.out.println(menuList);
    }
}
