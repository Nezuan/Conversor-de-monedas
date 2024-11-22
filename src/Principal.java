import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String url = "https://v6.exchangerate-api.com/v6/9c8955b75af3f1de211c7e96/latest/USD";
        try{
            //obteniendo el json
            ConsultaDeApi consultaDeApi = new ConsultaDeApi(url);
            String jsonString = consultaDeApi.buscarConversionRatesJson();

            // Instanciar el parser con el json obteniddo
            ParsearMonedas parser = new ParsearMonedas(jsonString);
            Scanner scanner = new Scanner(System.in);


            System.out.println("Seleccione una opción de conversion: ");
            System.out.println("1) Dólar ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real brasileño");
            System.out.println("4) Real brasileño ==> Dólar");
            System.out.println("5) Dólar ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dólar");
            System.out.println("7) Salir");

            int option = scanner.nextInt();

            while (option <7){

                System.out.println("Ingrese el monto a cambiar: ");
                double aCambiarUsuario = scanner.nextDouble();
                double cambio = 0;


                switch (option){
                    case 1:

                        cambio = parser.getConversionRate("USD", "ARS", aCambiarUsuario);
                        System.out.println("Tasa de USD a ARS: " + cambio);
                        break;
                    case 2:
                        cambio = parser.getConversionRate("ARS", "USD", aCambiarUsuario);
                        System.out.println("Tasa de ARS a USD: " + cambio);
                        break;
                    case 3:
                        cambio = parser.getConversionRate("USD", "BRL", aCambiarUsuario);
                        System.out.println("Tasa de USD a BRL: " + cambio);
                        break;
                    case 4:
                        cambio = parser.getConversionRate("BRL", "USD", aCambiarUsuario);
                        System.out.println("Tasa de BRL a USD: " + cambio);
                        break;
                    case 5:
                        cambio = parser.getConversionRate("USD", "COP", aCambiarUsuario);
                        System.out.println("Tasa de USD a COP: " + cambio);
                        break;
                    case 6:
                        cambio = parser.getConversionRate("COP", "USD", aCambiarUsuario);
                        System.out.println("Tasa de COP a USD: "+ cambio);
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
                System.out.println("Seleccione una opción de conversion: ");
                System.out.println("1) Dólar ==> Peso argentino");
                System.out.println("2) Peso argentino ==> Dólar");
                System.out.println("3) Dólar ==> Real brasileño");
                System.out.println("4) Real brasileño ==> Dólar");
                System.out.println("5) Dólar ==> Peso colombiano");
                System.out.println("6) Peso colombiano ==> Dólar");
                System.out.println("7) Salir");
                option = scanner.nextInt();

            }
            System.out.println("Gracias por usar nuestro conversor");



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
