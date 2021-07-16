package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pokemon")
public class DemoController {

    @Autowired
    private DemoRepository _demoRepository;

    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<String> create(
            @RequestBody Demo createItem
    ) {
        _demoRepository.save(createItem);
        return ResponseEntity.ok("Item salvo");
    }

    @GetMapping("/{num}")
    public ResponseEntity<Demo> getNum(@PathVariable("num") Long num) {
        Optional<Demo> demo = _demoRepository.findById(num);
        if(demo.isPresent())
            return new ResponseEntity<Demo>(demo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{num}")
    public ResponseEntity<Demo> putNum(@PathVariable("num") Long num) {
        Optional<Demo> oldDemo = _demoRepository.findById(num);
        if(oldDemo.isPresent()){
            Demo demo = oldDemo.get();
            _demoRepository.save(demo);
            return new ResponseEntity<Demo>(demo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<String> deleteNum(@PathVariable("num") Long num) {
        Optional<Demo> demo = _demoRepository.findById(num);
        if(demo.isPresent()){
            _demoRepository.delete(demo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Demo> findAll() {
        return _demoRepository.findAll();
    }

    @GetMapping("/{pagina}/{quantidade}")
    public List<Demo> getPaginate(@PathVariable("pagina") Integer pagina,
                                  @PathVariable("quantidade") Integer quantidade) {
        Pageable paging = PageRequest.of(pagina, quantidade);
        Page<Demo> pagedResult = _demoRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Demo>();
        }
    }


    

}