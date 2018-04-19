package cn.eakay.springboot.biz;

import cn.eakay.springboot.client.Eakay;

/**
 * Created by magic~ on 2018/4/17.
 */
public interface EakayService
{
    public  void flushdb();

    public  void set(Eakay eakay);
    public  Eakay  get(Eakay eakay);

    public  void  setHash(Eakay eakay);
    public  Eakay  getHash(Eakay eakay);



}
