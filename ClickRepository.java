package com.example.shortener.feature.link.repository;
import com.example.shortener.feature.link.entity.Click; import org.springframework.data.domain.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface ClickRepository extends JpaRepository<Click,Long>{Page<Click> findByShortLinkId(Long id,Pageable p); long countByShortLinkId(Long id);}
