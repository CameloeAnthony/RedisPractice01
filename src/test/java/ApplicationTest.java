import com.anthony.redis.template.RedisService;
import com.anthony.redis.RedisApplication;
import com.anthony.redis.template.User;
import com.anthony.redis.mq.PublishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Description: </p>
 *
 * @author Anthony
 * @date 2020-04-22 4:00 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisApplication.class})
public class ApplicationTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private PublishService service;

    private static final Logger log = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    public void setUser1(){
        redisTemplate.opsForValue().set("user1",new User(1,"anthony","123","111"));
        User user1 = (User)redisTemplate.opsForValue().get("user1");
        log.info("save user "+user1);
    }

    @Test
    public void setUser2(){
        boolean flag= redisService.set("user2","user2Value");
        if(flag){
            log.info("success");
        }else{
            log.info("fail");
        }
    }

    @Test
    public void testRedisRemove(){
        boolean flag=redisService.remove("user1");
        if(flag){
            log.info("remove success");
        }else{
            log.info("remove fail");
        }
    }


    //    private PublishService service;
    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            service.publish("test-topic", "hello~~~" + i);
        }
    }

}
