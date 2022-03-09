package anno;


import lombok.Data;

import java.lang.annotation.Documented;

@Data
public class Person {
    @MyAnno("youzhushi")
    private String stra;
    private String strb;
    private String strc;

    public Person(String str1,String str2,String str3){
        super();
        this.stra = str1;
        this.strb = str2;
        this.strc = str3;
    }

}