package com.frkn78.urun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/urunler") // Temel API yolu

public class UrunController {
    private List<Urun> urunler = new ArrayList<>();
    private long nextId = 1;

    @Autowired
    private UrunRepository urunRepository;

    @GetMapping
    public List<Urun> getAllUrunler() {
        return urunRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Urun> getUrunById(@PathVariable Long id) {
        Optional<Urun> urun = urunRepository.findById(id);
        return urun.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Urun> createUrun(@RequestBody Urun urun) {
        Urun kaydedilenUrun = urunRepository.save(urun);
        return new ResponseEntity<>(kaydedilenUrun, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Urun> updateUrun(@PathVariable Long id, @RequestBody Urun guncellenenUrun) {
        Optional<Urun> mevcutUrun = urunRepository.findById(id);
        if (mevcutUrun.isPresent()) {
            guncellenenUrun.setId(id); // Güncellenecek ürünün ID'sini ayarla
            Urun kaydedilenUrun = urunRepository.save(guncellenenUrun);
            return new ResponseEntity<>(kaydedilenUrun, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrun(@PathVariable Long id) {
        if (urunRepository.existsById(id)) {
            urunRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}