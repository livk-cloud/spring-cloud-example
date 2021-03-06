dependencies {
    compileOnly("org.springframework.cloud:spring-cloud-gateway-server")
    compileOnly("org.springframework:spring-webflux")
    api("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    api("io.springfox:springfox-boot-starter")
    api("org.springframework.cloud:spring-cloud-commons")
    api("com.fasterxml.jackson.core:jackson-databind")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}
