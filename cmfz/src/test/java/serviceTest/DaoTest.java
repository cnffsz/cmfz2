package serviceTest;

import com.baizhi.dao.ChapterDao;
import com.baizhi.dao.MenuDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Menu;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */


public class DaoTest extends BaseTest {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void testMenuDaoQueryAll() {
        List<Menu> menuList = menuDao.queryAll();
        System.out.println(menuList);
    }

    @Test
    public void testChapterDaoQueryAll() {
        List<Chapter> chapterList = chapterDao.queryAll();
        System.out.println(chapterList);
    }

    //--------------UserDao------------------
    @Test
    public void testUserQuery() {
        Integer integer = userDao.query("M", 1);
        System.out.println(integer);
    }

    @Test
    public void testUserQueryByprovince() {
        List<UserDto> userDtoList = userDao.queryByprovince("M");
        System.out.println(userDtoList);
    }



}
