package serviceTest;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Menu;
import com.baizhi.service.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 晨妃 on 2018/8/29.
 */
public class ServiceTest extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterServcie;
    @Autowired
    private UserService userService;

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
    public void testBannerSave() {
        Banner banner = new Banner();
        banner.setCreateDate(new Date());
        bannerService.save(banner);
        System.out.println("ok");
    }

    @Test
    public void testBannerDelete() {
        bannerService.delete(5);
        System.out.println("ok----------------------");
    }

    @Test
    public void saveAlbumUUIDSave() {
        int i;
        for (i = 0; i < 10; i++) {
            String s = UUID.randomUUID().toString();
            String uuid = s.replace("-", "");
            System.out.println(uuid);
        }
    }

    @Test//插入专辑测试通过只测试了ID
    public void saveAlbumServiceSave() {
        Album album = new Album();
        album.setId("test");
        albumService.save(album);
        System.out.println("ok");
    }

    @Test
    public void testDtea() {
        long l1 = 2000;
        long l2 = 1000;
        double d = l1 / 1000;
        int i = (int) d;
        System.out.println(i);
    }

    @Test
    public void testChapterSave() {
        Chapter chapter = new Chapter();
        chapter.setAlbumId("test");
        chapterServcie.save(chapter);
        System.out.println("ok");
    }

    //-----------------UserService-----------
    @Test
    public void testUserQuery() {
        Map<String, Object> map = userService.query();
        System.out.println("----------------ok-----------------");
        System.out.println(map);

    }
}
