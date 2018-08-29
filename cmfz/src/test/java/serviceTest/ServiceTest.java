package serviceTest;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */
public class ServiceTest extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private BannerService bannerService;

    @Test
    public void testMenuQueryAll() {
        List<Menu> menus = menuService.queryAll();
        System.out.println(menus);
    }

    @Test
    public void testBannerQueryByPage() {
        List<Banner> bannerList = bannerService.queryByPage(1, 2);
        System.out.println(bannerList);
    }

    @Test
    public void testBannerAdd() {
    }
}
