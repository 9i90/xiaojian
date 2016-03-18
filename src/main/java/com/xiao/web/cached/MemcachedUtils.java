package com.xiao.web.cached;

import com.alisoft.xplatform.asf.cache.memcached.client.MemCachedClient;
import com.alisoft.xplatform.asf.cache.memcached.client.SockIOPool;
import com.xiao.web.utils.SpringInfo;

public class MemcachedUtils {
    private MemcachedUtils() {  }  
    public static MemCachedClient getMemcachedClient(){
    	return (MemCachedClient)SpringInfo.getBean("memCachedClient");
    }
    public static MemCachedClient getDemo(){
    	SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(new String[]{"192.168.1.252:12306"});
		Integer[] weights = {3, 2};
        pool.setWeights(weights);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);
        pool.initialize();
//		pool.getConnection("192.168.1.252:12306").;
		MemCachedClient client = new MemCachedClient();
		return client;
    }
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
    
}
