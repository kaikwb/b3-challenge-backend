package br.com.fiap.b3_challenge_backend.dao;

import java.util.List;

public interface DAO<T> {
    T create(T t) throws Exception;

    T get(int id) throws Exception;

    List<T> get() throws Exception;

    void update(T t) throws Exception;

    void delete(int id) throws Exception;
}
