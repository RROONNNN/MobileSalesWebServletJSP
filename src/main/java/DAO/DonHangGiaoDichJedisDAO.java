package DAO;

import com.google.gson.Gson;

import Config.RedisConfig;
import Model.Cart;
import Model.CartJsonOnlyIdRef;
import Model.DonHangGiaoDich;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class DonHangGiaoDichJedisDAO {
	private JedisPool jedisPool ;
public DonHangGiaoDichJedisDAO() {
	 jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);
}
public void addElement(DonHangGiaoDich dhgd  ) {
    Gson gson=new Gson();
	  	String dhgdJson=gson.toJson(dhgd);
 	String key=RedisConfig.getKeyHoaDonGiaoDich(dhgd.getTransactionId());
	  //	String key="HoaDonGiaoDich:"+dhgd.getTransactionId();
	  	try (Jedis jedis=jedisPool.getResource()){
	  		jedis.set(key, dhgdJson);
	  		jedis.expire(key, 60*60);//1 gio
	  		
	  	}
}
public DonHangGiaoDich GetElement(String transactionid) {

  	try (Jedis jedis=jedisPool.getResource()){
  		String key=RedisConfig.getKeyHoaDonGiaoDich(transactionid);
  	 	String json =	jedis.get(key);
  	//String json =	jedis.get("HoaDonGiaoDich:"+transactionid);
  	Gson gson=new Gson();
  	DonHangGiaoDich dhgd=gson.fromJson(json, DonHangGiaoDich.class);
 	return dhgd;
  	}

}

public static void main(String[] args) {
	SanPhamDAO daosp=new SanPhamDAO();
    Cart cart=new Cart();
    cart.addSanPham(daosp.findById(1));
    cart.addSanPham(daosp.findById(2));

    cart.addnumSanPham(2);

    cart.addnumSanPham(3);
    
    CartJsonOnlyIdRef cartJsonOnlyIdRef=new CartJsonOnlyIdRef();
	DonHangGiaoDichJedisDAO dao =new DonHangGiaoDichJedisDAO();
	DonHangGiaoDich dhgDich=new DonHangGiaoDich("123","984731922124","Nguyen Ron","kim long em oi",cartJsonOnlyIdRef);
	//dao.addElement(dhgDich);
	DonHangGiaoDich donHangGiao=dao.GetElement("123");
	System.out.println(donHangGiao.getSDTKhachHang());
}
}
