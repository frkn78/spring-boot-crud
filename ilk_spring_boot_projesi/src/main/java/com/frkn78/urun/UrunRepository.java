package com.frkn78.urun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Bu arayüzün bir Spring Data JPA repository'si olduğunu belirtir

public interface UrunRepository extends JpaRepository<Urun, Long> {
    // JpaRepository, temel CRUD işlemleri (save, findById, findAll, deleteById vb.) için hazır metotlar sunar.
    // İhtiyaç duyarsanız buraya özel sorgu metotları da tanımlayabilirsiniz.
}
