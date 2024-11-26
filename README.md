# Использование профилей в Spring boot для управления запуском тестов

1-ый вариант: @EnabledIf - тестовый класс запускается в случае если активен заданный профиль
  - в application.properties устанавливается профиль: spring.profiles.active=white или black
  - в AppConfig создаются бины и через @Profile отмечается их принадлежность к профилю 
  - тестовые классы RunOnlyBlackCarTest и RunOnlyWhiteCarTest запускаются в зависимости от выбранного профиля

2-ой вариант: для тестового класса активируется свой профиль, который задает через @ActiveProfiles - какой профиль 
активировать и этот класс запускается всегда 
  - см. RunAlwaysBlackCarTest и RunAlwaysWhiteCarTest

В ресурсах для каждого профиля можно создать свой проперти файл:
- application-black.properties для профиля "black"
- application-white.properties для профиля "white"

Примечание: 
1) если нужно, чтобы запускались тесты только одного варианта - то нужно использовать 1-ый вариант с @EnabledIf.
2) если в приложении один файл application.properties, то настройки берутся из него,
если в тестах лежит свой application.properties, то при запуске тестов берется значение из него.

### References
`1.` Execute Tests Based on Active Profile With JUnit 5 https://www.baeldung.com/spring-boot-junit-5-testing-active-profile