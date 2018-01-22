package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
