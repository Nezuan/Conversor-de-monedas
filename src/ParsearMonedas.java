import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ParsearMonedas {
    private JsonObject conversionRates;

    //Constructor que recibe el JSON y lo parsea
    public ParsearMonedas(String json){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        this.conversionRates = jsonObject.getAsJsonObject("conversion_rates");
    }

    //Metodo para obtener la tasa de conversion entre dos monedas
    public double getConversionRate(String deMoneda, String aMoneda, double aCambiar) {
        double deTasa = conversionRates.get(deMoneda).getAsDouble();
        double aTasa = conversionRates.get(aMoneda).getAsDouble();
        return (aCambiar*aTasa) / deTasa;
    }

}
