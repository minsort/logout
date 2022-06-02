# sms security
Реализован метод разлогирования ("/LOGOUT") путем добавления JWT токена в черный список (Blacklist), который хранится в кэше Ehcache.
1) Необходимо найти лучшее решение для хранения ключа JWT (храниться в application.properties)
2) Endpoint's для фронтенда реализован в SWAGGER: http://localhost:8080/swagger-ui.html
