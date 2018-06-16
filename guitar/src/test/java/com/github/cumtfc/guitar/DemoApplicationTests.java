package com.github.cumtfc.guitar;

import com.github.cumtfc.guitar.application.DemoApplication;
import com.github.cumtfc.guitar.service.GuitarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Rollback
@Transactional
public class DemoApplicationTests {

    @Autowired
    GuitarService guitarService;

    @Test
    public void testFindAllGuitars() {
        guitarService.getAll().forEach(guitar -> {
            System.out.println(guitar.toString());
        });
    }
}
