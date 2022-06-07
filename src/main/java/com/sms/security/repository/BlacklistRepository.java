package com.sms.security.repository;

import com.sms.security.model.BlackList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
@CacheConfig(cacheNames = "blacklist")
public class BlacklistRepository {

    //Список для хранения токенов
    private ArrayList<BlackList> list = new ArrayList<>();

    //метод-адаптер с EhCache-аннотацией для взаимодействия с list
    @CachePut("blacklist")
    public ArrayList<BlackList> blackLists() {
    ArrayList<BlackList> blackLists = list;
    return blackLists;
}
    //Проверяем наличие токена в черном списке
    @Cacheable
    public boolean isTokenExist(String token) {

        boolean exist = false;
        for (int i = 0; i <blackLists().size(); i++) {
            exist = blackLists().get(i).getToken().equals(token);
        }
        return exist;
    }

    //Сохраняем объект с токеном и временем создания
    @CachePut("blacklist")
    public void saveToken(String token) {

        Date timeCreated = new Date();
        blackLists().add(new BlackList(token, timeCreated));
    }

    //тестовый метод - смотрим содержимое черного списка
    public List<BlackList>all(){

        return blackLists();
    }
    /*
    Метод проверяет - есть ли в списке объект, возраст которого превышает установленное время
    и если находит - удаляет. Данный метод вызывается со всех остальных методов, во избежание запуска
    по рассписанию.
    */
    public void delete(){

        if(blackLists().size()>0) {
            ArrayList<BlackList>promoList=blackLists();
            Long checkTime = new Date().getTime();//время проверки
            for (int i = 0; i < promoList.size(); i++) {//проходим по всем токенам
                if (checkTime - promoList.get(i).getTimeCreated().getTime()>45000) {//если токен старше 1-го часа
                    log.info("Был обнаружен и удален токен {}",promoList.get(i));
                    log.info("Время создания токена {}",checkTime,promoList.get(i).getTimeCreated().getTime());
                    blackLists().remove(i);//удаляем токен
                }
            }log.info("Прошла проверка на возраст токена");
            log.info("Время проверки {}",checkTime);
        }
    }
}