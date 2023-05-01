package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MenuController {
    private List<Menu> myMenu = new ArrayList();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/menu")
    public ResponseEntity getMenu(@RequestParam(value ="id") Long id) {
        Menu itemToReturn = null;
        for (Menu menu : myMenu) {
            if (menu.getID() == id)
                itemToReturn = menu;
        }
        return ResponseEntity.ok(itemToReturn);
    }

    @PostMapping(value = "/addMenuItem")
    public ResponseEntity addToMenu(@RequestParam(value ="name") String name,
                                    @RequestParam(value ="type") Integer type,
                                    @RequestParam(value ="price") Integer price,
                                    @RequestParam(value ="status") Integer status) {
        myMenu.add(new Menu(counter.incrementAndGet(), name, type, price, status));
        return ResponseEntity.ok(myMenu);
    }

    @PutMapping(value = "/updatemenu")
    public ResponseEntity updateMenu(@RequestParam(value ="id") Long id,
                                       @RequestParam(value ="name") String name,
                                       @RequestParam(value ="type") Integer type,
                                       @RequestParam(value ="price") Integer price,
                                       @RequestParam(value ="status") Integer status) {
        myMenu.forEach(Menu -> {
            if (Menu.getID() == id) {
                Menu.setName(name);
                Menu.setType(type);
                Menu.setPrice(price);
                Menu.setStatus(status);
            }
        });
        return ResponseEntity.ok(myMenu);
    }

    @DeleteMapping(value = "/deletemenuitem")
    public ResponseEntity removeMenu(@RequestParam(value ="id") Long id) {
        Menu itemToRemove = null;
        for (Menu menu : myMenu) {
            if (menu.getID() == id)
                itemToRemove = menu;
        }
        myMenu.remove(itemToRemove);
        return ResponseEntity.ok(myMenu);
    }
}