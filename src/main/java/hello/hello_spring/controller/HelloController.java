package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // http  get 요청을 처리하는 애너테이션 /URL 경로: 사용자가 http://서버주소/hello-mvc로 GET 요청을 보내면 이 메서드가 실행됩니다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//http에서 바디에 이 리턴 데이터를 직접 넣어주겠다는 코드
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring" view 없이 입력값이 그대로 보여줌
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 처음으로 문자가 아닌 객체를 넘긴 순간 json으로 넘어간다.
    }
    // 자바빈 표준방식
    static class Hello {
        private String name;// 메서드로 접근

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

