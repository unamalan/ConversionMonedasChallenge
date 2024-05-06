
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        ConversionDivisas consulta = new ConversionDivisas();

        System.out.println("*******************************************************");
        System.out.println("==========Bienvenidos al conversor de monedas==========");
        System.out.println("*******************************************************");

        while (true) {

            System.out.println("");
            System.out.println("""
                        1)  [USD] Dolar               -> [ARS] Peso Argentino
                        2)  [ARS] Peso Argentino      -> [USD] Dolar
                        3)  [USD] Dolar               -> [BRL] Real Brasileño"
                        4)  [BRL] Real Brasileño      -> [USD] Dolar"
                        5)  [USD] Dolar               -> [COP] Peso Colombiano
                        6)  [COP] Peso Colombiano     -> [USD] Dolar
                        7)  [USD] Dolar               -> [MXN] Peso Mexicano
                        8)  [MXN] Peso Mexicano       -> [USD] Dolar
                        9)  [USD] Dolar               -> [CRC] Colo Costarricense
                        10) [CRC] Colon Costarricense -> [USD] Dolar
                        11) [Salir]
                        """);

            System.out.print("Elija un opcion: ");
            Scanner lectura = new Scanner(System.in);
            int opc = lectura.nextInt();

            if(opc == 11){
                System.out.println("Programa finalizado");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            int valorAConvertir = lectura.nextInt();

            switch (opc) {

                case 1:
                    consulta.buscarDivisa(Divisas.USD, Divisas.ARS, valorAConvertir);
                    break;
                case 2:
                    consulta.buscarDivisa(Divisas.ARS, Divisas.USD, valorAConvertir);
                    break;
                case 3:
                    consulta.buscarDivisa(Divisas.USD, Divisas.BRL, valorAConvertir);
                    break;
                case 4:
                    consulta.buscarDivisa(Divisas.BRL, Divisas.USD, valorAConvertir);
                    break;
                case 5:
                    consulta.buscarDivisa(Divisas.USD, Divisas.COP, valorAConvertir);
                    break;
                case 6:
                    consulta.buscarDivisa(Divisas.COP, Divisas.USD, valorAConvertir);
                    break;
                case 7:
                    consulta.buscarDivisa(Divisas.USD, Divisas.MXN, valorAConvertir);
                    break;
                case 8:
                    consulta.buscarDivisa(Divisas.MXN, Divisas.USD, valorAConvertir);
                    break;
                case 9:
                    consulta.buscarDivisa(Divisas.USD, Divisas.CRC, valorAConvertir);
                    break;
                case 10:
                    consulta.buscarDivisa(Divisas.CRC, Divisas.USD, valorAConvertir);
                    break;
                default:
                    System.out.println("Opcion no valida,ingrese una opcion nuevamente");

            }
        }
    }
}
