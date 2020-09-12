package io.mbab.sda.groupproject2.menu;

import java.util.Scanner;

/* Scanner jest klasa finalną, nie można zamockować, wraper pozwoli na mockowanie na potrzeby testów*/
public class CustomScanner {

    private final Scanner scanner = new Scanner(System.in);


    public double nextDouble(){
        return scanner.nextDouble();
    }
    public String nextLine() {
        return scanner.nextLine();
    }

    public Integer nextInt() { return  scanner.nextInt();
    }
}
