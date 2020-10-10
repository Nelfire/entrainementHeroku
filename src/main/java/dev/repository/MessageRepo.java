package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entites.Message;

/**
 * Repository de l'entité Collegue
 * 
 * @author KOMINIARZ Anaïs, SAGAN Jonathan, BATIGNES Pierre, GIRARD Vincent.
 *
 */
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
