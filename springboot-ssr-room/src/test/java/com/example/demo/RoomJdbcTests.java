package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Room;
import com.example.demo.repository.RoomRepositoryJdbc;

@SpringBootTest
public class RoomJdbcTests {
	
	@Autowired
	@Qualifier("roomJdbc") // 因實作類別有別名，因此要輸入別名，方便查找要建立的實作類別
	private RoomRepositoryJdbc roomRepositoryJdbc; // 如果沒有寫 @Qualifier 則會去抓他的實作類別，因此兩個以上實作要寫

	@Test
	public void testRoomAdd() {
		Room room = new Room(101, "101(S)", 3);
		int rowcount = roomRepositoryJdbc.save(room);
		System.out.println("測試新增: " + room + " 結果回傳: " + rowcount);
	}
	
	@Test
	public void testFindAllRooms() {
		System.out.println("測試查詢全部: " + roomRepositoryJdbc.findAll());
	}
	
	@Test
	public void testGetOneRoom() {
		System.out.println("測試查詢單筆: " + roomRepositoryJdbc.findById(101));
		System.out.println("測試查詢單筆: " + roomRepositoryJdbc.findById(109));
	}
	
	@Test 
	void updateRoom() {
		Room uptRoom = new Room(101, "101(L)", 100);
		int rowcount = roomRepositoryJdbc.update(uptRoom);
		System.out.println("測試修改: " + uptRoom + " 結果回傳: " + rowcount + " (1 表示正確修改一筆)");
	}
	
	@Test 
	void deleteRoom() {
		int roomId = 101;
		int rowcount = roomRepositoryJdbc.deleteById(roomId);
		System.out.println("測試刪除: " + roomId + " 結果回傳: " + rowcount + " (1 表示刪除修改一筆)");
	}
	
}
