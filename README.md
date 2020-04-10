Инструкции по запуску:

1 вариант: по модулям
1. Скачать и установить https://www.postgresql.org/download/
2. Терминал 1: cd planit-scala && sbt run
3. Терминал 2: cd planit-frontend && npm install && ng serve

2 вариант: docker 
1. planit-scala/src/main/resources/application.conf  Раскомментировать строки 27, 30. Закомменитировать 28, 31.  
2. Запуск - docker-compose up -d --force-recreate
3. Выключение и очистка - docker-compose down --rmi all

