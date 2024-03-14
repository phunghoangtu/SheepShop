package com.example.sheepshop.repositorys;

import com.example.sheepshop.entitys.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {
}
