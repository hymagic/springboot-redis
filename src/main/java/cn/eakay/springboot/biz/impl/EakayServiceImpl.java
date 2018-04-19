package cn.eakay.springboot.biz.impl;

import cn.eakay.springboot.biz.EakayService;
import cn.eakay.springboot.client.Eakay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by magic~ on 2018/4/17.
 * redisTemplate序列化 {@link cn.eakay.springboot.config.redis.RedisConfig}
 * 无需手动转换json
 */
@Service
public class EakayServiceImpl implements EakayService
{

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisTemplate redisTemplate;




   /*  ValueOperations<K, V> valueOps;
       ListOperations<K, V> listOps;
       SetOperations<K, V> setOps;
       ZSetOperations<K, V> zSetOps;
       GeoOperations<K, V> geoOps;
       HashOperations<K,K,KV>
     */


    public void flushdb(){
        redisTemplate.execute(new RedisCallback<Object>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException
            {
                connection.flushDb();
                return "ok";
            }
        });
    }




    @Override
    public void set(Eakay eakay)
    {
        ValueOperations<String, Eakay> value=redisTemplate.opsForValue();
        value.set(eakay.getId().toString(),eakay);

/*
        ValueOperations<String, String> value=redisTemplate.opsForValue();
        value.set("wzg", "nihao");
        value.set("wzg", "nihao",3);
        value.set("wzg2", "nihao",2,TimeUnit.MINUTES);
        value.set("mc", "nihao");
        value.setIfAbsent("wzg", "dsg");
        Map<String, String> map = new HashMap<String, String>();
        map.put("cff", "xsg");
        map.put("cl", "xxsg");
        value.multiSet(map);
        value.append("cff", " sm");
        value.increment("age", 2);
        value.increment("age", 1);
        value.increment("age", -1);
        value.delete("mc");
        value.convertAndSend("redisss", "niyashabi");
        value.setEnableTransactionSupport(true);*/

    }

    @Override
    public Eakay get(Eakay eakay)
    {
        ValueOperations<String, Eakay> value=redisTemplate.opsForValue();
        return  value.get(eakay.getId().toString());


       /* ValueOperations<String, String> value=redisTemplate.opsForValue();
        value.get("wzg");
        value.get("wzg",1,2);
        value.getAndSet("wzg", "hello");
        value.get("wzg");
        value.multiGet(Arrays.asList("cff","cl"));

        value.size("wzg");
        value.get("mc");
        redisTemplate.keys("*");
        redisTemplate.randomKey();
        redisTemplate.getClientList();
        redisTemplate.hasKey("wzg");
        redisTemplate.type("wzg");*/


    }

    @Override
    public void setHash(Eakay eakay)
    {
       HashOperations<String,String,Eakay>  hash= redisTemplate.opsForHash();
       hash.put("groupid",eakay.getId().toString(),eakay);



    /*    Map<String, Eakay> map = new HashMap<String, Eakay>();
        map.put("1", eakay);
        map.put("2", eakay);
        hash.putAll("groupid", map);
        hash.putIfAbsent("groupid", "1", eakay);
        hash.increment("groupid", "1", 1l);
        hash.delete("groupid",new String[]{"1","2"});
*/



    }

    @Override
    public Eakay getHash(Eakay eakay)
    {
        HashOperations<String,String,Eakay>  hash= redisTemplate.opsForHash();

        /*List<Eakay> list= hash.multiGet("groupid",Arrays.asList("1","2"));
        hash.hasKey("groupid", "1");
        hash.entries("groupid");
        hash.keys("groupid");
        hash.values("groupid");
        hash.size("groupid");*/

        return  hash.get("groupid",eakay.getId().toString());

    }

    private List<Eakay> setList()
    {
        //ListOperations<String, Eakay> list=redisTemplate.opsForList();


       /* ListOperations<String, String> vo = redisTemplate.opsForList();
        vo.leftPush("book", "wzg");
        vo.leftPushAll("book", "cff","cl","mc");
        vo.leftPush("book", "cl", "||");
        vo.rightPush("book", "yw");
        vo.rightPushAll("book", "sj","jy");
        vo.rightPush( "book", "sj", "||");
        vo.leftPop("book");
        vo.rightPop("book");
        vo.rightPopAndLeftPush("book", "bag");
        vo.set("book", 0, "gzf");
        vo.leftPush("bag", "||");
        vo.remove("bag", 3, "||");
*/
        return null;
    }


    private List<Eakay> getList()
    {
       /* ListOperations<String, Eakay> list=redisTemplate.opsForList();


        ListOperations<String, String> vo = redisTemplate.opsForList();
        vo.range("book", 0, -1);
        vo.trim("book", 2, 3);
        vo.range("book", 0, -1);
        vo.size("book");
        vo.range("bag", 0, -1);
        vo.index("book", 1);
        */
        return null;
    }









}
