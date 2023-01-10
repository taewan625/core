package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    private String url;

    public NetworkClient(){
        System.out.println("constructor url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    @PostConstruct
    public void connect() {
        System.out.println("connect = " + url);
    }
    
    public void call(String message){
        System.out.println("Call: " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    @PreDestroy
    public void disconnect(){
        System.out.println("close = " + url);
    }

    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
