package org.binhkieu.bai3;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class Bai3Cache {
	Cache<Integer, Integer> cache;
	public Bai3Cache() {
		// TODO Auto-generated constructor stub
		cache=CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(10, TimeUnit.SECONDS).build();
	}
	
	public int CheckLoadingCache(int key) {
		if(cache.getIfPresent(key)==null) {
			cache.put(key, 1);
			return 1;
		}else if(cache.getIfPresent(key)<3 ) {
			int value=cache.getIfPresent(key);
			cache.put(key, value+=1);
			return 0;
		}else {
			return 2;
		}	
	}
}
