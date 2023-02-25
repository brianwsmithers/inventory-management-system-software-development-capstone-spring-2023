package com.inventorymanagementsystem.inventory.management.system.data;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Interface: DAO<br>
 * Description:
 * Source: https://www.baeldung.com/java-dao-pattern
 * @param <T>
 */
public interface DAO<T> {

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
