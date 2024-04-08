package com.example.restaurantapi;

import com.example.restaurantapi.model.entity.RestaurantModel;
import com.example.restaurantapi.repository.RestaurantRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    @Override
    public Optional<RestaurantModel> findByNameIsIgnoreCase(String name) {
        return Optional.empty();
    }

    @Override
    public List<RestaurantModel> findAllByAddressIgnoreCase_City(String name) {
        return null;
    }

    @Override
    public List<RestaurantModel> findAllByTypeIgnoreCase(String type) {
        return null;
    }

    @Override
    public List<RestaurantModel> findAllByRating_Mark(Integer mark) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends RestaurantModel> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RestaurantModel> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RestaurantModel getOne(Long aLong) {
        return null;
    }

    @Override
    public RestaurantModel getById(Long aLong) {
        return null;
    }

    @Override
    public RestaurantModel getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<RestaurantModel> findAll() {
        return null;
    }

    @Override
    public List<RestaurantModel> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> S save(S entity) {
        return null;
    }

    @Override
    public Optional<RestaurantModel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(RestaurantModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RestaurantModel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<RestaurantModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RestaurantModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RestaurantModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RestaurantModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RestaurantModel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RestaurantModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}