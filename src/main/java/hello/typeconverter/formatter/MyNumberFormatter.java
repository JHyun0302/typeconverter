package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Formatter: 문자에 특화(문자->객체, 객체->문자) + 현지화(Locale)
 * ex) 숫자(1000) -> 문자("1000")
 * <p>
 * test: http://localhost:8080/hello-v2?data=1,000
 */
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException { //문자 -> 객체
        log.info("text={}, locale={}", text, locale);
        //"1,000"->1000
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) { // 객체 -> 문자
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
