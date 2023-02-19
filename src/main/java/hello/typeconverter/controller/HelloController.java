package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 타입을 변환해야하는 경우 기본 예시
 */
@RestController
public class HelloController {
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intValue = Integer.valueOf(data); //숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    //http://localhost:8080/hello-v2?data=10000
    @GetMapping("/hello-v2") //문자 10000 -> 숫자 10000
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }
    
    @GetMapping("/ip-port") //localhost:8080/ip-port?ipPort=127.0.0.1:8080
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort Ip = " + ipPort.getIp());
        System.out.println("ipPort Port = " + ipPort.getPort());
        return "ok";
    }
}
