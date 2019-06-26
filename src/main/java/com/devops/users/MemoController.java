package com.devops.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
//	创建开封备忘
	@RequestMapping(value = "/setmemo", method = RequestMethod.GET)
    public Object setMemo(@RequestParam(value = "product_name", required = true) String product_name,
    		@RequestParam(value = "user_id", required = true) String user_id){
        return memoService.setMemo(product_name, user_id);
    }
    
//	查看用户的所有备忘
    @RequestMapping(value = "/getusermemo", method = RequestMethod.GET)
    public Object getUserMemo(@RequestParam(value = "user_id", required = true) String user_id){
        return memoService.getUserMemo(user_id);
    }
    
    
//  查看是否过期
    @RequestMapping(value = "/isexpired", method = RequestMethod.GET)
    public Object isExpired(@RequestParam(value = "memo_id", required = true) String memo_id){
        return memoService.isExpired(memo_id);
    }
}
