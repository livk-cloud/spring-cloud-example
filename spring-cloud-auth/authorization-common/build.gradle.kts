dependencies {
    api(project(":spring-common"))
    api("org.springframework.boot:spring-boot-starter-security")
    api("org.springframework.security:spring-security-oauth2-authorization-server")
    compileOnly("jakarta.servlet:jakarta.servlet-api")
}
