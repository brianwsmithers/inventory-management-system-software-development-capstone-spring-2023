package com.inventorymanagementsystem.inventory.management.system.data;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 3/22/23 <br>
 * @param <T>
 */
public interface GetByNameable<T> {

    List<Optional<T>> getByFirstAndLastName(String firstName, String lastName);
}
