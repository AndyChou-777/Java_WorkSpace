package com.example.tx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	private Integer BookId; // 書號
	private String BookName; // 書名
	private Integer BookPrice; // 價格
	
}
