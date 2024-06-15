# HashMap

### 생성 & 추가(put)

```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1,"사과");
```

### 삭제

```java
map.remove(key);
map.clear();
```

### 확인

```java
map.containsKey(key); // key가 있는지 확인 T/F
map.containsValue(value); // value가 있는지 확인 T/F

map.size(); // 해쉬맵 크기 확인
```

### 읽기(get) 

```java
map.get(key);
map.getOrDefault(key, 0); // key값이 있으면 value 반환, 없으면 0 반환
```
