package com.inventorymanagementsystem.inventory.management.system.data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 3/15/23<br>
 * Interface: DAO<br>
 * Description:
 * Source: https://www.baeldung.com/java-dao-pattern
 * @param <T>
 */
@Service
public interface DAO<T> {

    Optional<T> get(long id);

    List<T> getAll();

    int save(T t);

    int update(T t);

    int delete(T t);
}
