package hello.thymeleaf.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExampleController {

    @RequestMapping("/send-header")
    public ResponseEntity<String> sendHeader() {
        HttpHeaders header = new HttpHeaders();
        header.add("X-USER", "user12314");
        return new ResponseEntity<>("hello", header, HttpStatus.OK);
    }

    @RequestMapping("/receive-header")
    public String receiveHeader(@RequestHeader("X-USER") String xUser, @RequestBody String requestBody) {
        log.info("{} {}", xUser, requestBody);
        return "success";
    }
}
