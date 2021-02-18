package br.com.alura.gerenciador.listener;

import java.util.Arrays;

public class UtilListener {

    public static void print(Class<?> clazz, Object... text) {

	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	System.out.println("\t" + clazz.getSimpleName());
	System.out.println("\t" + Arrays.toString(text));
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

}
