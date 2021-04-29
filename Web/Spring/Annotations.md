## Spring Boot에서 사용되는 어노테이션
### @Controller
클래스에 붙여서 사용하며 컨트롤러라고 정의할 수 있다. 보통 @RequestMapping 등의 어노테이션과 같이 사용된다.
```java
    @Controller
@RequestMapping("books")
public class SimpleBookController {

    @GetMapping("/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```
>[참고: The Spring @Controller and @RestController Annotations](https://www.baeldung.com/spring-controller-vs-restcontroller#spring-mvc-controller)
### @GetMapping
HTTP 메서드 중 GET을 인식하는 어노테이션. `@RequestMapping(method = RequestMethod.GET)`와 같다.
> [참고: GetMapping (Spring Framework 5.3.6 API)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)

### @ResponseBody
메서드의 리턴 값을 응답 본문으로 묶어서 보낸다고 알리는 어노테이션. 그냥 사용하면 텍스트로 보내고 key:value 형식으로 보내면 json 형식으로 보내진다.

>[참고:docs.spring.io/spring-framework](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html)