package cn.kgc.movie.web;

import cn.kgc.movie.common.pojo.Order;
import cn.kgc.movie.web.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class MovieWebApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        String info = "12,14";
        String o="";
        ////以"· "为分隔符，截取上面的字符串。结果为五段
        String[] s1 = info.split(",");
        o=s1[0]+"排"+s1[1]+"坐";
        System.out.println(o);
    }

    @Test
    public void test01(){
        Random rand=new Random();
        for(int i=0;i<7;i++)
        {
            int s=rand.nextInt(32);
            System.out.println("生成随机数为 :"+s);
        }
    }

}
