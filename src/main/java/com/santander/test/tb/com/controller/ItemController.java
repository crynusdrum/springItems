package com.santander.test.tb.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santander.test.tb.com.model.Item;
import com.santander.test.tb.com.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping
	@Cacheable("itemList")
	public List<Item> itemList() {

		System.out.println("sem cache");
		return itemService.ItemList();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItem(@PathVariable Long id) {

		return Optional.ofNullable(itemService.getItem(id)).map(item -> ResponseEntity.ok().body(item)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Item itemCreate(@RequestBody Item item) {

		return itemService.itemSave(item);

	}

	@PostMapping("/itemsCreate")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Item> itemsCreate(@RequestBody List<Item> itemsList) {

		return itemService.itemsSave(itemsList);

	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Item itemUpdate(@RequestBody Item item) {

		return itemService.itemSave(item);

	}

	@DeleteMapping("/{itemId}")
	@ResponseStatus(HttpStatus.OK)
	public boolean itemDelete(@PathVariable Long itemId) {

		boolean isDeleted = true;
		itemService.itemDelete(itemId);

		return isDeleted;

	}

	@GetMapping("/getItem")
	public ResponseEntity<Item> getItem(@RequestBody Item item) {

		return Optional.ofNullable(itemService.findByIdAndNameAndOtherField(item))
				.map(itemObj -> ResponseEntity.ok().body(itemObj)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found

	}
	
    @GetMapping("/integrationTest")
    public String hello(@RequestParam(name = "name", defaultValue = "Test") String name) {
        return String.format("Integration, %s", name);
    }

}
