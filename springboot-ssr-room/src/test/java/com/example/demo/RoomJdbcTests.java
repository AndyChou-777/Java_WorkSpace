package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.RoomRepositoryJdbc;

@SpringBootTest
public class RoomJdbcTests {
	
	@Autowired
	@Qualifier("roomJdbc") // 因實作類別有別名，因此要輸入別名，方便查找要建立的實作類別
	private RoomRepositoryJdbc roomRepositoryJdbc; // 如果沒有寫 @Qualifier 則會去抓他的實作類別，因此兩個以上實作要寫

}
