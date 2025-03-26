package com.example.lab1.web;

import com.example.lab1.model.Host;
import com.example.lab1.services.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public ResponseEntity<List<Host>> findAll(){
        return ResponseEntity.ok(this.hostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id){
        Host host = this.hostService.findById(id);
        if (host == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(host);
    }

    @PostMapping("/add")
    public ResponseEntity<Host> addHost(@RequestBody Host host) {
        Host host1 = this.hostService.save(host);
        if(host1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(host1);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Host> editHost(@PathVariable Long id, @RequestBody Host host){
        Host host1 = this.hostService.update(id, host);
        if (host1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(host1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id){
        Host host1 = this.hostService.findById(id);
        if(host1 != null){
            this.hostService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}