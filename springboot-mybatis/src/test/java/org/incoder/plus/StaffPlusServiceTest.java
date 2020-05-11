package org.incoder.plus;

import org.incoder.plus.entity.Staff;
import org.incoder.plus.service.impl.StaffServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * MyBatis Plus Service CRUD
 *
 * @author : Jerry xu
 * @date : 2019/10/28  00:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StaffPlusServiceTest {

    @Resource
    private StaffServiceImpl staffService;

    @Test
    public void getById() {
        Staff staff = staffService.getById(1);
        System.out.println(staff);
    }



}
