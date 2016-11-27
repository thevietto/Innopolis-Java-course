package inno.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerAspect {

    public void controllerAction() {
        System.out.println("Какой-то констроллер работает");
    }

    public void aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Начал работать контроллер " + joinPoint.getSignature() +
                " с параметрами " + Stream.of(joinPoint.getArgs())
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println("Закончил работать контроллер " + joinPoint.getSignature() +
                ". Время в пути: " + (end - start) + " млс");
    }

    public void onRemovePost() {
        System.out.println("Ах вот же ты!");
    }

    public void printId(Long id) {
        System.out.println("АЙДИ " + id);
    }


}
