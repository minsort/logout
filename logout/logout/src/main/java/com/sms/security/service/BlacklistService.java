package com.sms.security.service;

import com.sms.security.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService {

    @Autowired
    BlacklistRepository blacklistRepository;


    public boolean isTokenExist(String token) {
        return blacklistRepository.isTokenExist(token);
    }

    public void saveToken(String token) {
        blacklistRepository.saveToken(token);
    }


}







    //private static final Map<Integer, String> blacklist = Maps.newConcurrentMap();

    //BlackList blackList = new BlackList();

    /*@Cacheable(cacheNames="exist")
    public boolean isTokenExist(String token) {
        boolean exist = blackList.getToken().equals(token);
        return exist;
    }*/



    /*@Cacheable(cacheNames="exist")
    public boolean isTokenExist(String token) {
        boolean exist = false;
        for (String value : blacklist.values()) {
           exist = blacklist.containsValue(token);
        }
        return exist;
    }*/

    /*@CachePut(cacheNames="exist")
    public void saveToken(String token) {
        Integer id = 1;
        blacklist.put(id, token);
        id++;
    }*/



    /*public List<BlackList> result() {
        return blacklist;
    }*/


    /*public Map<Integer, String> result(){
        return blacklist;
    }*/

    /*@CachePut(cacheNames="exist")
    public void saveToken(String token) {
        blackList.setToken(token);
    }

    public BlackList result(){
        return blackList;
    }*/




    /*private static final List<BlackList> blacklist = new ArrayList<>();

    public boolean isTokenExist(String token) {
        boolean exist = false;
        for (int i = 0; i < blacklist.size(); i++) {
            exist = token.equals(blacklist.get(i).getToken());
        }
        return exist;
    }

    public void saveToken(String token) {
        blacklist.add(new BlackList(token));
    }*/












        /*Blacklist blacklist = new Blacklist();
        blacklist.setToken(token);
        blacklist.setCreated(Instant.now());

        blacklistRepository.save(blacklist);*/


