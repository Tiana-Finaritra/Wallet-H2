package com.main.generic;

import java.util.List;

public interface GenericDAO<T> {
    List<T> findAll();
    List<T> saveAll(List<T> toSave);
    T save(T toSave);
    T delete(T toDelete);
}
