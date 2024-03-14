package com.example.sheepshop.repositorys;

import com.example.sheepshop.entitys.HandStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HandStyleRepository extends JpaRepository<HandStyle, UUID> {
}
