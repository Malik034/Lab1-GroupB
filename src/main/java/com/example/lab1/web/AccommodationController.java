package com.example.lab1.web;

import com.example.lab1.model.Accommodation;
import com.example.lab1.services.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> findAll(){
        return ResponseEntity.ok(this.accommodationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id){
        Accommodation accommodation = this.accommodationService.findById(id);
        if(accommodation == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(accommodation);
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody Accommodation accommodation){
        Accommodation accommodation1 = this.accommodationService.save(accommodation);
        if(accommodation1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(accommodation1);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> editAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodation){
        Accommodation accommodation1 = this.accommodationService.update(id, accommodation);
        if(accommodation1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(accommodation1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id){
        Accommodation accommodation = this.accommodationService.findById(id);
        if(accommodation !=null) {
            this.accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/rented/{id}")
    public ResponseEntity<Accommodation> rented(@PathVariable Long id) {
        Accommodation accommodation1 = accommodationService.setRented(id);
        if(accommodation1 == null){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok().body(accommodation1);
    }
}
