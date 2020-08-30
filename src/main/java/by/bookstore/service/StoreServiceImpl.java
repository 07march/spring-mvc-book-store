package by.bookstore.service;

import by.bookstore.entity.Store;
import by.bookstore.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
  private StoreRepository storeRepository;

  public StoreServiceImpl(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Override
  public void add(Store store) {
    storeRepository.add(store);
  }

  @Override
  public void delete(int id) {
    storeRepository.delete(id);
  }

  @Override
  public boolean update(String name, int id) {
    return storeRepository.update(name, id);
  }

  @Override
  public Store[] findAll() {
    return storeRepository.findAll();
  }

  @Override
  public Store findByName(String name) {
    return storeRepository.findByName(name);
  }
}
