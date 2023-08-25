# guava-cache-example

## 주요 확인 사항

### CacheBuilder.build.. 동작

> build 메서드 에 파라미터로 CacheLoader 를 제공하면, LoadingCache 를 생성한다.
> 이때 LoadingCache 구현체는 LocalCache.LocalLoadingCache 이다.

### CacheLoader
- CacheLoader 의 loadAll 메서드는 LoadingCache 의 getAll 호출시 내부적으로 호출된다.

#### 특이사항

> getAll 호출시 파라미터인 key 와 무관하게 cache 가 전부 업로드 되었으면 하였다.
> 그래서 빈 key 를 파라미터로 입력하여 테스트하였으나 정상적으로 초기화 되지 못하였다.
> 그 이유는 아래와 같다.
> > getAll 호출에서 key 를 파라미터로 받는데, 내부적으로 검증 과정을 거치면서
> > key 에 해당하는 value 가 없을 경우 오류가 발생하게 된다.
> > 따라서, getAll 호출시 임의의 key 가 아닌 실제 key 들을 입력해주어야 한다.

# Mysql 테스트 환경 docker 실행 명령어
> docker run --name mysql-8 -p 13306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql:8

## DDL & DML
```
create table config
(
    id    int auto_increment
        primary key,
    `key` varchar(255) not null,
    value varchar(100) not null
)
collate = utf8mb4_general_ci;

INSERT INTO guava_cache.config (id, `key`, value) VALUES (1, 'config1', '100');
INSERT INTO guava_cache.config (id, `key`, value) VALUES (2, 'config2', '200');

```
