package junittesting;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hotel.beans.HotelBeans;
import com.hotel.services.AdminService;

public class MockitoTest {

	AdminService adminservice;
	@Before
	public void setUp()
	{
		adminservice=mock(AdminService.class);
		
	}
	@Test
	public void insertTest(){
		 
		HotelBeans hb=new HotelBeans();  
		hb.setId(6);
		hb.setHotel("Balaji Resort");
		hb.setCity("Hydrabaad");
		hb.setCheckin("01/01/2017");
		hb.setCheckout("06/02/2017");
		hb.setNofrooms("40");
		when(adminservice.insert(hb)).thenReturn(1);
		System.out.println("Insert Article Mockito Test:" + adminservice.insert(hb));
		assertEquals(adminservice.insert(hb), 1);
	}
	
	
	
	@Test
	public void getCityTest() 
	{  when(adminservice.getCity()).thenReturn(new java.util.ArrayList());
		System.out.println("Get All Articles Mockito Test:" + adminservice.getCity());
		assertEquals(adminservice.getCity(), new java.util.ArrayList());
	}
	
	@Test
	public void getAllHotels() 
	{  when(adminservice.getAllHotels()).thenReturn(new java.util.ArrayList());
		System.out.println("Get All Articles Mockito Test:" + adminservice.getAllHotels());
		assertEquals(adminservice.getAllHotels(), new java.util.ArrayList());
	}
	
	@Test
	public void getCityFromHotel() 
	{  when(adminservice.getCityFromHotel()).thenReturn(new java.util.ArrayList());
		System.out.println("Get All Articles Mockito Test:" + adminservice.getCityFromHotel());
		assertEquals(adminservice.getCityFromHotel(), new java.util.ArrayList());
	}
	
	@Test
	public void getHotelFromCityTest()
	{  when(adminservice.getHotelFromCity("Balaji Resort")).thenReturn(new java.util.ArrayList());
		System.out.println("Get All Articles Mockito Test:" + adminservice.getHotelFromCity("Balaji Resort"));
		assertEquals(adminservice.getHotelFromCity("Balaji Resort"), new java.util.ArrayList());
	}
	

}
