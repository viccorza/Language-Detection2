/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagedetection2;
import DBManager.dbmanager;
import beans.unoporuno_snippet;
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import java.util.List;

public class LanguageDetection2 {

    /**
     * @param args the command line arguments
     */
    private static dbmanager dbm = new dbmanager();
    
    public static void main(String[] args) throws LangDetectException {
        DetectorFactory.loadProfile("./profiles");
        List<unoporuno_snippet> snippetList = dbm.obtenerDatos();
        for(unoporuno_snippet snippet: snippetList)
        {
            Detector detector = DetectorFactory.create();
            String text=snippet.getDescription();
            detector.append(text);
            String lang = detector.detect();
            System.out.println( "Frase: " + text + "-- Esta en idioma: " + lang);   
        }
    }
    
}
