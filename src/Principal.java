import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConversorMoneda moneda = new ConversorMoneda();
        int opcion=-1;
        String[] listaDivisas = {"USD", "EUR", "ARS", "BRL", "CLP", "COP", "MXN", "UYI"};

        String menu = """
                CONVERSOR DE MONEDAS EN JAVA
                ****************************
                Elija el tipo de cambio:
                1-USD
                2-EUR
                3-ARS
                4-BRL
                5-CLP
                6-COP
                7-MXN
                8-UYI
                0-Salir
                ****************************""";

        while(true) {
            try {
                System.out.println(menu);
                opcion = entrada.nextInt();
                if (opcion==0) {
                    break;
                }

                System.out.println("Ahora ingrese la cantidad en soles(PEN) que desee convertir: ");
                double cantidad = entrada.nextDouble();

                Moneda divisa = moneda.monedaConversor(listaDivisas[opcion-1],cantidad);
                System.out.println("Tipo de Cambio:");
                System.out.println(cantidad+" (PEN) -- "+divisa.conversion_result()+" ("+listaDivisas[opcion-1]+")");
                System.out.println("****************************");

                ConvertidorJson archivoJson = new ConvertidorJson();
                archivoJson.archivoJson(divisa);

            } catch (Exception e) {
                throw new RuntimeException("Ocurrio un error... "+e.getMessage());
            }
        } ;
        System.out.println("Aplicacion Finalizada :)");

    }
}
