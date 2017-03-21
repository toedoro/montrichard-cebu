/**
 * 
 */
package ph.com.montrichard.bisaya.order.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import ph.com.montrichard.bisaya.order.entity.Order;

/**
 * Mar 18, 2017 10:06:11 PM
 * @version 1.0
 * @author © tdelacerna <delacerna_teodoro@yahoo.com>
 */
@Service
public class OrderService {
	
	Set<Order> orders = new HashSet<>();
	
	public Collection<Order> read( Integer offSet, Integer limit ){
//		return orders.subList(offSet, limit);
		return orders;
	}
	
	public Order create( Order order ){
		Integer size = orders.size();
		String orderNo = String.format("ORDER000%s", size+1);
		BigInteger id = new BigInteger( new String(size+1+"") );
		order.setId(id);
		order.setCreatedDate(new Date());
		order.setOrderNo(orderNo);
		order.setStatus("Waiting For Confirmation");
		orders.add( order );
		
		return order;
	}
	
	public Order update( Order order ){
		if( !orders.add( order ) ){
			orders.remove( order );
			orders.add( order );
		}
		return order;
	}
	
}