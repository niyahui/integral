package com.jk.integral.utils;

import java.util.HashMap;
import java.util.Map;

public class ReturnMsgUtils {

	
	
	/**
	 * <pre>returnMsg(返回工具类)   
	 * 创建人：郭峪诚 15201017556@163.com
	 * 创建时间：2020年10月27日 上午9:39:03    
	 * 修改人：郭峪诚 15201017556@163.com 
	 * 修改时间：2020年10月27日 上午9:39:03    
	 * 修改备注： 
	 * @param code
	 * @param message
	 * @param obejct
	 * @return</pre>
	 */
	public static Map returnMsg(Integer code,String message,Object obejct) {
		Map map = new HashMap();
		map.put("code", code);
		map.put("message", message);
		map.put("data", obejct);
		return map;
	}
}
