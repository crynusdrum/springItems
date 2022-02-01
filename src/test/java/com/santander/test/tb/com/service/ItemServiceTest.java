package com.santander.test.tb.com.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.santander.test.tb.com.model.Item;

@SpringBootTest
class ItemServiceTest {
	
	@MockBean
	ItemService itemService;
	

	@Test
	@DisplayName("Unit test for getItem")
	void getItem() {
		
		Item itemMock = buildingItem(1L);
		
		when(itemService.getItem(1L)).thenReturn(itemMock);
		assertNotNull(itemMock);
		
	}
	
	private Item buildingItem(Long itemId) {
		
		Item item = new Item();
		item.setId(itemId);
		item.setName("name");
		
		return item;
		
	}

}
