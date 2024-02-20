package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;
import com.example.ex00.dependency.qualifier.Outback;
import com.example.ex00.dependency.qualifier.Restaurant;
import com.example.ex00.dependency.qualifier.Vips;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QualifierTests {
	
	@Autowired
	@Qualifier("desktop")
	private Computer desktop;

	@Autowired
	@Qualifier("laptop")
	private Computer laptop;
	
	@Autowired
	private Computer computer;
	
	@Autowired
	@Qualifier("outback")
	private Restaurant outback;
	
	@Autowired
	@Qualifier("vips")
	private Restaurant vips;
	
	@Autowired
	private Restaurant restaurant;
	
//	@Test
//	public void testQualifier() {
//		log.info("=================");
//		log.info("computer: " + desktop);
//		log.info("screen width: " + desktop.getScreenWidth());
//		log.info("=================");
//		
//		log.info("=================");
//		log.info("computer: " + laptop);
//		log.info("screen width: " + laptop.getScreenWidth());
//		log.info("=================");
//
//		log.info("=================");
//		log.info("computer: " + computer);
//		log.info("screen width: " + computer.getScreenWidth());
//		log.info("=================");
//	}
	@Test
	public void testQualifier() {
		log.info("=================");
		log.info("outback: " + outback);
		log.info("outback salad: " + outback.hasSalad());
		log.info("steak price: " + Outback.steak);
		log.info("=================");
		
		log.info("=================");
		log.info("vips: " + vips);
		log.info("vips salad: " + vips.hasSalad());
		log.info("steak price: " + Vips.steak);
		log.info("=================");

		log.info("=================");
		log.info("vips: " + restaurant);
		log.info("vips salad: " + restaurant.hasSalad());
		log.info("steak price: " + Restaurant.steak);
		log.info("=================");
	}
}

















