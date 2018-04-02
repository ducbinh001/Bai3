package org.binhkieu.bai3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai3")
public class Bai3Controller {
	Bai3Cache cache;
	
	public Bai3Controller() {
		// TODO Auto-generated constructor stub
		cache=new Bai3Cache();
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping(value="/{var}", method=RequestMethod.GET)
	public ResponseEntity<List<Integer>> getSo(@PathVariable("var") int var) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<=var;i++) {
			list.add(i);
		}
		if(cache.cache==null) {
			System.out.println(cache.cache.asMap());
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		}else if(cache.CheckLoadingCache(var)==2) {
			System.out.println(cache.cache.asMap());
			return new ResponseEntity("TOO MANY REQUEST TO THE SAME VAR ",HttpStatus.TOO_MANY_REQUESTS);
		}else {
			System.out.println(cache.cache.asMap());
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		}
	}
}
