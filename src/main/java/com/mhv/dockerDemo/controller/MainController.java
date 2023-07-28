package com.mhv.dockerDemo.controller;

import com.mhv.dockerDemo.dao.DemoRepository;
import com.mhv.dockerDemo.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/test")
    public ResponseEntity<String> testController(){
        return ResponseEntity.ok().body("Controller response !");
    }

    @GetMapping("/add-data/{name}")
    public ResponseEntity<String> addDummyData(@PathVariable("name") String name){
        DemoEntity demoEntity = new DemoEntity(name);
        return demoRepository.addData(demoEntity) ? ResponseEntity.ok().body("SUCCESS") : ResponseEntity.internalServerError().body("FAILED");
    }

    @GetMapping("/get-data")
    public ResponseEntity<DemoEntity> getData(){
        Optional<DemoEntity> optionalDemoEntity = demoRepository.getData(1);
        return optionalDemoEntity.map(demoEntity -> ResponseEntity.ok().body(demoEntity)).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/get-all-data")
    public ResponseEntity<List<DemoEntity>> getAllData(){
        Optional<List<DemoEntity>> optionalDemoEntityList = demoRepository.getAllData();
        return optionalDemoEntityList.map(demoEntity -> ResponseEntity.ok().body(demoEntity)).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
