package hello.hello_spring.domain;

public class Member {

    private long id; // 시스템이 정하는 임의의 값
    private String name; // 고객이 정하는 이름

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
