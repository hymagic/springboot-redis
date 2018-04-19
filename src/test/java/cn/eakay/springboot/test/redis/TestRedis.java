package cn.eakay.springboot.test.redis;

import cn.eakay.springboot.biz.EakayService;
import cn.eakay.springboot.client.Eakay;
import cn.eakay.springboot.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by magic~ on 2018/4/17.
 */
public class TestRedis extends BaseTest
{

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EakayService eakayService;

    @Test
    public void testSet()
    {
        Eakay eakey=new Eakay();
        eakey.setId(1);
        eakey.setEid(1);
        eakey.setName("naaa");
        eakey.setTitle("taaa");
        eakey.setCreatetime(new Date());
        eakey.setUpdatetime(new Date());
        eakayService.set(eakey);

    }
    @Test
    public void testGet()
    {
        Eakay eakey=new Eakay();
        eakey.setId(1);
        Eakay eakay1=  eakayService.get(eakey);
        logger.info(eakay1.getName());

    }


}
