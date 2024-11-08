package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.entity.Room;

@Component // 此元件由 Springboot 自動掃描後管理
public class RoomMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 	此方式和上面注入相同，只是這個方式可以在注入之前處理其他程式或資料
	 * 
	 *  private ModelMapper modelMapper;
	 *  
	 *  @Autowired
	 *  public RoomMapper(ModelMapper modelMapper) {
	 *  // ...
	 *  this.modelMapper = modelMapper;
	 *  }
	 */
	
	public RoomDto toDto(Room room) {
		// Entity 轉 DTO
		return modelMapper.map(room, RoomDto.class);
	}
	
	public Room toEntity(RoomDto roomDto) {
		// DTO 轉 Entity 
		return modelMapper.map(roomDto, Room.class);
	}
	
}
