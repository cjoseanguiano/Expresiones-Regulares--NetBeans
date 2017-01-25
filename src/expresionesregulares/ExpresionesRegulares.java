/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carlosjoseanguiano
 */
public class ExpresionesRegulares {

    public static void main(String args[]) {

        String input = "carchat@bda.com";
//        String input = "www.?regular.com";

        Pattern p = Pattern.compile("^|^@");
        Matcher m = p.matcher(input);

        if (m.find()) {
            System.err.println("Las direcciones no empiezan por un punto o @");
        }

        //Verificar que no empieze por www.
        p = Pattern.compile("^www.");
        m = p.matcher(input);
        if (m.find()) {
            System.out.println("Los email no empiezan por www");
        }

        //Comprobar que contenga @
        p = Pattern.compile("@");
        m = p.matcher(input);
        if (m.find()) {
            System.out.println("La cadena no tiene arroba");
        }

        //Comprobar que no contenga caracteres prohibidos
        p = Pattern.compile("[A-Za-z0-9.@-~#]+");
        m = p.matcher(input);
        StringBuffer stringBuffer = new StringBuffer();
        boolean resultado = m.find();
        boolean caracteresIlegals = false;

        while (resultado) {
            caracteresIlegals = true;
            m.appendReplacement(stringBuffer, "");
            resultado = m.find();
        }

        //Añade el ultimo segmento de la entrada a la cadena
        m.appendTail(stringBuffer);
        input = stringBuffer.toString();

        if (caracteresIlegals) {
            System.out.println("La cadena contiene caracteres ilegales");
        }
    }
}
