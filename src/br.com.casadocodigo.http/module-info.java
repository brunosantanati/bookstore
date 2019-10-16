module br.com.casadocodigo.http {
    exports br.com.casadocodigo.http;
    //requires jdk.incubator.httpclient; //Java 9
    requires java.net.http; //Java 11
    requires br.com.casadocodigo.domain;
}