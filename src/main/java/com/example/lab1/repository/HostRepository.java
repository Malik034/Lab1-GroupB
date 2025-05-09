package com.example.lab1.repository;

import com.example.lab1.model.domain.Host;
import com.example.lab1.model.projections.HostNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    List<HostNameProjection> findAllBy();
}
