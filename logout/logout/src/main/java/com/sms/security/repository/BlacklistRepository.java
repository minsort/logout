package com.sms.security.repository;

import com.sms.security.model.BlackList;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@CacheConfig(cacheNames = "blacklist")
public class BlacklistRepository {

   private ArrayList<BlackList> list = new ArrayList<BlackList>();

    @CachePut("blacklist")
    public List<BlackList> blackLists() {
    ArrayList<BlackList> blackLists = list;
        System.out.println("Обращение к методу blacklist "+blackLists);

    return blackLists;
}
   // ArrayList<BlackList> list = new ArrayList<BlackList>();

@Cacheable
    public boolean isTokenExist(String token) {
        boolean exist = false;
        for (int i = 0; i <blackLists().size(); i++) {
            exist = blackLists().get(i).getToken().equals(token);
        }
        System.out.println("isToken " + exist +blackLists());
        return exist;
    }
    @CachePut("blacklist")
    public void saveToken(String token) {
        System.out.println("saveToken "+blackLists());
        blackLists().add(new BlackList(token));
        System.out.println("saveToken after save "+blackLists());
    }

    public List<BlackList>all(){
        return blackLists();
    }

}