package com.example.demo.repository;


import com.example.demo.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> { 
    String SQL_BASE = "SELECT A FROM Demo A WHERE 1=1";
    String SQL_TIPO_POKEMON = SQL_BASE + " AND A.tipo = ?1";

    @Query(value = SQL_TIPO_POKEMON)
    List<Demo> findPokemonsTipo(String tipo);
}