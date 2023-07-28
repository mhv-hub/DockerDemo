package com.mhv.dockerDemo.dao;

import com.mhv.dockerDemo.entity.DemoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DemoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean addData(DemoEntity demoEntity){
        try{
            if(this.getData(demoEntity.getId()).isPresent()){
                return false;
            }
            entityManager.persist(demoEntity);
            entityManager.flush();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<DemoEntity> getData(int id){
        try{
            DemoEntity demoEntity = entityManager.find(DemoEntity.class, id);
            return Optional.of(demoEntity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<List<DemoEntity>> getAllData(){
        try{
            TypedQuery<DemoEntity> typedQuery = entityManager.createQuery("select e from DemoEntity e", DemoEntity.class);
            return Optional.of(typedQuery.getResultList());
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
