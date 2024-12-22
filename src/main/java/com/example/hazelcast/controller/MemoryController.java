package com.example.hazelcast.controller;

import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryController {
    @Autowired
    IMap<String, String> nameMap;
    @RequestMapping(path = "/getValue")
    public String getValue(@RequestParam(name="key") String key) {
      return nameMap.get(key);
    }

    @RequestMapping(path = "/putValue")
    public String putValue(@RequestParam(name="key") String key, @RequestParam(name="value") String value) {
        nameMap.put(key,value);
        return "ok";
    }
}
